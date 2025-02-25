package member.controller;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import naver.storage.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/member")
public class MemberListController {
    @Autowired
    MemberService memberService;

    // 버킷 이름
    private String bucketName = "bitcamp-bucket";
    private String naverurl = "https://kr.object.ncloudstorage.com/bitcamp-bucket";
    private String fronturl = "https://lumr99uh8720.edge.naverncp.com/MrrbyGGKhq";
    private String backurl = "?type=f&w=30&h=30&faceopt=true&ttype=jpg";

    @Autowired
    NcpObjectStorageService storageService;

    @GetMapping("/list")
    public String list(Model model) {
        List<MemberDto> list = memberService.getMembers();

        model.addAttribute("list", list);
        model.addAttribute("naverurl", naverurl);
        model.addAttribute("fronturl", fronturl);
        model.addAttribute("backurl", backurl);
        return "member/memberlist";
    }

    @GetMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam int num, HttpServletRequest request) {
        MemberDto dto = memberService.getMemberByNum(num);
//        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
//        // 파일명
//        if (dto.getMphoto() != null && !dto.getMphoto().isEmpty()) {
//            // 파일 삭제
//            File f = new File(uploadPath + "/" + dto.getMphoto());
//            if (f.exists()) {
//                f.delete();
//            }
//        }
        // ncp storage 파일 삭제
        storageService.deleteFile(bucketName,"member",dto.getMphoto());
        memberService.deleteMember(num);
    }
    @GetMapping("/mypagedel")
    @ResponseBody
    public void mypageDelete(@RequestParam int num, HttpServletRequest request, HttpSession session) {
        MemberDto dto = memberService.getMemberByNum(num);
//        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
//        // 파일명
//        if (dto.getMphoto() != null && !dto.getMphoto().isEmpty()) {
//            // 파일 삭제
//            File f = new File(uploadPath + "/" + dto.getMphoto());
//            if (f.exists()) {
//                f.delete();
//            }
//        }
        // ncp storage 파일 삭제
        storageService.deleteFile(bucketName,"member",dto.getMphoto());

        memberService.deleteMember(num);
        // 모든 세션 제거
        session.removeAttribute("loginstatus");
        session.removeAttribute("loginid");
        session.removeAttribute("profileImg");
    }

    @PostMapping("/deleteSelected")
    @ResponseBody
    public void deleteSelected(@RequestParam String nums, HttpServletRequest request) {
        String[] numArray = nums.split(","); // 문자열을 배열로 변환
        for (String num : numArray) {
            MemberDto dto = memberService.getMemberByNum(Integer.parseInt(num));
//            String uploadPath = request.getSession().getServletContext().getRealPath("/save");
//            // 파일명
//            if (dto.getMphoto() != null && !dto.getMphoto().isEmpty()) {
//                // 파일 삭제
//                File f = new File(uploadPath + "/" + dto.getMphoto());
//                if (f.exists()) {
//                    f.delete();
//                }
//            }
            // ncp storage 파일 삭제
            storageService.deleteFile(bucketName,"member",dto.getMphoto());

            memberService.deleteMember(Integer.parseInt(num)); // 개별 삭제 메서드 호출
        }
    }

    @GetMapping("/mypage")
    public String mypage(Model model, HttpSession session) {
        // 세션으로부터 아이디를 얻는다
        String loginid = (String) session.getAttribute("loginid");
        // 아이디에 해당하는 dto 얻기
        MemberDto dto = memberService.getMemberById(loginid);
        // 모델에 dto 저장
        model.addAttribute("dto", dto);
        model.addAttribute("naverurl", naverurl);

        return "member/mypage";
    }

    @PostMapping("/changephoto")
    @ResponseBody
    public void changephoto(
            HttpSession session,
            HttpServletRequest request,
            @RequestParam int num,
            @RequestParam("upload") MultipartFile upload) {
        String loginid = (String) session.getAttribute("loginid");
        MemberDto dto = memberService.getMemberById(loginid);

        // 파일 삭제
//        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        if (dto.getMphoto() != null && !dto.getMphoto().isEmpty()) {
//            File f = new File(uploadPath + "/" + dto.getMphoto());
//            if (f.exists()) {
//                f.delete();
//            }
            storageService.deleteFile(bucketName,"member",dto.getMphoto());
        }
        // 파일 업로드
        String filename = upload.getOriginalFilename();
        String uploadFileName = "";
        if (filename.equals("") || filename == null || filename.isEmpty()) {
            uploadFileName = "no";
        } else {
//            // 파일명을 랜덤값.확장자 형식으로 만들기(UUID)
//            String extension = filename.substring(filename.lastIndexOf(".") + 1);
//            uploadFileName = UUID.randomUUID() + "." + extension;
//            // 업로드
//            try {
//                upload.transferTo(new File(uploadPath + "/" + uploadFileName));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            uploadFileName = storageService.uploadFile(bucketName, "member",upload);
        }
        // 사진 변경
        memberService.changePhoto(num, uploadFileName);
        // 세션 변경
        session.setAttribute("profileImg", uploadFileName);
    }
    @PostMapping("/updateMember")
    @ResponseBody
    public void updateMember(@RequestParam int num,
                             @RequestParam String mname,
                             @RequestParam String mhp,
                             @RequestParam String maddr) {
        MemberDto dto = new MemberDto();
        dto.setMname(mname);
        dto.setMhp(mhp);
        dto.setMaddr(maddr);
        dto.setNum(num);
        memberService.updateMember(dto);
    }

}
