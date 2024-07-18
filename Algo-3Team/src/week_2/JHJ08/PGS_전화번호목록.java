package week_2.JHJ08;

import java.util.*;

public class PGS_전화번호목록 {

	static public boolean solution(String[] phone_book)
	{
		boolean answer = true;
        
        Arrays.sort(phone_book); // 전화번호부 정보 정렬
        
        for(int i=0; i<phone_book.length-1; i++)
        {
            int ori_len = phone_book[i].length();
            int next_len = phone_book[i+1].length();
            
            if(ori_len <= next_len) // ex>119, 1195524421
            {
                // 접두어인지 확인
                String tmp = phone_book[i+1].substring(0,ori_len);
                
                // 접두어가 존재하는 경우, for문 종료 answer 값 false로 변경
                if(phone_book[i].compareTo(tmp) == 0)
                {
                    answer = false;
                    break;
                }
            } 
        }
        
        return answer;
	}
	
	public static void main(String[] args) {

		String [] phone_book = {"119", "97674223", "1195524421"};
		//String [] phone_book = {"123","456","789"};
		//String [] phone_book = {"12","123","1235","567","88"};
		
		System.out.println(solution(phone_book));
		
	}

}
