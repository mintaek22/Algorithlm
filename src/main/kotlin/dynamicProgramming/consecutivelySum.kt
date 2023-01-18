package dynamicProgramming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 *n개의 정수중 이중 연속된 일부분을 합하여 가장 큰수 만들기
 * acmicpc.net/problem/1912
 */
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val arr = Array(N){0}
    val dp = Array(N){0}

    val line1 = StringTokenizer(br.readLine())

    for(i in 0 until N){
        val num = line1.nextToken().toInt()
        arr[i] = num
    }

    dp[0] = arr[0]

    var max = dp[0]
    for(i in 1 until N){
        dp[i] = (dp[i - 1] + arr[i]).coerceAtLeast(arr[i])
        max = dp[i].coerceAtLeast(max)
    }
    println(max)
}