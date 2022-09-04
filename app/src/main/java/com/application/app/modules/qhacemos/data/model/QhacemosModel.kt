package com.application.app.modules.qhacemos.`data`.model

import com.application.app.R
import com.application.app.appcomponents.di.MyApp
import kotlin.String

data class QhacemosModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtH5: String? = MyApp.getInstance().resources.getString(R.string.lbl_en_el_mundo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_se_desperdician)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_1_3_de_lo_que_s)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeight: String? = MyApp.getInstance().resources.getString(R.string.msg_rescatamos_135)
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
