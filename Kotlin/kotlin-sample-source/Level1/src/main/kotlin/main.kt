import level1.*

fun main(args: Array<String>) {
/*    // 최대공약수와 최소공배수
    println(level1.GreatestLeast().solution(3,12))
    println(level1.GreatestLeast().solution(2,5))*/
/*    // 가운데 글자 가져오기
    println(level1.MidString().solution("adced"))
    println(level1.MidString().solution("qwer"))*/
/*    // 행렬의 덧셈
    val arr1 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
    var arr2 = arrayOf(intArrayOf(3,4), intArrayOf(5,6))
    println(level1.AdditionOfMatrices().solution(arr1, arr2))*/
/*    // 핸드폰 번호 가리기
    println(PhoneNumber().solution("00000012145165148"))*/
/*    // 자연수 뒤집어 배열로 만들기
    println(NumbersToReverseArray().solution(12345))*/
/*    // 이상한 문자 만들기
    println(CreateWeirdCharacters().solution("HappY new yEAr"))*/
/*    // 정수 제곱근 판별
    println(IntegerSquareRoot().solution(1))*/
/*    // 문자열 내림차순으로 배치하기
    println(StringDescending().solution("Zbcdefg"))*/
/*    // 시저 암호
    println(CaesarCipher().solution("kj",25))
    println('a'.toInt())
    println('z'.toInt())
    println('A'.toInt())
    println('Z'.toInt())*/
/*    // 콜라츠 추측
    println(ColatzQuess().solution(626331))*/
/*    // 하샤드 수
    println(Hasshadsu().solution(10))*/
/*    // 문자열 내 마음대로 정렬하기
    val arr1: Array<String> = arrayOf("sun", "bed", "car")
    val arr2: Array<String> = arrayOf("abce", "abcd", "cdx")
    val arr3: Array<String> = arrayOf("jhee", "haneol", "soonyeo", "jaemyeong")
    println(SortStringMine().solution(arr1, 1).joinToString())
    println(SortStringMine().solution(arr2, 2).joinToString())
    println(SortStringMine().solution(arr3, 0).joinToString())*/
/*    // 두개 뽑아서 더하기
    val arr1: IntArray = intArrayOf(2,1,3,4,1)
    println(TwoPickPlus().solution(arr1).joinToString())*/
/*    // 2016년
    println(year2016().solution1(5,24))
    println(year2016().solution2(5,24))*/
    // 체육복
    println(GymSuit().solution(5,intArrayOf(4,2), intArrayOf(1,3,5)))
    println(GymSuit().solution(5,intArrayOf(2,4), intArrayOf(3)))
    println(GymSuit().solution(3,intArrayOf(3), intArrayOf(1)))
    println(GymSuit().solution(5,intArrayOf(3,5), intArrayOf(2,4)))
    println(GymSuit().solution(5,intArrayOf(3,4), intArrayOf(3,5)))
    println(GymSuit().solution(3,intArrayOf(1,2), intArrayOf(2,3)))
}