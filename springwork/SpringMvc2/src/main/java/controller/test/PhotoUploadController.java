package controller.test;

import data.dto.FileNameChange;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@Controller
public class PhotoUploadController {
    @Autowired
    FileNameChange fileNameChange;

    @GetMapping("/uploadform")
    public String uploadform() {

        return "upload/uploadform";
    }

    @PostMapping("/uploadprocess")
    public String uploadprocess(
            HttpServletRequest request,
            Model model,
            @RequestParam String title,
            @RequestParam("upload") MultipartFile upload
    ) {
        // 업로드 할 프로젝트 내의 위치를 지정
//        String uploadFolder = request.getSession().getServletContext().getRealPath("/resources/upload");
        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
        // 업로드 할 파일 명
        // original 이름으로 저장할 경우 같은 이름 업로드 시 덮어 씌어 지는 문제 발생
//        String uploadFile = upload.getOriginalFilename();

        String uploadFileName = fileNameChange.getDateChangeFilename(upload.getOriginalFilename());

        // 업로드
        try {
            upload.transferTo(new File(uploadFolder + "/" + uploadFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("title", title);
        model.addAttribute("photo", uploadFileName);

        return "upload/uploadresult";
    }

    // 파일 여러 개 업로드
    @GetMapping("/multiform")
    public String multiform() {
        return "upload/uploadformmulti";
    }

    @PostMapping("/multiprocess")
    public String multiprocess(
            HttpServletRequest request,
            @RequestParam String title,
            @RequestParam("upload") List<MultipartFile> uploadList,
            Model model
    ) {
        // 제목부터 모델에 저장
        model.addAttribute("title", title);

        // 업로드할 프로젝트 내의 위치를 지정(webapp/save)
        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");

        // 업로드된 파일명을 저장할 리스트 변수
        List<String> list = new Vector<>();

        // 여러 개의 파일들을 업로드(파일 명은 뒤에 날짜 붙여서 업로드 하기)
        for (MultipartFile multiFile : uploadList) {
            // 업로드 할 파일명 구하기
//            String uploadFileName = fileNameChange.getDateChangeFilename(multiFile.getOriginalFilename());
            String uploadFileName = fileNameChange.getRandomChangeFilename(multiFile.getOriginalFilename());
            // 업로드
            try {
                multiFile.transferTo(new File(uploadFolder + "/" + uploadFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 업로드된 파일명 list에 추가
            list.add(uploadFileName);
        }
        model.addAttribute("list", list);

        return "upload/uploadresultmulti";
    }

    // ajax
    @GetMapping("/ajaxupload")
    public String ajaxupload() {
        return "upload/ajaxphotoupload";
    }

    // 사진을 업로두 후 json 형태로 파일명 반환
    // ajax 함수를 통해서 호출되는 메서드
    @PostMapping("/oneupload")
    @ResponseBody
    public Map<String, String> oneupload(
            HttpServletRequest request,
            @RequestParam("upload") MultipartFile upload
    ) {
        // 업로드 할 경우
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        // 업로드 할 파일명
        String uploadFileName = fileNameChange.getDateChangeFilename(upload.getOriginalFilename());

        // 업로드
        try {
            upload.transferTo(new File(uploadPath+"/"+uploadFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> map = new HashMap<>();
        map.put("photo", uploadFileName);

        return map;
    }

    // ajax 여러 개 사진 업로드
    @GetMapping("/multiajaxupload")
    public String multiajaxupload() {
        return "upload/ajaxmultiuploadform";
    }

    @PostMapping("/multiuploadprocess")
    @ResponseBody
    public List<Map<String,String>> multiuploadprocess(
            HttpServletRequest request,
            @RequestParam("upload") List<MultipartFile> uploadList
    ) {
        // 업로드할 프로젝트 내의 위치를 지정(webapp/save)
        String uploadFolder = request.getSession().getServletContext().getRealPath("/save");

        // 업로드된 파일명을 저장할 리스트 변수
        List<Map<String,String>> list = new Vector<>();

        for (MultipartFile multiFile : uploadList) {
            // 업로드 할 파일명 구하기
            String uploadFileName = fileNameChange.getRandomChangeFilename(multiFile.getOriginalFilename());
            // 업로드
            try {
                multiFile.transferTo(new File(uploadFolder + "/" + uploadFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 업로드된 파일명 list에 추가
            Map<String, String> map = new HashMap<>();
            map.put("photo", uploadFileName);
            list.add(map);
        }

        return list;
    }
}
