package C_AllRoadsLeadToRome

fun main(){
    val italia = readLine()!!.split(" ")
    var i = 0
    var roadList = mutableListOf<Pair<Int, Int>>()
    while (i < italia[1].toInt()){
        var string = readLine()!!.split(" ")
        roadList.add(Pair(string[0].toInt() - 1, string[1].toInt() - 1))
        i++
    }
    var visitCountMap = mutableMapOf<Int, Int>()
    for (i in 0 until italia[0].toInt()) {
        var visitedList = mutableListOf<Boolean>()
        for(j in 1..italia[0].toInt())
            visitedList.add(false)
        DFS(i, visitedList, roadList, visitCountMap)
    }
    val filter = visitCountMap.filter { it.value == italia[0].toInt()}
    for (i in filter.keys.indices){
        if(roadList.filter { it -> it.first == filter.keys.elementAt(i) }.isEmpty()){
            println(filter.keys.elementAt(i) + 1)
            return
        }
    }
   println("-1")
}

fun DFS(i: Int, visited: MutableList<Boolean>, roads: MutableList<Pair<Int, Int>>, visitCount: MutableMap<Int, Int>){
    visited[i] = true
    if (visitCount.containsKey(i))
        visitCount[i] = visitCount[i]!! + 1
    else
        visitCount[i] = 1
    val filter = roads.filter { it -> it.first == i }
    for (j in filter.indices){
        if(!visited[filter[j].second]){
            DFS(filter[j].second, visited, roads, visitCount)
        }
    }
}