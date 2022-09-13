package A_SimpleHint

fun main() {
    val n = readLine()!!.toInt()
    var i = 0
    val mutableMap = mutableMapOf<Char, Int>()
    while (i < n){
        var char = readLine()!!.first()
        if (mutableMap.containsKey(char))
            mutableMap[char] = mutableMap[char]!! + 1
        else
            mutableMap[char] = 1
        i++
    }
    val maxKey = mutableMap.values.maxOrNull()
    println(mutableMap.filterValues { it == maxKey}.keys.elementAt(0))
}