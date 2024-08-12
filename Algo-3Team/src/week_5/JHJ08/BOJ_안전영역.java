package week_5.JHJ08;
import java.util.*;

public class BOJ_안전영역 {

	static int N; // 배열 W,H
	static int [][] map; // 안전영역 정보 담고 있는 2차원 배열
	static boolean [][] visit; // 방문 확인
	
	static int max = Integer.MIN_VALUE; //입력받는 수중 제일 큰 수
	
	static int [] di = {-1,1,0,0}; // 행 이동
	static int [] dj = {0,0,-1,1}; // 열 이동 

	// 방문처리 초기화 함수
	static void init_visit()
	{
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				visit[i][j]=false; // 모든 영역을 방문하지 않은 상태로 초기화
			}
		}
	}
	
	// 깊이우선탐색  
	static void dfs(int condition, int i, int j)
	{
		visit[i][j] = true;
		
		for(int d=0; d<4; d++)
		{
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(ni >= 0 && ni <N && nj >=0 && nj <N)
			{
				if(visit[ni][nj] == false) // 방문했던 곳인지 확인
				{
					if(map[ni][nj] > condition) // condition 보다 높이가 높은지 확인
					{
						dfs(condition,ni,nj);
					}
				}
			}
			
		}
		
	}
	
	// 너비우선탐색 
	static void bfs(int condition, int i, int j)
	{
		ArrayDeque<int []> q = new ArrayDeque<>();
		visit[i][j]=true;
		q.offer(new int[] {i,j});
		
		
		while(!q.isEmpty())
		{
			int [] cur = q.poll();
			
			i = cur[0];
			j = cur[1];
			
			for(int d=0; d<4; d++)
			{
				int ni = i+di[d];
				int nj = j+dj[d];
				
				if(ni >=0 && ni<N && nj >=0 && nj < N)
				{
					if(visit[ni][nj] == false) // 방문했던 곳인지 확인
					{
						if(map[ni][nj] > condition) // condition 보다 높이가 높은지 확인
						{
							visit[ni][nj]=true;
							q.offer(new int[] {ni,nj});
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		// 입력받기
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		// 입력받은 높이 정보 중 가장 높은 높이 정보 구하기
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		
		int count = Integer.MIN_VALUE;
		
		for(int condition = 0; condition <= max; condition++)
		{
			int res_tmp = 0;
			init_visit(); // 방문배열 초기화
			
			// 조건별 안전영역 개수 계산
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					if(visit[i][j]== false)
					{
						if(map[i][j] > condition)
						{
							dfs(condition,i,j);
							res_tmp++;
						}
							
					}
				}
			}
				
			// 계산한 안전영역 최대 개수 갱신
			if(count < res_tmp)
			{
				count = res_tmp;
			}
				
		}
		
		// 결과 출력
		System.out.println(count);
	}

}
