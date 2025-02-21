package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("MemberDto")
public class MemberDto {
    private int num;
    private String mname;
    private String mpass;
    private String myid;
    private String mhp;
    private String maddr;
    private String mphoto;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp gaipday;
}
