package dfs

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/10974
 */
private var visit:Array<Boolean> = emptyArray()
private var N:Int = 0

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    visit = Array(N +1) {false}

    for(i in 1 .. N){
        visit[i] = true
        dfs(1,"$i")
        visit[i] = false
    }
}

fun dfs(depth:Int,ans:String){

    if(depth == N){
        println(ans)
        return
    }

    for(i in 1 ..N){
        if(!visit[i]){
            visit[i] = true
            dfs(depth+1, "$ans $i")
            visit[i] = false
        }
    }
}