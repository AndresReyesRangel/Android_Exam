package mx.arr.news.`interface`

import mx.arr.news.model.ListaNoticias
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonApi {

    @GET("v2/everything?q=tesla&from=2021-04-05&sortBy=publishedAt&apiKey=64d4d5d6223247308a2b8ac26e0d0480")
    fun getNoticias(@Query("api_key") key : String) : Call<ListaNoticias>

}