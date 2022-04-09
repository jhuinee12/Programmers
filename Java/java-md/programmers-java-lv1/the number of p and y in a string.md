> 최초작성 : 2021.01.17

## ******Level1 - 문자열 내 p와 y의 개수**** (java)**

 [코딩테스트 연습 - 문자열 내 p와 y의 개수](https://programmers.co.kr/learn/courses/30/lessons/12916)

| **문제 설명** |
| --- |
| 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.<br>s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.<br>'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.<br>단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.<br>예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다. |

| **제한 조건** |
| --- |
|   -   문자열 s의 길이 : 50 이하의 자연수<br>-   문자열 s는 알파벳으로만 이루어져 있습니다.   |

| **​입출력 예**    |  |
| --- | --- |
| s | answer |
| "pPoooyY" | true |
| "Pyy" | false |


|입출력 예#1|
|---|
|‘p’의 개수 2개, ‘y’의 개수 2개로 같으므로 true를 return|

|입출력 예#2|
|---|
|‘p’의 개수 1개, ‘y’의 개수 2개로 다르므로 false를 return|

### _**나의 풀이**_

1\. p와 y의 개수를 카운트 할 pCount와 yCount 변수 선언

2\. String s를 split으로 쪼개 배열 spelling에 넣음

3\. 배열을 loop를 돌려 p/P 와 y/Y의 개수 구함

```java
class Solution {
	boolean solution(String s) {
		boolean answer = true;
		int pCount = 0, yCount = 0;
		String[] spelling = s.split("");
		
		for (int i=0; i<spelling.length; i++) {
			if (spelling[i].equals("p") || spelling[i].equals("P"))
				pCount++;
			if (spelling[i].equals("y") || spelling[i].equals(Y"))
				yCount++;
		}
		
		if (pCount == yCount) answer = true;
		else answer = false;
		
		return answer;
	}
}
```

### _**JAVA1 코드 정리**_

1\. 문자 전체를 대문자로 변환

2\. 람다식을 이용해서 s.chars(문자 비교)의 ‘P’나 ‘Y’의 count가 같으면 true 출력

```java
class Solution {
	boolean solution(String s) {
		s = s.toUpperCase(); // 전체 대문자 변환

		// 람다식 : 식이 옳으면 true, 다르면 false
		return s.chars().filter( e -> 'P' == e).count()
		== s.chars().filter( e -> 'Y'==e).count(); 
	}
}
```

### _**JAVA2 코드 정리**_

1\. 나의 방법과 동일하게 pCount와 yCount 변수 선언

2\. if문이 아닌 switch ~ case 문 사용

3\. pCount와 yCount가 둘 다 0이면 true를 리턴

4\. 마지막 리턴은 삼항연산자를 이용하여 pCount==yCount면 true, 아니면 false 리턴

```java
class Solution {
	boolean solution(String s) {
		int size = s.length(), pCount = 0, yCount = 0;
		for (int i=0; i<size; i++) {
			switch(String.valueOf(s.charA(i)).toUpperCase()) {
				case "P": pCount++; break;
				case "Y": yCount++; break;
				defualt: break;
			}
		}
		if(pCount == 0 && yCount == 0) return true; // 둘 다 0일 때 true
		return (pCount==yCount)?true:false; // 삼항연산자
	}
}
```


|내가 풀때는 비교적 간단한 문제라고 생각하고 룰루랄라 풀었었다.<br>하지만, 내 코딩은 너무 길고 복잡했다는 것을 다른 사람들과 비교를 할 때 깨달았다.<br>굳이 split을 써서 배열에 넣을 필요 없이 문자열 그대로 둔 상태에서 charAt이나.<br>chars를 사용하여 문자 하나씩만을 비교할 수 있었다.<br>또한 p/P, y/Y를 번거롭게 다 비교할 필요 없이 toLowerCase나 toUpperCase를 사용<br>하나로 통일 한 후 비교를 하면 됐을 일이었다.<br>그리고 람다식을 사용하면 저렇게 코드가 짧아질 수 있다는 것을 알게되었다.<br>새롭게 알게 된 람다식을 다른 풀이에서도 더 잘 활용하고 싶다.|
|---|