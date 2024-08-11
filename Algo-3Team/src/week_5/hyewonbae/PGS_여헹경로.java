package week_5.hyewonbae;

import java.io.*;
import java.util.*;

public class PGS_여헹경로 {
	// 여행 경로를 저장할 리스트
    static List<String> result = new ArrayList<>();
    // key : 출발공항 , value(우선순위 큐- 알파벳 순서로 유지하기 위해) : 도착공항
    static final Map<String, PriorityQueue<String>> map = new HashMap<>();


    /**
     * 항공권 배열을 기반으로 여행 경로를 찾는 메소드
     *
     * @param tickets 각 항공권의 출발 공항과 도착 공항을 포함한 2차원 배열
     * @return 여행 경로를 담고 있는 문자열 배열
     */
    public static String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).add(to);
        }

        /**
         *
         * Map: {
         *     "ICN": PriorityQueue(JFK),
         *     "HND": PriorityQueue(IAD),
         *     "JFK": PriorityQueue(HND)
         * }
         * */

        dfs("ICN");

        // 결과 리스트를 배열로 변환하여 반환
        return result.toArray(new String[0]);
    }

    /**
     * 깊이 우선 탐색(DFS)을 사용하여 여행 경로를 탐색하는 메소드
     *
     * @param airport 현재 탐색 중인 공항
     */
    private static void dfs(String airport) {
        // 현재 공항에서 가능한 도착 공항을 pq에서 가져오기
        PriorityQueue<String> destinations = map.get(airport);

        // 도착 공항이 존재하는 경우, 가능한 모든 도착 공항을 탐색하기
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next);
        }

        // 탐색이 끝난 공항부터 결과에 추가되어 역순으로 쌓이게 되므로 맨 앞으로 추가
        result.add(0, airport);
    }

    public static void main(String[] args) {
        // TEST CASE 1
        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.toString(solution(tickets1)));

        // TEST CASE 2
//        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//        System.out.println(Arrays.toString(solution(tickets2)));
    }

}
