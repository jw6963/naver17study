package day1219;

public class Ex10MyCarArray {
	
	public static void showTitle() {
		System.out.println("자동차명\t가격\t색상\t구입일");
		System.out.println("=".repeat(50));
	}
	
	public static void writeMyCar(MyCar myCar) {
		System.out.println(myCar.getCarName()+"\t"+myCar.getCarPrice()+"\t"+myCar.getCarColor()+"\t"+myCar.getGuipDay());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCar my1 = new MyCar();
		System.out.println(my1); // toString이 있을 경우 자동 호출 (없으면 주소 나옴)

		MyCar my2 = new MyCar("소나타",3900,"하늘색");
		System.out.println(my2);
		
		System.out.println("객체 배열 생성");
		// 방법 1
//		MyCar[] carArray= {
//				new MyCar(),
//				new MyCar("그랜져",5600,"검정색"),
//				new MyCar("BMW",6700,"흰색")
//		};
		// 방법 2
		MyCar[] carArray=new MyCar[3]; // 메모리 할당, 초기값 null
		carArray[0]=new MyCar();
		carArray[1]=new MyCar("그랜져",5600,"검정색");
		carArray[2]=new MyCar("BMW",6700,"흰색");
		
		System.out.println();
		// 제목 출력
		showTitle();
//		for (int i=0;i<carArray.length; i++) {
//			writeMyCar(carArray[i]);
//		}
		for (MyCar my:carArray) {
			writeMyCar(my);;
		}
	}

}