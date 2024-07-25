package week_3.eunsoo;

import java.io.*;
import java.util.*;

/* 의상
 * [입력] clothes : 옷 2차원 배열
 * [출력] 다른 옷의 조합 수
 * [분석] 해시[종류,개수] -> 각 종류별 (개수+1) 곱해주기 -> -1
 * 					     		  개수+1 : 안입는경우  -1 : 전체 다 안입는 건 제외
 */

public class PGS_의상 {
	public static int solution(String[][] clothes) {
        int answer = 1;
        //1. 해시[종류,개수] 생성
        HashMap<String, Integer> h = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
        	String kind = clothes[i][1];
        	h.put(kind, h.getOrDefault(kind, 1)+1); //안 입는 경우 포함 -> 미리 +1
        }
        //2. 다른 가짓수 계산
        for(int v:h.values()) answer *= v;
        answer--; //전체 안입는경우 빼기
        return answer;
    }	

	public static void main(String[] args) {
		int answer = solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
		System.out.println(answer);
	}

}
