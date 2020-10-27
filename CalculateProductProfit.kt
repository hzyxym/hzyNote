package com.hzy.viewmodeldemo2

/**
 * Created by hzy on 2020/10/27 14:16
 * @description: 计算商品利润
 */
fun main() {
    calculateProfit(3, 18.0)
    calculateProfit(6, 17.0)
}

fun calculateProfit(productAmount: Int, productPrice: Double, promotePrice: Double = 15.0) {
    println()
    println("---${productAmount}支装---")
    val sales = productAmount * productPrice
    val cost = productAmount * 6 + if (productAmount < 5) 3.5 else 4.0
    val profit = sales - cost
    println("售价：${sales}")
    println("成本：${cost}")
    println("利润：${profit}")
    println("净赚：${profit - promotePrice}")
}