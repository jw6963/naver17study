package data.service;

import data.dto.MemberDto;
import data.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;
    public boolean checkMyid(String myid) {
//        if (memberMapper.checkMyid(myid) == 1) {
//            return true;
//        } else {
//            return false;
//        }
        return memberMapper.checkMyid(myid)==1?true:false;
    }

    public void addMember(MemberDto member) {
        memberMapper.insertMember(member);
    }

    public List<MemberDto> getMembers() {
        return memberMapper.getAllDatas();
    }

    public void deleteMember(int num) {
        memberMapper.deleteMember(num);
    }

    public MemberDto getMember(int num) {

        return memberMapper.getOneByNum(num);
    }
}
