package controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class HelloController {
    @GetMapping("/")
   /*public ModelAndView hello1() { 방법 1

      ModelAndView mview = new ModelAndView();

      mview.addObject("message","오늘은 월요일입니다.");//request 저장
      mview.setViewName("hello");//WEB-INF/hello.jsp 폴더를 찾아서 포워드

      return mview;

   }*/

    public String hello1(Model model) {//방법2

        model.addAttribute("message", "오늘은 월요일입니다.");
        model.addAttribute("today", new Date());

        return "hello";

    }
}
