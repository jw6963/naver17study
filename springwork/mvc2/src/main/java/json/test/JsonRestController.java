package json.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController : foward 없이 브라우저로 직접 데이터를 출력(주로 json 방식)
// 프론트에서 GET,PUT,DELETE, POST 매핑에 따라 메서드가 호출되는 방식
@RestController
public class JsonRestController {

    @GetMapping("/bit")
    public String test1() {
        return "bitcamp";
    }
}