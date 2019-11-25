package com.retrofitcrud

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.retrofitcrud.model.ResponseLogin
import com.retrofitcrud.network.NetworkModule
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_login = findViewById(R.id.buttonLogin) as Button
        button_login.setOnClickListener{
            login(et_username.text.toString(), et_password.text.toString())
        }
    }

    private fun login (username: String, password: String){
        NetworkModule.getService().login_api(username, password)
            .enqueue(object : Callback<ResponseLogin>{
                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: Response<ResponseLogin>
                ) {
                  if (response.isSuccessful){
//                      nampung dikurung siku saja
                      var data=response.body()?.data
//                      ambil data
                      data?.forEach{
                          var i: Intent
                          i = Intent(this@MainActivity, HomePage::class.java)
                             startActivity(i)
                      }
                  }else{

                  }
                }

            })
    }
}
