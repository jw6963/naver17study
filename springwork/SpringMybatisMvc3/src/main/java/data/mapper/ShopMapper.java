package data.mapper;

import data.dto.ShopDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopMapper {
    // 전체 수
    public int getTotalCount();
    // 추가
    public void insertShop(ShopDto dto);
    // 전체 조회
    public List<ShopDto> getAllSangpum();
    // 특정 조회
    public ShopDto getSangpumByNum(int num);
    // 특정 수정
    public void updateSangpum(ShopDto dto);
    // 특정 삭제
    public void deleteSangpum(int num);
    // 사진 수정
    public void updatePhoto(Map<String, Object> map);
}
