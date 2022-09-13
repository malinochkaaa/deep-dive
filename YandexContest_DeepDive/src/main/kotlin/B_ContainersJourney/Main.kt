package B_ContainersJourney

import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    var i = 0
    val mutableList = mutableListOf<Int>()
    while (i < n){
        val string = readLine()!!.split(' ')
        val max = max(string[1].toInt(), max(string[2].toInt(), string[3].toInt()))
        mutableList.add(max)
        i++
    }
    mutableList.sort()
    println(mutableList[if (n.mod(2)==0) n/2 + 1 else n/2])
}