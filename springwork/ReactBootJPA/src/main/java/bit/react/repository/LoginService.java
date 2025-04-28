package bit.react.repository;

import bit.react.data.UserEntity;
import bit.react.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    public String login(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("user not found");
            return null;
        }
        if (!encoder.matches(password, user.getPassword())) {
            System.out.println("wrong password");
            return null;
        }
        String accessToken= jwtUtil.createAccessToken(user);

        return accessToken;
    }
}
