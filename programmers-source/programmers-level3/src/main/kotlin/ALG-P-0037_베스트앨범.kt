package src.main.kotlin

class `ALG-P-0037_베스트앨범` {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val answer = arrayListOf<Int>()
        val songs: MutableMap<String, Pair<Int, Array<Pair<Int, Int>>>> = mutableMapOf()

        for (i in genres.indices) {
            val key = genres[i]
            val value = plays[i]

            if (songs.containsKey(key)) {
                val sum = songs[key]!!.first

                val firstMax = songs[key]!!.second[0]
                val secondMax = songs[key]!!.second[1]

                if (value > firstMax.second) {
                    songs[key] = Pair(sum+value, arrayOf(Pair(i, value), firstMax))
                } else if (value > secondMax.second) {
                    songs[key] = Pair(sum+value, arrayOf(firstMax, Pair(i, value)))
                } else {
                    songs[key] = Pair(sum+value, arrayOf(firstMax, secondMax))
                }
            } else {
                songs[key] = Pair(value, arrayOf(Pair(i, value), Pair(0,0)))
            }
        }

        val array: Array<Pair<Int, Array<Pair<Int, Int>>>> =
            songs.keys.map {
                Pair(songs[it]!!.first, songs[it]!!.second) }
                .sortedByDescending { value -> value.first }
                .toTypedArray()

        array.forEach {
            if (it.second[1].second == 0) {
                answer.add(it.second[0].first)
            } else {
                answer.add(it.second[0].first)
                answer.add(it.second[1].first)
            }
        }

        return answer.toIntArray()
    }

    fun solution1(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] }
            .toList()
            .sortedByDescending { it.second.sumBy { plays[it] } }
            .map { it.second.sortedByDescending { plays[it] }.take(2) }
            .flatten()
            .toIntArray()
    }
}

private fun main() {
    println(`ALG-P-0037_베스트앨범`().solution1(
        arrayOf("classic", "pop", "classic", "classic", "pop"),
        intArrayOf(500, 600, 150, 800, 2500)
    )) // [4, 1, 3, 0]

    println(`ALG-P-0037_베스트앨범`().solution1(
        arrayOf("classic", "pop", "classic", "classic"),
        intArrayOf(800, 600, 150, 800)
    )) // [0, 3, 1]

    println(`ALG-P-0037_베스트앨범`().solution1(
        arrayOf("pop", "pop", "pop", "rap", "rap"),
        intArrayOf(45, 50, 40, 60, 70)
    )) // [1, 0, 4, 3]
}