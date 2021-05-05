package mx.arr.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.arr.news.model.Result

// Administra la info. que se muestra en el Recycler View
class Adaptador(val noticias: List<Result>) :
    RecyclerView.Adapter<Adaptador.VistaRenglon>(){

    //Crear un renglon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaRenglon {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.renglon_noticia, parent, false)
        return VistaRenglon(vista)
    }

    //Pide los datos de un renglon
    override fun onBindViewHolder(holder: VistaRenglon, position: Int) {
        return holder.bind(noticias[position])
    }

    //Número de renglones a desplegar
    override fun getItemCount(): Int {
        return noticias.size
    }

    //Poblando la tarjeta con sus respectivos componentes
    class VistaRenglon(private val vistaRenglonNoticia: View ) :
        RecyclerView.ViewHolder(vistaRenglonNoticia) {
        private val titulo :TextView = itemView.findViewById(R.id.tvTitulo)
        private val fuente :TextView = itemView.findViewById(R.id.tvFuente)
        private val imagen :ImageView = itemView.findViewById(R.id.imgNoticia)
        fun bind(noticia: Result){
            titulo.text = "Title: " + noticia.title
            fuente.text = "Autor: " + noticia.author
            imagen.setImageURI(noticia.urtlToImage)
        }

    }




}