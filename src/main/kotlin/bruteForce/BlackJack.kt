package bruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * N장의 카드
 * N장의 카드중 3개를 골라 M을 넘지 않으며 최대한 M에 가깝게
 * https://www.acmicpc.net/problem/2798
 *
 */
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val line = StringTokenizer(br.readLine())
    val N = line.nextToken().toInt()
    val M = line.nextToken().toInt()

    val arr = Array(N) {0}
    val line2 = StringTokenizer(br.readLine())

    for(i in 0 until N){
        arr[i]=line2.nextToken().toInt()
    }
    var max = 0

    for(i in 0 until N-2){
        for(j in i+1 until N-1){
            for(k in j+1 until N){
                val num = arr[i]+arr[j]+arr[k]
                if(num in (max + 1).. M){
                    max = num
                }
            }
        }
    }

    print(max)
}
