package com.application.app.modules.seleccinalimentos.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityAbarrotesBinding
import com.application.app.databinding.ActivitySelecciNAlimentosBinding
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity
import com.application.app.modules.resumenalimentos.ui.ResumenAlimentosActivity
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

        fragTransaction.commit()
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
        const val TAG: String = "SELECCI_N_ALIMENTOS_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, SelecciNAlimentosActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}