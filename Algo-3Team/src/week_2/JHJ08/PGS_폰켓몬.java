package week_2.JHJ08;

import java.util.*;

public class PGS_폰켓몬 {
	
	static public int solution(int[] nums) {
		int answer = 0;
		
		int max = nums.length/2;
	      
		// 폰켓몬의 종류 번호를 담을 set_info 생성
        Set<Integer> set_info = new HashSet <>();
        
        // set_info에 폰켓몬 종류 정보 담기
        for(int i=0; i<nums.length; i++)
        {
        	set_info.add(nums[i]);
        }
        
        // set_info에 추가된 폰켓몬 종류가 N/2 보다 큰 경우
        if(set_info.size() > max)
        {
            answer = max;
        }
        else // set_info에 추가된 폰켓몬 종류가 N/2 보다 크지 않은 경우
        {
            answer = set_info.size();
        }
	        
		return answer;
	}

	public static void main(String[] args) {

		//int [] nums = {3,1,2,3};
		//int [] nums = {3,3,3,2,2,4};
		int [] nums = {3,3,3,2,2,2};
		
		int answer = solution(nums);
		
		System.out.println(answer);

	}

}
