package member.controller;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberListController {
    @Autowired
    MemberService memberService;


    @GetMapping("/list")
    public String list(Model model) {
        List<MemberDto> list = memberService.getMembers();

        model.addAttribute("list", list);
        return "member/memberlist";
    }

    @GetMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam int num, HttpServletRequest request) {
        MemberDto dto = memberService.getMember(num);
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        // 파일명
        if (dto.getMphoto() != null && !dto.getMphoto().isEmpty()) {
            // 파일 삭제
            File f = new File(uploadPath + "/" + dto.getMphoto());
            if (f.exists()) {
                f.delete();
            }
        }
        memberService.deleteMember(num);
    }
    @PostMapping("/deleteSelected")
    @ResponseBody
    public void deleteSelected(@RequestParam String nums) {
        String[] numArray = nums.split(","); // 문자열을 배열로 변환
        for (String num : numArray) {
            memberService.deleteMember(Integer.parseInt(num)); // 개별 삭제 메서드 호출
        }
    }

}
