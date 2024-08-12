package week_5.JHJ08;

import java.util.*;

public class PGS_여행경로 {

	static class Ticket 
    {
        String start;
        String end;
        int idx;
        
        Ticket(String start, String end, int idx)
        {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }
	
	static int idx;
    static int ticket_cnt; // 티켓 개수
    static int [] visited;
    static List <Ticket> res;
    
    static int find_ticket(String start, String[][] tickets)
    {
        int tmp_chk = 0; // 다음에 탐색할 수 있는 항목이 있는지 체크
        
        for(int i=0; i<ticket_cnt; i++)
        {
            if(visited[i] == 0)
            {
                if(start.equals(tickets[i][0]))
                {
                    res.add(new Ticket(tickets[i][0],tickets[i][1],i));
                    visited[i] = 1;
                    tmp_chk++;
                    idx++;
                    
                    // 해당 경로를 선택한 경우, 다음 경로를 선택할 수 없는 경우
                    if(find_ticket(tickets[i][1], tickets) ==1)
                    {
                        // 마지막에 추가된 항목 삭제 및 관련 정보 초기화 처리
                        Ticket prev = res.get(res.size()-1);
                        visited[prev.idx] = 0;
                        res.remove(prev);
                        idx--;
                        tmp_chk--;
                    }
                }
            }
        }
        
        if(tmp_chk == 0 && idx < ticket_cnt)
        {
            return 1;
        }
        
        return 0;
    }
    
    
    static String[] solution(String[][] tickets) {
        
        idx=0;
        ticket_cnt = tickets.length;
        
        visited = new int[ticket_cnt];
        
        res = new LinkedList<>();
        
        // 2차원 배열 정렬 
        Arrays.sort(tickets, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }			
        });
        
        find_ticket("ICN", tickets);
        
        String[] answer = new String[res.size()+1];
        int answer_idx = 0;
        for(Ticket value : res)
        {
            answer[answer_idx] = value.start;
            answer_idx++;
        }
        answer[answer_idx] = res.get(res.size()-1).end;
        
        return answer;
    }
	
	public static void main(String[] args) {
		//String [][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String [][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		
		System.out.println(Arrays.toString(solution(tickets)));

	}

}
