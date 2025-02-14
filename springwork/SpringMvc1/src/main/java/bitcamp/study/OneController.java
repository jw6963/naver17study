package bitcamp.study;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

//@RestController
@Controller
@AllArgsConstructor // 모든 멤버 변수 자동 주입
public class OneController {
	
	// 같은 타입의 빈을 찾아서 자동으로 주입힌다.(DI)
//	@Autowired // 방법 1
	Mycar mycar;
	
	@GetMapping(value="/")
	public ModelAndView  show() {
		ModelAndView mview = new ModelAndView();
		
		// Model에 데이터를 저장(서블릿에서 request에 저장하는 것과 같음)
		mview.addObject("today", new Date());
		mview.addObject("message","오늘은 즐거운 금요일!!");
		
		// 포워드
		mview.setViewName("result1");
		return mview;
	}
	
	@GetMapping({"/board/list","/board/list.do"})
	public String list1(Model model) {
		model.addAttribute("writer","한가람");
		return "boardlist";
	}
	
	@GetMapping({"/shop/list"})
	public String list2(Model model) {
		model.addAttribute("sangpum", "사과");
		model.addAttribute("price", "3000");
		return "shoplist";
	}
	@GetMapping({"/bitcamp/study","/bitcamp/study2"})
	public String list3(Model model) {
		
		model.addAttribute("mycar", mycar.getMycarName());
		model.addAttribute("mycarColor",mycar.getMycarColor());
		return "study";
	}
}
