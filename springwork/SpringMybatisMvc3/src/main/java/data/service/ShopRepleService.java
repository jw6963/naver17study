package data.service;

import data.dto.ShopRepleDto;
import data.mapper.ShopRepleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopRepleService {
    @Autowired
    ShopRepleMapper shopRepleMapper;

    public void insertShopReple(ShopRepleDto dto) {
        shopRepleMapper.insertShopReple(dto);
    }

    public void deleteShopReple(int idx) {
        shopRepleMapper.deleteShopReple(idx);
    }

    public List<ShopRepleDto> getReplesByNum(int num) {
        return shopRepleMapper.getReplesByNum(num);
    }

    public void repleLikeUp(int idx) {
        shopRepleMapper.repleLikeUp(idx);
    }
}
