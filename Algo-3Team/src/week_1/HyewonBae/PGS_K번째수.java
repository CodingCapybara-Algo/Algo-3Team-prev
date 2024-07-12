package week_1.HyewonBae;

import java.io.*;
import java.util.*;

public class PGS_K번째수 {
	static int[] temp;
	public static void main(String[] args) throws Exception {
		int []array= {1,5,2,6,3,7,4};
		int [][]commands= {{2,5,3},{4,4,1},{1,7,3}};
		
		int[] result=solution(array,commands);
		System.out.println(Arrays.toString(result));
		
		}
    static int[] solution(int[] array, int[][] commands) {
        // array = [1,5,2,6,3,7,4]
        // commands =[[2,5,3],[4,4,1],[1,7,3]]
        int[] answer = new int[commands.length];
		
		for(int i=0;i<commands.length;i++) {
			int []command=commands[i];
			int start=command[0]-1;
			int end=command[1]-1;
			int t=command[2]-1;
			
			temp=new int[end-start+1];
			int index=0;
			
			for(int j=start;j<=end;j++) {
				temp[index]=array[j];
				index++;
			}
			Arrays.sort(temp);
			answer[i]=temp[t];
        }
        return answer;
    }
}