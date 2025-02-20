package data.service;

import data.dto.ShopDto;
import data.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopService {
    @Autowired
    ShopMapper shopMapper;

    public int getTotalCount() {
        return shopMapper.getTotalCount();
    }
    public void insertShop(ShopDto dto) {
        shopMapper.insertShop(dto);
    }
    public List<ShopDto> getAllSangpum() {
        return shopMapper.getAllSangpum();
    }
    public ShopDto getSangpumByNum(int num) {
        return shopMapper.getSangpumByNum(num);
    }
    public void updateSangpum(ShopDto dto) {
        shopMapper.updateSangpum(dto);
    }
    public void deleteSangpum(int num) {
        shopMapper.deleteSangpum(num);
    }
    public void updatePhoto(int num, String photo){
        Map<String ,Object> map = new HashMap<>();
        map.put("num",num);
        map.put("photo",photo);
        shopMapper.updatePhoto(map);
    }
}
