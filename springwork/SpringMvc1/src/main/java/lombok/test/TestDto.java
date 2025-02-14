package lombok.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // default 생성자
@AllArgsConstructor // 모든 변수를 인자로 갖는 생성자
public class TestDto {
	private String name;
	private String addr;
	private String hp;
}
