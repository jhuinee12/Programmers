> 최초작성 : 2020.10.21

## **Level1 - 하샤드수 (java)**

 [코딩테스트 연습 - 하샤드 수](https://programmers.co.kr/learn/courses/30/lessons/12947)

| **문제 설명** |
| --- |
| 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.<br>예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.<br>자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요. |

| **제한 조건** |
| --- |
|   -   x는 1 이상, 10000 이하인 정수입니다.<입출력 예\>   |

| **​입출력 예**    |  |
| --- | --- |
| arr | return |
| 10 | true |
| 12 | true |
| 11 | false |
| 13 | false |
|   -   입출력 예 #1       10의 모든 자릿수의 합은 1입니다. 10은 1로 나누어 떨어지므로 10은 하샤드 수입니다. -   입출력 예 #2       12의 모든 자릿수의 합은 3입니다. 12는 3으로 나누어 떨어지므로 12는 하샤드 수입니다. -   입출력 예 #3       11의 모든 자릿수의 합은 2입니다. 11은 2로 나누어 떨어지지 않으므로 11는 하샤드 수가 아닙니다. -   입출력 예 #4       13의 모든 자릿수의 합은 4입니다. 13은 4로 나누어 떨어지지 않으므로 13은 하샤드 수가 아닙니다.   |  |

### _**나의 풀이**_

1\. 입력받은 값(x)의 자릿수를 더한 값을 저장할 int sum 선언

2\. 입력받은 값(x)가 훼손되지 않도록 int n을 따로 선언 후 10으로 나눠 나머지를 구하여 한자리씩 추출

3\. 한자리씩 추출 받은 값을 sum으로 계속 더함 (각 자릿수 합하기)

4\. sum이 x에 나누어 떨어지면 하샤드수

```java
class Solution {
  public boolean solution(int x) {
      	boolean answer = true;
		int sum = 0;
		int n = x; // x값 훼손 방지
		
		while(n!=0) {
			sum += n%10;
			n = n/10;
		}
		
		answer = (x%sum == 0) ? true : false;
		
		return answer;
	}
}
```

### _**JAVA1 코드 정리**_

1\. 입력받은 숫자(num)을 한글자씩 쪼개서 String temp 배열에 입력

2\. temp 배열에 각 요소 하나씩을 s로 int 값으로 변경 후 sum 변수에 합하기

3\. 하샤드 여부 확인

```java
public boolean isHarshad(int num){

    String[] temp = String.valueOf(num).split("");

    int sum = 0;
    for (String s : temp) { // temp 배열의 각 요소 추출
        sum += Integer.parseInt(s);
    }

    if (num % sum == 0) {
            return true;
    } else {
      return false;
    }
}
```

### _**JAVA2 코드 정리**_

1\. 입력받은 값(num)을 int mod에 입력

2\. 각 자릿수를 더하는 변수 calc 선언

3\. mod를 10으로 나누었을 때 나머지가 0이상이면 do 실행문 실행

```java
public class HarshadNumber{
    public boolean isHarshad(int num){
		int mod=num;
		int calc=0;
		do{
			calc+=(mod%10);
			mod=mod/10;
		}while(mod%10 > 0);

        return (num%calc == 0) ? true:false;
    }
}
```

do~while문은 조건 상관 없이 무조건 한번은 실행

do{ 실행문 } while { 조건문 }

| 상당히 간단한 문제이지만, 다양한 풀이법이 존재하였다.<br>나 같은 경우는 int내에서 %10을 이용하여 각 자릿수를 추출하여 결과를 계산하였고,<br>어떤 사람은 배열을 사용하여 각 자릿수를 뽑아내 사용하였다.<br>\-48의 정체는 알아내지 못하였지만, 다양한 풀이법이 신기하고 흥미롭다. |
| --- |