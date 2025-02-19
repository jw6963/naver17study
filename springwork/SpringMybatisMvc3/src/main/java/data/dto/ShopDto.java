package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("sdto")
public class ShopDto {
    private int num;
    private String sangpum;
    private String scolor;
    private int sprice;
    private int scnt;
    private String sphoto;
    private String ipgoday;
    private Timestamp writeday;
    private  String mainphoto;
}