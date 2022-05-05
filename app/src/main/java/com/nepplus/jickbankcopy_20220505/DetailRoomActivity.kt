package com.nepplus.jickbankcopy_20220505

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nepplus.jickbankcopy_20220505.models.RoomData
import kotlinx.android.synthetic.main.activity_detail_room.*
import java.text.DecimalFormat

class DetailRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_room)

        val roomData = intent.getSerializableExtra("roomData") as RoomData

        val formatter = DecimalFormat("#,###")

        val resultPrice = if (roomData.price < 10000) {
            formatter.format(roomData.price)
        } else {
            val over = roomData.price / 10000
            val remain = roomData.price % 10000
            "${over}억${formatter.format(remain)}"
        }

        val resultLevel =
            when {
                roomData.level > 0 -> { "${roomData.level}층" }
                roomData.level < 0 -> {
                    val level = roomData.level * -1
                    "지하${level}층"
                }
                else -> {"반지하"}
            }

        priceTxt.text = resultPrice
        addressTxt.text = "${roomData.address}, $resultLevel"
        descriptionTxt.text = roomData.description
    }
}