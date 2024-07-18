package week_2.JHJ08;

import java.util.*;

public class PGS_완주하지못한선수 {

	static public String solution(String[] participant, String[] completion) 
	{
		String answer = "";
        
        Map <String, Integer> map_info = new HashMap<>(); // 이름, 이름에 해당하는 사람 수...
        
        // 참가자 정보 저장
        for(int i=0; i<participant.length; i++)
        {
            if(map_info.containsKey(participant[i]) == true)
            {
                // 해당 이름으로 등록된 사람이 있는 경우 - 기존에 등록된 사람 수 + 1로 정보 갱신
            	map_info.replace(participant[i] , map_info.get(participant[i])+1);
            }
            else
            {
                // 없는 경우 - 추가 (이름, 1)
            	map_info.put(participant[i], 1);
            }
        }
        
        // 완주한 사람들의 이름과 참가자 이름 비교 후 계산
        for(int i=0; i<completion.length; i++)
        {
            if(map_info.containsKey(completion[i]) == true)
            {
                int value = map_info.get(completion[i]);
                if(value == 1) // 사람 수가 1명인 경우, 완주한 사람이기 때문에 map_info에서 정보를 삭제
                {
                	map_info.remove(completion[i]);
                }
                else
                {
                	map_info.replace(completion[i], value-1); // 1명 이상인 경우, 사람 수를 1명 감소시켜준다
                }
            }
        }
        
        // map_info에 남아 있는 사람은 완주하지 못한 사람..
        for(String key : map_info.keySet())
        {
            answer = key;
        }
        
        return answer;
	}
	
	
	public static void main(String[] args) {
		
		//String[] participant = {"leo", "kiki", "eden"};
		//String[] completion = {"eden", "kiki"};
		
		//String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		//String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		String answer = solution(participant, completion);
		
		System.out.println(answer);
		
		
		
	}

}
