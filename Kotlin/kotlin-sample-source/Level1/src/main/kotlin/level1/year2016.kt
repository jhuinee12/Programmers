package level1

import java.text.SimpleDateFormat

class year2016 {
    /**
     * 첫번째 솔루션
     */
    fun solution1(a: Int, b: Int): String {
        val day = when (a) {
            1 -> b-1
            2 -> 31+b-1
            3 -> 31+29+b-1
            4 -> 31+29+31+b-1
            5 -> 31+29+31+30+b-1
            6 -> 31+29+31+30+31+b-1
            7 -> 31+29+31+30+31+30+b-1
            8 -> 31+29+31+30+31+30+31+b-1
            9 -> 31+29+31+30+31+30+31+31+b-1
            10 -> 31+29+31+30+31+30+31+31+30+b-1
            11 -> 31+29+31+30+31+30+31+31+30+31+b-1
            12 -> 31+29+31+30+31+30+31+31+30+31+30+b-1
            else -> b-1
        }

        return when (day%7) {
            0 -> "FRI"
            1 -> "SAT"
            2 -> "SUN"
            3 -> "MON"
            4 -> "TUE"
            5 -> "WED"
            6 -> "THU"
            else -> "FRI"
        }
    }

    /**
     * 두번째 솔루션
     */
    fun solution2(a: Int, b: Int): String {
        val day = (( SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-$a-$b 00:00:00").time
                    - SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-01-01 00:00:00").time
                    ) / (60 * 60 * 24 * 1000)
                  ).toInt()

        return when (day%7) {
            0 -> "FRI"
            1 -> "SAT"
            2 -> "SUN"
            3 -> "MON"
            4 -> "TUE"
            5 -> "WED"
            6 -> "THU"
            else -> "FRI"
        }
    }
}