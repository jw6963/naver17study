package day1226;

public class Sawon {
	private String SawonName;
	private int age;
	private String hp;
	private String addr;
	
	public Sawon() {
		
	}

	public Sawon(String sawonName, int age, String hp, String addr) {
		super();
		SawonName = sawonName;
		this.age = age;
		this.hp = hp;
		this.addr = addr;
	}

	public String getSawonName() {
		return SawonName;
	}

	public void setSawonName(String sawonName) {
		SawonName = sawonName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	


}
