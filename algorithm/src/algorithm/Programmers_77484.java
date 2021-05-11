package algorithm;

//로또의 최고 순위와 최저 순위

public class Programmers_77484 {
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int wincheck = 0;
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) {zero++;}
            else {
	            for(int j=0; j<win_nums.length; j++) {
	                if(lottos[i] == win_nums[j]) {wincheck++; break;}
	            }
            }
        }
        int total = zero + wincheck;
        switch(wincheck) {
            case 6: answer[1] = 1; break;
            case 5: answer[1] = 2; break;
            case 4: answer[1] = 3; break;
            case 3: answer[1] = 4; break;
            case 2: answer[1] = 5; break;
            default: answer[1] = 6; break;
        }
        switch(total) {
            case 6: answer[0] = 1; break;
            case 5: answer[0] = 2; break;
            case 4: answer[0] = 3; break;
            case 3: answer[0] = 4; break;
            case 2: answer[0] = 5; break;
            default: answer[0] = 6; break;
        }
        return answer;
    }
	public static void main(String[] args) {
		
		int[] lottos = {0, 0, 0, 0, 0, 0};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		System.out.println(solution(lottos, win_nums));
	}
	
}