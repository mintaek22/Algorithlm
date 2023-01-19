package dynamicProgramming

import java.lang.Integer.max

/**
 * 공통된 부분수열의 최대 길이
 * https://www.acmicpc.net/problem/9251
 */
fun main(){
    val br = System.`in`.bufferedReader()

    val line1 = br.readLine()
    val line2 = br.readLine()

    val dp = Array(line1.length+1){Array(line2.length+1){0}}

    for(i in 1 .. line1.length){
        for(j in 1 .. line2.length){
            if(line1[i-1] == line2[j-1]){
                dp[i][j]=dp[i-1][j-1]+1
            }
            else{
                dp[i][j] = max(dp[i-1][j],dp[i][j-1])
            }

        }
    }

    println(dp[line1.length][line2.length])

}