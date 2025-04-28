package bit.react.controller;

import bit.react.data.JoinDto;
import bit.react.repository.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {
    @Autowired
    JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(@RequestBody JoinDto dto) {
        joinService.joinProcess(dto);
        return "join success";
    }
}
