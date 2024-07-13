package week_1.eunsoo;

import java.io.*;
import java.util.*;

/* K번째 수 
 * array: 기존배열, commands: 명령어배열
 * (i,j,k): 시작,끝,위치
 -- 기존배열의 시작~끝 원소만 정렬
 * 출력 ==> 각 정렬된 리스트의 위치 배열
 * [분석] Arrays.sort()로 간단히 오름차순 정렬!
 * (방법 1) int[] 배열로 풀기
 */

public class PGS_K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        int N = commands.length; //commands(i,j,k) 길이
        int[] answer = new int[N]; //정답배열
        for(int t=0; t<N; t++) {
        	int ijk[] = commands[t];
        	int i = ijk[0]-1; //시작
        	int j = ijk[1]; //끝
        	int k = ijk[2]-1; //몇번째
        	int arr[] = new int[j-i], idx=0; //정렬배열,인덱스
        	for(int a=i; a<j; a++) { //(0-base)
        		arr[idx] = array[a]; 
                idx++;
        	}
        	Arrays.sort(arr); //정렬
        	answer[t]=arr[k];
        }
        return answer;
    }
    
    public static void main(String[] args) throws Exception {
		int[] answer = solution(new int[] {1, 5, 2, 6, 3, 7, 4},
				new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
		
		System.out.println(Arrays.toString(answer));
	}
}