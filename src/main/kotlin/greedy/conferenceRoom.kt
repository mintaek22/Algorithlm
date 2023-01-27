package greedy

import java.util.*
import kotlin.collections.ArrayList

/**
 * N개의 회의 사용표
 * 회의 시작과 끝나는 시간 주어지고 최대한 많은 회의 개수 담기
 * https://www.acmicpc.net/problem/1931
 */

data class Time(
    val start:Int,val end:Int
)
fun main()= with(System.`in`.bufferedReader()){
    val N = readLine().toInt()

    val arr = arrayListOf<Time>()

    for(i in 0 until N){
        val input = readLine().split(" ")
        arr.add(Time(input[0].toInt(),input[1].toInt()))
    }

    arr.sortWith(compareBy({it.end},{it.start}))

    val list = ArrayList<Int>()
    list.add(arr[0].end)
    for(i in 1 until N){
        if(arr[i].start>=list.last()){
            list.add(arr[i].end)
        }
    }

    println(list.size)
}