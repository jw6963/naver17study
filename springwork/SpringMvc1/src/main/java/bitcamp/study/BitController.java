package bitcamp.study;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.test.TestDto;

@RestController
public class BitController {

	@GetMapping("/hello2")
	public List<TestDto> list() {
		
		List<TestDto> list = new Vector<>();
		list.add(new TestDto("강호동","서울","010-1111-1111"));
		list.add(new TestDto("이영자","부산","010-2222-2222"));
		list.add(new TestDto("곽철용","제주","010-3333-3333"));
		
		return list;
	}
}
