package com.nepplus.jickbankcopy_20220505.models

import java.io.Serializable
import java.text.DecimalFormat

class RoomData (
    val price : Int,
    val address : String,
    val level : Int,
    val description : String,
        ) : Serializable {
    fun getFormattedPrice() : String {
        val formatter = DecimalFormat("#,###")

        val resultPrice = if (this.price < 10000) {
            formatter.format(this.price)
        } else {
            val over = this.price / 10000
            val remain = this.price % 10000
            "${over}억${formatter.format(remain)}"
            "${over} + 억 + "
        }
        return resultPrice
    }

    fun getFormattedLevel() : String {
        val resultLevel =
            when {
                this.level > 0 -> { "${this.level}층" }
                this.level < 0 -> {
                    val level = this.level * -1
                    "지하${level}층"
                }
                else -> {"반지하"}
            }
        return resultLevel
    }
}