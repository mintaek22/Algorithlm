package dynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 마지막을 큰사각형,눕힌 사각형 2개,세운 사각형
 * https://www.acmicpc.net/problem/11727
 */
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val dp = Array(N+1) {0}
    if(N==1){
        println(1)
        return
    }
    else if(N==2){
        println(3)
        return
    }

    dp[1] = 1
    dp[2] = 3

    for(i in 3 until N+1){
        dp[i] = (dp[i-1]+2*dp[i-2]) % 10007
    }
    println(dp[N])
}