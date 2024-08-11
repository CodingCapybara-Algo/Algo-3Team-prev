package week_5.hyewonbae;

import java.io.*;
import java.util.*;

public class BOJ_안전영역 {
  static final int[] di = {-1, 0, 1, 0}; // 상,우,하,좌
    static final int[] dj = { 0, 1, 0, -1};
    static int N;   // 지도 크기
    static int[][]map;  // 지도 저장할 배열
    static boolean[][] v;   // 방문 여부
    static int minH=Integer.MAX_VALUE;  // 최소 높이
    static int maxH=Integer.MIN_VALUE;  // 최대 높이
    static int max =0;  // 최대 안전영역의 개수
    static ArrayList<Integer> safezone; // 안전 영역의 개수를 저장할 리스트

    /**
     * 깊이 우선 탐색  (dfs)
     *
     * @param i 현재 탐색중인 위치의 행
     * @param j 현재 탐색중인 위치의 열
     * @param  h 기준 높이
     * */
    static void dfs(int i, int j, int h) {
        v[i][j]=true;
        for(int d=0;d<4;d++) {
            int ni=i+di[d];
            int nj=j+dj[d];
            if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj] && map[ni][nj]>=h) {
                dfs(ni,nj,h);
            }
        }
    }


    /**
     * 깊이 우선 탐색  (bfs)
     *
     * @param i 현재 탐색중인 위치의 행
     * @param j 현재 탐색중인 위치의 열
     * @param  h 기준 높이
     * */
    static void bfs(int i, int j, int h) {
        ArrayDeque<int[]> q=new ArrayDeque<>();
        v[i][j]=true;
        q.offer(new int[] {i,j});

        while(!q.isEmpty()) {
            int[] ij=q.poll();
            i=ij[0];
            j=ij[1];
            for(int d=0;d<4;d++) {
                int ni=i+di[d];
                int nj=j+dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj] && map[ni][nj]>=h) {
                    v[ni][nj]=true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());  // 지도 크기 입력
        safezone=new ArrayList<>(); // 안전 영역 리스트 초기화
        map=new int[N][N];  // 지도 배열 초기화
        v=new boolean[N][N];    // 방문처리 배열 초기화
		/*
		
		5
		6 8 2 6 2
		3 2 3 4 6
		6 7 3 3 2
		7 2 5 3 6
		8 9 5 2 7
		
		*/
        
        for(int i=0;i<N;i++) {
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if (map[i][j] > maxH) {
                    maxH = map[i][j];   // 최대 높이
                }
                if (map[i][j] < minH) {
                    minH = map[i][j];   // 최소 높이
                }
            }
        }

        // 최소 높이 부터 최대 높이까지에 대해 안전영역 개수 계산
        for(int h=minH; h<maxH+1; h++) {
            v=new boolean[N][N];
            int count=0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j]>=h && !v[i][j]) {
						dfs(i,j,h);
//                        bfs(i,j,h);
                        count++;    // 안전 영역 개수 증가
                    }
                }

            }
            max=Math.max(max, count);
        }
        System.out.println(max);
        br.close();
    }

}
