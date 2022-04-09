> 최초작성 : 2021.04.30

## ******Level2 - 124 나라의 숫자**** (java)**

 [코딩테스트 연습 - 124 나라의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12899)

| **문제 설명** |
| --- |
| 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.<br>1.  124 나라에는 자연수만 존재합니다.<br>2.  124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.<br>예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다 |

| **10진법** | **124 나라** | **10진법** | **124나라** |
| --- | --- | --- | --- |
| 1 | 1 | 6 | 14 |
| 2 | 2 | 7 | 21 |
| 3 | 4 | 8 | 22 |
| 4 | 11 | 9 | 24 |
| 5 | 12 | 10 | 41 |

||
| --- |
| 자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록<br>solution 함수를 완성해 주세요.|

| **제한 조건** |
| --- |
|   -   n은 500,000,000이하의 자연수 입니다.   |

| **​입출력 예**    |  |
| --- | --- |
| n | result |
| 1 | 1 |
| 2 | 2 |
| 3 | 4 |
| 4 | 11 |

---

### _**나의 풀이**_

**_\* 3진법!!_**

**_\* 1->1, 2->2, 0->1 (다음 숫자를 -1 해야함)_**

1\. 자연수 n을 3진수로 바꾸는 div 함수를 생성한 후 3진수를 reverse해서 solution에 리턴

2\. div에서 받아온 string 값을 charArray로 변경 후 각 원소들을 for문을 통해 비교

3\. 값이 0일 경우, 4로 변경 후 zero 값을 true로 변경 : 다음 자리수를 -1하기 위해 비교값 선언

4\. 값이 0보다 작을 경우, 2로 변경 후 zero 값을 true로 변경 : 0이 4로 바뀌어야 하는데 이 값에서 또 -1 되면서 2 (다음 자리수 -1)

5\. for문 종료 후 num이 0일 경우 (마지막 문자가 0이 되었을 경우) 4로 바뀌어서 저장되는데 해당 값을 제거

6\. sb2에 저장된 모든 값들을 reverse해서 리턴

```java
class Solution {
	StringBuilder sb1 = new StringBuilder();

	public String solution(int n) {
		StringBuilder sb2 = new StringBuilder();
		Boolean zero = false;
		int num = 0;
		sb1.delete(0,sb1.length());
		
		for (char s : div(n).toCharArray())
		{
			num = zero ? Integer.parseInt(String.valueOf(s))-1 : Integer.parseInt(String.valueOf(s));

			if (num > 0)
			{
				sb2.append(num);
				zero = false;
			}
			else if (num == 0)
			{						
				sb2.append(4);
				zero = true;
			}
			else
			{
				sb2.append(2);
				zero = true;
			}

		}
		
		if (sb2.length() > 1 && num==0)
			sb2.deleteCharAt(sb2.length()-1);
		
		return sb2.reverse().toString();
	}
	
	public String div (int n) {
		if (n>=3)
		{
			sb1.append(n%3);
			div(n/3);
		}
		else {
			sb1.append(n%3);
		}
		return sb1.toString();
	}
}
```

<center>

| 진짜 거의 울면서 풀었다....ㅎㅎㅎㅎ<br>배열도 선언해보고 이것저것 다해보다가 '3진수'로 바꾸면 된다는 것을 깨닫고<br>그 다음부터는 제대로 소스의 가닥이 잡혔다.   계속 하나씩 오류가 나서 모든 숫자 다 찍어보고 오류나는 부분 찾아서 고치고,<br>또 고치고를 반복해서 겨우 성공했다.......<br>하지만 좀... 비효율적으로 소스를 돌린 것 같긴 한데 내 머리에선 이게 최선... |
| :---: |

</center>

### _**JAVA1 코드 정리**_

1\. "4","1","2"로 구성된 배열 선언

2\. n을 3으로 나눈 나머지 값을 차례로 num에서 가져와 answer에 계속 쌓기 (4->0, 1->1, 2->2)

```java
class Solution {
  public String solution(int n) {
      String[] num = {"4","1","2"};
      String answer = "";

      while(n > 0){
          answer = num[n % 3] + answer;
          n = (n - 1) / 3;
      }
      return answer;
  }
}
```

* n-1 모르는 사람을 위해 설명하자면, 1,2,4 숫자 체계에서 3씩 나누면 한 칸씩 당겨집니다.<br>다만 문제가 생기죠. 이에 대해 설명 하면, 1, 2, 4를 1, 2, 3이라고 칩시다.<br>133일경우 한 칸씩 당기면 13.3이 되는데 이때 0.1은 10진수로 1/3이됩니다.<br>그래서 13.3의 0.3이 1이되어서 몫에 영향을 주게 됩니다.<br>그래서 나누기전에 -1을 해주면 소수점 값이 0.3일때 몫에 영향을 줄일 이 없게 됩니다.<br>그리고 111을 당길경우 1을빼면 33이되고 이를 3으로 나누어서 당겨주면 3.3이되는데<br>0.3은 1이되므로 3 + 1해서 11이되어서 정상적으로 당겨지게 됩니다.<br>당기면서 3모듈러연산하면 1의자리수 알 수있으니 계속 당기면서 1의자리 추출해준겁니다.

<center>

| 분석해보면 내 코드랑 비슷하다...<br>내가 생각한 방식이랑 비슷하다.<br>4가 0으로 바뀌고, 1이 1로 바뀌고, 2가 2로 바뀌고.<br>근데 진짜 이렇게 간단하고 깔끔하게 구현할 수 있었다니........!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!   <br> 이건 천재다... |
| :---: |

</center>

### _**JAVA2 코드 정리**_

1\. JAVA1 동일

```java
class OneTwoFour {
    public String change124(int n) {
        String answer = "";
        int k = 0;

        while (n > 0) {
            k = n % 3; //나머지  - 자릿수 (낮은자리부터)
            n = n / 3; //몫        - 다음루프의 피제수
            if (k == 0) {
                n = n-1; //자리올림을 안 하는 효과
                k = 4;
            }
            answer = k + answer;
        }
        return answer;
    }
}
```