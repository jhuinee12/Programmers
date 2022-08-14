package level1

class SortStringMine {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        val map1 = mutableMapOf<Int, String>()  // n 기준 앞자리 문자열
        val map2 = mutableMapOf<Int, String>()  // n 기준 뒷자리 문자열

        val stringsArray = strings.sorted()
        for (i in strings.indices) {
            map1[i] = stringsArray[i].substring(0, n)
            map2[i] = stringsArray[i].substring(n, strings[i].length)
        }

        val sortArray = map2.values.sorted()

        for (i in strings.indices) {
            for (j in strings.indices) {
                if (sortArray[i] == map2[j]) {
                    strings[i] = map1[j] + map2[j]
                    println(strings[i])
                }
            }
        }

        return strings
    }
}