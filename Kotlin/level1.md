# (Kotliln) Programmers Level1 문제풀이 및 정리
- [직사각형 별찍기](#직사각형-별찍기)
- [X만큼 간격이 있는 n개의 숫자](#x만큼-간격이-있는-n개의-숫자)
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
- [문자열 다루기 기본](#문자열-다루기-기본)
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

---

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

## *나의 풀이*
1. for문
```kotlin
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    for(i in 1..b) {
        for(j in 1..a) {
            print("*")
        }
        println()
    }
}
```
* redLine : 입력 -> java의 Scanner와 같은 역할
* val(a,b) => split으로 나눈 값 각각 저장

<br>

## ***Kotlin1 코드 정리***
```kotlin
fun main(argsL Array<String>) {
	val(a,b) = readLine()!!.split(' ').map(String::toInt)
	
	var star : String = ""
	
	for (1 in 1..a) {
		star += "*"
	}
	
	for (i in 1..b) {
		println(star)
	}
}
```

</br>

---

</br>

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

## *나의 풀이*
1. x가 음수일 경우, 양수일 경우, 0일 경우로 나눠서 계산
2. x가 양수일 경우, answer에는 x부터 x*n까지 x만큼 증가하는 값을 add
3. x가 0일 경우, answer에는 0을 n개만큼 add
4. x가 음수일 경우, answer에는 x부터 x*n까지 -x(x는 음수이니 -)만큼 감소하는 값을 add

```kotlin
class Solution {
    fun solution(x: Int, n: Int): MutableList<Long> {
        var answer = mutableListOf<Long>()

        if (x>0)
        {
            for(i in x.toLong().. x*n.toLong()step x.toLong())
                answer.add(i.toLong())
        }
        else if (x==0)
        {
            var i = 0
            while(i != n)
            {
                answer.add(0)
                i++
            }
        }
        else
        {
            for (downToIndex in x.toLong() downTo x*n.toLong() step -x.toLong())
                answer.add(downToIndex.toLong())
        }

        return answer
    }
}
```
* for문 안에서 int로 받은 매개변수들을 Long 형태로 변경해주지 않으면 long 타입과 int 타입이 최대 가져올 수 있는 범위가 달라 answer에 들어가는 배열의 답도 달라지므로 오류가 남
* 음수와 양수를 따로 계산해야 하는 이유는 음수의 값을 양수대로 for문에 때려넣으면 step이 -x를 인식하지 못하므로 오류가 남
* downTo는 해당 값만큼 -로 계산되므로 바로 x를 그냥 넣으면 down을 하지 못하므로 오류가 남

>너무 자바식대로 풀었다.
오히려 for문은 코틀린과 자바가 다른 관계로 자바보다도 빙빙 돌아 답을 구했다.
코틀린의 장점을 하나도 활용하지 못한 최악의 코딩 결과다.
아래 다른 사람들의 풀이를 보며 조금 창피함을 느낀다.
하지만 for문의 문법 만큼을 제대로 잡아갈 수 있는 소스라고 생각한다.

<br>

## ***Kotlin1 코드 정리***
1. 리턴할 LongArray를 바로 선언 : LongArray(n) => n개까지
2. it은 0부터 시작 -> x.toLong()을 계속 더해나가 LongArray가 n개가 될 때까지 넣는 함수

```kotlin
class Solution {
    fun solution(x: Int, n: Int): LongArray = LongArray(n) { x.toLong() * (it + 1) }
}
```

>코틀린의 장점인 간결한 소스를 제대로 보여준 코드

</br>

## ***Kotlin2 코드 정리***
1. Kotlin1과 같음

```kotlin
class Solution {
    fun solution(x: Int, n: Int): LongArray {
        return Array<Long>(n){i -> (x.toLong() * (i + 1))}.toLongArray() // 람다식 사용
    }
}
```

</br>

## ***Kotlin3 코드 정리***
1. i를 1부터 n까지 증가시키는 for문
2. x를 i와 곱해(x만큼 증가) answer 배열에 add

```kotlin
class Solution {
    fun solution(x: Int, n: Int): LongArray {
        val answer = mutableListOf<Long>()
        for(i in 1 .. n) {
            answer.add(x.toLong() * i)
        }
        return answer.toLongArray()
    }
}
```

> kotlin3이 애초 내가 짜려던 소스.
그리고 자바에서 내가 짰던 소스와 동일.
어쩌다 이리 꼬여버렸을꼬....

</br>

---

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

<br>

## *나의 풀이*
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

<br>

## ***Kotlin1 코드 정리***
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

<br>

## ***Kotlin2 코드 정리***
1. 내장 sum()함수를 사용 -> 입력받은 arr의 총합 구함
2. 그 값을 double로 변환한 후 arr의 크기만큼 나누어줌
```kotlin
class Solution {
	fun solution(arr: IntArray): Double {retrun arr.sum().toDouble()/arr.size}
}
```

</br>

---

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

<br>

## ***나의 풀이***
1. num을 2로 나눴을 때 나머지가 0이면 (짝수) Even을 리턴하고 0이 아니면 (홀수) Odd를 리턴한다.
```kotlin
class Solution {
    fun solution(num: Int): String {
        return if(num % 2 == 0) "Even" else "Odd"
    }
}
```

<br>

## ***Kotlin1 코드 정리***
```kotlin
class Solution {
	fun solution(num: Int): String {
		return if(num.and(1)==0) "Even" else "Odd"
	}
}
```
> .and(1)이 뭔지 검색을 해봐도 안나옴...ㅠㅠ

<br>

## ***Kotlin2 코드 정리***
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

---

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

<br>

## ***나의 풀이***
1. String을 바로 Int로 바꿔주는 내장 함수 사용
```kotlin
Class Solution {
	public int solution(String s) {
		return Integer.parseInt(s);
	}
}
```

<br>

## ***Kotlin1 코드 정리***
```kotlin
class Solution {
    fun solution(s: String) = s.toInt()
}
```
> 내 풀이법과 방법은 같지만, 나는 바로 return을 한 반면 이 소스는 함수를 만들어 리턴함.

<br>

## ***Kotlin2 코드 정리***
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
1. try~catch문을 사용하여 int로 변환이 가능하고, 다시 string으로 바꿨을 때 s와 같으면 숫자로만 구성되어 있음
2. int로 변환이 안되어 오류가 떨어져 catch문을 타게 되면 문자열 길이와 상관 없이 false
3. try에서 문자열을 비교한 후 길이가 4나 6이면 true, 이외 false 값 리턴

```kotlin
class Solution {
    fun solution(s:String):Boolean {
        try {
            if (s.toInt().toString() == s)
            return (s.length == 4 || s.length == 6)
        }
        catch (e:NumberFormatException){
            return false
        }
        return false
    }
}
```

> 진짜 소름돋았던게...
내가 JAVA로 풀었을 때도 try~catch 문을 사용했었는데 코틀린도 똑같이 풀었다...
차이가 있다면 그때는 try~catch문이 처음이었고 이번엔 편하게 사용했다는 점?

<br>

## ***Kotlin1 코드 정리***
1. isDigit()이라는 숫자 판별 내장 함수 사용
2. s의 원소값이 숫자면 length+
3. s의 길이와 숫자만 판별한 length 값을 비교해서 같고, 그 길이가 4나 6이면 true 리턴

```kotlin
class Solution {
	fun solution(s: String): Boolean {
		val length = s.filter{ it.isDigit() }.length
		return (length==4 || length==6) && length==s.length
	}
}
```

>kotlin을 잘 활용하려면 filter가 손에 익어야하는데 왜 이렇게 잘 안써질까...
아직 코틀린 감을 잡는 단계여서 그런가보다.
내가 숫자를 판별하는 걸로 머리를 싸맨 것이 무색할 정도로 간결한 코드이다.

<br>

## ***Kotlin2 코드 정리***
1. s의 길이가 4나 6이 아니면 false 리턴
2. s를 charArray로 변경 후 그 원소 c를 isDigit() 함수를 활용해 숫자 판별
3. 숫자가 아닌 원소가 있으면 false 리턴

```kotlin
class Solution { // 형광펜 두 조건 만족하면 false
	fun solution(s: String): Boolean {
		if(s.length!=4 && s.length!=6) {
			return false
		}
		for (c in s.toCharArray()) {
			if(!c.isDigit()) {
				return false
			}
		}
		return true
	}
}
```