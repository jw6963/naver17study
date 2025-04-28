package bit.react.repository;

import bit.react.data.ShopEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopRepository extends JpaRepository<ShopEntity, Integer> {

    @Query("" +
            "update ShopEntity s " +
            "set s.sangpum = :#{#entity.sangpum}, s.price = :#{#entity.price}, s.color = :#{#entity.color}" +
            ", s.sangguip = :#{#entity.sangguip} " +
            "where s.num = :#{#entity.num}")
    @Modifying // insert, update, delete 뿐만 아니라 DDL 구문을 사용할 때도 표기를 해야 한다.
    @Transactional // update, delete를 할 때 표기를 해줘야 정상 실행이 된다.
    public void updateShopNoPhoto(@Param("entity") ShopEntity entity);
}
