package bruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * 0~9 +,-
 * +1,-1
 * 0에서 -누르면 제자리
 * N으로 이동하고 싶어한다
 * 지금보고있는 채널은 100
 * 고장난 버튼 개수 M
 * https://www.acmicpc.net/problem/1107
 */
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val M = br.readLine().toInt()

    val errorButton = Array(M) {-1}

    if(M!=0){
        val line = StringTokenizer(br.readLine())
        for(i in 0 until M){
            errorButton[i]=line.nextToken().toInt()
        }
    }

    if(M==10){
        println(kotlin.math.abs(100 - N))
        return
    }


    var num = 0

    while(true){
        val numberUp = (N+num).toString()
        val numberDown = (N-num).toString()
        var stat1 = true
        var stat2 = true

        if(numberDown.toInt()>=0) {
            for (i in numberDown) {
                if (errorButton.contains(i.digitToInt())) {
                    stat2 = false
                    break
                }
            }

            if(stat2){
                println(kotlin.math.abs(100 - N).coerceAtMost(num + numberDown.length))
                return
            }
        }

        for(i in numberUp){
            if(errorButton.contains(i.digitToInt())){
                stat1 = false
                break
            }
        }

        if(stat1){
            println(kotlin.math.abs(100 - N).coerceAtMost(num + numberUp.length))
            return
        }
        num++
    }
}