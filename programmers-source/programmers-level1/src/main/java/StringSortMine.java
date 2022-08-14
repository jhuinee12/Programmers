package main.java;

/*
 * 문제 설명
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.

제한 조건
strings는 길이 1 이상, 50이하인 배열입니다.
strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
모든 strings의 원소의 길이는 n보다 큽니다.
인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.

입출력 예
strings	n	return
[sun, bed, car]	1	[car, bed, sun]
[abce, abcd, cdx]	2	[abcd, abce, cdx]

입출력 예 설명
입출력 예 1
sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다. 이를 기준으로 strings를 정렬하면 [car, bed, sun] 입니다.

입출력 예 2
abce와 abcd, cdx의 2번째 인덱스 값은 c, c, x입니다. 따라서 정렬 후에는 cdx가 가장 뒤에 위치합니다.
abce와 abcd는 사전순으로 정렬하면 abcd가 우선하므로, 답은 [abcd, abce, cdx] 입니다.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class StringSortMine {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        String[] answer = new String[strings.length];
        HashMap<Integer,String> mapA = new HashMap<>();
        HashMap<Integer,String> mapB = new HashMap<>();
        HashMap<Integer,String> mapC = new HashMap<>();
        int a=0;


        for(int i=0; i<strings.length; i++)
        {
            mapA.put(i,strings[i].substring(0,n));
            mapB.put(i,String.valueOf(strings[i].charAt(n)));
            mapC.put(i,String.valueOf(strings[i].substring(n+1,strings[i].length())));
        }

        List<Integer> keySetListA = new ArrayList<>(mapA.keySet());
        List<Integer> keySetListB = new ArrayList<>(mapB.keySet());
        List<Integer> keySetListC = new ArrayList<>(mapC.keySet());

        Collections.sort(keySetListB, (o1, o2) -> (mapB.get(o1).compareTo(mapB.get(o2))));

        for(Integer keyB:keySetListB)
        {
            for (Integer keyA:keySetListA)
            {
                for (Integer keyC:keySetListC)
                {
                    if (keyA == keyB && keyB == keyC)
                    {
                        answer[a] = mapA.get(keyA) + mapB.get(keyB) + mapC.get(keyC);
                        System.out.println(answer[a]);
                        a++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StringSortMine sol = new StringSortMine();
        String[] strings = {"abzcd","cdzab","abzfg","abzaa","abzbb","bbzaa"};
        sol.solution(strings, 2);
    }

}