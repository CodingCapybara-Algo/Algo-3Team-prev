package week_1.HyewonBae;

import java.io.*;
import java.util.*;

public class PGS_가장큰수 {
	
	    static String solution(int[] numbers) {
    		String[] st=new String[numbers.length];
			
			for(int i=0;i<numbers.length;i++) {
				st[i]=String.valueOf(numbers[i]);
			}

			// 두 수를 합친 값이 큰 순서대로 정렬(내림차순)
			// o1:6, o2:10 인 경우 610 과 106을 비교
			Arrays.sort(st,(o1,o2)->{return -(o1+o2).compareTo(o2+o1);});
			
			// 첫번째 수가 0이면 0으로만 이루어진 배열이므로 0을 리턴
			if(st[0].equals("0")) {
				return "0";
			}
			
			return String.join("", st);

	    }
	    public static void main(String[] args) throws Exception{
	    	int[] numbers= {6,10,2};
	    	
	    	String answer=solution(numbers);
	    	System.out.println(answer);
	    }
}