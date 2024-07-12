package week_1.JHJ08;

import java.util.*;
import java.io.*;

public class PGS_K번째수 {
	
	 static public int[] solution(int[] array, int[][] commands) 
	 {
	        int[] answer = new int[commands.length];
	        
	        ArrayList <Integer> tmp_list = new ArrayList<>(); // 추출한 배열 정보를 저장할 리스트 생성
	        
	        for(int idx=0; idx<commands.length; idx++)
	        {
	            tmp_list.clear(); // 초기화
	            
	            int i = commands[idx][0]-1; // 시작 인덱스
	            int j = commands[idx][1]-1; // 끝 인덱스
	            int k = commands[idx][2]-1; // 몇번째 숫자인지
	            
	            for(;i<=j; i++)
	            {
	                tmp_list.add(array[i]);
	            }
	            
	            Collections.sort(tmp_list);
	            
	            // 찾은 수를 answer에 추가해준다.
	            answer[idx] = tmp_list.get(k);
	            
	        }
	        
	        return answer;
	}

	public static void main(String[] args) {
		
		// 입력 예시
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		// 구현 함수
		int [] answer = solution(array,commands);
		
		// 결과 출력
		for(int i=0; i<answer.length; i++)
        {
        	System.out.print(answer[i] + " "); // 5, 6, 3
        }
	}

}
