package bruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/**
 * N*M map
 * 각 칸의 정수가 있고
 * 수의 합을 최대로
 * https://www.acmicpc.net/problem/14500
 */

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val line1 = StringTokenizer(br.readLine())
    val N = line1.nextToken().toInt()
    val M = line1.nextToken().toInt()

    val arr = Array(N) {Array(M){0}}
    val visit = Array(N){ Array(M) { false } }
    val check = Array(N){ Array(M) { true } }

    for(i in 0 until N){
        val line = StringTokenizer(br.readLine())
        for(j in 0 until M){
            arr[i][j] = line.nextToken().toInt()
        }
    }

    var ans = 0

    fun bfs(i:Int,j:Int,score:Int,depth:Int){
        val dx = arrayOf(1,-1,0,0)
        val dy = arrayOf(0,0,1,-1)


        if(depth == 4){
            ans= ans.coerceAtLeast(score)
            return
        }

        for(a in 0 until 4){
            val newI = i+dx[a]
            val newJ = j+dy[a]
            if(newI in 0 until N && newJ in 0 until M){
                if(check[newI][newJ] && !visit[newI][newJ]) {
                    check[newI][newJ] = false
                    bfs(newI, newJ, score + arr[i][j], depth + 1)
                    check[newI][newJ]=true
                }
            }
        }

    }

    for(i in 0 until N){
        for(j in 0 until M){
            check[i][j] = false
            bfs(i,j,0,0)
            visit[i][j] = true
            check[i][j] = true
        }
    }
    print(ans)

}