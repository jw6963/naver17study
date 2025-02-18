package controller.test;

import data.dto.FileNameChange;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@Controller
public class UploadMunjaeController {
    @Autowired
    FileNameChange fileNameChange;

    @GetMapping("/munjaeupload1")
    public String munjaeupload1() {
        return "uploadmunjae/munjae1form";
    }

    @PostMapping("/munjae1process")
    @ResponseBody
    public Map<String, String> munjae1process(
            HttpServletRequest request,
            @RequestParam("title") String title,
            @RequestParam("upload") MultipartFile upload
    ) {
        // 업로드 할 경우
        String uploadPath = request.getSession().getServletContext().getRealPath("/save");
        // 업로드 할 파일명
        String uploadFileName = fileNameChange.getDateChangeFilename(upload.getOriginalFilename());

        // 업로드
        try {
            upload.transferTo(new File(uploadPath + "/" + uploadFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> map = new HashMap<>();
        map.put("title", title);
        map.put("photo", uploadFileName);
        return map;
    }

    @GetMapping("/munjaeupload2")
    public String munjaeupload2() {
        return "uploadmunjae/munjae2form";
    }

    @PostMapping("/munjae2process")
    public String munjae2process(
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

        return "uploadmunjae/munjae2result";
    }
}
