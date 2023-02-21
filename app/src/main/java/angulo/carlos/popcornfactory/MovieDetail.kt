package angulo.carlos.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        cargarDescripcion()
        val bundle = intent.extras
        var ns=0
        var id=-1
        var title=""
        var seats: TextView = findViewById(R.id.seatsLeft) as TextView
        var boton: Button= findViewById(R.id.buyTickets) as Button
        if(bundle!=null){
            ns=bundle.getInt("numberSeats")
            seats.setText("$ns seats Aviable")
            id=bundle.getInt("pos")
            title=bundle.getString("titulo")!!
        }
        if(ns==0){
            boton.isActivated=false
        }else{
            boton.setOnClickListener {
                val intent: Intent= Intent(this, SeatSelection::class.java)
                intent.putExtra("id",id)
                intent.putExtra("name",title)
            }
        }
    }

    fun cargarDescripcion(){
        var titulo: TextView = findViewById(R.id.tituloPelicula) as TextView
        var descripcion: TextView = findViewById(R.id.descripcionPelicula) as TextView
        var imagen: ImageView= findViewById(R.id.imagenPelicula) as ImageView
        var seats: TextView = findViewById(R.id.seatsLeft) as TextView
        intent.getStringExtra("titulo")
        var tituloPelicula= intent.getStringExtra("titulo")
        var descripcionPelicula= intent.getStringExtra("sinopsis")
        var imagenPelicula= intent.getIntExtra("header", 0)
        titulo.setText(tituloPelicula)
        descripcion.setText(descripcionPelicula)
        imagen.setImageResource(imagenPelicula)
    }

}