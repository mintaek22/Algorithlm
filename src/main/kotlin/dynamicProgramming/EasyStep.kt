package dynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 끝을 기준으로 붙인다는 느낌
 *https://www.acmicpc.net/problem/10844
 */
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val dp = Array(N+1) {Array(10) {0L} }

    for(i in 1 until 10){
        dp[1][i] = 1L
    }

    for(i in 2 until N+1){
        dp[i][0] = dp[i-1][1]
        dp[i][9] = dp[i-1][8]
        for(j in 1..8){
            dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000
        }
    }

    println(dp[N].sum() % 1000000000)
}