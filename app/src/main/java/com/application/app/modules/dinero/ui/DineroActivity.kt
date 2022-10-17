package com.application.app.modules.dinero.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.application.app.R
import com.application.app.Stripe
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityDineroBinding
import com.application.app.modules.dinero.data.viewmodel.DineroVM
import com.application.app.modules.menprincipal.ui.MenPrincipalActivity
import com.application.app.modules.qhacemos.ui.QhacemosActivity

class DineroActivity : BaseActivity<ActivityDineroBinding>(R.layout.activity_dinero) {
  private val viewModel: DineroVM by viewModels<DineroVM>()


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dineroVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linear1Tab.setOnClickListener {
      val destIntent = MenPrincipalActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnEnviarDonacinOne.setOnClickListener {
     val intent = Intent(this, Stripe::class.java)
      intent.putExtra("dinero",binding.dinero.text.toString().toInt())
      startActivity(intent)
    }

    binding.btn100Zero.setOnClickListener {
      val intent = Intent(this, Stripe::class.java)
      intent.putExtra("dinero",100)
      startActivity(intent)
    }

    binding.btn200Zero.setOnClickListener {
      val intent = Intent(this, Stripe::class.java)
      intent.putExtra("dinero",200)
      startActivity(intent)
    }

    binding.btn500Zero.setOnClickListener {
      val intent = Intent(this, Stripe::class.java)
      intent.putExtra("dinero",500)
      startActivity(intent)
    }

  }

  fun info(view: View){
    val intent = Intent(this, QhacemosActivity::class.java)
    startActivity(intent)
  }

  companion object {
    const val TAG: String = "DINERO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DineroActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
