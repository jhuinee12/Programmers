> 최초작성 : 2021.01.16

## ******Level1 - 2016년**** (java)**

 [코딩테스트 연습 - 2016년](https://programmers.co.kr/learn/courses/30/lessons/12901)

| **문제 설명** |
| --- |
| 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?<br>두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.<br>요일의 이름은 일요일부터 토요일까지 각각 **_SUN,MON,TUE,WED,THU,FRI,SAT_** 입니다.<br>예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요. |

| **제한 조건** |
| --- |
|   -   2016년은 윤년입니다. -   2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)   |

| **​입출력 예**    |  |  |
| --- | --- | --- |
| a | b | result |
| 5 | 24 | "TUE" |

​

### _**나의 풀이**_

1.  캘린더를 이용하여 풀었다. (기존 안드로이드 스튜디오에서 사용했던 기법)

2\. 캘린더에 해당 날짜를 입력하고 나온 결과값을 토대로 출력하면 된다.

3\. 1:일요일, 2:월요일, 3:화요일, 4:수요일, 5:목요일, 6:금요일, 7:토요일

```java
import java.util.Calendar;

class Solution {
  public String solution(int a, int b) {
      String answer = "";
        
        Calendar cal = Calendar.getInstance();
        cal.set(2016,a-1,b);

        int dayNum = cal.get(Calendar.DAY_OF_WEEK);

        switch (dayNum) {
                
        case 1:
            answer = "SUN";
            break;
        	
        case 2:
        	answer = "MON";
        	break;
        	
        case 3:
        	answer = "TUE";
        	break;
        	
        case 4:
        	answer = "WED";
        	break;
        	
        case 5:
        	answer = "THU";
        	break;
        	
        case 6:
        	answer = "FRI";
        	break;
        	
        case 7:
        	answer = "SAT";
        	break;
        }
        
        return answer;
  }
}
```

* Calendar.MONTH 값은 0~11로 존재, 따라서 원하는 월의 -1로 출력해야 결과값이 바르게 나옴
* Calendar.DAY\_OF\_WEEK : 요일을 1~7의 숫자로 출력

### _**JAVA1 코드 정리**_

1\. 나와 같이 Calendar를 이용하였지만, 나는 나온 결과값(숫자)를 이용해 출력한 반면 함수를 써 아예 값을 뽑아냄

```java
class TryHelloWorld
{
    public String getDayName(int month, int day)
    {
        Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
                        .setDate(2016, month - 1, day).build();
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
    }
    public static void main(String[] args)
    {
        TryHelloWorld test = new TryHelloWorld();
        int a=5, b=24;
        System.out.println(test.getDayName(a,b));
    }
}
```

~_\* getDisplayName : 정확한 정의가 검색으로 나오지 않음. 아무래도 숫자로 나온 요일을 변환해주는게 아닐까 싶음_~

\* getDisplayName() : 지정된 스타일 및 로컬에서 매개 변수로 전달 된 달력 필드 값의 문자열 표현을 리턴

   ㄴ public  String getDisplayName ( int  field,  int  style, Locale locale)  

         **- 필드**  달력 필드가 달처럼 전달, DAY\_OF\_WEEK 등

         **- style** 매개 변수로 전달 된 필드의 문자열 표현에 적용 할 스타일

         **- locale** 문자열 표현의 로케일

### _**JAVA2 코드 정리**_

1\. day\[\] 배열에 1월 1일의 시작인 '금요일'부터 '목요일'까지 리턴받을 요일을 넣는다.

2\. date\[\] 배열에 각 월별 일자를 넣는다. (1월은 31일이 존재)

3\. date를 토대로 1월 1일부터 오늘이 '며칠째'인지를 계산(for문)한다.

* ex. 오늘이 5월 24일이면 오늘은 31+29+31+30 (1월부터 4월) + 24 (현재일자) 만큼이  지났으며, -1을 해줘야 5월 24일로 정상 출력된다.

4\. 오늘이 며칠째인지 계산이 완료되었으면 day 배열을 통해 오늘 요일을 계산한다. (배열을 7로 나눈 나머지)

```java
class TryHelloWorld
{
    public String getDayName(int a, int b) {
        String answer = "";
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int allDate = 0;
        for (int i = 0; i < a - 1; i++) {
            allDate += date[i];
        }
        allDate += (b - 1);
        answer = day[allDate % 7];

        return answer;
    }
    public static void main(String[] args)
    {
        TryHelloWorld test = new TryHelloWorld();
        int a=5, b=24;
        System.out.println(test.getDayName(a,b));
    }
}
```

\* allDate += (b - 1) : -1을 하지 않으면 1월 1일도 하루가 지났다고 계산이 되어 '토요일'이 출력됨

### _**Kotlin 코드 정리**_

```java
class Solution {
    fun solution(a: Int, b: Int): String {
        val days = listOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")
        val lastDays = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        val result = (0 until a - 1).map {
            lastDays[it]
        }.sum() + b


        return days[result % 7]
    }
}
```

| 한가지 뿌듯한 점은 나와 코드가 비슷한 사람이 없는 것 같다.<br>코드를 잘 짰고 못 짰고를 떠나서 일단 나만의 생각으로 새로운 풀이를 했다는 점이 상당히 만족스럽다.<br>이 문제는 자세히 보면 그렇게 다양한 코드가 나올만한 문제는 아니지만,<br>큰 틀은 같은데 그 안에 세세한 부분이 사람들마다 조금씩 다르다는 점에 상당히 흥미를 느낀다. |
| --- |