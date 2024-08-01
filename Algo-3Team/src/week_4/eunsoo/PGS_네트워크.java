package week_4.eunsoo;

import java.util.*;
import java.io.*;

/* 네트워크
 * [입력] n: 컴퓨터수, computers: 연결정보배열
 * [출력] 네트워크 개수
 * - a[i][j]=1 : (i-j) 연결
 * [분석] 인접배열 생성 -> DFS / BFS
 */

public class PGS_네트워크 {
	static ArrayList<Integer>[] arr;
	static boolean[] v;
	
    //1. dfs
    static void dfs(int i) {
		v[i] = true; //방문처리
		for(int ni:arr[i])  //인접배열
			if(!v[ni]) {
				v[ni] = true;
				dfs(ni);
			}
	}
    
    //2. bfs
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>(); //큐
		v[i] = true; //방문처리
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			for(int ni:arr[i]) //인접배열
				if(!v[ni]) {
					v[ni] = true;
					q.offer(ni);
				}
		}
	}
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        arr = new ArrayList[n+1]; //1-base
        v = new boolean[n+1]; //1-base
        
        //1. 인접배열 설정
        for(int i=0; i<=n; i++) arr[i] = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(i==j) continue;
        		if(computers[i][j] == 1) arr[i+1].add(j+1); //단방향
        	}
        }
        
        //2. dfs or bfs
        for(int i=1; i<=n; i++) {
        	if(!v[i]) {
                dfs(i);
        		//bfs(i);
                answer++;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) throws Exception {
		int answer = solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
		System.out.println(answer);
	}
}
