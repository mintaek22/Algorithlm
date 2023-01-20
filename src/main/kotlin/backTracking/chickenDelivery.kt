package backTracking

import com.sun.xml.internal.bind.v2.util.EditDistance
import java.lang.Math.*
import java.util.StringTokenizer

/**
 * 크기가 N*N
 * M개 뺴고 다 폐업
 * 빈칸,치킨집,집
 * 치킨거리 = 집과 가장 가까운 치킨집
 * 도시의 치킨거리  = 모든집의 치킨 거리합
 * 0,1,2 빈칸,집,치킨집
 * https://www.acmicpc.net/problem/15686
 */
private var N = 0
private var M = 0
private var ans = Integer.MAX_VALUE

private lateinit var map: Array<Array<Int>>
private val house = ArrayList<Array<Int>>()
private var chicken = ArrayList<Array<Int>>()
private var index = ArrayList<Int>()
fun main(){

    val br = System.`in`.bufferedReader()
    val line = StringTokenizer(br.readLine())

    N = line.nextToken().toInt()
    M  = line.nextToken().toInt()
    map = Array(N){Array(N) {0} }

    for(i in 0 until N){
        val line1 = StringTokenizer(br.readLine())
        for(j in 0 until N){

            val num = line1.nextToken().toInt()

            if(num == 1){
                house.add(arrayOf(i,j))
            }
            else if(num == 2){
                chicken.add(arrayOf(i,j))
            }
            map[i][j] = num
        }
    }

    //한다 안하다로 나눈다 치킨집이 M 이상 선택되면 종료
   dfs(index,0)
   println(ans)
}

private fun dfs(index:ArrayList<Int>,depth:Int){

    if(index.size == M){
        distanceCal(index)
        return
    }

    if(depth ==chicken.size){
        return
    }

    //추가한다
    index.add(depth)
    dfs(index,depth+1)

    //안한다
    index.remove(depth)
    dfs(index,depth+1)
}

private fun distanceCal(index:ArrayList<Int>){
    var distance = 0
    for(i in house){
        var num = Integer.MAX_VALUE
        for(j in index){
            num = (kotlin.math.abs(chicken[j][0] - i[0]) + kotlin.math.abs(chicken[j][1] - i[1])).coerceAtMost(num)
        }
        distance += num
    }
    ans = ans.coerceAtMost(distance)
}