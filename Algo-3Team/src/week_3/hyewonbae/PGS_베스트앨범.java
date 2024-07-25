package week_3.hyewonbae;

import java.io.*;
import java.util.*;

public class PGS_베스트앨범 {

	static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<>();	// 장르별 총 재생횟수 저장 
		HashMap<String, List<int[]>> genresSongs = new HashMap<>();	// 장르별 노래 리스트 저장

		/**
		 * computeIfAbsent 메소드 
		 * 키가 맵에 존재하지 않을 때만 값을 생성하고 그 값을 맵에 넣는 작업을 수행
		 * */
		for (int i = 0; i < genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
			genresSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[] { plays[i], i });
		}
		
//		for (String genre : genresSongs.keySet()) {
//			System.out.println("장르: " + genre);
//			for (int[] song : genresSongs.get(genre)) {
//				System.out.println("    재생횟수: " + song[0] + ", 고유번호: " + song[1]);
//			}
//		}

		/**
		 * 
		 * 장르: pop
		  	재생횟수: 600, 고유번호: 1
			재생횟수: 2500, 고유번호: 4
		   장르: classic
			재생횟수: 500, 고유번호: 0
			재생횟수: 150, 고유번호: 2
			재생횟수: 800, 고유번호: 3
		 * 
		 * */
		
		// 장르를 총 재생 횟수에 따라 내림차순으로 정렬
		List<String> sortedGenres=new ArrayList<>(genresSongs.keySet());
		sortedGenres.sort((o1,o2)->map.get(o2)-map.get(o1));
		
//		System.out.println(sortedGenres);
		
		List<Integer> bestAlbum=new ArrayList<>();
		
		for(String genre : sortedGenres) {
			List<int[]> songs=genresSongs.get(genre);
			
			// 노래를 재생 횟수에 따라 내림차순 정렬, 재생 횟수가 같으면 고유 번호에 따라 오름차순 정렬
			songs.sort((o1,o2)->o2[0]==o1[0] ? o1[1]-o2[1] : o2[0]-o1[0]);
			
			// 장르별로 최대 두 개의 노래를 선택 
			for(int i=0;i<Math.min(2, songs.size());i++) {
				bestAlbum.add(songs.get(i)[1]);
			}
		}
		
		// 결과 리스트를 배열로 리턴 
		int[] answer = bestAlbum.stream().mapToInt(i -> i).toArray();

		return answer;
	}

	public static void main(String[] args) {

		// Test Case 1:
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		System.out.println(Arrays.toString(solution(genres, plays))); // 출력: 4,1,3,0
	}

}
