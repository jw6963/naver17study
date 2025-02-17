package controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class HelloController {
    @GetMapping("/")
    public ModelAndView hello1(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message","오늘은 월요일입니다.");
        mav.setViewName("hello");

        return mav;
    }
}
