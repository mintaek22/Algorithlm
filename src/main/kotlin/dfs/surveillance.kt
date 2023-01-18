package dfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


/**
 * cctv의 종류는 5개
 * cctv 회전가능
 * 0=빈칸 6=벽 1~5 cctv
 * cctv 벽 통과 불가,cctv를 통과할 순 있다
 * 사각지대 최소 출력
 * https://www.acmicpc.net/problem/15683
 */

/**
 * 오른쪽 기준 시계방향으로 0,1,2,3 방향
 */
private var map:Array<Array<Int>> = emptyArray()
private var camera = ArrayList<Array<Int>>()
private var N = 0
private var M = 0

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val line1 = StringTokenizer(br.readLine())

    //세로/가로
    N = line1.nextToken().toInt()
    M = line1.nextToken().toInt()

    map = Array(N){Array(M) {0}}

    for(i in 0 until N){
        val line = StringTokenizer(br.readLine())
       for(j in 0 until M){
           val num = line.nextToken().toInt()
           map[i][j] = num
           if(num in 1 .. 5){
               camera.add(arrayOf(i,j))
           }
       }
    }
   dfs(0)
}


fun dfs(depth:Int){
    if(depth == camera.size){
        return
    }

    val i = camera[depth][0]
    val j = camera[depth][1]


    if(map[i][j] == 1){
        for(i in 0 until 4){
            dfs(depth+1)
        }
    }
    else if(map[i][j] == 2){
        for(i in 0 until 4 step 2){
            dfs(depth+1)
        }
    }
    else if(map[i][j] == 3){
        for(i in 0 until 4){
            dfs(depth+1)
        }

    }
    else if(map[i][j] == 4){
        for(i in 0 until 4){
            dfs(depth+1)
        }
    }
    else{

    }
}

