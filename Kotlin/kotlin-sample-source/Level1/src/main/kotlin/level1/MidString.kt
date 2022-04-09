package level1

class MidString {
    fun solution(s: String): String {
        var len = s.length / 2

        return if (s.length % 2 == 0)
            s.substring(len-1, len+1)
        else
            s.substring(len, len+1)
    }
}