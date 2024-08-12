package week_5.eunsoo;

import java.io.*;
import java.util.*;

/* 아이템 줍기
 * [입력] rectangle : 지형 직사각형 2차원 배열,
 * - [(왼하 x,y), 우상(x,y)] 
 * characterX, characterY : 캐릭터 위치,
 * itemX, itemY : 아이템 위치,
 * [출력] 캐릭터 출발 -> 아이템 위치까지 짧은 거리
 * - 캐릭터 경로 : 다각형 바깥 테두리
 * 좌표를 2배로 늘려서 BFS => 다시 1/2배해서 출력
 * 2배로 해야하는 이유 : 테두리를 따라가야하는데 테두리가 겹치는 경우는 
 * 그냥 BFS로 냅다 직진해서 제대로 따라갈 수 없음 (2배로 하면 모서리와 점을 나눠 가능)
 */

public class PGS_아이템줍기 {
	//상우하좌
	static int[] di = {-1,0,1,0}, dj = {0,1,0,-1};
	static int[][] a; //기존 배열
	static boolean[][] v; //방문 배열
	static int end_x, end_y, N=0, M=0; //도착(x,y), 배열크기(N,M)
	
	static int bfs(int i, int j) {
		v[i][j] = true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j, 0});
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			int cnt = ij[2];
			if(j==end_y && i==end_x) {
				return cnt/2;
			}
		
			for(int d=0; d<4; d++) {
				int ni = i+di[d];
				int nj = j+dj[d];
				//범위 확인
				if(0<=nj && nj<101 && 0<=ni && ni<101 && !v[nj][ni] && a[nj][ni] == 1) {
					v[nj][ni] = true;
					q.offer(new int[] {ni, nj, cnt+1});
				}
			}
		}
		return -1; //경로 X
	}
	
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rec : rectangle) {
            M = Math.max(M, rec[2]); //우상x
            N = Math.max(N, rec[3]); //우상y
        }
        N*=2; M*=2; //배열크기*2
        int[][] outline = new int[N+2][M+2];
        
        for(int[] rec:rectangle) { //각 꼭짓점*2
        	int left_bot_x = rec[0]*2; //왼하 x == left_top_x 왼상 x
        	int right_bot_x = rec[2]*2; //우하 x == right_top_x 우상 x
        	int left_bot_y = rec[1]*2; //왼하 y == right_bot_y 우하 y
        	int left_top_y = rec[3]*2; //왼상 y == right_top_y 우상 y
        	
        	// 직사각형 테두리
        	// 테두리=1, 내부=2, 아무것도 아님=0 으로 만들어주기
        	for(int y=left_bot_y; y<=left_top_y; y++) {
        		for(int x=left_bot_x; x<=right_bot_x; x++) {
        			if(x == left_bot_x || x == right_bot_x ||
        			   y == left_bot_y || y == left_top_y) {
        				if(outline[y][x] == 2) continue; //이전에 내부였음 pass
        				outline[y][x] = 1; //테두리=1
        			}
        			else outline[y][x] = 2; //내부=2
        		}
        	}
        }
        
    	//초기화
    	a = outline;
    	v = new boolean[N+2][M+2];
    	end_x = itemX*2;  end_y = itemY*2; //도착좌표*2
    	
    	//bfs
    	int answer = bfs(characterX*2, characterY*2); //출발좌표*2
        return answer;
        
    }

	public static void main(String[] args) {
		int answer = solution(new int[][] {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},
				9, 7, 6, 1);
		System.out.println(answer);
	}
}
