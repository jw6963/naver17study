package data.dto;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileNameChange {
    public String getDateChangeFilename(String originalFileName) {
        // 파일 명에 날짜를 붙여서 업로드해보자
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        // 예)a.jpg => a_20250218104123.jpg
        String filename = originalFileName.split("\\.")[0];
        String ext = originalFileName.split("\\.")[1];
        String uploadFileName = filename + "_" + sdf.format(new Date()) + "." + ext;

        return uploadFileName;
    }

    public String getRandomChangeFilename(String originalFileName) {
        String ext = originalFileName.split("\\.")[1];
        String uploadFileName = UUID.randomUUID() + "." + ext;

        return uploadFileName;
    }
}
