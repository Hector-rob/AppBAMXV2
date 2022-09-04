package com.application.app.modules.recetas.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowRecetasBinding
import com.application.app.modules.recetas.`data`.model.RecetasRowModel
import kotlin.Int
import kotlin.collections.List

class RecetasAdapter(
  var list: List<RecetasRowModel>
) : RecyclerView.Adapter<RecetasAdapter.RowRecetasVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowRecetasVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_recetas,parent,false)
    return RowRecetasVH(view)
  }

  override fun onBindViewHolder(holder: RowRecetasVH, position: Int) {
    val recetasRowModel = RecetasRowModel()
    // TODO uncomment following line after integration with data source
    // val recetasRowModel = list[position]
    holder.binding.recetasRowModel = recetasRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<RecetasRowModel>) {
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
      item: RecetasRowModel
    ) {
    }
  }

  inner class RowRecetasVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowRecetasBinding = RowRecetasBinding.bind(itemView)
  }
}
