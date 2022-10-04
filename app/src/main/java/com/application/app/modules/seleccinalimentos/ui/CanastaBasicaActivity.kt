package com.application.app.modules.seleccinalimentos.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityCanastaBasicaBinding
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import com.application.app.modules.resumenalimentos.ui.ResumenAlimentosActivity
import com.application.app.modules.seleccinalimentos.data.viewmodel.SelecciNAlimentosVM
import java.util.ArrayList

class CanastaBasicaActivity :
    BaseActivity<ActivityCanastaBasicaBinding>(R.layout.activity_canasta_basica) {

    private val viewModel: SelecciNAlimentosVM by viewModels<SelecciNAlimentosVM>()

    private var fragMng: FragmentManager = supportFragmentManager
    var fragTransaction : FragmentTransaction = fragMng.beginTransaction()
    private var fragments = arrayListOf<Fragment>()
    private var idFragment = arrayListOf<Int>()

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.selecciNAlimentosVM = viewModel
    }

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
            val frag: articuloFragment = articuloFragment.newInstance(imgLink, name)
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

    private fun fillIDPositions(){
        idFragment.add(R.id.fragment1)
        idFragment.add(R.id.fragment2)
        idFragment.add(R.id.fragment3)
        idFragment.add(R.id.fragment4)
        idFragment.add(R.id.fragment5)
        idFragment.add(R.id.fragment6)
        idFragment.add(R.id.fragment7)
        idFragment.add(R.id.fragment8)
        idFragment.add(R.id.fragment9)
        idFragment.add(R.id.fragment10)
        idFragment.add(R.id.fragment11)
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
            val destIntent = ResumenAlimentosActivity.getIntent(this, null)
            startActivity(destIntent)
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
        const val TAG: String = "CANASTA_BASICA_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, SelecciNAlimentosActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}