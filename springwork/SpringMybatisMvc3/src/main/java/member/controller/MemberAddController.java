package member.controller;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/member")
public class MemberAddController {
    @Autowired
    MemberService memberService;

    @GetMapping("/form")
    public String form() {
        return "member/memberform";
    }

    // 아이디가 존재하면 result에 fail, 존재하지 않으면 ,success를 보내기
    @GetMapping("/idcheck")
    @ResponseBody
    public Map<String, String> idcheck(
            @RequestParam("myid") String myid
    ) {
        Map<String, String> map = new HashMap<>();
        if (memberService.checkMyid(myid)) {
            map.put("result", "fail");
        } else {
            map.put("result", "success");
        }

        return map;
    }

    @PostMapping("/insert")
    public String insert(
            HttpServletRequest request,
            @ModelAttribute MemberDto dto,
            @RequestParam(value = "upload", required = false) MultipartFile upload
    ) {
        // 사진 선택을 안 했을 경우 upload의 파일명을 확인 후
        // 사진 선택을 안 했다면 upload 하지 말고 mphoto에 "no"저장
        String filename = upload.getOriginalFilename();
        String uploadFileName = "";
        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
        if (filename.equals("") || filename == null || filename.isEmpty()) {
            uploadFileName = "no";
        } else {
            // 파일명을 랜덤값.확장자 형식으로 만들기(UUID)
            String extension = filename.substring(filename.lastIndexOf(".") + 1);
            uploadFileName = UUID.randomUUID() + "." + extension;
            // 업로드
            try {
                upload.transferTo(new File(uploadFolder + "/" + uploadFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        dto.setMphoto(uploadFileName);
        memberService.addMember(dto);

        return "redirect:./list"; // 일단 홈으로 이동
    }
}
