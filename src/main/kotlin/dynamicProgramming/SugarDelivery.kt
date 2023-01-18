package dynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * N만큼 배달
 * 3,5 봉지
 * 최대한 적은 봉지 사용
 * 정확히 만들 수 없다면 -1출력
 * 봉지 개수 출력
 * https://www.acmicpc.net/problem/2839
 */
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val dp = Array(N+1){0}
    if(N<3 || N==4){
        println(-1)
        return
    }
    if(N ==3 || N==5){
        println(1)
        return
    }
    dp[0] = -1
    dp[1] = -1
    dp[2] = -1
    dp[3] = 1
    dp[4] = -1
    dp[5] = 1

    for (i in 6..N) {
        if(dp[i-5] == -1 && dp[i-3] == -1){
            dp[i] = -1
        }
        else if(dp[i-5] == -1){
            dp[i] = dp[i-3]+1
        }
        else if(dp[i-3] == -1){
            dp[i] = dp[i-5]+1
        }
        else{
            dp[i] = (dp[i - 5] + 1).coerceAtMost(dp[i - 3] + 1)
        }
    }
    println(dp[N])
}