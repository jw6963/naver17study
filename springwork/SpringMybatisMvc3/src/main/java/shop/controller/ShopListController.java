package shop.controller;

import data.dto.ShopDto;
import data.dto.ShopRepleDto;
import data.service.ShopRepleService;
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
    @Autowired
    private ShopRepleService shopRepleService;

    private String naverurl = "https://kr.object.ncloudstorage.com/bitcamp-bucket";
    private String fronturl = "https://lumr99uh8720.edge.naverncp.com/MrrbyGGKhq";
    private String backurl = "?type=f&w=100&h=120&faceopt=true&ttype=jpg";


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

            // 댓글 수 저장
            List<ShopRepleDto> replecnt = shopRepleService.getReplesByNum(shopDto.getNum());
            shopDto.setReplecnt(replecnt.size());
        }
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("list", list);
        model.addAttribute("naverurl", naverurl);
        model.addAttribute("fronturl", fronturl);
        model.addAttribute("backurl", backurl);
        // foward
        return "shop/shoplist";
    }

}
