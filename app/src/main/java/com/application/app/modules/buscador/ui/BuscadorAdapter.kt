package com.application.app.modules.buscador.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowBuscadorBinding
import com.application.app.modules.buscador.`data`.model.BuscadorRowModel
import kotlin.Int
import kotlin.collections.List

class BuscadorAdapter(
  var list: List<BuscadorRowModel>
) : RecyclerView.Adapter<BuscadorAdapter.RowBuscadorVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowBuscadorVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_buscador,parent,false)
    return RowBuscadorVH(view)
  }

  override fun onBindViewHolder(holder: RowBuscadorVH, position: Int) {
    val buscadorRowModel = BuscadorRowModel()
    // TODO uncomment following line after integration with data source
    // val buscadorRowModel = list[position]
    holder.binding.buscadorRowModel = buscadorRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<BuscadorRowModel>) {
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
      item: BuscadorRowModel
    ) {
    }
  }

  inner class RowBuscadorVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowBuscadorBinding = RowBuscadorBinding.bind(itemView)
  }
}
