package week_2.eunsoo;
import java.io.*;
import java.util.*;

/* 전화번호 목록
 * phone_book: 전화번호 적힌 명단
 * (분석 1) 정렬 -> 인접 접두사 확인[startsWith]
 * (분석 2) 해시[번호,인덱스] -> 해시 키에 있는지 확인[h.containsKey]
 */

public class PGS_전화번호목록 {
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        /* (분석 1) 정렬 -> 인접 접두사 확인[startsWith] 
        Arrays.sort(phone_book); // (1) 정렬
        for (int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {// (2) 앞뒤 원소 접두사 검사
                answer = false;
                break;
            }
        } */

        /* (분석 2) 해시[번호,인덱스] -> 해시 키에 있는지 확인[h.containsKey] */
        HashMap<String, Integer> h = new HashMap<>(); // (1) 해시 생성
        for(int i=0; i<phone_book.length; i++) h.put(phone_book[i], i);
        exit: for(int i=0; i<phone_book.length; i++) { 
            for(int j=0; j<phone_book[i].length(); j++) {
                if(h.containsKey(phone_book[i].substring(0, j))) { // (2) 해시 키에 있는지 확인
                    answer = false;
                    break exit;
                }
            }
        }
        return answer;
    }
	
	public static void main(String[] args) {
		boolean answer = solution(new String[] {"119", "97674223", "1195524421"});
		System.out.println(answer);
	}
}
