package com.nepplus.jickbankcopy_20220505.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.nepplus.jickbankcopy_20220505.R
import com.nepplus.jickbankcopy_20220505.models.RoomData
import java.text.DecimalFormat

class RoomAdapter(
    val mContext: Context,
    val resId : Int,
    val mList : ArrayList<RoomData>,
) : ArrayAdapter<RoomData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)
        }
        val row = tempRow!!

        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val levelTxt = row.findViewById<TextView>(R.id.levelTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTxt)

        val data = mList[position]

        val formatter = DecimalFormat("#,###")

        val resultPrice = if (data.price < 10000) {
            formatter.format(data.price)
        } else {
            val over = data.price / 10000
            val remain = data.price % 10000
            "${over}억${formatter.format(remain)}"
        }

        val resultLevel =
            when {
                data.level > 0 -> { "${data.level}층" }
                data.level < 0 -> {
                    val level = data.level * -1
                    "지하${level}층"
                }
                else -> {"반지하"}
            }

        priceTxt.text = resultPrice
        addressTxt.text = "${data.address}, "
        levelTxt.text = resultLevel
        descriptionTxt.text = data.description

        return row
    }
}