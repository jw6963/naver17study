package member.controller;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    MemberService memberService;

    @PostMapping("/member/login")
    public Map<String, String> login(@RequestParam String loginid, @RequestParam String loginpass, HttpSession session) {
        Map<String, String> result = new HashMap<>();
        MemberDto dto = memberService.getMemberById(loginid);
        boolean b = memberService.loginChk(loginid, loginpass);
        result.put("result", b ? "success" : "fail");
        // 세션 저장
        if(b) {
            session.setMaxInactiveInterval(60*60*4); // 4시간 유지
            session.setAttribute("loginstatus", "success");
            session.setAttribute("loginid", loginid);
            session.setAttribute("profileImg", dto.getMphoto());
        }

        return result;
    }

    @GetMapping("/member/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("loginstatus");
        session.removeAttribute("loginid");
    }
}
