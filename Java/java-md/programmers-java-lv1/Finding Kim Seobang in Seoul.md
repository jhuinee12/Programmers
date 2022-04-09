> 최초작성 : 2020.11.07

## **Level1 - 서울에서 김서방 찾기 (java)**

 [코딩테스트 연습 - 서울에서 김서방 찾기](https://programmers.co.kr/learn/courses/30/lessons/12919)

| **문제 설명** |
| --- |
| String형 배열 seoul의 element 중 “Kim”의 위치 x를 찾아, “김서방은 x에 있다”는 String 반환<br>seoul에 “Kim”은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우 없음 |

| **제한 조건** |
| --- |
|   -   seoul의 길이 1 이상, 1000 이하 배열|
|   -   seoul의 원소는 길이 1 이상, 20 이하인 문자열 -   “Kim”은 반드시 seoul 안에 포함   |

| **​입출력 예**    |  |
| --- | --- |
| seoul | result |
| \[“Jane”, “Kim”\] | “김서방은 1에 있다” |

### _**나의 풀이**_

answer를 초기화 선언한 뒤, seoul의 배열 길이만큼 for문을 돌려 “Kim”이 등장하면 위치 return

```java
class Solution {
	public String solution(String[] seoul) {
		String answer = "";
		
		for (int i=0 i<seoul.length; i++)
			if(seoul[i].equals("Kim")) // 요소 찾기
				answer= "김서방은 " +i + "에 있다";
		
		return answer;
	}
}
```

### _**JAVA1 코드 정리**_

1\. 배열과 리스트의 속성 이용

2\. 리스트는 ‘인덱스’를 가지고 있으므로 indexOf를 이용해 “Kim”이 있는 곳에 인덱스 출력

```java
class Solution {
	public String solution(String[] seoul) {
		int x = Arrays.asList(seoul).indexOf("Kim");
		return "김서방은 " + x + "에 있다";
	}
}
// 한줄 가능
// return “김서방은 “ + Arrays.asList(seoul).indexOf(“Kim”) + “에 있다”;
```

\* **Arrays.asList** : 배열->리스트 // 처리만!

\* **indexOf** : 찾는 변수가 배열 어디에 있는지 반환 // Array에는 indexOf가 없음

\* **배열 vs 리스트**

배열 : 크기가 정해져 있다 (길이 변경 불가)

리스트 : 인덱스X, ‘순서’ (그저 위치만 중요)

인덱스 : 유일무이 식별자

| 배열과 리스트를 이용해서 구하면 더욱 쉽고 빠르게 구할 수 있다는 사실을 알게 되었다.<br>Arrays.asLis()와 indexOf()를 앞으로도 잘 활용할 수 있었으면 좋겠다.<br>그럼 쓸데없는 코드들은 빠지고 한줄로만 구현할 수 있을 것이다. |
| --- |