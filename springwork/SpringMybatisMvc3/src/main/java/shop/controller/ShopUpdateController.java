package shop.controller;

import data.dto.ShopDto;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ShopUpdateController {
    private final ShopService shopService;

    public ShopUpdateController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shop/updateform")
    public String updateForm(
            Model model,
            @RequestParam("num") int num
    ) {
        ShopDto dto = shopService.getSangpumByNum(num);
        model.addAttribute("dto", dto);
        return "shop/updateform";
    }

    @PostMapping("/shop/update")
    public String update(
            HttpServletRequest request,
            @ModelAttribute ShopDto dto,
            @RequestParam("num") int num
    ) {
        // db insert
        shopService.updateSangpum(dto);

        return "redirect:/shop/detail?num="+dto.getNum();
    }
}
