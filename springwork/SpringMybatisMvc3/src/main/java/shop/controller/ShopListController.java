package shop.controller;

import data.dto.ShopDto;
import data.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShopListController {
    @Autowired
    ShopService shopService;

    @GetMapping("/shop/list")
    public String shopList(Model model) {
        // 총 상품 갯수
        int totalCount = shopService.getTotalCount();
        // 전체 상품
        List<ShopDto> list = shopService.getAllSangpum();
        // 메인 사진 등록
        for(ShopDto shopDto : list) {
            String mainPhoto= shopDto.getSphoto().split(",")[0]; // 첫번 째 사진
            shopDto.setMainphoto(mainPhoto);
        }
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("list", list);
        // foward
        return "shop/shoplist";
    }

}
