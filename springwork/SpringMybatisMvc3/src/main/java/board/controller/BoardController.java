package board.controller;

import data.dto.BoardDto;
import data.dto.BoardFileDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    final BoardService boardService;
    final BoardFileService fileService;
    final MemberService memberService;
    final NcpObjectStorageService storageService;

    //버켓 이름
    private String bucketName = "bitcamp-bucket";//각자 자기꺼 써야함

    @GetMapping("/writeform")
    public String writeForm(
            // 아래 5개의 값은 답글일 때만 넘어온다, 새 글일 때는 null 값이 넘어오므로
            // required false를 주거나 defaultValue를 지정해야 한다
            @RequestParam(value = "idx", defaultValue = "0") int idx,
            @RequestParam(value = "regroup", defaultValue = "0") int regroup,
            @RequestParam(value = "restep", defaultValue = "0") int restep,
            @RequestParam(value = "relevel", defaultValue = "0") int relevel,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            Model model
    ) {
        model.addAttribute("idx", idx);
        model.addAttribute("regroup", regroup);
        model.addAttribute("restep", restep);
        model.addAttribute("relevel", relevel);
        model.addAttribute("pageNum", pageNum);

        return "board/writeform";
    }

    @PostMapping("/insert")
    public String insert(
            @ModelAttribute BoardDto dto,
            @RequestParam int pageNum,
            @RequestParam("upload") List<MultipartFile> upload,
            HttpSession session
    ) {
        // session으로부터 아이디를 얻는다
        String id = (String) session.getAttribute("loginid");
        // 아이디를 이용해서 멤버 테이블에서 작성자를 얻는다
        String writer = memberService.getMemberById(id).getMname();
        dto.setWriter(writer);
        dto.setMyid(id);
        // 게시판 내용을 db에 저장(그래야만 dto가 idx를 얻어올 수 있다)
        boardService.insertBoard(dto);

        // 파일이 있는 경우에만 해당
        // 네이버 스토리지에 저장 후 db에 파일 저장(이때 필요한 게 idx, filename)
        // 반복문 내에서 이루어져야한다(파일 여러개)
        for (MultipartFile file : upload) {
            if (!file.isEmpty()) {
                BoardFileDto fdto = new BoardFileDto();
                fdto.setIdx(dto.getIdx());
                fdto.setFilename(storageService.uploadFile(bucketName, "board", file));
                fileService.insertBoardFile(fdto);
            }
        }

        return "redirect:./list?pageNum=" + pageNum;
    }

    @GetMapping("/detail")
    public String detail() {
        return "board/boarddetail";
    }
}