package com.adegoke.cowrywisecodingtest

import android.app.Activity
import android.content.ClipData
import android.content.Context
import android.widget.ArrayAdapter

class MyDropDownAdapter(context: Activity, groupId:Int, items: ArrayList<Items>): ArrayAdapter<Items>(context, groupId,items) {

}