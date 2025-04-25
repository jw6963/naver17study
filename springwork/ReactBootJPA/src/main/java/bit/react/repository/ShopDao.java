package bit.react.repository;

import bit.react.data.ShopEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDao {
    @Autowired
    ShopRepository shopRepository;

    // 저장
    public void insertShop(ShopEntity shopEntity) {
        shopRepository.save(shopEntity); // num 값이 포함되어 있지 않으면 추가
    }

    // 전체 목록
    public List<ShopEntity> findAll() {
        return shopRepository.findAll();
    }

    // 한 개의 데이터 반환
    public ShopEntity getData(int num) {
        return shopRepository.getReferenceById(num);
    }

    // 삭제
    public void deleteShop(int num) {
        shopRepository.deleteById(num);
    }

    // 수정
    public void updateShop(ShopEntity shopEntity) {
        shopRepository.save(shopEntity); // num이 포함되어 있으므로 수정됨
    }
}
