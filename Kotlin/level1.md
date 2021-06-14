# (Kotliln) Programmers Level1 문제풀이 및 정리
- 직사각형 별찍기
- X만큼 간격이 있는 n개의 숫자
- 행렬의 덧셈
- 핸드폰 번호 가리기
- 하샤드수
- [평균 구하기](#평균-구하기)
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
- 수박수박수박수박수박수?
- 서울에서 김서방 찾기
- 문자열 다루기 기본
- 문자열 내림차순으로 배치하기
- 문자열 내 마음대로 정렬하기
- 두 정수 사이의 합
- 나누어 떨어지는 숫자 배열
- 가운데 글자 가져오기
- 2016년
- 두 개 뽑아서 더하기
- 약수의 개수와 덧셈
- 실패율
- 3진법 뒤집기
- 로또의 최고 순위와 최저 순위
- 체육복
- K번째수
- 내적
- 신규 아이디 추천
- 음양 더하기
- 키패드 누르기
- 크레인 인형뽑기 게임
- 모의고사
- 소수 만들기

</br>

# [평균 구하기](https://programmers.co.kr/learn/courses/30/lessons/12944)
## 문제 설명
정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요
## 제한 조건
+ arr은 길이 1 이상, 100 이하인 배열입니다.
+ arr의 원소는 -10000 이상 10,000 이하인 정수입니다..
## ​입출력 예

|      arr     |  return  |
| :----------: | :------: |
|   [1,2,3,4]  |    2.5   |
|      [5,5]   |     5    |
----------
## 나의 풀이
1. arr의 길이만큼 for문을 돌려서 총 합을 구한다.
2. 구한 합을 다시 arr의 길이로 나눠서 평균을 구한다.
```kotlin
class Solution {
    fun solution(arr: IntArray): Double {
        var answer:Double = 0.0

        for(i in arr) 
            answer += i

        answer /= arr.size
        return answer
    }
}
```
----
## Kotlin1 코드 정리
1. 내장 average()함수를 사용 -> average 값이 있으면 average 리턴, 없으면 0 리턴
```kotlin
class Solution {
	fun solution(arr: IntArray): Double {return arr.average()}
}
```

<center> ↓ </center>

* fun solution(arr: IntArray): Double = arr.average()
```kotlin
class Solution {
	fun solution(arr: IntArray): Double {
		return (arr.fold(0){ acc,i -> acc+i }.toDouble()/arr.size) // fold(0) : 초기값 0
	}
}
```
* fold : 초기값을 설정해주고 왼쪽부터 오른쪽까지 현재의 계산값에 각각을 적용하는 함수
----
## Kotlin2 코드 정리
1. 내장 sum()함수를 사용 -> 입력받은 arr의 총합 구함
2. 그 값을 double로 변환한 후 arr의 크기만큼 나누어줌
```kotlin
class Solution {
	fun solution(arr: IntArray): Double {retrun arr.sum().toDouble()/arr.size}
}
```

</br>
</br>

# [짝수와 홀수](https://programmers.co.kr/learn/courses/30/lessons/12937)
## 문제 설명
정수 num이 짝수일 경우 “Even”을 반환하고 홀수인 경우 “Odd”를 반환하는 함수
## 제한 조건
+ num은 int 범위의 정수입니다.
+ 0은 짝수입니다.
## ​입출력 예

|   n  |  return  |
| :--: | :------: |
|   3  |   "Odd"  |
|   4  |  "Even"  |
----------
## 나의 풀이
1. num을 2로 나눴을 때 나머지가 0이면 (짝수) Even을 리턴하고 0이 아니면 (홀수) Odd를 리턴한다.
```kotlin
class Solution {
    fun solution(num: Int): String {
        return if(num % 2 == 0) "Even" else "Odd"
    }
}
```
----
## Kotlin1 코드 정리
```kotlin
class Solution {
	fun solution(num: Int): String {
		return if(num.and(1)==0) "Even" else "Odd"
	}
}
```
> .and(1)이 뭔지 검색을 해봐도 안나옴...ㅠㅠ
----
## Kotlin2 코드 정리
```kotlin
class Solution {
	fun solution(num: Int): String {
		return when(num%2) {
			0 -> "Even"
			else -> "Odd"
		}
	}
}
```
> java에서 switch ~ case 문과 흡사
-	- num%2 == 0 -> "Even"
-	- num%2 != 0 -> "Odd"

</br>
</br>

# [문자열을 정수로 바꾸기](https://programmers.co.kr/learn/courses/30/lessons/12925)
## 문제 설명
문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
## 제한 조건
+ S의 길이는 1 이상 5 이하입니다.
+ S의 맨 앞에는 부호(+,-)가 올 수 있습니다.
+ S는 부호와 숫자로만 이루어져 있습니다.
+ S는 “0”으로 시작하지 않습니다.
## 입출력 예
예를 들어 str이 “1234”이면 1234를 반환하고, “-1234”이면 -1234를 반환
Str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없음

----------

## 나의 풀이
1. String을 바로 Int로 바꿔주는 내장 함수 사용
```kotlin
Class Solution {
	public int solution(String s) {
		return Integer.parseInt(s);
	}
}
```
----
## Kotlin1 코드 정리
```kotlin
class Solution {
    fun solution(s: String) = s.toInt()
}
```
> 내 풀이법과 방법은 같지만, 나는 바로 return을 한 반면 이 소스는 함수를 만들어 리턴함.
----
## Kotlin2 코드 정리
1. 입력받은 문자열 s의 첫 글자가 -면 -1을 대입하고, 아니면 1을 대입함.
2. 문자열 s가 숫자이면 int()로 변경 후 sign에 곱함
```kotlin
class Solution {
	fun solution(s: String) : Int { // -면 *(-1) : 음수, 아니면 *1 : 양수
		val sign:Int = if(s.first() == '-') -1 else 1
		return (s.filter { it. isDigit() }.toInt())*sign
	}
}
```
* isDigit() : 숫자 판단
* filter : 리스트 중에서 조건에 맞는 값만 리턴
> 어차피 .toInt()를 쓸거면 왜 저렇게 복잡하게 돌아갔을까?
-1과 1 여부는 toInt()가 알아서 해줄텐데...

> s.filter { it. isDigit() } 이 부분은 숫자가 아닌 문자가 들어올 경우 걸러내기 좋아 괜찮은 것 같다.
근데 이 줄만 있어도 괜찮을 것 같다.