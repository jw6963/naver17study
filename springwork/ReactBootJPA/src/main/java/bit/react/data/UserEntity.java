package bit.react.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "jpajoin")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40)
    private String username;

    @Column(length = 100)
    private String password;

    private String address;

    @Column(length = 20)
    private String role;

    @CreationTimestamp
    @Column(updatable = false)
    private String gaipday;
}
