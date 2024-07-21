package week_2.eunsoo;
import java.io.*;
import java.util.*;

/* 완주하지 못한 선수
 * participant: 마라톤 참여 명단
 * completion: 완주 명단
 * (분석 1) 정렬[명단순서 맞춰주기] -> 비교[없는이름 확인]
 * (분석 2) 해시[이름,인원수] -> 비교[완주명단 가지고 해시-1씩] -> 최종 남은 해시 반환
 * (시간) 해시(0.05ms) < 정렬 (0.21ms)
 */

public class PGS_완주하지못한선수 {
	 public static String solution(String[] participant, String[] completion) {
		 String answer = "";
		 
		 /* (분석 1) 정렬 -> 비교 */
		 Arrays.sort(participant); //(1) 정렬 (명단순서 맞추기)
		 Arrays.sort(completion);
		 for(int i=0; i<completion.length; i++) { //(2) 없는 명단 확인
			 if(!participant[i].equals(completion[i])) { //다르면
				 answer = participant[i]; //없는 친구로 간주
                 break;
			 }
		 }
         if(answer == "") //(3) 완주명단 다 돌았는데 없으면
             answer = participant[participant.length-1]; //마지막 참가자
		 
		/* (분석 2) 해시 -> 비교 */
        HashMap<String, Integer> h = new HashMap<>(); //(1) 해시 생성
        for(String p:participant) h.put(p, h.getOrDefault(p, 0)+1);
        for(String c:completion) h.replace(c, h.get(c)-1); //(2) 있는 선수 제거
        for(String p:participant) { //(3) 남은 선수 출력
        	if(h.get(p)!=0) answer=p;
        }
        return answer;
	 }
	 
	 public static void main(String[] args) {
		String answer = solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"});
		System.out.println(answer);
	}
}