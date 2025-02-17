package controller.test;

import data.dto.MyCloudProps;
import data.dto.MyPropDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPropController {

    @Autowired
    MyPropDto myPropDto;

    @Autowired
    MyCloudProps myCloudProps;

    @Value("${server.port}")
    int port;
    @Value("${emp.addr}")
    String addr;

    @GetMapping("/prop1")
    public String prop1(Model model) {
        model.addAttribute("addr", myPropDto.getAddr());
        model.addAttribute("hp", myPropDto.getHp());
        model.addAttribute("msg","서버포트는 "+port+" 이고, 지역은 "+addr+"입니다");
        return "result3";
    }

    @GetMapping("/prop2")
    public String prop2(Model model) {
        model.addAttribute("db", myCloudProps.getDb());
        model.addAttribute("username", myCloudProps.getUsername());
        model.addAttribute("password", myCloudProps.getPassword());
        return "result4";
    }
}
