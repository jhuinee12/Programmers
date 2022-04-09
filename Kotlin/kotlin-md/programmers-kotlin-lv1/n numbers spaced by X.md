> 최초작성 : 2021.04.27

## **Level1 - X만큼 간격이 있는 n개의 숫자 (kotlin)**

 [코딩테스트 연습 - x만큼 간격이 있는 n개의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12954)

| **문제 설명** |
| --- |
| 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지나는 리스트를 리턴해야 합니다.   다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성하세요. |

| **제한 조건** |
| --- |
|   -   x는 -10000000 이상, 10000000 이하인 정수입니다. -   n은 1000 이하인 자연수입니다.   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| x | n | answer |
| 2 | 5 | \[2,4,6,8,10\] |
| 4 | 3 | \[4,8,12\] |
| \-4 | 2 | \[-4,-8\] |

---

### _**나의 풀이**_

1\. x가 음수일 경우, 양수일 경우, 0일 경우로 나눠서 계산

2\. x가 양수일 경우, answer에는 x부터 x\*n까지 x만큼 증가하는 값을 add

3\. x가 0일 경우, answer에는 0을 n개만큼 add

4\. x가 음수일 경우, answer에는 x부터 x\*n까지 -x_(x는 음수이니 -)_만큼 감소하는 값을 add

```kt
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

<center>

| 너무 자바식대로 풀었다.<br>오히려 for문은 코틀린과 자바가 다른 관계로 자바보다도 빙빙 돌아 답을 구했다.<br>코틀린의 장점을 하나도 활용하지 못한 최악의 코딩 결과다.<br>아래 다른 사람들의 풀이를 보며 조금 창피함을 느낀다.<br>하지만 for문의 문법 만큼을 제대로 잡아갈 수 있는 소스라고 생각한다. |
| :---: |

</center>

### _**Kotlin1 코드 정리**_

1\. 리턴할 LongArray를 바로 선언 : LongArray(n) => n개까지

2\. it은 0부터 시작 -> x.toLong()을 계속 더해나가 LongArray가 n개가 될 때까지 넣는 함수

```kt
class Solution {
    fun solution(x: Int, n: Int): LongArray = LongArray(n) { x.toLong() * (it + 1) }
}
```

<center>

| 코틀린의 장점인 간결한 소스를 제대로 보여준 코드 |
| :---: |

</center>

### _**Kotlin2 코드 정리**_

1\. Kotlin1과 같음

```kt
class Solution {
    fun solution(x: Int, n: Int): LongArray {
        return Array<Long>(n){i -> (x.toLong() * (i + 1))}.toLongArray() // 람다식 사용
    }
}
```

### _**Kotlin3 코드 정리**_

1\. i를 1부터 n까지 증가시키는 for문

2\. x를 i와 곱해(x만큼 증가) answer 배열에 add

```kt
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

<center>

| kotlin3이 애초 내가 짜려던 소스.<br>그리고 자바에서 내가 짰던 소스와 동일.   어쩌다 이리 꼬여버렸을꼬.... |
| :---: |

</center>