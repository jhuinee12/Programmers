package level1

class intervalXcountN {
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