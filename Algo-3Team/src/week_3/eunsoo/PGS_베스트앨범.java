package week_3.eunsoo;

import java.io.*;
import java.util.*;

/* 베스트앨범
 * [설명] 장르별 가장 많이 재생된 노래를 2개씩 모으기
 * 수록 기준 [1] 장르 - 총 재생수가 가장 많은
 * 					[2] 노래 - 가장 많이 재생된
 * 								 - 재생수 같으면? 고유번호가 낮은
 * [입력] genres[i] -> 고유번호 i인 노래의 장르
 * 			  plays[i] -> 고유번호 i인 노래의 재생 수
 * [출력] 고유번호 return
 * [분석] [1] 총재생수 높은 장르 계산 : map(장르,총재생수)
 * 			  [2] 각 장르별 재생수 높은 곡 인덱스 2개 : map (장르,[ [인덱스,개별재생수] 목록 ])
 * 			  [3] 출력
 */

public class PGS_베스트앨범 {
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        //[1] 총재생수 높은 장르 계산
          //(1) map (장르,총재생수) 생성
        Map<String, Integer> m_genre = new HashMap<>(); 
        for(int i=0; i<genres.length; i++) m_genre.put(genres[i], m_genre.getOrDefault(genres[i], 0)+plays[i]);
          //(2) 재생수 기준 장르 정렬
        ArrayList<String> sort_genre = new ArrayList<>(m_genre.keySet());
        sort_genre.sort((o1,o2) -> m_genre.get(o2).compareTo(m_genre.get(o1))); 
      
        //[2] 각 장르별 재생수 높은 곡 인덱스 2개
         //(1) map (장르,[ [인덱스,개별재생수] 목록 ]) 생성
        Map<String, ArrayList<int[]>> m_play = new HashMap<>(); 
        for(String now_genre:sort_genre) { //위에서 정렬된 장르 순서로
            for(int i=0; i<genres.length; i++) {
            	if(genres[i].equals(now_genre)) {
            		m_play.putIfAbsent(now_genre, new ArrayList<>()); //첫등장이면 초기화하고
            		m_play.get(now_genre).add(new int[] {i,plays[i]}); //[인덱스,재생수] 추가하기
            	}
            }
        }
        //(2) 각 장르별 재생수 정렬
       for(String k:m_play.keySet()) { //각 장르별로
    	   Collections.sort(m_play.get(k), (o1,o2) ->  {
    		   if(o1[1]==o2[1]) { return Integer.compare(o1[0], o2[0]); } //재생수 같으면 인덱스 작은 순
    		   else { return Integer.compare(o2[1], o1[1]); } //다르면 재생수 내림차순
    	   });
       }
       
       //[3] 출력
         //(1) ArrayList에 담기
       ArrayList<Integer> al = new ArrayList<>();
       for(String genre:sort_genre) {
    	   int cnt = 0;
    	   for(int[] num : m_play.get(genre)) {
    		   if(cnt < 2) { //2개씩만 담기
    			   al.add(num[0]); cnt++;
    		   }
    	   }
       }
        //(2) int 배열로 이동
       answer = new int[al.size()];
       int idx=0;
       for(int a:al) {
    	   answer[idx] = a; idx++;
       }
        return answer;
    }

	public static void main(String[] args) {
		int[] answer = solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, 
				new int[] {500, 600, 150, 800, 2500});
		System.out.println(Arrays.toString(answer));
	}

}
