package bit.react.repository;

import bit.react.data.JoinDto;
import bit.react.data.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto dto) {
        String username = dto.getUsername();
        Boolean isExist = userRepository.existsByUsername(username);
        if (isExist) {
            System.out.println("db에 이미 존재 함");
            return;
        }
        UserEntity data = UserEntity.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .address(dto.getAddress())
                .build();
        userRepository.save(data);
    }
}
