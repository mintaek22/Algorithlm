package bruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/**
 * M*N체스판
 * 체크 색깔로 이루어 지도록 만든다
 * 8*8로 잘라서 만듬
 * 최소한만 바꾸게
 * https://www.acmicpc.net/problem/1018
 */
private val arr1 = makeCheck1()
private var arr:Array<Array<Char>> = emptyArray()

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val line1 = StringTokenizer(br.readLine())


    val N = line1.nextToken().toInt()
    val M = line1.nextToken().toInt()

    arr = Array(N){Array(M) {' '}}

    for(i in 0 until N){
        val line = br.readLine()
        for(j in 0 until M){
            arr[i][j] = line[j]
        }
    }

    var ans = 2500
    for(i in 0 .. N-8){
        for(j in 0 .. M-8){
            val num = check(i,j)
            if(num<ans){
                ans= num
            }
        }
    }
    println(ans)
}

fun makeCheck1(): Array<Array<Char>> {
    val arr = Array(8){Array(8) {' '} }
    for(i in 0 until 8){
        for(j in 0 until 8){
            if((i+j)%2==0){
                arr[i][j] = 'B'
            }
            else{
                arr[i][j]='W'
            }

        }
    }
    return arr
}

fun check(a: Int,b: Int): Int{
    var sum = 0
    for (i in 0 until 8){
        for(j in 0 until 8){
            if(arr1[i][j] == arr[i+a][j+b]){
                sum++
            }
        }
    }
    if(sum>32){
        return 64-sum
    }
    return sum
}




