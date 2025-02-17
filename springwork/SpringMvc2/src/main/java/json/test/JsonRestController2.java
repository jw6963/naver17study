package json.test;

import data.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonRestController2 {
    @GetMapping("/test")
    @ResponseBody
    public TestDto test1() {
        return new TestDto("이영자","서울시","여성");
//        TestDto testDto = new TestDto();
//        testDto.setAddr("서울");
//        testDto.setName("이영자");
//        testDto.setGender("여성");
//        return testDto;
    }
}
