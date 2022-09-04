package com.application.app.modules.voluntariado.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class VoluntariadoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtH5: String? = MyApp.getInstance().resources.getString(R.string.lbl_voluntariado)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAyudaalosque: String? =
      MyApp.getInstance().resources.getString(R.string.msg_ayuda_a_los_que)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCaption: String? = MyApp.getInstance().resources.getString(R.string.lbl_men)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCaptionOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_information)

)
