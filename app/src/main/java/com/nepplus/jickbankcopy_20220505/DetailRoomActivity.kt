package com.nepplus.jickbankcopy_20220505

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nepplus.jickbankcopy_20220505.models.RoomData

class DetailRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_room)

        val roomData = intent.getSerializableExtra("roomData") as RoomData
    }
}