package week_3.JHJ08;

import java.util.*;

public class PGS_베스트앨범 {
	
	static class Music_Info
	{
		int num; // 고유번호
		String genre; // 장르
		int genre_cnt; // 장르별 재생된 수
		int play_cnt; // 노래가 재생된 수
		
		Music_Info(int num, String genre, int genre_cnt, int play_cnt)
		{
			this.num = num;
			this.genre = genre;
			this.genre_cnt = genre_cnt;
			this.play_cnt = play_cnt;
		}
	}

	static public int[] solution(String[] genres, int[] plays)
	{
		
		Map <String, Integer> genres_play_cnt = new HashMap<>(); // 장르 별 노래 수록 개수 저장 맵 (키 - 장르명, 값 - 장르별 재생된 수)
        for(int i=0; i<genres.length; i++)
        {
            if(genres_play_cnt.containsKey(genres[i]))
            {
            	int newValue = genres_play_cnt.get(genres[i]) + plays[i];
            	genres_play_cnt.replace(genres[i], newValue);
            }
            else
            {
            	genres_play_cnt.put(genres[i], plays[i]);
            }
        }
        
        Map <Integer, Music_Info> musics_info = new HashMap<>(); // 노래 정보 저장 맵 (키 - 고유번호, 값 - Music_Info)
        for(int i=0; i<plays.length; i++)
        {
        	musics_info.put(i, new Music_Info(i, genres[i], genres_play_cnt.get(genres[i]), plays[i]));
        }
        
        // map 정렬하기 -> value 값 기준으로
        List<Map.Entry<Integer, Music_Info>> entryList = new LinkedList<>(musics_info.entrySet());

        entryList.sort(new Comparator<Map.Entry<Integer, Music_Info>>() {
            @Override
            public int compare(Map.Entry<Integer, Music_Info> o1, Map.Entry<Integer, Music_Info> o2) {
            	
            	if(o1.getValue().genre_cnt == o2.getValue().genre_cnt)
            	{
            		// 노래 재생 수를 기준으로 내림차순 정렬
            		return o2.getValue().play_cnt - o1.getValue().play_cnt;
            	}
            	else
            	{
            		// 장르별 재생된 수를 기준으로 내림차순 정렬
            		return o2.getValue().genre_cnt - o1.getValue().genre_cnt; 
            	}
            }
        });

        Map <String, Integer> genres_cnt = new HashMap<>(); // 장르별로 최대 두개 까지 등록하도록 처리할때 사용할 맵 (키 - 장르명, 값 - 베스트 앨범에 등록된 횟수)
        ArrayList<Integer> answer_list = new ArrayList<>(); // 결과 리스트
        for(Map.Entry<Integer, Music_Info> entry : entryList){
        	
        	String genre = entry.getValue().genre;
        	if(genres_cnt.containsKey(genre))
        	{
        		if(genres_cnt.get(genre) == 1)
        		{
        			answer_list.add(entry.getKey());
        			genres_cnt.replace(genre, genres_cnt.get(genre)+1);
        		}
        	}
        	else
        	{
        		answer_list.add(entry.getKey());
        		genres_cnt.put(genre, 1);
        	}
        }
        
        return answer_list.stream().mapToInt(i -> i).toArray();
	}
	
	public static void main(String[] args) {
		
		// 입력값 예시
		String [] genres = {"classic", "pop", "classic", "classic", "pop"};
		int [] plays = {500, 600, 150, 800, 2500};
		
		// 결과 출력
		int [] answer = solution(genres, plays);
		for(int i=0; i<answer.length; i++)
		{
			System.out.print(answer[i] + " ");
		}
	}
}
