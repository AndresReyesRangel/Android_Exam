package mx.arr.news.model

import android.net.Uri

data class ListaNoticias(val results: List<Result>)

data class Result(
    var author:String?,
    var title: String?,
    var description: String?,
    var url: Uri?,
    var urtlToImage: Uri?,
    var publishedAt: String?,
    var content: String?
)
