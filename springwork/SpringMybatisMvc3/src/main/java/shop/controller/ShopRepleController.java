package shop.controller;

import data.dto.ShopRepleDto;
import data.service.ShopRepleService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

@RestController
public class ShopRepleController {

    @Autowired
    private ShopRepleService shopRepleService;

    // 버킷 이름
    private String bucketName = "bitcamp-bucket";

    @Autowired
    NcpObjectStorageService storageService;

    @PostMapping("/shop/addreple")
    public void insertReple(
        HttpServletRequest request,
        @RequestParam int num,
        @RequestParam String message,
        @RequestParam("upload") MultipartFile upload
    ){
//        // save의 실제 경로 구하기
//        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
//        // 업로드할 파일명(랜덤 문자열.확장자)
//        String fileName = UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\.")[1];
//        // 사진 업로드
//        File uploadFile = new File(uploadPath+"/"+fileName);
//        try {
//            upload.transferTo(uploadFile);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        String fileName = storageService.uploadFile(bucketName, "shop",upload);
        // dto 생성
        ShopRepleDto dto = new ShopRepleDto();
        dto.setMessage(message);
        dto.setNum(num);
        dto.setPhoto(fileName);
        // db insert
        shopRepleService.insertShopReple(dto);
    }

    @GetMapping("/shop/repleList")
    public List<ShopRepleDto> getRepleList(
            @RequestParam int num
    ) {
      return shopRepleService.getReplesByNum(num);
    };

    @GetMapping("/shop/repleLike")
    public void repleLike(@RequestParam int idx){
        shopRepleService.repleLikeUp(idx);
    }

    @GetMapping("/shop/repleDelete")
    public void repleDelete(
            @RequestParam int idx,
            @RequestParam String pname,
            HttpServletRequest request
    ){
//        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
//        File file = new File(uploadPath+"/"+pname);
//        if (file.exists()){
//            file.delete();
//        }
        // ncp storage 파일 삭제
        storageService.deleteFile(bucketName,"shop",pname);
        shopRepleService.deleteShopReple(idx);
    }
}
