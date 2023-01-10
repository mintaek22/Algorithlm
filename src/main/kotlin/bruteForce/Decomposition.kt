package bruteForce

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/2231
 */
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    var ans:Int
    for(i in 1 .. N){

        ans = i

        var input = i

        while (input != 0) {
            ans += input % 10
            input /= 10
        }

        if(ans == N){
            println(i)
            return
        }
    }
    println(0)

}