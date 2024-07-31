package week_4.JHJ08;

import java.util.*;

public class PGS_게임맵최단거리 {
	
	static class Point
	{
		int x; // 2차원 배열에서는 열에 해당
		int y; // 2차원 배열에서는 행에 해당
		
		Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;
	static int m;
	
	static int [] move_y = {-1,1,0,0} ; // 행 이동에 사용 (상,하,좌,우)
	static int [] move_x = {0,0,-1,1} ; // 열 이동에 사용 (상,하,좌,우)
	
	static boolean [][] visited; // 방문처리에 사용할 배열
	
	static int solution(final int [][] maps)
	{
		n = maps.length;
		m = maps[0].length;
		
		visited = new boolean[n+1][m+1];
		
		int answer = 0;
		boolean bStop = false; // 상대팀 진영에 도착했는지를 판단하는 변수 (도착한 경우 true로 변경)
		
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.add(new Point(1,1)); // 1,1에서 캐릭터 위치 시작
		
		while(!q.isEmpty())
		{
			int q_size = q.size();
			
			for(int size=0; size<q_size; size++)
			{
				Point cur_point = q.poll();
				
				// 효율성 테스트
				if(visited[cur_point.y][cur_point.x])
				{
					continue;
				}
				else
				{
					visited[cur_point.y][cur_point.x] = true;
				}
				//
				
				if(cur_point.x == m && cur_point.y == n)
				{
					bStop = true;
					break;
				}
				
				for(int a=0; a<4; a++)
				{
					// 현재 위치에서 이동 가능한 지점 계산
					int new_x = cur_point.x + move_x[a];
					int new_y = cur_point.y + move_y[a];
					
					// 계산된 위치가 유효범위 내에 있는지 확인
					if(new_x>=1 && new_x<= m && new_y>=1 && new_y<= n)
					{
						// 방문하지 않았던 위치인지 확인
						if(visited[new_y][new_x] == false)
						{
							// 벽이 있는자리가 아닌지 확인
							if(maps[new_y-1][new_x-1] == 1)
							{
								q.add(new Point(new_x,new_y)); // 모든 조건을 만족하면 큐에 담아준다
							}
						}
					}
				}
			}
			
			answer++;
			
			if(bStop == true) // 상대 팀 진영에 도착한 경우, 반복문 종료
			{
				break;
			}
		}
		
		if(bStop == false) // 도착하지 못한 경우는 answer 값을 -1로 설정
		{
			answer = -1;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		//int [][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int [][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		
		
				
		System.out.println(solution(maps));
	}

}
