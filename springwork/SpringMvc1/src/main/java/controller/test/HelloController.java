package controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.test.TestDto;

@RestController
public class HelloController {
	
	@GetMapping(value="/2")
	public TestDto hello() {
		TestDto dto = new TestDto();
		dto.setName("이영자");
		dto.setAddr("강남구");
		dto.setHp("010-1234-1234");
		
		return dto;
	}
}
