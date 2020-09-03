package com.developer.allef.onsavedinstance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     var name:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null && !savedInstanceState.isEmpty){
           val savedInstanceName = savedInstanceState.getString("Name","Bosta")
            tv_name.text = savedInstanceName
            name = savedInstanceName
        }

        button.setOnClickListener {
             name = edit_name.text.toString()
            tv_name.text = name
        }



    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
        val savedInstanceName = savedInstanceState.getString("Name","Bosta")
        tv_name.text = savedInstanceName
        name = savedInstanceName.toString()
    }



    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("Name",name)

        super.onSaveInstanceState(outState)

    }
}