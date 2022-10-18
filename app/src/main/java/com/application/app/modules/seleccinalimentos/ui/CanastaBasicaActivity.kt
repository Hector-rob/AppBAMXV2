package com.application.app.modules.seleccinalimentos.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.application.app.FormularioComun
import com.application.app.R
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import java.util.ArrayList

class CanastaBasicaActivity : AppCompatActivity() {

    private var fragMng: FragmentManager = supportFragmentManager
    var fragTransaction : FragmentTransaction = fragMng.beginTransaction()
    private var fragments = arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canasta_basica)

        createFragments()
    }

    private fun createFragments(){
        val intent = intent
        val keys : ArrayList<String>? = intent.getStringArrayListExtra("keys")
        val products: HashMap<String, String> = intent.getSerializableExtra("CanastaBasica") as HashMap<String, String>

        for((i, key) in keys!!.withIndex()){
            val name = key.toString()
            val imgLink = products[name].toString()
            Log.e("canasta", "img link: $imgLink, name: $name")
            val frag: articuloFragment = articuloFragment.newInstance(imgLink, name, "0")
            fragments.add(frag)
        }
        updateFragments()
    }

    private fun updateFragments(){
        fragTransaction.replace(R.id.fragment1, fragments[0])
        fragTransaction.replace(R.id.fragment2, fragments[1])
        fragTransaction.replace(R.id.fragment3, fragments[2])
        fragTransaction.replace(R.id.fragment4, fragments[3])
        fragTransaction.replace(R.id.fragment5, fragments[4])
        fragTransaction.replace(R.id.fragment6, fragments[5])
        fragTransaction.replace(R.id.fragment7, fragments[6])
        fragTransaction.replace(R.id.fragment8, fragments[7])
        fragTransaction.replace(R.id.fragment9, fragments[8])
        fragTransaction.replace(R.id.fragment10, fragments[9])
        fragTransaction.replace(R.id.fragment11, fragments[10])

        fragTransaction.commit()
    }

    private fun Donar(): HashMap<String, Int> {
        val frag1 = fragMng.findFragmentById(R.id.fragment1) to articuloFragment
        val frag2 = fragMng.findFragmentById(R.id.fragment2) to articuloFragment
        val frag3 = fragMng.findFragmentById(R.id.fragment3) to articuloFragment
        val frag4 = fragMng.findFragmentById(R.id.fragment4) to articuloFragment
        val frag5 = fragMng.findFragmentById(R.id.fragment5) to articuloFragment
        val frag6 = fragMng.findFragmentById(R.id.fragment6) to articuloFragment
        val frag7 = fragMng.findFragmentById(R.id.fragment7) to articuloFragment
        val frag8 = fragMng.findFragmentById(R.id.fragment8) to articuloFragment
        val frag9 = fragMng.findFragmentById(R.id.fragment9) to articuloFragment
        val frag10 = fragMng.findFragmentById(R.id.fragment10) to articuloFragment
        val frag11 = fragMng.findFragmentById(R.id.fragment11) to articuloFragment

        val name1 = frag1.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount1 =
            frag1.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name2 = frag2.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount2 =
            frag2.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name3 = frag3.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount3 =
            frag3.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name4 = frag4.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount4 =
            frag4.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name5 = frag5.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount5 =
            frag5.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name6 = frag6.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount6 =
            frag6.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name7 = frag7.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount7 =
            frag7.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name8 = frag8.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount8 =
            frag8.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name9 = frag9.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount9 =
            frag9.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name10 = frag10.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount10 =
            frag10.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name11 = frag11.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount11 =
            frag11.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        return hashMapOf(
            name1 to amount1,
            name2 to amount2,
            name3 to amount3,
            name4 to amount4,
            name5 to amount5,
            name6 to amount6,
            name7 to amount7,
            name8 to amount8,
            name9 to amount9,
            name10 to amount10,
            name11 to amount11
        )
    }

    fun btnDonar(view: View){
        val foodDonations = Donar()
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

    fun carButton(view: View){
        //val intent = Intent(this, )
        //startActivity(intent)
    }

}