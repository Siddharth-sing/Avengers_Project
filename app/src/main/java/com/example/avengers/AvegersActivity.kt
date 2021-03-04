package com.example.avengers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class AvegersActivity : AppCompatActivity() {

    lateinit var sharedPreferences:SharedPreferences
    lateinit var btnLogOut: Button

    var titleName: String? = "Avengers"
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)

                sharedPreferences=getSharedPreferences(getString(R.string.shared_preferences_file_name), Context.MODE_PRIVATE)

      /*  if(intent !=null)
        {
            titleName = intent.getStringExtra("Name")  /* Data transfer between two activities */
        } */ /* we will use this code snippet when we are using intent for data transfer */
        titleName=sharedPreferences.getString("TitleKey","The Avengers")
                title = titleName





                var intentLogout= Intent(this@AvegersActivity,LoginActivity::class.java)
                btnLogOut=findViewById(R.id.btnLogout)

                btnLogOut.setOnClickListener {

                    sharedPreferences.edit().clear().apply()
                    Toast.makeText(this@AvegersActivity , "GoodBye!" , Toast.LENGTH_LONG).show()
                    startActivity(intentLogout)
                    finish()
                }




            }
}