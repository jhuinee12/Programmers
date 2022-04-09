> 최초작성 : 2021.09.24

## ******Level1 - 시저 암호**** (java)**

 [코딩테스트 연습 - 시저 암호](https://programmers.co.kr/learn/courses/30/lessons/12926)

| **문제 설명** |
| --- |
| 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요. |

| **제한 조건** |
| --- |
|   -   공백은 아무리 밀어도 공백입니다. -   s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다. -   s의 길이는 8000이하입니다. -   n은 1 이상, 25이하인 자연수입니다.   |

| **​입출력 예** |  |  |
| --- | --- | --- |
| s | n | result |
| "AB" | 1 | "BC" |
| "z" | 1 | "a" |
| "a B z" | 4 | "e F d" |

---

### _**나의 풀이**_

1\. s를 char 배열로 바꿔 charArr 배열에 넣는다.

2\. charArr 배열의 자릿값이 공백이면 값을 바꾸지 않고 continue

3\. charArr 배열의 자릿값이 대문자 'Z'보다 작으면서 대문자 'A'보다 크고 n을 더한 값이 대문자 'Z'보다 크면 +n-26으로 변경

4\. charArr 배열의 자릿값+n이 'z'보다 크면 +n-26으로 변경

5\. 위 사항에 해당되지 않으면 charArr 배열의 자릿값+n으로 변경

6\. charArr을 string으로 변환하고 리턴

```java
class Solution {
  public String solution(String s, int n) {
      char[] charArr = s.toCharArray();
		for(int i = 0 ;i < charArr.length; i++) {
			if(charArr[i]==' ')
				continue;
			else if(charArr[i]<='Z'&&charArr[i]>='A'&&charArr[i]+n>'Z')
				charArr[i] = (char) (charArr[i] + n - 26);
			else if(charArr[i]+n>'z')
				charArr[i] = (char) (charArr[i] + n - 26);
			else
				charArr[i] = (char) (charArr[i] + n);
		}
		
		return new String(charArr);
  }
}
```

### _**JAVA1 코드 정리**_

1\. s의 각 자릿수의 char인 변수 ch

2\. ch가 소문자이면 ch+n에 -'a'하고 %26을 해줘서 소문자 내 증가값을 구함 : +'a'

3\. ch가 대문자이면 ch+n에 -'A'하고 %26을 해줘서 대문자 내 증가값을 구함 : +'A'

4\. ch를 string으로 합쳐 리턴

```java
class Caesar {
	String caesar(String s, int n) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isLowerCase(ch)) {
				ch = (char) ((ch - 'a' + n) % 26 + 'a');
			} else if (Character.isUpperCase(ch)) {
				ch = (char) ((ch - 'A' + n) % 26 + 'A');
			}
			result += ch;
		}
		return result;
	}
}
```