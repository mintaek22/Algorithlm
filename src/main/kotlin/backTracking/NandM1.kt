package backTracking

import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/15649
 */
private var N = 0
private var M = 0
private val arr = ArrayList<Int>()
private var sb = StringBuilder()

fun main(){
    val br= System.`in`.bufferedReader()
    val line = StringTokenizer(br.readLine())

    N = line.nextToken().toInt()
    M = line.nextToken().toInt()

    //시작하는수 1~N
    for(i in 1 .. N){
        arr.add(i)
        dfs(1)
        arr.remove(i)
    }

    println(sb)

}

fun dfs(depth:Int){
    if(depth == M){
        arr.forEach{sb.append(it).append(' ')}
        sb.append('\n')
        return
    }
    for(i in 1 .. N){
       if(i in arr) continue
        arr.add(i)
        dfs(depth+1)
        arr.remove(i)
    }
}