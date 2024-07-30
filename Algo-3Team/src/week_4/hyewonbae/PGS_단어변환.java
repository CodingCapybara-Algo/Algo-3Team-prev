package week_4.hyewonbae;

import java.io.*;
import java.util.*;

/**
 * 한 글자 빼고 나머지가 같은 단어를 words에서 찾기
 * 찾은 단어를 방문처리
 * cnt 증가하면서 dfs 재귀호출
 * 모든 경우의 수를 보기 위해 방문 해제 하기
 * begin과 target이 같은 경우 cnt를 answer에 대입 후 종료
 * */
public class PGS_단어변환 {
	static boolean[] v;
	static int answer =0;
	
	/**
     * 깊이 우선 탐색(DFS)을 이용해 단어 변환 과정을 탐색하는 함수
     * @param begin 현재 단어
     * @param target 목표 단어
     * @param words 단어 목록
     * @param cnt 변환 횟수
     */
	static void dfs(String begin, String target, String[] words, int cnt) {
		
		if(begin.equals(target)) {
			answer = cnt;
			return;
		}
		
		for(int i=0;i<words.length;i++) {
			if(v[i]) {
				continue;
			}
			
			int same_spell = 0;
			
			for(int j=0;j<begin.length();j++) {
				if(begin.charAt(j)==words[i].charAt(j)) {
					same_spell++;
				}
			}
			
			if(same_spell == begin.length()-1) {
				v[i] = true;
				dfs(words[i], target, words, cnt+1);
				v[i] = false;
			}
		}
	}

   public static void main(String[] args) throws Exception {
	   String begin="hit";
	   String target="cog";
	   //Test case 1
	   String[] words= {"hot","dot","dog","lot","log","cog"};
	   //Test case 2
//	   String[] words= {"hot", "dot", "dog", "lot", "log"};
			  
	   v=new boolean[words.length];
	   int cnt=0;
	   dfs(begin, target, words, cnt);
	   System.out.println(answer);
   }


}