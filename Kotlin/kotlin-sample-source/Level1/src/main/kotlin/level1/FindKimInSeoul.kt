package level1

class FindKimInSeoul {
    fun solution1(seoul: Array<String>): String {
        var cnt = 0
        for (s in seoul) {
            if (s == "Kim")
                break
            cnt++
        }
        return "김서방은 ${cnt}에 있다"
    }

    fun solution2(seoul: Array<String>) = "김서방은 ${seoul.indexOf("Kim")}에 있다"
}