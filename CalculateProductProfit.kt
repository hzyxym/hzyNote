package com.hzy.viewmodeldemo2

/**
 * Created by hzy on 2020/10/27 14:16
 * @description: 计算商品利润
 */
fun main() {
    val discount = 9.5
//    val coupon = 7
    println("全场: ${discount}折")
    val discountDesc = if (discount < 10) "(${discount}折)" else "(无折扣)"
    val stringBuffer = StringBuffer()
    stringBuffer.append("利润汇总$discountDesc：")
    calculateProfit(1, 27.6, 5, discount, stringBuffer = stringBuffer)
    calculateProfit(2, 49.6, 7, discount, stringBuffer = stringBuffer)
    calculateProfit(3, 69.6, 9, discount, stringBuffer = stringBuffer)
    calculateProfit(5, 102.6, 9, discount, stringBuffer = stringBuffer)
    calculateProfit(6, 115.6, 15, discount, stringBuffer = stringBuffer)
    println()
    println(stringBuffer.toString())
}

fun calculateProfit(
    productAmount: Int,
    sales: Double,
    coupon: Int = 0,
    discount: Double = 10.0,
    promotePrice: Int = 15,
    stringBuffer: StringBuffer? = null
) {
    println()
    println("---${productAmount}支装---")
    val productPrice = (sales * (discount / 10) - coupon) / productAmount
    val cost = productAmount * 6 + if (productAmount < 5) 3.5 else 4.0
    val profit = sales * (discount / 10) - coupon - cost
    println("原价：${getTwoDigits(sales)}(优惠券${coupon}元)")
    println("售价：${getTwoDigits(sales * (discount / 10))}")
    println("单价：${getTwoDigits(productPrice)}")
    println("成本：${getTwoDigits(cost)} + $promotePrice = ${getTwoDigits(cost + promotePrice)}")
    println("利润：${getTwoDigits(profit - promotePrice)}")
    val couponDesc = if (coupon > 0) "(${coupon}元券)" else ""
    stringBuffer?.append("${productAmount}支$couponDesc：${getTwoDigits(profit - promotePrice)}    ") //${discount}折-${coupon}券：
}

fun getTwoDigits(number: Double): String {
    val format = DecimalFormat("0.##")
    //未保留小数的舍弃规则，RoundingMode.FLOOR表示直接舍弃。
    format.roundingMode = RoundingMode.FLOOR
    return format.format(number)
}
