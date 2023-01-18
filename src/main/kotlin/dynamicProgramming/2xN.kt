package dynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 마지막을 서있는거
 * 마지막을 누워있는거
 * https://www.acmicpc.net/problem/11726
 */
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    if(N==1){
        println(1)
        return
    }
    if (N==2){
        println(2)
        return
    }

    val dp = Array(N+1){0}
    dp[1]=1
    dp[2]=2

    for(i in 3 ..N){
        dp[i] = (dp[i-1]+dp[i-2]) % 10007
    }

    println(dp[N])
}