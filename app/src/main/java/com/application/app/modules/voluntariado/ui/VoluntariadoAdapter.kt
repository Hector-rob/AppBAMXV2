package com.application.app.modules.voluntariado.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowVoluntariadoBinding
import com.application.app.modules.voluntariado.`data`.model.VoluntariadoRowModel
import kotlin.Int
import kotlin.collections.List

class VoluntariadoAdapter(
  var list: List<VoluntariadoRowModel>
) : RecyclerView.Adapter<VoluntariadoAdapter.RowVoluntariadoVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowVoluntariadoVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_voluntariado,parent,false)
    return RowVoluntariadoVH(view)
  }

  override fun onBindViewHolder(holder: RowVoluntariadoVH, position: Int) {
    val voluntariadoRowModel = VoluntariadoRowModel()
    // TODO uncomment following line after integration with data source
    // val voluntariadoRowModel = list[position]
    holder.binding.voluntariadoRowModel = voluntariadoRowModel
  }

  override fun getItemCount(): Int = 7
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<VoluntariadoRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: VoluntariadoRowModel
    ) {
    }
  }

  inner class RowVoluntariadoVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowVoluntariadoBinding = RowVoluntariadoBinding.bind(itemView)
  }
}
