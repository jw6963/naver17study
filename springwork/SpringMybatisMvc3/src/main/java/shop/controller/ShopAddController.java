package shop.controller;

import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import data.dto.ShopDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ShopAddController {
    private final ShopService shopService;

    public ShopAddController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shop/addform")
    public String addForm() {
        return "shop/addform";
    }
    @PostMapping("/shop/insert")
    public String insert(
            HttpServletRequest request,
            @ModelAttribute ShopDto dto,
            @RequestParam(value = "upload", required = false) List<MultipartFile> uploadList
            ) {
        // 업로드 할 save 경로 구하기
        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
        // dto에 저장할 변수명
        StringBuilder sphoto = new StringBuilder();
        if (uploadList != null && uploadList.size() > 0) {
            for (MultipartFile upload : uploadList) {
                // 원본 파일 변수명
                String originFilename=upload.getOriginalFilename();
                // 파일명을 랜덤값.확장자 형식으로 만들기(UUID)
                String extension = originFilename.substring(originFilename.lastIndexOf(".") + 1);
                String uploadFileName
                        = UUID.randomUUID()+"."+extension;

                sphoto.append(uploadFileName).append(",");

                // 업로드
                try {
                    upload.transferTo(new File(uploadFolder+"/"+uploadFileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // sphoto에서 마지막 콤마 제거
        if (sphoto.length() > 0) {
            sphoto.setLength(sphoto.length() - 1);
        }
        // dto에 저장
        dto.setSphoto(sphoto.toString());
        // db insert
        shopService.insertShop(dto);

        return "redirect:/shop/list";
    }
}
