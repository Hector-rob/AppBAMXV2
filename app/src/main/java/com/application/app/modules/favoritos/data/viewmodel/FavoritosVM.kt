package com.application.app.modules.favoritos.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.app.modules.favoritos.`data`.model.FavoritosModel
import org.koin.core.KoinComponent

class FavoritosVM : ViewModel(), KoinComponent {
  val favoritosModel: MutableLiveData<FavoritosModel> = MutableLiveData(FavoritosModel())

  var navArguments: Bundle? = null
}
