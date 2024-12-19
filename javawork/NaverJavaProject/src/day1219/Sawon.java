package day1219;

public class Sawon {

	/*
	 * 멤버 변수 사원명 sawonName, 직급 position, 가족수 famSu
	 */
	private String sawonName;
	private String position;
	private int famSu;
	
	/*
	 * 생성자
	 * default 생성자 실행할 게 없어도 만들어 놓는 게 좋다. 만들기만 하기
	 * 
	 * 사원명,직급, 가족수를 인자로 받는 생성자
	 */
	Sawon() {
		
	}
	public Sawon(String sawonName, String position, int famSu) {
		setSawonName(sawonName);
		setPosition(position);
		setFamSu(famSu);		
	}
	
	/*
	 * setter & getter method
	 */
	public String getSawonName() {
		return sawonName;
	}
	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getFamSu() {
		return famSu;
	}
	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}
	
	/*
	 * 직급에 따라 기본급을 구하는데 부장 -> 450, 과장 -> 300, 대리->250, 사원 ->150
	 * 메서드명 : getGibonPay()
	 */
	public int getGibonPay(String position) {
		int gibonPay=0;
		switch(position) {
		case "부장":
			gibonPay = 450;
			break;
		case "과장":
			gibonPay=300;
			break;
		case "대리":
			gibonPay=250;
			break;
		case"사원":
			gibonPay=150;
			break;
		}
		return gibonPay;
	}
	
	/*
	 * 직급에 따라 수당을 구하는데 부장,과장->70, 대리,사원 ->50
	 * getSudang()
	 */
	public int getSudang(String position) {
		int sudang =0;
		switch(position) {
		case"부장","과장":
			sudang=70;
			break;
		case"대리","사원":
			sudang=50;
			break;
		}
		return sudang;
	}
	
	/*
	 * getGibonPay() 값을 반환 받아서 세금 5%를 구해서 반환하는 
	 * getTax()
	 */
	public int getTax(int gibonPay) {
		return (int)(gibonPay*0.05);
	}
	
	/*
	 * 가족수가 5인 이상이면 30 반환, 5인 미만 2인 이상은 10 반환, 나머지는 0
	 * getFamSudang()
	 */
	public int getFamSudang(int famSu) {
		if (famSu>=5) {
			return 30;
		} else if (famSu<=1) {
			return 0;
		} else {
			return 10;
		}
	}
	
	/*
	 * 실수령액을 구해서 반환하는 메서드 기본급 + 수당 - 세금 + 가족수당을 구해서 반환
	 * getNetPay()
	 */
	public int getNetPay(int gibonPay, int sudang, int tax, int famSudang) {
		return gibonPay+sudang+famSudang-tax;
	}
}
