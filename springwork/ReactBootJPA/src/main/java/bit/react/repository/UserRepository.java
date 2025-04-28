package bit.react.repository;

import bit.react.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    // username이 존재하는지 true/false로 반환
    Boolean existsByUsername(String username);

    // 해당 username 정보를 UserEntity 타입으로 반환
    UserEntity findByUsername(String username);
}
