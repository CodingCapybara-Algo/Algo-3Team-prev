package week_4.hyewonbae;

import java.io.*;
import java.util.*;

public class PGS_게임맵최단거리 {

    static boolean[][] visited;
    static final int[] di = {-1, 0, 1, 0}; // 상, 우, 하, 좌 방향
    static final int[] dj = {0, 1, 0, -1};
    static int[][] map;


    /**
     * BFS를 이용하여 최단 거리를 계산하는 메소드
     *
     * @param startX 시작 x 좌표
     * @param startY 시작 y 좌표
     * @param maps 게임 맵 배열
     * @return 시작점에서 도착점까지의 최단 거리, 도달할 수 없으면 -1
     */
    static int bfs(int startX, int startY, int[][] maps) {
        int answer=0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 시작점을 방문처리 후 큐에 추가
        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY, 1}); // (x, y, 거리)

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 도착 지점에 도달한 경우
            if (x == maps.length - 1 && y == maps[0].length - 1) {
                answer = distance;
                return answer;
            }

            // 사방탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + di[d];
                int ny = y + dj[d];

                // 배열 범위와 방문 여부, 값 확인
                if (0 <= nx && nx < maps.length && 0 <= ny && ny < maps[0].length && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1; // 도달할 수 없는 경우 -1 반환
    }

    public static void main(String[] args) throws Exception {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];

        // BFS 호출 및 결과 출력
        System.out.println(bfs(0, 0, maps));
    }
}
