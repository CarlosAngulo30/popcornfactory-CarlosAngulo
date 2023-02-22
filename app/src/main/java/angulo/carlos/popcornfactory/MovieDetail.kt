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
        var buyTickets: Button= findViewById(R.id.buyTickets) as Button
        if(bundle!=null){
            var seats: TextView = findViewById(R.id.seatsLeft) as TextView
            ns=bundle.getInt("numberSeats")
            seats.setText("$ns seats Aviable")
            id=bundle.getInt("pos")
            title=bundle.getString("titulo")!!
            var asientosRestantes = intent.getIntExtra("numberSeats", 0)!!
            id = intent.getIntExtra("pos", -1)
            seats.setText("$asientosRestantes seats available ")
        }


        if(ns==0){
            buyTickets.isEnabled=false
        }else{
            buyTickets.isEnabled=true
            buyTickets.setOnClickListener {
                val intent: Intent= Intent(this, SeatSelection::class.java)
                intent.putExtra("id",id)
                intent.putExtra("name",title)
                this.startActivity(intent)
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