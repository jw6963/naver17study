package shop.controller;

import data.dto.ShopDto;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@Controller
public class ShopDetailDeleteController {
    @Autowired
    private ShopService shopService;

    @GetMapping("/shop/detail")
    public String detail(@RequestParam("num") int num, Model model) {
        ShopDto dto = shopService.getSangpumByNum(num);
        List<String> photoList = List.of(dto.getSphoto().split(","));
        String mainPhoto = dto.getSphoto().split(",")[0]; // 첫 번째 사진
        dto.setMainphoto(mainPhoto);
        model.addAttribute("dto", dto);
        model.addAttribute("photoList", photoList);
        return "shop/detail";
    }

    @GetMapping("/shop/delete")
    public String delete(@RequestParam("num") int num, HttpServletRequest request) {
        // 객체 호출
        ShopDto dto = shopService.getSangpumByNum(num);
        // 파일 경로
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        // 파일명
        if (dto.getSphoto() != null && !dto.getSphoto().isEmpty()) {
            String[] files = dto.getSphoto().split(",");
            // 파일 삭제
            for (String file : files) {
                File f = new File(uploadPath + "/" + file);
                if (f.exists()){
                    f.delete();
                }
            }
        }

        shopService.deleteSangpum(num);
        return "redirect:/shop/list";
    }
}
