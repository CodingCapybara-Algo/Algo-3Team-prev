package week_2.hyewonbae;

import java.io.*;
import java.util.*;

public class PGS_전화번호목록 {
	static boolean answer=true;
	static boolean solution(String[] phone_book) {
		Set<String>set=new HashSet<>();

		for(String number : phone_book) {
		    set.add(number);
		}
		
		// number: 1235
		for(String number : phone_book) {
			//"1", "12", "123"
			for(int i=1;i<number.length();i++) {
				if(set.contains(number.substring(0,i))) {		//접두사로 포함하는지 확인 여부
					answer=false;
				}
			}
		}
		return answer;
    }
	
	public static void main(String[] args) throws Exception {
		// Test case 1
//		String[] phone_book= {"119", "97674223", "1195524421"};
		// Test case 2
		String[] phone_book= {"123","456","789"};
		// Test case 2
//		String[] phone_book= {"12","123","1235","567","88"};
		
		solution(phone_book);
		System.out.println(answer);
	}

}
