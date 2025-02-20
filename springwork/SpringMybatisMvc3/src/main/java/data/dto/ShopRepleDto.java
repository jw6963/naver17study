package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("ShopRepleDto")
public class ShopRepleDto {
    private int idx;
    private int likes;
    private int num;
    private String photo;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp writetime;
}
