package angulo.carlos.popcornfactory

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        cargarDescripcion()
    }

    fun cargarDescripcion(){
        var titulo: TextView = findViewById(R.id.tituloPelicula) as TextView
        var descripcion: TextView = findViewById(R.id.descripcionPelicula) as TextView
        var imagen: ImageView= findViewById(R.id.imagenPelicula) as ImageView
        intent.getStringExtra("titulo")
        var tituloPelicula= intent.getStringExtra("titulo")
        var descripcionPelicula= intent.getStringExtra("sinopsis")
        var imagenPelicula= intent.getIntExtra("image", 0)
        titulo.setText(tituloPelicula)
        descripcion.setText(descripcionPelicula)
        imagen.setImageResource(imagenPelicula)
    }

}