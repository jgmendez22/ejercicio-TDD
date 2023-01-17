package com.example.tdd

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */


fun main() {
    println("Test 1")
    if (testProduct()) println("Paso") else println("Error Try Again")
    println("SumProduct Test")

    println("Test 2")
    if (testSumProducts()) println("Paso") else println("Error Try Again")
    println("DifferenceOfTen Test")

    println("Test 3")
    if (testdifferenceOfTen()) println("Paso") else println("Error Try Again")
    println("isValidNui Test")

    println("Test 4")
    if (testvalidNui()) println("Paso") else println("Error Try Again")
}



fun product(coefficient:Int, digit:Int):Int{
    val result = coefficient * digit
    return if(result > 9) (result - 9) else result
}

fun testProduct():Boolean{
    val res = product(1,1000)
    val expected = 991
    return (res == expected)
}

fun sumProducts(array:ArrayList<Int>):Int{
    var sum = 0
    for(i in array.indices){
        var residue = i % 2 ==0;
        val coefficient:Int = if(residue) {
            2
        } else 1;
        var result = product(coefficient, array[i])
        sum += result

    }
    return sum
}


fun testSumProducts():Boolean{
    val res = sumProducts(arrayListOf(0,1,2,3))
    val expected = 8
    return (res == expected)
}




fun differenceOfTen(number:Int):Int{
    val residue:Int = number % 10;
    val result:Boolean = residue ==0
    return if(result) 0 else residue
}



fun testdifferenceOfTen():Boolean{
    val res = differenceOfTen(41)
    val expected = 1
    return (res == expected)
}




fun isValidNuiNumber(nui:String): Boolean {
    val convertToInt = nui.map { it.toString().toInt() }
    var separateNineElements: ArrayList<Int> = arrayListOf()
    for (i in convertToInt){
        separateNineElements.add(i)
    }
    separateNineElements.removeAt(9)
    val tenElement = convertToInt[9]
    val result = sumProducts(separateNineElements)
    val res = differenceOfTen(result)
    return (tenElement == res)

}
fun testvalidNui():Boolean{
    val res = isValidNuiNumber("0106605207")
    val expected = true
    return (res == expected)
}