package mx.arr.news

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_news_feed.*
import kotlinx.android.synthetic.main.renglon_noticia.*
import mx.arr.news.`interface`.JsonApi
import mx.arr.news.model.ListaNoticias
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsFeed : AppCompatActivity() {

    private lateinit var adaptador : Adaptador

    // sharedPreferences
    private lateinit var prefs : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        //Configurar las prefs
        prefs = getSharedPreferences("Login", Context.MODE_PRIVATE)
        editor = prefs.edit()


        val request = ServiceBuilder.buildService(JsonApi::class.java)
        val call = request.getNoticias(getString(R.string.api_key))
        call.enqueue(object : Callback<ListaNoticias>{
            override fun onResponse(call: Call<ListaNoticias>, response: Response<ListaNoticias>) {
                if (response.isSuccessful){
                    rvNoticias.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@NewsFeed)
                        adaptador = Adaptador(response.body()!!.results)
                    }
                }
            }

            override fun onFailure(call: Call<ListaNoticias>, t: Throwable) {
                Toast.makeText(this@NewsFeed, "${t.message}", Toast.LENGTH_LONG).show()
            }
        }
        )
    }



    //Finalizar sesion
    fun finalizarSesion(v : View){
        editor.clear()
        editor.commit()
        val intMain = Intent(this, MainActivity::class.java)
        startActivity(intMain)
        finish()
    }

}