package week_1.HyewonBae;

import java.io.*;
import java.util.*;

public class PGS_H_Index {
	static int solution(int[] citations) {
		Arrays.sort(citations);
		// System.out.println(Arrays.toString(citations));
		
		// citations [0,1,3,5,6]
		// 0번 이상 인용된 논문 : 0,1,3,5,6 -5편
		// 1번 이상 인용된 논문 : 1,3,5,6 -4편
		// 3번 이상 인용된 논문 : 3,5,6 -3편
		// 5번 이상 인용된 논문 : 5,6 -2편
		// 6번 이상 인용된 논문 : 6 -1편
		
		int hIndex=0;
		int n=citations.length;
		for(int i=0;i<n;i++) {
			int h= n-i;	//현재 인덱스 이후의 논문의 수
			if(citations[i]>=h) {
				hIndex=h;
				break;
			}
		}
		return hIndex;
	}
    public static void main(String[] args) throws Exception{
    	 int[] citations = {0, 1, 3, 5, 6};
         int answer = solution(citations);
        
         System.out.println(answer);
    }
}