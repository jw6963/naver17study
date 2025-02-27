package shop.controller;

import data.dto.ShopDto;
import data.dto.ShopRepleDto;
import data.service.ShopRepleService;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;
import naver.storage.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ShopDetailDeleteController {
    @Autowired
    private ShopService shopService;
    @Autowired
    ShopRepleService shopRepleService;

    // 버킷 이름
    private String bucketName = "bitcamp-bucket";
    private String naverurl = "https://kr.object.ncloudstorage.com/bitcamp-bucket";
    private String fronturl = "https://lumr99uh8720.edge.naverncp.com/MrrbyGGKhq";
    private String backurl = "?type=f&w=100&h=120&faceopt=true&ttype=jpg";
    @Autowired
    NcpObjectStorageService storageService;

    @GetMapping("/shop/detail")
    public String detail(@RequestParam("num") int num, Model model) {
        ShopDto dto = shopService.getSangpumByNum(num);
        List<String> photoList = List.of(dto.getSphoto().split(","));
        String mainPhoto = dto.getSphoto().split(",")[0]; // 첫 번째 사진
        dto.setMainphoto(mainPhoto);
        // 댓글 수 저장
        List<ShopRepleDto> replecnt = shopRepleService.getReplesByNum(dto.getNum());
        dto.setReplecnt(replecnt.size());
        model.addAttribute("dto", dto);
        model.addAttribute("photoList", photoList);
        model.addAttribute("naverurl", naverurl);
        model.addAttribute("fronturl", fronturl);
        model.addAttribute("backurl", backurl);
        return "shop/detail";
    }

    @GetMapping("/shop/delete")
    public String delete(@RequestParam("num") int num, HttpServletRequest request) {
        // 객체 호출
        ShopDto dto = shopService.getSangpumByNum(num);
        // 파일 경로
//        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
//        // 파일명
//        if (dto.getSphoto() != null && !dto.getSphoto().isEmpty()) {
//            String[] files = dto.getSphoto().split(",");
//            // 파일 삭제
//            for (String file : files) {
//                File f = new File(uploadPath + "/" + file);
//                if (f.exists()){
//                    f.delete();
//                }
//            }
//        }
        // ncp storage 파일 삭제
        storageService.deleteFile(bucketName,"shop",dto.getSphoto());

        shopService.deleteSangpum(num);
        return "redirect:/shop/list";
    }

    // 사진 수정 페이지
    @GetMapping("/shop/photos")
    public String photos(@RequestParam("num") int num, Model model) {
        String sphoto = shopService.getSangpumByNum(num).getSphoto();
        model.addAttribute("num",num);
        model.addAttribute("sphoto", sphoto);
        model.addAttribute("naverurl", naverurl);
        model.addAttribute("fronturl", fronturl);
        model.addAttribute("backurl", backurl);

        return "shop/photos";
    }

    // 사진 수정
    @GetMapping("/shop/delphoto")
    @ResponseBody
    public void delPhoto(
            @RequestParam("num") int num,
            @RequestParam("pname") String pname,
            HttpServletRequest request
    ) {
        // num에 해당하는 sphoto를 db에서 얻는다
        String sphoto = shopService.getSangpumByNum(num).getSphoto();
        // sphoto에서 pname 부분을 삭제하는데 중간일 경우 뒤에 콤마도 삭제
        if (sphoto != null && !sphoto.isEmpty()) {
            int idx= sphoto.indexOf(pname);
            if (idx != -1 && idx + pname.length() < sphoto.length() && sphoto.charAt(idx + pname.length()) == ',') {
                sphoto = sphoto.replace(pname+",","");
            } else {
                sphoto = sphoto.replace(pname,"");
            }
            // 첫 글자가 콤마로 시작하면 콤마 제거
            if (sphoto.startsWith(",")) {
                sphoto = sphoto.substring(1);
            }
        }
//        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
//        File file = new File(uploadPath+"/"+pname);
//        if (file.exists()){
//            file.delete();
//        }
        // ncp storage 파일 삭제
        storageService.deleteFile(bucketName,"shop",pname);

        // 그 변경된 changephoto를 updatePhoto를 통해서 보낸다
        shopService.updatePhoto(num,sphoto);
    }

    @PostMapping("/shop/addphoto")
    @ResponseBody
    public void addPhoto(
            @RequestParam("num") int num,
            @RequestParam("upload") List<MultipartFile> uploadList,
            HttpServletRequest request
    ){
//         업로드 경로 구하기
//        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
//        // 새로 업로드 할 파일명 구할 변수
        String photos="";
        String uploadFileName ="";
        for (MultipartFile upload : uploadList) {
            // 업로드 할 파일명
//            String uploadfileName = UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\.")[1];
//            photos+=uploadfileName+",";
//            // 업로드
//            try {
//                upload.transferTo(new File(uploadFolder+"/"+uploadfileName));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            // ncp storage upload
            uploadFileName = storageService.uploadFile(bucketName, "shop",upload);
            photos+=uploadFileName+",";
        }
        // 마지막 콤마 제거
        photos=photos.substring(0,photos.length()-1);
        // db에서의 sphoto 값 얻기
        String sphoto = shopService.getSangpumByNum(num).getSphoto();
        // sphoto가 값이 없을 경우 photos를 대입하고, 이미 있을 경우 ,를 추가 후 photos 추가
        if (sphoto != null && !sphoto.isEmpty()) {
            sphoto+=","+photos;
        } else {
            sphoto=photos;
        }
        // db에서 sphoto 수정
        shopService.updatePhoto(num,sphoto);
    }
}
