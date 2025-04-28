package bit.react.controller;

import bit.react.data.ShopDto;
import bit.react.data.ShopEntity;
import bit.react.repository.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import naver.storage.NcpObjectStorageService;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/react")
public class ReactShopController {
    @Autowired
    private NcpObjectStorageService storageService;
    @Autowired
    private ShopDao shopDao;

    private String uploadFileName;

    //네이버 클라우드 버켓네임
    private String bucketName = "bitcamp-semi";
    //스토리지의 폴더명
    private String folderName = "jpashop";

    @PostMapping(value = "/addshop")
    public String addShop(@RequestBody ShopDto dto) { // json 데이터를 자바 객체로 변환
        ShopEntity shopEntity = ShopEntity.builder()
                .sangpum(dto.getSangpum())
                .price(dto.getPrice())
                .sangguip(dto.getSangguip())
                .color(dto.getColor())
                .photo(uploadFileName)
                .build();
        // db에 저장
        shopDao.insertShop(shopEntity);
        // 업로드한 파일명은 초기화
        uploadFileName = null;

        return "insert ok!";
    }

//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // for swagger test
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("upload") MultipartFile upload) {
        // 스토리지에 업로드
        if(uploadFileName != null) {
            storageService.deleteFile(bucketName, folderName, uploadFileName);
        }
        uploadFileName = storageService.uploadFile(bucketName, folderName, upload);

        return uploadFileName;
    }

    @GetMapping("/detail")
    public ShopEntity getSelectData(@RequestParam int num) {
        return shopDao.getData(num);
    }

    @GetMapping("/shoplist")
    public List<ShopEntity> getShopList() {
        return shopDao.findAll();
    }

    @DeleteMapping("/shopdelete")
    public String deleteShop(@RequestParam int num) {
        // 삭제 전에 스토리지 사진 지우기
        String photoName = shopDao.getData(num).getPhoto();
        storageService.deleteFile(bucketName, folderName, photoName);

        // 삭제
        shopDao.deleteShop(num);

        return "delete ok!";
    }

    @PostMapping("/shopupdate")
    public String updateShop(@RequestBody ShopDto dto) {
//        ShopEntity entity = shopDao.getData(dto.getNum());
//        entity.setSangpum(dto.getSangpum());
//        entity.setPrice(dto.getPrice());
//        entity.setSangguip(dto.getSangguip());
//        entity.setColor(dto.getColor());
//        entity.setPhoto(uploadFileName);
//        shopDao.updateShop(entity);
        ShopEntity entity = ShopEntity.builder()
                .sangpum(dto.getSangpum())
                .color(dto.getColor())
                .price(dto.getPrice())
                .sangguip(dto.getSangguip())
                .num(dto.getNum())
                .photo(uploadFileName)
                .build();
        shopDao.updateShop(entity);
        uploadFileName = null;
        return "update ok!";
    }
}
