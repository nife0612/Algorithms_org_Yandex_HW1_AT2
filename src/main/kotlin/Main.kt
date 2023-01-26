import java.util.Scanner

fun main(args: Array<String>) {

    AT2_Exp_6()
}

// Legend:
//
// HW1 - HomeWork number 1
// A_air_conditioning - name of exercise
//
// AT2 - Algorithm train number 2 or Lecture number 2
// Exp_1 - example number 1

// https://contest.yandex.ru/contest/27393/problems/

fun HW1_A_air_conditioning(){
    val scanner = Scanner(System.`in`)

    val troom = scanner.nextInt()
    val tcond = scanner.nextInt()
    val mode = scanner.next()

    //println("$troom $tcond \n$mode")

    val ans = when(mode){
        "fan" -> troom
        "auto" -> tcond
        "heat" -> if (troom > tcond) troom else tcond
        "freeze" -> if (troom < tcond) troom else tcond
        else -> {"NON"}
    }

    println(ans)
}

fun HW1_B_triangle() {
    val scanner = Scanner(System.`in`)

    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()

    if (a < b + c && b < a + c && c < a + b)
        print("YES")
    else
        print("NO")
}

fun HW1_C_phone_numbers(){
    val scanner = Scanner(System.`in`)

    val dirtNumbers: MutableList<String> = mutableListOf()
    val clerNumbers: MutableList<String> = mutableListOf()

    var numStr : String = ""

    for(i in 0..3)
        dirtNumbers.add(scanner.next())

    for (i in 0..3) {

        for (j in dirtNumbers[i].length - 1 downTo 0) {
            if (dirtNumbers[i][j] == '-') continue
            else if (dirtNumbers[i][j] == '(') continue
            else if (dirtNumbers[i][j] == ')') continue

            numStr += dirtNumbers[i][j]
        }
        when (numStr.length) {
            12 -> numStr = numStr.dropLast(2)
            11 -> numStr = numStr.dropLast(1)
            7 -> numStr += "594"
        }

        clerNumbers.add(numStr)
        numStr = ""
    }

    for(i in 1..3){
       if(clerNumbers[0] == clerNumbers[i]) println("YES")
       else println("NO")
    }


}

fun HW1_D_equation_with_root() {

    val scanner = Scanner(System.`in`)

    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()

    var x1: Int
    var x2: Int

    if (c >= 0) {
        if (a == b && b == c && c == 0) println("MANY SOLUTION")
        else if (a == 0 && b == c * c) print("MANY SOLUTION")
        else if (a == 0) println("NO SOLUTION")
        else {
            x1 = (c * c - b) / a
            x2 = (b - c * c) / a

            if (x1 >= -b / a && x2 >= -b / a)  {
                if (x1 > x2) {
                    println(x1)
                    println(x2)
                }
                else if (x1 == x2 && x1 == 0) {
                    println(x1)
                }
                else {
                    println(x2)
                    println(x1)
                }
            }
            else if (x1 >= -b / a) println(x1)
            else if (x2 >= -b / a) println(x2)
            else println("NO SOLUTION")
        }
    }
    else println("NO SOLUTION")

// | ax - b | = cc      c >= 0 and               ax + b >= 0   =>   x >= - b/a
// ax - b == cc     or      b - ax == cc
// x == (cc - b)/a  or      x == (b - cc)/a     a != 0

// c > 0 and a!=0 and a=b=c=0 -> inf and x >= - b/a
}


// https://yandex.ru/yaintern/algorithm-training_1
fun AT2_Exp_1(){
    val N = readln().toInt()
    val x = readln().toInt()

    val list = mutableListOf<Int>()

    for (i in 0 until N)    list.add(readln().toInt())

    for (i in 0 until list.size) if (x == list[i]) { println(i); return }

    println(-1)
}

fun AT2_Exp_2(){
    val N = readln().toInt()
    val x = readln().toInt()
    val list = mutableListOf<Int>()

    for(i in 0..N-1)
        list.add(readln().toInt())

    var ans = -1

    for (i in list.size - 1 downTo 0) if(ans == -1 && x == list[i]) {ans = i}

    println(ans)
}

fun AT2_Exp_3(){
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    for (i in 0 until n)
        list.add(readln().toInt())

    var tmp = list[0]

    for (i in list)
        if (tmp < i)
            tmp = i

    println(tmp)
}

fun AT2_Exp_4(){
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    for(i in 0 until n)
        list.add(readln().toInt())

    var firstMax : Int
    var secondMax : Int

    if (list[0] > list[1]){
        firstMax = list[0]
        secondMax = list[1]
    }
    else{
        firstMax = list[0]
        secondMax = list[1]
    }

    for(i in (2 until list.size)){
        if(list[i] > firstMax) {
            secondMax = firstMax
            firstMax = list[i]
        }
        else if(list[i] > secondMax){
            secondMax = list[i]
        }
    }

    println("$firstMax and $secondMax")
}

fun AT2_Exp_5(){
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    for(i in 0 until n)
        list.add(readln().toInt())

    var minDi = -1

    for(i in list){
        if(i%2 == 0){
            if(minDi == -1 || i < minDi) minDi = i
        }
    }

    println(minDi)
}

fun AT2_Exp_6(){
    val list = mutableListOf<String>()
    for (i in 0 until 10){
        list.add(readln())
    }

    var minLen = list[0].length
    for (i in list){
        if(i.length < minLen) minLen = i.length
    }
    for (i in list){
        if (i.length == minLen)
            print("$i ")
    }

}