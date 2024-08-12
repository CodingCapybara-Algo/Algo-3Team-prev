package week_5.eunsoo;

import java.util.*;
import java.io.*;

/* 안전 영역
 * N : 배열 크기 (2~100)
 * a : 배열 (원소-해당지점 높이)
 * 물에 잠기는 영역 : 일정 높이 이하
 * 안전 영역 : 일정 높이 초과하는 인접한 그룹 수
 * res : 최대의 안전한 개수를 계산
 * 
 * [입력1]
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
 * [출력] 5
 */

public class BOJ_안전영역 {
	static int[] di = {-1,0,1,0}; //상우하좌
	static int[] dj = {0,1,0,-1};
	static int N, res=0; //배열크기, 결과
	static int[][] a; //높이배열
	static boolean[][] v; //방문
	
	//2. dfs --> 그룹화
	static void dfs(int i, int j, int height) {
		v[i][j] = true; //방문처리
		for(int d=0;d<4;d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && a[ni][nj] > height) {
				dfs(ni,nj,height);
			}
		}
	}
	
	//2. bfs --> 그룹화
		static void bfs(int i, int j, int height) {
			ArrayDeque<int[]> q = new ArrayDeque<>();
			v[i][j] = true; //방문처리
			q.offer(new int[] {i,j}); //큐에 넣기
			while (!q.isEmpty()) {
				int[] ij = q.poll(); //큐 맨위에서 꺼내서
				i = ij[0];
				j = ij[1];
				for(int d=0;d<4;d++) { //사방탐색
					int ni = i + di[d];
					int nj = j + dj[d];
					if (0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && a[ni][nj] > height) {
						v[ni][nj] = true;
						q.offer(new int[] {ni,nj}); //새 좌표 큐에 넣기
					}
				}
			}
			
		}

	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		int max=Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, a[i][j]);
			}
		}
		//for(int[] arr:a) System.out.println(Arrays.toString(arr));
		
		//2. 높이 차례대로 dfs/bfs
		for (int h=0; h<=max; h++) {//높이 h 이하로 물 잠기면
			int cnt = 0;
			v = new boolean[N][N];
			//각 높이에서 dfs/bfs
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (a[i][j]>h && !v[i][j]) { //안전영역에 대한
						//dfs(i,j,h); //인접 그룹 확인
						bfs(i,j,h); //인접 그룹 확인
						cnt++; //그룹 하나 찾았으면 +1
					}
				}
			}
			//높이에 대해 최대인지 비교
			res = Math.max(res, cnt);
		}
		System.out.println(res);	
	}
}
