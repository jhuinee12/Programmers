package main.java;

import java.util.*;

public class SumTwo {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = 0;

        for (int i=0; i<numbers.length; i++)
        {
            for (int j=i+1; j<numbers.length; j++)
            {
                if(!list.contains(numbers[i]+numbers[j]))
                    list.add(numbers[i]+numbers[j]);
            }
        }

        int[] answer = new int[list.size()];

        for (int i : list)
        {
            answer[a] = i;
            a++;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        SumTwo sol = new SumTwo();
        int[] numbers = {2,1,3,4,1};
        System.out.println(sol.solution(numbers));
    }

}