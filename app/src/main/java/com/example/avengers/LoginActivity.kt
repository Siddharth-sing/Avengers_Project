package com.example.avengers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


           lateinit var imgAvengers:Image
           lateinit var editTextNumber: EditText
           lateinit var editPassword: EditText
           lateinit var btnLogin:Button
           lateinit var bottomTag:TextView
           lateinit var forgotPass:TextView
           val validMobileNumber="9119148863"
           val validPassword= arrayOf<String>("Steve","Tony","Hulk","Natasha","Thanos")

    lateinit var sharedPreferences:SharedPreferences /* First we will create the a var of type SharedPreference to use the var to create object of  SharedPreferences() class inside onCreate() method*/
    /* we made this var global so that we can use it anywhere that is in savePreference user defined function.*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences=getSharedPreferences(getString(R.string.shared_preferences_file_name),Context.MODE_PRIVATE)
        /* Since R.string.shared_preferences_file_name will be an integer value so we used the getString() function to extract
        * string from the R file. */

        val intent=Intent(this@LoginActivity,AvegersActivity::class.java) /* This is the connection Point of two activities */
        /* Since we are shared the destination as AvengersActivity in intent variable we can use intent anywhere in AvengersActivit */

        var isLoggedIn:Boolean=sharedPreferences.getBoolean("isLoggedIn",false)




        if(isLoggedIn)
        {
            startActivity(intent)
            finish()
        }
        


        editTextNumber=findViewById(R.id.editTextNumber)
        editPassword=findViewById(R.id.editTextNumberPassword)
        btnLogin=findViewById(R.id.buttonLogin)
        bottomTag=findViewById(R.id.txtBottom)
        forgotPass=findViewById(R.id.txtForgotPass)

        btnLogin.setOnClickListener{

            val mobileNumber = editTextNumber.text.toString()
            val password = editPassword.text.toString()

            var nameOfAvengers:String? = "Avengers" /* general initialisation, we put this variable inside button OnClick method because all this things will happen after the click */

          /*  if((mobileNumber==validMobileNumber) && (validPassword.contains(password))) {
               val intent = Intent(this@LoginActivity, AvegersActivity::class.java)
               startActivity(intent)
           } this is for array of password case*/



            if((mobileNumber==validMobileNumber))
            {
                when (password) {
                    "Steve" -> {
                        nameOfAvengers="Steve Rogers"
                        savePreferences(nameOfAvengers)

                        /*intent.putExtra("Name",nameOfAvengers) /* Name of data,actual value of data */*/
                        startActivity(intent)
                    }
                    "Tony" -> {
                        nameOfAvengers="Tony Stark"
                        savePreferences(nameOfAvengers)


                       /* intent.putExtra("Name",nameOfAvengers) *//* Name of data,actual value of data */
                        startActivity(intent)
                    }
                    "Hulk" -> {
                        nameOfAvengers="Bruce Banner"
                        savePreferences(nameOfAvengers)


                        /*intent.putExtra("Name",nameOfAvengers) /* Name of data,actual value of data */*/
                        startActivity(intent)
                    }
                    "Natasha" -> {
                        nameOfAvengers="Natasha Romanov"
                        savePreferences(nameOfAvengers)


                       /* intent.putExtra("Name",nameOfAvengers) /* Name of data,actual value of data */*/
                        startActivity(intent)
                    }
                    "Thanos" -> {
                        savePreferences(nameOfAvengers)

                        startActivity(intent)
                    }
                    else -> {
                        Toast.makeText(this@LoginActivity , "Invalid Credentials Entered" , Toast.LENGTH_LONG).show()
                    }
                }
            }


        }
    }

    fun savePreferences(nameOnTop: String?)
    {
          sharedPreferences.edit().putBoolean("isLoggedIn",true).apply();
          sharedPreferences.edit().putString("TitleKey", nameOnTop).apply();
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}
