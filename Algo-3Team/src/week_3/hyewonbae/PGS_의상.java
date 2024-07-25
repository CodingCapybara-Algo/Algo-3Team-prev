package week_3.hyewonbae;

import java.io.*;
import java.util.*;

public class PGS_의상 {

	static int solution(String[][] clothes) {
		HashMap<String, Integer> clothesMap=new HashMap<>();
		
		/**
		 * clothesMap
		 *   종류 	| 개수
		 * headgear |  2
		 * eyewear  |  1
		 * 
		 * */
		
		for(String[] cloth: clothes) {
			clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0)+1);
		}
		
		/**
		 * 조합의 수
		 * 각 종류별 개수 + 1 한 값의 곱 --> 선택 안 하는 경우도 포함   
		 * (point) 아무것도 선택 안 하는 경우는 제외해야 하기 때문에 결과 값 -1 해주어야 함
		 * */

		int result=1;
		for(int count: clothesMap.values()) {
			result *= (count+1);
		}
		
		return result-1;
	}

	public static void main(String[] args) {
		
		//Test Case 1:
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes)); // 출력: 5
        
        //Test Case 2:
//        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
//        System.out.println(solution(clothes)); // 출력: 3
	}


}
