package backTracking

import java.util.StringTokenizer

/**
 * N개의 정수로 이루어진 수열
 * 부분수열의 합이 S가 되는 경우의수
 * https://www.acmicpc.net/problem/1182
 */
private var N = 0
private var S = 0
private var cnt = 0
private var arr = emptyArray<Int>()
fun main(){
    val br = System.`in`.bufferedReader()
    val line1 = StringTokenizer(br.readLine())
    N = line1.nextToken().toInt()
    S = line1.nextToken().toInt()

    val line = StringTokenizer(br.readLine())
    arr = Array(N){0}
    for(i in 0 until N){
        arr[i] = line.nextToken().toInt()
    }

    dfs(0,0)
    if(S == 0){
        cnt-=1
    }
    println(cnt)
}

private fun dfs(depth:Int,sum:Int){
    if(depth == N){
        if(sum == S) {
            cnt += 1
        }
        return
    }
    //현재 수를 더할지 말지
    dfs(depth+1,sum+arr[depth])
    dfs(depth+1,sum)
}

