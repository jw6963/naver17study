package data.mapper;

import data.dto.ShopRepleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopRepleMapper {
    public void insertShopReple(ShopRepleDto shopRepleDto);
    public void deleteShopReple(int idx);
    public List<ShopRepleDto> getReplesByNum(int num);
    public void repleLikeUp(int idx);
}