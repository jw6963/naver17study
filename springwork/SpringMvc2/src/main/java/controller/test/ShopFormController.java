package controller.test;

import data.dto.ShopDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ShopFormController {
    @GetMapping("/form1")
    public String form1() {
        return "shop/form1";
    }

    @GetMapping("/form2")
    public String form2() {
        return "shop/form2";
    }

    @GetMapping("/form3")
    public String form3() {
        return "shop/form3";
    }

    /////////////////////////////
    @GetMapping("/process1")
    public String list1(Model model,
//                        @RequestParam("myid") String myid, // 방법 1
//                        @RequestParam String myid, // 방법 2. param과 변수명이 같다면 생략 가능
                        String myid, // 방법 3. 이름이 같을 경우 @RequestParam도 생략 가능(권장 x)
                        @RequestParam("mypass") String mypass,
                        // pageNum 이라는 폼 태그가 없으면 null 이 넘어온다
                        // 이 경우 default 값 지정 가능
                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
        String result = "";
        if (mypass.equals("1234")) {
            result = myid + "님이 로그인했습니다";
        } else {
            result = "비밀번호가 맞지 않습니다";
        }
        model.addAttribute("result", result);
        model.addAttribute("pageNum", pageNum);
        return "shop/list1";
    }

    @PostMapping("/process2")
    // dto로 통째로 읽어서 모댈링 저장하기
//    public String list2( @ModelAttribute ShopDto dto) { // 저장 시 shopDto로 저장
    public String list2(@ModelAttribute("dto") ShopDto dto) { // 저장 시 dto로 저장
        return "shop/list2";
    }

    @PostMapping("/process3")
    public String list3(Model model, @RequestParam Map<String, String> map) {
        model.addAttribute("name", map.get("name"));
        model.addAttribute("age", map.get("age"));
        model.addAttribute("addr", map.get("addr"));
        model.addAttribute("gender", map.get("gender"));
        return "shop/list3";
    }
}

