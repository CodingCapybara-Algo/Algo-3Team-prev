package week_1.eunsoo;

import java.io.*;
import java.util.*;

/* H-index
 * citations: 논문 인용횟수 배열
 -- 발표 논문 n개 중 h번 이상 인용된 게 h편 이상,
 -- 나머지 논문이 h번 이하 인용된 경우
 * 출력 ==> h 최댓값
 * [분석] Arrays.sort()로 간단히 오름차순 정렬!
 * (방법) 가장 큰 원소값부터 -1하며 개수세고 h개 넘는지 확인
 */
    
public class PGS_HIndex {
    public static int solution(int[] citations) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(citations); //오름차순 정렬
        for(int h=citations[citations.length-1]; h>=0; h--) { //가장 큰 원소값부터 => h
        	int len_up=0, len_dw=0;
        	for(int j=0; j<citations.length; j++) {
        		if(citations[j] >= h) len_up++; //h편이상 인용된 논문수
        		if(citations[j] < h) len_dw++; //h편미만 인용된 논문수
        	}
        	//h 최댓값 갱신
        	if(len_up>=h && len_dw<=h) max=Math.max(max, h); 
        }
        return max;
    }
    
    public static void main(String[] args) throws Exception{
    	int answer = solution(new int[] {3, 0, 6, 1, 5});
    	System.out.println(answer);
	}
}