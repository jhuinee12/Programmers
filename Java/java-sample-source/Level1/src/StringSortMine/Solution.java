/*
 * ���� ����
���ڿ��� ������ ����Ʈ strings��, ���� n�� �־����� ��, �� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����Ϸ� �մϴ�.
���� ��� strings�� [sun, bed, car]�̰� n�� 1�̸� �� �ܾ��� �ε��� 1�� ���� u, e, a�� strings�� �����մϴ�.

���� ����
strings�� ���� 1 �̻�, 50������ �迭�Դϴ�.
strings�� ���Ҵ� �ҹ��� ���ĺ����� �̷���� �ֽ��ϴ�.
strings�� ���Ҵ� ���� 1 �̻�, 100������ ���ڿ��Դϴ�.
��� strings�� ������ ���̴� n���� Ů�ϴ�.
�ε��� 1�� ���ڰ� ���� ���ڿ��� ���� �� ���, ���������� �ռ� ���ڿ��� ���ʿ� ��ġ�մϴ�.

����� ��
strings	n	return
[sun, bed, car]	1	[car, bed, sun]
[abce, abcd, cdx]	2	[abcd, abce, cdx]

����� �� ����
����� �� 1
sun, bed, car�� 1��° �ε��� ���� ���� u, e, a �Դϴ�. �̸� �������� strings�� �����ϸ� [car, bed, sun] �Դϴ�.

����� �� 2
abce�� abcd, cdx�� 2��° �ε��� ���� c, c, x�Դϴ�. ���� ���� �Ŀ��� cdx�� ���� �ڿ� ��ġ�մϴ�.
abce�� abcd�� ���������� �����ϸ� abcd�� �켱�ϹǷ�, ���� [abcd, abce, cdx] �Դϴ�.
 */

package StringSortMine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class Solution {
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
		Solution sol = new Solution();
		String[] strings = {"abzcd","cdzab","abzfg","abzaa","abzbb","bbzaa"};
		sol.solution(strings, 2);
	}

}
