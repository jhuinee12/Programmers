package level1

/**
 * 소수 만들기
 */
class CreatePrimeNumver {
    fun solution(nums: IntArray): Int {
        var count = 0

        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                for (k in j+1 until nums.size) {
                    val sum = nums[i] + nums[j] + nums[k]
                    var zeroCount = 0
                    for (s in 2 until sum) {
                        if (sum % s == 0) {
                            zeroCount++
                            break
                        }
                    }
                    if (zeroCount == 0) {
                        count++
                    }
                }
            }
        }

        return count
    }
}

class CreatePrimeNumverSolution1 {
    fun isPrime(n: Int): Boolean {
        if(n<2)return false
        else if(n<6){
            if(n==4)
                return false
            else return true}
        for (i in 2..Math.sqrt(n.toDouble()).toInt()){
            if(n%i==0)return false
        }
        return true
    }
    fun solution(nums: IntArray): Int {
        var answer = 0
        for (i in 0..nums.size-3){
            for(j in i+1..nums.size-2){
                for(k in j+1..nums.size-1){
                    if(isPrime(nums[i]+nums[j]+nums[k]))answer++
                }
            }
        }

        return answer
    }
}