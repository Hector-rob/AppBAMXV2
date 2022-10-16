package com.application.app.modules.seleccinalimentos.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.application.app.FormularioComun
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityAbarrotesBinding
import com.application.app.databinding.ActivitySelecciNAlimentosBinding
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import com.application.app.modules.seleccinalimentos.data.viewmodel.SelecciNAlimentosVM
import java.util.ArrayList

class AbarrotesActivity :
    BaseActivity<ActivityAbarrotesBinding>(R.layout.activity_abarrotes) {
    private val viewModel: SelecciNAlimentosVM by viewModels<SelecciNAlimentosVM>()

    private var fragMng: FragmentManager = supportFragmentManager
    var fragTransaction : FragmentTransaction = fragMng.beginTransaction()
    private var fragments = arrayListOf<Fragment>()

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.selecciNAlimentosVM = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abarrotes)

        createFragments()
    }

    private fun createFragments(){
        val intent = intent
        val keys : ArrayList<String>? = intent.getStringArrayListExtra("keys")
        val products: HashMap<String, String> = intent.getSerializableExtra("Abarrotes") as HashMap<String, String>

        for((i, key) in keys!!.withIndex()){
            val name = key.toString()
            val imgLink = products[name].toString()
            Log.e("abarrotes", "img link: $imgLink, name: $name")
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

        return hashMapOf(
            name1 to amount1,
            name2 to amount2,
            name3 to amount3,
            name4 to amount4,
            name5 to amount5,
            name6 to amount6,
            name7 to amount7,
        )
    }

    fun btnDonar(view: View){
        val foodDonations = Donar()
        val intent = Intent(this, FormularioComun::class.java)
        intent.putExtra("donation", foodDonations)
        startActivity(intent)
    }

    override fun setUpClicks(): Unit {
        binding.imageArrowleft.setOnClickListener {
            val destIntent = MenPrincipalActivity.getIntent(this, null)
            startActivity(destIntent)
        }
        binding.imageArrowleft.setOnClickListener {
            finish()
        }
        binding.imageImageFiftyOne.setOnClickListener {
//            val destIntent = ResumenAlimentosActivity.getIntent(this, null)
//            startActivity(destIntent)
        }
        binding.btnDonar.setOnClickListener {
            val destIntent = MensajeDonaciNActivity.getIntent(this, null)
            startActivity(destIntent)
        }
        binding.linear1Tab.setOnClickListener {
            val destIntent = MenPrincipalActivity.getIntent(this, null)
            startActivity(destIntent)
        }
    }

    companion object {
        const val TAG: String = "SELECCI_N_ALIMENTOS_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, AbarrotesActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}