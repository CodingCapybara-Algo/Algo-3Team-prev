package week_3.JHJ08;

import java.util.*;

public class PGS_타겟넘버 {

	static int N = 0;
	static int C = 0;
	
	static void subs(int cnt, int res, int [] numbers, int target)
	{
		if(cnt == N) // 종료조건
		{
			if(res == target)
			{
				C++;
			}
			
			return;
		}
		
		// 더한 경우
		subs(cnt+1, res+numbers[cnt], numbers, target);
		
		// 뺀 경우
		subs(cnt+1, res-numbers[cnt], numbers, target);
	}
	
	static public int solution(int[] numbers, int target) {
        
		int answer = 0;
        
		N = numbers.length;
        subs(0,0,numbers,target);
        
        answer = C;
        
        return answer;
    }
	
	
	public static void main(String[] args) {

		// 입력값 예시
		int [] numbers = {1,1,1,1,1};
		int target = 3;
		
		//int [] numbers = {4, 1, 2, 1};
		//int target = 2;
		
		// 결과 출력
		System.out.println(solution(numbers,target));
		
	}
}
