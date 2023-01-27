package greedy

import java.util.*

/**
 * 정렬된 두 묶음의 숫자 A,B
 * 합치려면 A+B
 * 작은 수 끼리 먼저 합해야 한다
 * https://www.acmicpc.net/problem/1715
 */
fun main()= with(System.`in`.bufferedReader()){
    val N = readLine().toInt()

    val arr = PriorityQueue<Int>()
    for(i in 0 until N){
        arr.add(readLine().toInt())
    }
    if(N==1){
        println(0)
        return@with
    }

    var ans = 0

    while (arr.size>1){
        val num = arr.poll()+arr.poll()
        ans+= num
        arr.add(num)
    }

    println(ans)

}