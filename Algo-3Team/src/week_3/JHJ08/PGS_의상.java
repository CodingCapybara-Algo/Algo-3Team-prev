package week_3.JHJ08;

import java.util.*;

public class PGS_의상 {

	static public int solution(String [][] clothes)
	{
		Map<String, Integer> map_info = new HashMap<>(); // 키 - 의상의 종류, 값 - 의상 종류 개수
		
		for(int i=0; i<clothes.length; i++)
		{
			if(map_info.containsKey(clothes[i][1]))
			{
				// 이미 있는 경우
				map_info.replace(clothes[i][1], map_info.get(clothes[i][1])+1);
			}
			else
			{
				// 없는 경우
				map_info.put(clothes[i][1], 1);
			}
		}
		
		// 경우의 수 계산
		int amswer = 1;
		
		for(String key : map_info.keySet())
		{
			amswer *= (map_info.get(key) + 1); // 1을 더해주는 이유 : 아이템을 착용하지 않은 경우 추가
		}
		
		amswer-=1; // 1을 빼주는 이유 : 최소 한가지의 아이템은 착용해야하기 때문에
		
		return amswer;
	}
	
	
	public static void main(String[] args) {
		
		// 입력값 예시
		String [][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
		//String [][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		
		
		// 결과 출력
		System.out.println(solution(clothes));
	}

}
