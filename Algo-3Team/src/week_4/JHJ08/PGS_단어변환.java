package week_4.JHJ08;

import java.util.*;

public class PGS_단어변환 {

	static int bfs(final String begin, final String target, final String [] words) 
	{
		int answer = 0;
		
		boolean [] visited = new boolean[words.length];
		
		ArrayDeque<String> q = new ArrayDeque<>();
		
		q.add(begin);
		
		boolean bFind = false;
		
		while(!q.isEmpty())
		{
			int q_size = q.size();
			
			for(int size=0; size<q_size; size++)
			{
				String tmpTarget = q.poll();
				
				if(tmpTarget.equals(target))
				{
					bFind = true; // 변환 가능한 경우
					break;
				}
				
				// 한글자만 다른 항목들을 다 큐에 넣어준다.
				for(int i=0; i<words.length; i++)
				{
					// 한글자만 다른지 확인
					int tmp_cnt = 0;
					for(int j=0; j<words[i].length(); j++)
					{
						if(words[i].charAt(j) == tmpTarget.charAt(j))
						{
							tmp_cnt++;
						}
					}
					
					if(tmp_cnt >= tmpTarget.length()-1)
					{
						if(visited[i] == false)
						{
							visited[i] = true;
							q.add(words[i]);
						}
					}
				}
				
			}
			
			answer++;
		}
		
		if(bFind == false)
		{
			answer = 0;
		}
		else
		{
			answer -=1;
		}
		
		return answer;
		
	}
	public static void main(String[] args) {
		
		String begin = "hit";
		String target ="cog";
		String [] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		//String begin = "hit";
		//String target ="cog";
		//String [] words = {"hot", "dot", "dog", "lot", "log"};
		
		System.out.println(bfs(begin, target, words));
	}

}
