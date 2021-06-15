# (JAVA) Programmers Level1 문제풀이 및 정리
- [직사각형 별찍기](#직사각형-별찍기)
- [X만큼 간격이 있는 n개의 숫자](#x만큼-간격이-있는-n개의-숫자)
- 행렬의 덧셈
- 핸드폰 번호 가리기
- 하샤드수
- 평균 구하기
- 콜라츠 추측
- 최대공약수와 최소공배수
- [짝수와 홀수](#짝수와-홀수)
- 제일 작은 수 제거하기
- 정수 제곱근 판별
- 정수 내림차순으로 배치하기
- 자연수 뒤집어 배열로 만들기
- 자릿수 더하기
- 이상한 문자 만들기
- 약수의 합
- 시저 암호
- [문자열을 정수로 바꾸기](#문자열을-정수로-바꾸기)
- [수박수박수박수박수박수?](#수박수박수박수박수박수)
- 소수 찾기
- 서울에서 김서방 찾기
- [문자열 다루기 기본](#문자열-다루기-기본)
- 문자열 내림차순으로 배치하기
- 문자열 내 p와 y의 개수
- 문자열 내 마음대로 정렬하기
- [두 정수 사이의 합](#두-정수-사이의-합)
- 나누어 떨어지는 숫자 배열
- 같은 숫자는 싫어
- [1차] 다트 게임
- 가운데 글자 가져오기
- [1차] 비밀지도
- 2016년
- 두 개 뽑아서 더하기
- 3진법 뒤집기
- 약수의 개수와 덧셈
- 예산
- 실패율
- 모의고사
- 소수 만들기
- 음양 더하기
- 내적
- 로또의 최고 순위와 최저 순위
- 키패드 누르기
- 폰켓몬
- 체육복
- K번째수
- 완주하지 못한 선수
- 신규 아이디 추천
- 크레인 인형뽑기 게임

<br>

----

<br>

# [직사각형 별찍기](https://programmers.co.kr/learn/courses/30/lessons/12954)
## 문제 설명
이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 평태를 출력해보세요.
## 제한 조건
+ n과 m은 각각 1000 이하인 자연수입니다.
## ​입출력 예

|   입력예시  |              출력예시             |
| :---------: | :------------------------------: |
|     5 3     |    ***** </br>***** </br>*****   |

<br>


## ***나의 풀이***
1. for문
```java
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for (int i=0; i<b; i++){
			for (int j=0; j<a; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
```

<br>


## ***JAVA1 코드 정리***
1. StringBuilder에 하나씩 넣고 toString으로 string형 출력
```java
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<a; i++) // a크기만큼 sb 저장
			sb.append("*");
		for (int i=0; i<b; i++) // b 개수만큼 출력
			System.out.println(sb.toString());
	}
}
```
> 이번 코드는 Scanner를 사용해야해서 그런가 다른 코드들과는 다르게 main 클래스에서 실행을 했다.
상대적으로 쉬운 코드였고, 확실히 코드가 간결했다.
for문으로 다 출력하는 방법도 있고 StringBuilder를 써도 되는구나를 알게되었다.

<br>

----

<br>

# [x만큼 간격이 있는 n개의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12954)
## 문제 설명
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지나는 리스트를 리턴해야 합니다.
다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성하세요.
## 제한 조건
+ x는 -10000000 이상, 10000000 이하인 정수입니다.
+ n은 1000 이하인 자연수입니다.
## ​입출력 예

|  x  |   n  |    answer    |
| :-- | :--: | :-----------: |
|  2  |   5  | [2,4,6,8,10] |
|  4  |   3  |   [4,8,12]   |
| -4  |   2  |    [-4,-8]   |

<br>

## ***나의 풀이***
1. 처음 입력될 [0]의 자리는 입력받은 x를 넣는다.
2. 그 다음 answer[0]만큼 증가시켜 n개의 숫자를 배열 안에 넣는다.
```java
class Solution {
  public long[] solution(int x, int n) {
      long[] answer = new long[n];
      answer[0] = x;
      for(int i=1; i<n; i++){
          answer[i] = answer[i-1] + x; 
      }
      return answer;
  }
} 
```
> 확실히 난이도는 쉬웠다.
배열의 개념을 알고 있고 반복문을 제대로 사용할 줄 안다면 누구나 풀 수 있는 문제였다.
나 외에 다른 코드들도 보았지만, 대부분 비슷하게 코딩하였다.

<br>

---

<br>

# [문자열 다루기 기본](https://programmers.co.kr/learn/courses/30/lessons/12918)
## 문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성되어있는지 확인해주는 함수, solution 완성하세요.
예를 들어 s가 “a234”이면 False를 리턴하고 “1234”이면 True를 리턴하면 됩니다.
## 제한 조건
+ s는 길이 1 이상, 길이 8 이하인 문자열입니다.
## ​입출력 예

|     s    |  return  |
| :------: | :------: |
|  "a1234" |  false   |
|   "1234  |   true   |

<br>

## ***나의 풀이***
1. try~catch문을 이용하여 숫자로 바꾸다가 오류가 나면 false를 리턴하고 오류가 안나면 true 리턴
```java
class Solution {
	public static boolean solution (String s) {
		boolean answer = true;
		if (s.length()==4 || s.length()==6) {
			try {
				Integer.parseInt(s);
				answer = true;
			} catch(NumberFormatException e) { // 문자 포함됨
				answer = false;
			}
		} else answer = false;
		return answer;
	}
}
```
> comment
```java
try {
	에러가 발생할 수 있는 코드
	throw new Exception(); // 강제 에러 출력
} catch (Exception e) {
	e.printStackTrace(); // 오류 출력
	throw.e; // 최상위 클래스가 아니면 무조건 던져주자
} finally {
	무조건 수행
}
```

<br>

## ***JAVA1 코드 정리***
* 숫자임을 확인하는 정규식 이용
```java
class Solution {
	public static boolean solution (String s) {
		if (s.length()==4 || s.length()==6) {
			return s.matches("(^[0-9]*$)");
		}
		return false;
	}
}
```
- ^ : 문자열의 시작
- $ : 문자열의 종료
- . : 임의의 한 문자 (\는 불가)
- * : 앞에 문자가 없거나 무한
- + : 앞에 문자가 하나이상
- ? : 앞에 문자가 없거나 하나
- [] : 문자의 집하이나 범위. 두 문자 사이는 -로 나타냄. []내에 ^가 선행하면 not의 의미
- {} : 횟수 또는 범위
- () : 소괄호 안에 문자를 하나의 문자로 인식
- | : 패턴 안에서 또는 연산자
- \s : 공백문자
- \S : 공백 아닌 나머지 문자
- \w : 알파벳이나 숫자
- \W : 알파벳, 숫자를 제외한 문자
- \d : 숫자 [0-9]와 동일
- \D : 숫자 제외 모든 문자
- \ : 확장 문자. 뒤에 일반문자가 오면 특수문자 취급. 뒤에 특수문자가 오면 그 문자 자체 의미
- (?!) : 대소문자 구분 X

<br>

>try~catch를 처음 사용하여 코드를 짜 보았는데 if를 하는 방법보다 훨씬 효율적인 것 같다.
정규식도 생각보다 많이 복잡하지 않아서 조금 더 공부해서 정규식으로도 다시 코드를 짜보고 싶다.

<br>

----

<br>

# [짝수와 홀수](https://programmers.co.kr/learn/courses/30/lessons/12937)
## 문제 설명
정수 num이 짝수일 경우 “Even”을 반환하고 홀수인 경우 “Odd”를 반환하는 함수
## 제한 조건
+ num은 int 범위의 정수입니다.
+ 0은 짝수입니다.
## ​입출력 예

|   n  | answer |
| :--: | :-----:|
|   3  |  "Odd" |
|   3  | "Even" |

<br>

## ***나의 풀이***
1. 삼항연산자를 이용하여 num을 2로 나눴을 때 나머지가 0이면 (짝수) Even을 리턴하고 0이 아니면 (홀수) Odd를 리턴한다.
```java
class Solution {
	public String solution (int num) {
		return (num%2 == 0) ? "Even" : "Odd"
	}
}
```
> 프로그래머스 중 가장 쉬운 난이도인 것 같다.
다른 사람들의 코드를 비교해봤을 때도 다 비슷비슷하다고 느껴졌다.

<br>

----

<br>

# [문자열을 정수로 바꾸기](https://programmers.co.kr/learn/courses/30/lessons/12925)
## 문제 설명
문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
## 제한 조건
+ S의 길이는 1 이상 5 이하입니다.
+ S의 맨 앞에는 부호(+,-)가 올 수 있습니다.
+ S는 부호와 숫자로만 이루어져 있습니다.
+ S는 “0”으로 시작하지 않습니다.
## ​입출력 예
예를 들어 str이 “1234”이면 1234를 반환하고, “-1234”이면 -1234를 반환
Str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없음

<br>

## ***나의 풀이***
1. String을 바로 Int로 바꿔주는 내장 함수 사용
```java
class Solution {
    fun solution(s: String): Int {
        return s.toInt()
    }
}
```

<br>

## ***JAVA1 코드 정리***
1. 내가 사용한 Integer.parseInt(s)를 풀어서 코딩
2. result*10을 이용하여 자릿수를 하나씩 위로 올림
```java
public class StrToInt {
	public int getStrToInt(String str) { // Integer.parseInt(s)를 분해한 것
		Boolean Sign = true;
		Int result = 0;
		
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '-')
				Sign = false;
			else if (ch != '+')
				result = result*10 + (ch-'0'); // 자릿수를 하나씩 위로
		}
		return Sign ? 1: -1*result;
	}
}
```

<br>

----

<br>

# [수박수박수박수박수박수?](https://programmers.co.kr/learn/courses/30/lessons/12922)
## 문제 설명
길이가 n이고, “수박수박수박수….”와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution 완성
예를 들어 n=4이면, “수박수박”을 리턴하고 3이면 “수박수”리턴
## 제한 조건
+ n은 길이 10,000 이하인 자연수
## ​입출력 예

|  x  |    answer    |
| :-- | :-----------: |
|  3  | "수박수" |
|  4  |   "수박수박"   |

<br>

## ***나의 풀이***
1. “수”,”박”을 각각 Pattern이라는 배열에 저장
2. for문을 돌려 n의 길이만큼 나타내기 : 홀수인 경우 한글자 누락
3. 홀수인 경우 누락된 한 글자를 나중에 추가 : answer += “수”;
```java
class Solution {
	public String solution(int n) {
		String answer = "";
		String[] Pattern = {"수", "박"};
		
		if (n%2 == 0) {
			for (int i=0; i<n/2; i++)
				for (int j=0; j<2; j++)
					answer += Pattern[j];
		} 
		else {
			for (int i=0; i<n/2; i++)
				for (int j=0; j<2; j++)
					answer += Pattern[j];
					
			answr = answer + "수";
		}
		retrun answer;
	}
}
```

<br>

## ***JAVA1 코드 정리***
1. “수”,”박”을 각각 Pattern이라는 배열에 저장
2. for문을 돌려 n의 길이만큼 나타내기 : 홀수인 경우 한글자 누락
3. 홀수인 경우 누락된 한 글자를 나중에 추가 : answer += “수”;
```java
class Solution {
	public String solution(int n) {
		return new String(new char[n/2+1]).replace("\0","수박").subString(0,n);
	}
}
```
* subString(0, n) : 0부터 n까지 자르는 함수
    1. new String() 생성자 키워드 안에 char 배열을 넣으면 String 객체로 변환
    2. 빈 char 배열이 생성되면 그 안에는 \0으로 생성​

<br>

## ***JAVA2 코드 정리***
1. 삼항연산자를 이용하여 자릿수(for문 중 i)가 홀수면 “수”, 짝수면 “박”
```java
class Solution {
	public String solution(int n) {
		String result = "";
		for (int i=0; i<n; i++)
			result += i%2==0 ? "수" : "박";
		return result;
	}
}
```

<br>

## ***JAVA3 코드 정리***
1. StringBuffer를 이용하여 Java2의 풀이법을 sf에 넣어 나중에 String으로 바꿔 출력
```java
class Solution {
	public String solution(int n) {
		StringBuffer sf = new StringBuffer();
		for (int i=0; i<n; i++)
			sf.append(i%2==1 ? "수" : "박");
		return sf.toString();
	}
}
```
* StringBuffer : 문자열 추가 or 변경시 사용
    - insert : 특정위치 문자열 삽입
    - append : 문자열 추가

<br>

> 이번에는 다양한 방법이 존재했다.
그 중에서 나의 코드가 제일 비효율적이고 길었다.
나의 코드에서도 일단 if문과 else를 합쳐서 좀 더 짧게 쓸 수 있었는데 그 생각을 하지 못했다.
다양한 방법 중 가장 좋았던 것은 char 배열을 string으로 고친 후 replace와 subString을 써서 한줄로 표현한 방법이었다.
다 아는 문법들이었지만, 이런 방법은 생각하지 못했었다.
그리고 StringBuffer도 다른 사람들에 풀이에 비하면 굳이?라는 생각이 들긴 하지만,
StringBuffer라는 새로운 것을 사용했다는 점이 좋아 풀이 방법에 추가하였다

<br>

----

<br>

# [두 정수 사이의 합](https://programmers.co.kr/learn/courses/30/lessons/12912)
## 문제 설명
두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수,
solution을 완성하세요.
예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
## 제한 조건
+ a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
+ a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
+ a와 b의 대소관계는 정해져있지 않습니다.​
## ​입출력 예

|  a  |   b  |  return  |
| :-- | :--: | :------: |
|  3  |   5  |    12    |
|  3  |   3  |     3    |
|  5  |   3  |    12    |

<br>

## ***나의 풀이***
1. a와 b의 대소관계 구분
2. 작은 수부터 큰 수까지 for문을 이용하여 모든 숫자 합하기
```java
class Solution {
	public long solution(int a, int b) {
		long answer = 0;
		
		if (a < b) {
			for (int i=a; i<=b; i++)
				answer = answer+i;
		} else if (a > b) {
			for (int i=b; i<=a; i++)
				answer = answer+i;
		} else answer = a;
		
		return answer;
	}
}
```
<br>

## ***JAVA1 코드 정리***
1. 새로운 함수 sumAtoB 생성
2. Math.min(), Math.max()를 이용하여 대소관계 구분
3. 등차수열의 합 공식을 이용하여 모든 숫자의 합 구함
    - (등차수열의 합 공식 : (2a+(n-1)d)/2
```java
class Solution {
	public long solution(int a, int b) {
		return sumAtoB(Math.min(a,b), Math.max(b,a)); // 대소관계 구분 내장함수
	}
	
	private long sumAtoB(long a, long b) {
		return (b - a +1) * (a + b) / 2; // 등차수열의 합 공식
	}
}
```

<br>

## ***JAVA2 코드 정리***
1. 삼항연산자를 이용하여 for문 안에 대소관계 구분
2. 작은 수부터 큰 수까지 for문을 이용하여 숫자 합하기
```java
class Solution {
	public long solution(int a, int b) {
		long answer = 0;
		for (int i=((a<b)?a:b); i<=((a<b)?a:b); i++)
			answer += i; // 나의 식 한줄요약
			
		return answer;
	}
}
```

<br>

> 좀 창피한 코딩이었다.
훨씬 압축해서 줄일 수 있는 것을 미련하게 줄줄줄줄 쓴 느낌이다.
문제 자체가 쉬워서 코딩이 길지는 않았지만, 그래도 좀 아쉬움이 많이 남는 코딩이다.
새롭게 배운 점은 ‘등차수열’이다. 그동안 배운 수학을 알고리즘에서도 사용할 수 있으니 참 새로웠다.
저런 아이디어를 바로 적용할 수 있는 사람들이 놀랍다.