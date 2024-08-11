package week_5.hyewonbae;

import java.io.*;
import java.util.*;

public class PGS_아이템줍기 {
   static int[][] map = new int[101][101]; // 맵 크기를 2배로 확대
    static boolean[][] visited = new boolean[101][101];
    static final int[] di = {-1, 0, 1, 0}; // 상, 우, 하, 좌 방향
    static final int[] dj = {0, 1, 0, -1};
    static int result=0;

    /**
     * BFS를 사용하여 시작 위치에서 목표 위치까지의 최단 거리를 계산하는 메소드
     *
     * @param characterX 시작 위치의 X 좌표 (2배 확대된 좌표)
     * @param characterY 시작 위치의 Y 좌표 (2배 확대된 좌표)
     * @param itemX 목표 위치의 X 좌표 (2배 확대된 좌표)
     * @param itemY 목표 위치의 Y 좌표 (2배 확대된 좌표)
     */
    static void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterY, characterX, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentI = current[0];
            int currentJ = current[1];
            int currentStep = current[2];

            // 아이템 위치에 도달한 경우
            if (currentI == itemY && currentJ == itemX) {
                result = currentStep/2;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextI = currentI + di[i];
                int nextJ = currentJ + dj[i];

                if(nextI>=1 && nextI <=100 && nextJ>=1 && nextJ <=100) {
                    if (!visited[nextI][nextJ] && map[nextI][nextJ] == 1) {
                        visited[nextI][nextJ] = true;
                        q.add(new int[]{nextI, nextJ, currentStep + 1});
                    }
                }

            }
        }
    }


    /**
     * 사각형을 맵에 그리기 위한 메소드
     * @param rectangle 사각형의 좌표 배열
     * */
    static void draw(int[][] rectangle) {
        for(int[] rect : rectangle){
            int startI = rect[1] *2;    // Y 좌표 시작
            int endI = rect[3] *2;      // Y 좌표 끝
            int startJ = rect[0]*2;     // X 좌표 시작
            int endJ = rect[2]*2;       // X 좌표 끝

            for(int i=startI;i<=endI;i++) {
                for(int j=startJ;j<=endJ;j++) {
                    if(i == startI || i == endI || j == startJ || j == endJ) {
                        if(map[i][j] ==2) {
                            continue;
                        }
                        map[i][j] = 1;  // 테두리
                    } else{
                        map[i][j] = 2;  // 내부
                    }
                }
            }
        }
    }


    /**
     * @param rectangle 사각형의 좌표 배열
     * @param characterX 시작 위치의 X 좌표
     * @param characterY 시작 위치의 Y 좌표
     * @param itemX 목표 위치의 X 좌표
     * @param itemY 목표 위치의 Y 좌표
     * @return 시작 위치에서 목표 위치까지의 최단 거리
     */
    static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        draw(rectangle);
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return result;
    }

    public static void main(String[] args) {
//	        TEST CASE 1
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;


//	        TEST CASE 2
//	        int[][] rectangle = {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
//	        int characterX = 9;
//	        int characterY = 7;
//	        int itemX = 6;
//	        int itemY = 1;

        int answer = solution(rectangle, characterX, characterY, itemX, itemY);
        System.out.println(answer);
    }

}
