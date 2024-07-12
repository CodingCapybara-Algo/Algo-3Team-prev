package week_1.JHJ08;

import java.io.*;
import java.util.*;

public class PGS_H_Index {
	
	static public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations); // 정렬 해주기 
        
        // 정렬 => [0, 1, 3, 5, 6]
        // 0번 이상 인용된 논문 갯수 : citations.length(=5)
        // 1번 이상 인용된 논문 갯수 : citations.length(=5) - 1 = 4
        // 3번 이상 인용된 논문 갯수 : citations.length(=5) - 2 = 3
        // 5번 이상 인용된 논문 갯수 : citations.length(=5) - 3 = 2
        // 6번 이상 인용된 논문 갯수 : citations.length(=5) - 4 = 1
        
        for(int i=0; i<citations.length; i++)
        {
            int h = citations.length - i; // 논문 갯수
            
            if(citations[i] >= h) //h번 이상 인용된 논문이 h편 이상인 경우 확인
            {
                if(h >= answer) // 최대값 갱신
                {
                     answer = h;
                }
            }
        }
        
        return answer; // 결과값 반환
    }

	public static void main(String[] args) {
		
		// 입력 예시
		int [] citations = {3, 0, 6, 1, 5};
		
		// 결과 출력
		System.out.println(solution(citations)); // 3

	}

}
