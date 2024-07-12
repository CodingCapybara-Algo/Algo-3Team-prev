package week_1.JHJ08;

import java.util.*;
import java.io.*;

public class PGS_가장큰수 {
	
	static public String solution(int[] numbers) {
        
        // 입력받은 int 배열을 담을 string 배열 선언 및 생성
        String [] tmp_arr = new String[numbers.length];
        
        // int 정보 -> string 변환 후, tmp_arr 배열에 넣어주기
        for(int i =0; i<numbers.length; i++)
        {
            tmp_arr[i] = Integer.toString(numbers[i]);
        }
        
        // 정렬함수 호출
        // ex> 81, 818이 배열에 있는 경우 => 81818이 큰지 81881이 큰지 판단 후 정렬
        Arrays.sort(tmp_arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // 결과값 answer에 담아주기
        String answer = "";
        if (tmp_arr[0].equals("0") == false) 
        {
            for(int i=0; i<numbers.length; i++)
            {
                answer+=tmp_arr[i];
            }
        }
        else
        {
            // ex> 000이 결과값인 경우, 0으로 answer에 값 설정
            answer = "0";
        }
        
        return answer;
    }

	public static void main(String[] args) {
		
		// 입력 예시
		int [] numbers = {3, 30, 34, 5, 9};
		
		// 결과 출력
		System.out.println(solution(numbers)); // "9534330"
		

	}

}
