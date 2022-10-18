package com.application.app.modules.seleccinalimentos.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.application.app.FormularioComun
import com.application.app.R
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import org.w3c.dom.Text
import kotlin.String
import kotlin.Unit
import kotlin.collections.ArrayList

class ResumenFoodDonations : AppCompatActivity() {

    private var keysFood = arrayListOf<String>()
    private lateinit var foodDonations : HashMap<String, String>

    private var productos = arrayListOf<TextView>()
    private var cantidades = arrayListOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen_food_donations)

        val intent = intent
        val keys : ArrayList<String>? = intent.getStringArrayListExtra("keys")
        keysFood = keys!!
        val food: HashMap<String, String> = intent.getSerializableExtra("donation") as HashMap<String, String>
        foodDonations = food


        getTextView()
        fillTextView()
    }

    private fun fillTextView(){
        for((i, key) in keysFood.withIndex()){
            productos[i].text = key
            cantidades[i].text = foodDonations[key].toString()
        }
    }

    private fun getTextView(){
        val prod1 = findViewById<TextView>(R.id.producto1)
        val prod2 = findViewById<TextView>(R.id.producto2)
        val prod3 = findViewById<TextView>(R.id.producto3)
        val prod4 = findViewById<TextView>(R.id.producto4)
        var prod5 = findViewById<TextView>(R.id.producto5)
        var prod6 = findViewById<TextView>(R.id.producto6)
        var prod7 = findViewById<TextView>(R.id.producto7)
        var prod8 = findViewById<TextView>(R.id.producto8)
        var prod9 = findViewById<TextView>(R.id.producto9)
        var prod10 = findViewById<TextView>(R.id.producto10)
        var prod11 = findViewById<TextView>(R.id.producto11)
        var prod12 = findViewById<TextView>(R.id.producto12)
        var prod13 = findViewById<TextView>(R.id.producto13)
        var prod14 = findViewById<TextView>(R.id.producto14)
        var prod15 = findViewById<TextView>(R.id.producto15)
        var prod16 = findViewById<TextView>(R.id.producto16)
        var prod17 = findViewById<TextView>(R.id.producto17)
        var prod18 = findViewById<TextView>(R.id.producto18)
        var prod19 = findViewById<TextView>(R.id.producto19)
        var prod20 = findViewById<TextView>(R.id.product20)
        var prod21 = findViewById<TextView>(R.id.producto21)
        var prod22 = findViewById<TextView>(R.id.product22)
        var prod23 = findViewById<TextView>(R.id.producto23)
        var prod24 = findViewById<TextView>(R.id.producto24)
        var prod25 = findViewById<TextView>(R.id.producto25)
        var prod26 = findViewById<TextView>(R.id.producto26)
        var prod27 = findViewById<TextView>(R.id.producto27)
        var prod28 = findViewById<TextView>(R.id.producto28)
        var prod29 = findViewById<TextView>(R.id.producto29)
        var prod30 = findViewById<TextView>(R.id.producto30)
        var prod31 = findViewById<TextView>(R.id.producto31)
        var prod32 = findViewById<TextView>(R.id.producto32)
        var prod33 = findViewById<TextView>(R.id.producto33)
        var prod34 = findViewById<TextView>(R.id.producto34)
        var prod35 = findViewById<TextView>(R.id.producto35)
        var prod36 = findViewById<TextView>(R.id.producto36)
        var prod37 = findViewById<TextView>(R.id.producto37)
        var prod38 = findViewById<TextView>(R.id.producto38)

        val cant1 = findViewById<TextView>(R.id.cantidad1)
        val cant2 = findViewById<TextView>(R.id.cantidad2)
        var cant3 = findViewById<TextView>(R.id.cantidad3)
        var cant4 = findViewById<TextView>(R.id.cantidad4)
        var cant5 = findViewById<TextView>(R.id.cantidad5)
        var cant6 = findViewById<TextView>(R.id.cantidad6)
        var cant7 = findViewById<TextView>(R.id.cantidad7)
        var cant8 = findViewById<TextView>(R.id.cantidad8)
        var cant9 = findViewById<TextView>(R.id.cantidad9)
        var cant10 = findViewById<TextView>(R.id.cantidad10)
        var cant11 = findViewById<TextView>(R.id.cantidad11)
        var cant12 = findViewById<TextView>(R.id.cantidad12)
        var cant13 = findViewById<TextView>(R.id.cantidad13)
        var cant14 = findViewById<TextView>(R.id.cantidad14)
        var cant15 = findViewById<TextView>(R.id.cantidad15)
        var cant16 = findViewById<TextView>(R.id.cantidad16)
        var cant17 = findViewById<TextView>(R.id.cantidad17)
        var cant18 = findViewById<TextView>(R.id.cantidad18)
        var cant19 = findViewById<TextView>(R.id.cantidad19)
        var cant20 = findViewById<TextView>(R.id.cantidad20)
        var cant21 = findViewById<TextView>(R.id.cantidad21)
        var cant22 = findViewById<TextView>(R.id.cantidad22)
        var cant23 = findViewById<TextView>(R.id.cantidad23)
        var cant24 = findViewById<TextView>(R.id.cantidad24)
        var cant25 = findViewById<TextView>(R.id.cantidad25)
        var cant26 = findViewById<TextView>(R.id.cantidad26)
        var cant27 = findViewById<TextView>(R.id.cantidad27)
        var cant28 = findViewById<TextView>(R.id.cantidad28)
        var cant29 = findViewById<TextView>(R.id.cantidad29)
        var cant30 = findViewById<TextView>(R.id.cantidad30)
        var cant31 = findViewById<TextView>(R.id.cantidad31)
        var cant32 = findViewById<TextView>(R.id.cantidad32)
        var cant33 = findViewById<TextView>(R.id.cantidad33)
        var cant34 = findViewById<TextView>(R.id.cantidad34)
        var cant35 = findViewById<TextView>(R.id.cantidad35)
        var cant36 = findViewById<TextView>(R.id.cantidad36)
        var cant37 = findViewById<TextView>(R.id.cantidad37)
        var cant38 = findViewById<TextView>(R.id.cantidad38)

        productos.add(prod1)
        productos.add(prod2)
        productos.add(prod3)
        productos.add(prod4)
        productos.add(prod5)
        productos.add(prod6)
        productos.add(prod7)
        productos.add(prod8)
        productos.add(prod9)
        productos.add(prod10)
        productos.add(prod11)
        productos.add(prod12)
        productos.add(prod13)
        productos.add(prod14)
        productos.add(prod15)
        productos.add(prod16)
        productos.add(prod17)
        productos.add(prod18)
        productos.add(prod19)
        productos.add(prod20)
        productos.add(prod21)
        productos.add(prod22)
        productos.add(prod23)
        productos.add(prod24)
        productos.add(prod25)
        productos.add(prod26)
        productos.add(prod27)
        productos.add(prod28)
        productos.add(prod29)
        productos.add(prod30)
        productos.add(prod31)
        productos.add(prod32)
        productos.add(prod33)
        productos.add(prod34)
        productos.add(prod35)
        productos.add(prod36)
        productos.add(prod37)
        productos.add(prod38)

        cantidades.add(cant1)
        cantidades.add(cant2)
        cantidades.add(cant3)
        cantidades.add(cant4)
        cantidades.add(cant5)
        cantidades.add(cant6)
        cantidades.add(cant7)
        cantidades.add(cant8)
        cantidades.add(cant9)
        cantidades.add(cant10)
        cantidades.add(cant11)
        cantidades.add(cant12)
        cantidades.add(cant13)
        cantidades.add(cant14)
        cantidades.add(cant15)
        cantidades.add(cant16)
        cantidades.add(cant17)
        cantidades.add(cant18)
        cantidades.add(cant19)
        cantidades.add(cant20)
        cantidades.add(cant21)
        cantidades.add(cant22)
        cantidades.add(cant23)
        cantidades.add(cant24)
        cantidades.add(cant25)
        cantidades.add(cant26)
        cantidades.add(cant27)
        cantidades.add(cant28)
        cantidades.add(cant29)
        cantidades.add(cant30)
        cantidades.add(cant31)
        cantidades.add(cant32)
        cantidades.add(cant33)
        cantidades.add(cant34)
        cantidades.add(cant35)
        cantidades.add(cant36)
        cantidades.add(cant37)
        cantidades.add(cant38)
    }


    fun btnDonar(view: View){
        val intent = Intent(this, FormularioComun::class.java)
        intent.putExtra("donation", foodDonations)
        startActivity(intent)
    }

    fun back(view: View){
        finish()
    }

    fun returnMenu(view: View){
        val intent = Intent(this, MenPrincipalActivity::class.java)
        startActivity(intent)
    }

    fun info(view: View){
        val intent = Intent(this, QhacemosActivity::class.java)
        startActivity(intent)
    }
}