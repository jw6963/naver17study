package data.mapper;

import data.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    public int checkMyid(String id);
    public void insertMember(MemberDto dto);
    public List<MemberDto> getAllDatas();
    public void deleteMember(int num);
    public MemberDto getOneByNum(int num);
    public int loginChk(String loginid, String loginpass);
    public MemberDto getOneById(String myid);
    public void changePhoto(int num, String mphoto);
    public void updateMember(MemberDto dto);
}
