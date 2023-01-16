package bruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

/**
 * N*M map
 * 각 칸의 정수가 있고
 * 수의 합을 최대로
 * https://www.acmicpc.net/problem/14500
 */

private var ans = 0
private var N = 0
private var M = 0

private var check:Array<Array<Boolean>> = emptyArray()
private var arr:Array<Array<Int>> = emptyArray()
val dx = arrayOf(1,-1,0,0)
val dy = arrayOf(0,0,1,-1)

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val line1 = StringTokenizer(br.readLine())
    N = line1.nextToken().toInt()
    M = line1.nextToken().toInt()

    arr = Array(N) {Array(M){0}}
    check =Array(N){ Array(M) { true } }

    for(i in 0 until N){
        val line = StringTokenizer(br.readLine())
        for(j in 0 until M){
            arr[i][j] = line.nextToken().toInt()
        }
    }

    for(i in 0 until N){
        for(j in 0 until M){
            check[i][j] = false
            dfs(i,j,0,0)
            oh(i,j)
            check[i][j] = true
        }
    }
    print(ans)

}

fun dfs(i:Int,j:Int,score:Int,depth:Int){

    if(depth == 4){
        ans= max(score,ans)
        return
    }

    for(a in 0 until 4){
        val newI = i+dx[a]
        val newJ = j+dy[a]
        if(newI in 0 until N && newJ in 0 until M){
            if(check[newI][newJ]) {
                check[newI][newJ] = false
                dfs(newI, newJ, score + arr[i][j], depth + 1)
                check[newI][newJ]=true
            }
        }
    }
}

fun oh(i:Int,j:Int){

    var num = Integer.MAX_VALUE
    var score = arr[i][j]
    var cnt = 0

    for(a in 0 until 4){
        val newI = i+dx[a]
        val newJ = j+dy[a]
        if(newI in 0 until N && newJ in 0 until M){
           cnt++
            num = min(num,arr[newI][newJ])
            score += arr[newI][newJ]
        }
    }
    if(cnt==4){
        score -= num
    }

    ans= max(score,ans)
}