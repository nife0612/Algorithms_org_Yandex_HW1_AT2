import java.util.Scanner

fun main() {

    HW2_C_Nearest_number()

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

fun HW1_E_Ambulance(){

}

fun HW1_F_Placement_of_laptops(){
    val scanner = Scanner(System.`in`)

    val list = mutableListOf<Int>()
    val listSquares = mutableListOf<Int>()

    for (i in 0 until 4)
        list.add(scanner.nextInt())

    var sideA : Int = 0
    var sideB : Int = 0
    var minSquare : Int = Int.MAX_VALUE

    for (i in 0 until 2)
        for (j in 2 until 4){
            listSquares.add( (list[i]+list[j]) * max(list[1-i], list[5-j]) )
            if(minSquare > listSquares[listSquares.size - 1]){
                minSquare = listSquares[listSquares.size - 1]
                sideA = (list[i]+list[j])
                sideB = max(list[1-i], list[5-j])
            }
        }

    println("$sideA $sideB")
    //println(min(min(listSquares[0], listSquares[1]), min(listSquares[2], listSquares[3])))

}

fun max(a : Int, b : Int) : Int{
    return if (a > b) a else b
}
fun min(a : Int, b : Int) : Int{
    return if (b > a) a else b
}

fun HW1_G_Details(n : Int, k : Int, m : Int) : Int{
    /*
    val scanner = Scanner(System.`in`)


    var N : Int = scanner.nextInt()
    var K : Int = scanner.nextInt()
    var M : Int = scanner.nextInt()
    */

    var N : Int = n
    var K : Int = k
    var M : Int = m

    var a : Int     // a = N / K
    var b : Int     // b = K / M
    var n1: Int     // n1 = N % K
    var n2: Int     // n2 = K % M

    var ans : Int = 0

    if(K in M..N) {
        while (N / K > 0) {

            a = N / K
            n1 = N % K

            b = K / M
            n2 = a * (K % M)

            N = n1 + n2
            ans += a * b
        }
    }
    //println(ans)
    return ans
}

fun HW1_I_Prisoner_of_the_Chateau_d_If(){
    val scanner = Scanner(System.`in`)

    var flag = false
    val list = mutableListOf<Int>()

    for(i in 0 until 5)
        list.add(scanner.nextInt())

    for(i in 3 until 5){
        if(list[1] <= list[i] && list[2] <= list[7-i]) flag = true
        else if (list[1] <= list[i] && list[0] <= list[7-i]) flag = true
        else if (list[0] <= list[i] && list[2] <= list[7-i]) flag = true
    }

    print(if(flag) "YES" else "NO")
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

fun AT2_Exp_8(){
    val line = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"

    var ans = ""
    var lastsym = line[0]
    var repitions = 0

    for(i in line){
        if(lastsym != i){
            ans += lastsym
            if(repitions > 1){
                ans += repitions
            }
            lastsym = i
            repitions = 0
        }

        ++repitions
    }

    ans += lastsym
    ans += repitions

    println(ans)
}

fun HW2_A_Is_the_list_growing(){
    val scanner = Scanner(System.`in`).nextLine().split(" ")
    val list = mutableListOf<Int>()

    for(element in scanner){
        list.add(element.toInt())
    }

    var flag = true

    for (i in 0 until list.size - 1)
        if(list[i] >= list[i+1])
        {
            flag = false
            break
        }

    if(flag) print("YES")
    else print("NO")
}

fun HW2_B_Determine_the_type_of_sequence(){
    val scanner = Scanner(System.`in`)
    val list = mutableListOf<Int>()

    var tmp : Int
    while(true){
        tmp = scanner.nextInt()
        if(tmp == -2_000_000_000)
            break
        list.add(tmp)
    }

    var isConstant = true
    var isAscending = true
    var isDescending = true
    var isWeakAscending = true
    var isWeakDescending = true
    var isRandom = true

    for (i in 0 until list.size - 1){
        if(list[i] != list[i+1])
            isConstant = false
        if(list[i] >= list[i+1])
            isAscending = false
        if(list[i] <= list[i+1])
            isDescending = false
        if(list[i] > list[i+1])
            isWeakAscending = false
        if(list[i] < list[i+1])
            isWeakDescending = false
    }

    if(isConstant)  println("CONSTANT")
    else if(isAscending)    println("ASCENDING")
    else if(isDescending)   println("DESCENDING")
    else if(isWeakAscending)    println("WEAKLY ASCENDING")
    else if(isWeakDescending)   println("WEAKLY DESCENDING")
    else println("RANDOM")



}

fun HW2_C_Nearest_number(){

}