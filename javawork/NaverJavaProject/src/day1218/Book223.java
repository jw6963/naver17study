package day1218;

public class Book223 {

	String nation = "대한민국";
	String name;
	String ssn;
	
	public Book223(String n, String s) {
		name = n;
		ssn = s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book223 book1 = new Book223("전종원","1234");
		System.out.println("book1.nation: "+ book1.nation);
		System.out.println("book1.name: "+ book1.name);
		System.out.println("book1.ssn: "+ book1.ssn);
		System.out.println();
		
		Book223 book2 = new Book223("김준호","5677");
		System.out.println("book1.nation: "+ book2.nation);
		System.out.println("book1.name: "+ book2.name);
		System.out.println("book1.ssn: "+ book2.ssn);
		System.out.println();
		System.out.println(book1.name.substring(0, 2));
		
		String answer = "";
        String temp="";
        int[] index_list = {1,2,3,4};
        String my_string = "sdadsadsrwij";
        for (int i=0; i<index_list.length; i++) {
            temp+=String.valueOf(my_string.charAt(index_list[i]));
        }
        System.out.println(temp);
        temp.contains(my_string);
	}

}