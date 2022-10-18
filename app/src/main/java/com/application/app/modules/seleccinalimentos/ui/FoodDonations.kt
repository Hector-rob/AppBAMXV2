package com.application.app.modules.seleccinalimentos.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.application.app.FormularioComun
import com.application.app.R
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.qhacemos.ui.QhacemosActivity
import kotlin.collections.ArrayList

class FoodDonations : AppCompatActivity() {

    private lateinit var keysNames : ArrayList<String>

    private var fragMng: FragmentManager = supportFragmentManager
    var fragTransaction : FragmentTransaction = fragMng.beginTransaction()
    private var fragments = arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_donations)

        createFragments()
    }

    private fun createFragments(){
        val intent = intent
        val keys : ArrayList<String>? = intent.getStringArrayListExtra("keys")
        keysNames = keys!!
        val products: HashMap<String, String> = intent.getSerializableExtra("Products") as HashMap<String, String>

        for((i, key) in keys!!.withIndex()){
            val name = key.toString()
            val imgLink = products[name].toString()
            Log.e("foodDoantions", "img link: $imgLink, name: $name")
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
        fragTransaction.replace(R.id.fragment12, fragments[11])
        fragTransaction.replace(R.id.fragment13, fragments[12])
        fragTransaction.replace(R.id.fragment14, fragments[13])
        fragTransaction.replace(R.id.fragment15, fragments[14])
        fragTransaction.replace(R.id.fragment16, fragments[15])
        fragTransaction.replace(R.id.fragment17, fragments[16])
        fragTransaction.replace(R.id.fragment18, fragments[17])
        fragTransaction.replace(R.id.fragment19, fragments[18])
        fragTransaction.replace(R.id.fragment20, fragments[19])
        fragTransaction.replace(R.id.fragment21, fragments[20])
        fragTransaction.replace(R.id.fragment22, fragments[21])
        fragTransaction.replace(R.id.fragment23, fragments[22])
        fragTransaction.replace(R.id.fragment24, fragments[23])
        fragTransaction.replace(R.id.fragment25, fragments[24])
        fragTransaction.replace(R.id.fragment26, fragments[25])
        fragTransaction.replace(R.id.fragment27, fragments[26])
        fragTransaction.replace(R.id.fragment28, fragments[27])
        fragTransaction.replace(R.id.fragment29, fragments[28])
        fragTransaction.replace(R.id.fragment30, fragments[29])
        fragTransaction.replace(R.id.fragment31, fragments[30])
        fragTransaction.replace(R.id.fragment32, fragments[31])
        fragTransaction.replace(R.id.fragment33, fragments[32])
        fragTransaction.replace(R.id.fragment34, fragments[33])
        fragTransaction.replace(R.id.fragment35, fragments[34])
        fragTransaction.replace(R.id.fragment36, fragments[35])
        fragTransaction.replace(R.id.fragment37, fragments[36])
        fragTransaction.replace(R.id.fragment38, fragments[37])

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
        val frag12 = fragMng.findFragmentById(R.id.fragment12) to articuloFragment
        val frag13 = fragMng.findFragmentById(R.id.fragment13) to articuloFragment
        val frag14 = fragMng.findFragmentById(R.id.fragment14) to articuloFragment
        val frag15 = fragMng.findFragmentById(R.id.fragment15) to articuloFragment
        val frag16 = fragMng.findFragmentById(R.id.fragment16) to articuloFragment
        val frag17 = fragMng.findFragmentById(R.id.fragment17) to articuloFragment
        val frag18 = fragMng.findFragmentById(R.id.fragment18) to articuloFragment
        val frag19 = fragMng.findFragmentById(R.id.fragment19) to articuloFragment
        val frag20 = fragMng.findFragmentById(R.id.fragment20) to articuloFragment
        val frag21 = fragMng.findFragmentById(R.id.fragment21) to articuloFragment
        val frag22 = fragMng.findFragmentById(R.id.fragment22) to articuloFragment
        val frag23 = fragMng.findFragmentById(R.id.fragment23) to articuloFragment
        val frag24 = fragMng.findFragmentById(R.id.fragment24) to articuloFragment
        val frag25 = fragMng.findFragmentById(R.id.fragment25) to articuloFragment
        val frag26 = fragMng.findFragmentById(R.id.fragment26) to articuloFragment
        val frag27 = fragMng.findFragmentById(R.id.fragment27) to articuloFragment
        val frag28 = fragMng.findFragmentById(R.id.fragment28) to articuloFragment
        val frag29 = fragMng.findFragmentById(R.id.fragment29) to articuloFragment
        val frag30 = fragMng.findFragmentById(R.id.fragment30) to articuloFragment
        val frag31 = fragMng.findFragmentById(R.id.fragment31) to articuloFragment
        val frag32 = fragMng.findFragmentById(R.id.fragment32) to articuloFragment
        val frag33 = fragMng.findFragmentById(R.id.fragment33) to articuloFragment
        val frag34 = fragMng.findFragmentById(R.id.fragment34) to articuloFragment
        val frag35 = fragMng.findFragmentById(R.id.fragment35) to articuloFragment
        val frag36 = fragMng.findFragmentById(R.id.fragment36) to articuloFragment
        val frag37 = fragMng.findFragmentById(R.id.fragment37) to articuloFragment
        val frag38 = fragMng.findFragmentById(R.id.fragment38) to articuloFragment

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

        val name12 = frag12.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount12 =
            frag12.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name13 = frag13.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount13 =
            frag13.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name14 = frag14.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount14 =
            frag14.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name15 = frag15.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount15 =
            frag15.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name16 = frag16.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount16 =
            frag16.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name17 = frag17.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount17 =
            frag17.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name18 = frag18.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount18 =
            frag18.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name19 = frag19.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount19 =
            frag19.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name20 = frag20.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount20 =
            frag20.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name21 = frag21.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount21 =
            frag21.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name22 = frag22.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount22 =
            frag22.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name23 = frag23.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount23 =
            frag23.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name24 = frag24.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount24 =
            frag24.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name25 = frag25.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount25 =
            frag25.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name26 = frag26.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount26 =
            frag26.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name27 = frag27.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount27 =
            frag27.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name28 = frag28.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount28 =
            frag28.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name29 = frag29.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount29 =
            frag29.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name30 = frag30.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount30 =
            frag30.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name31 = frag31.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount31 =
            frag31.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name32 = frag32.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount32 =
            frag32.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name33 = frag33.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount33 =
            frag33.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name34 = frag34.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount34 =
            frag34.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name35 = frag35.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount35 =
            frag35.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name36 = frag36.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount36 =
            frag36.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name37 = frag37.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount37 =
            frag37.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

        val name38 = frag38.first?.view?.findViewById<TextView>(R.id.txtArticulo)?.text.toString()
        val amount38 =
            frag38.first?.view?.findViewById<TextView>(R.id.amount)?.text.toString().toInt()

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
            name11 to amount11,
            name12 to amount12,
            name13 to amount13,
            name14 to amount14,
            name15 to amount15,
            name16 to amount16,
            name17 to amount17,
            name18 to amount18,
            name19 to amount19,
            name20 to amount20,
            name21 to amount21,
            name22 to amount22,
            name23 to amount23,
            name24 to amount24,
            name25 to amount25,
            name26 to amount26,
            name27 to amount27,
            name28 to amount28,
            name29 to amount29,
            name30 to amount30,
            name31 to amount31,
            name32 to amount32,
            name33 to amount33,
            name34 to amount34,
            name35 to amount35,
            name36 to amount36,
            name37 to amount37,
            name38 to amount38,
        )
    }

    fun btnDonar(view: View){
        val foodDonations = Donar()
        val intent = Intent(this, ResumenFoodDonations::class.java)
        intent.putExtra("donation", foodDonations)
        intent.putExtra("keys", keysNames)
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