package day1211;

public class Ex1DataType {

	public static void main(String[] args) {
		byte a = 127;
		byte b = (byte)128; // 128 - 128 = 0 => -128
		byte c = (byte)426; // 512 - 426 = 86 => -86
		byte d = (byte)161; // 256 - 161 = 95 => -95
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		System.out.println("c="+c);
		System.out.println("d="+d);
	}
}