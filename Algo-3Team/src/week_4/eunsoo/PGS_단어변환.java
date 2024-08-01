package week_4.eunsoo;

import java.util.*;

/* 단어변환
 * [입력] begin: 시작단어, end: 끝단어
 * - 한번에 한개의 알파벳만
 * - words에 있는 단어로만 변환 가능
 */

public class PGS_단어변환 {
    static int minCnt = Integer.MAX_VALUE;
    static String[] w;
    static boolean[] v;

    private static void dfs(String current, String target, int cnt) { //현재단어, 타겟, 변환개수
        if (current.equals(target)) {
            minCnt = Math.min(minCnt, cnt); //기존보다 더 작을경우 갱신
            return;
        }

        for (int i = 0; i < w.length; i++) {
            if (!v[i]) {
                int diff = 0; //얼마나 다른지
                for (int j = 0; j < current.length(); j++) {
                    if (current.charAt(j) != w[i].charAt(j)) {
                        diff++;
                    }
                }
                if (diff == 1) { //하나만 다르면
                    v[i] = true; //인접노드로 간주
                    dfs(w[i], target, cnt + 1);
                    v[i] = false;
                }
            }
        }
    }

    public static int solution(String begin, String target, String[] words) {
        w = words;
        v = new boolean[words.length];

        dfs(begin, target, 0);

        return minCnt == Integer.MAX_VALUE ? 0 : minCnt;
    }

    public static void main(String[] args) {
        int answer = solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(answer); // Expected output: 4
    }
}
