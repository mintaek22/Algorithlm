package dynamicProgramming

import java.util.*

/**
 * N개의 물건 W무게 V가치
 *최대 K만큼
 * 가치의 최댓값
 * https://www.acmicpc.net/problem/12865
 */
fun main(){
    val br = System.`in`.bufferedReader()
    val line1 = StringTokenizer(br.readLine())

    val N = line1.nextToken().toInt()
    val K = line1.nextToken().toInt()


    //무게 value
    val item = Array(N+1) { Array(2){0} }
    for(i in 1 until N+1){
        val line = StringTokenizer(br.readLine())
        item[i][0] = line.nextToken().toInt()
        item[i][1] = line.nextToken().toInt()
    }

    //N은 가방 index,K가 무게
   val dp = Array(N+1){Array(K+1){0}}
    for(i in 1 until  N+1){
        for(w in 1 until K+1){
            //현재 물건을 넣을 수 있다.
            if(item[i][0]<=w){
                dp[i][w] = kotlin.math.max(dp[i-1][w],dp[i-1][w-item[i][0]]+item[i][1])
            }
            //현재 물건을 넣을 수 없다
            else{
                dp[i][w] = dp[i-1][w]
            }
        }
    }
    println(dp.contentDeepToString())
    println(dp[N][K])
}