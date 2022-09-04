package com.application.app.modules.seleccinalimentos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowListnaranjaBinding
import com.application.app.modules.seleccinalimentos.`data`.model.ListnaranjaRowModel
import kotlin.Int
import kotlin.collections.List

class ListnaranjaAdapter(
  var list: List<ListnaranjaRowModel>
) : RecyclerView.Adapter<ListnaranjaAdapter.RowListnaranjaVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListnaranjaVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listnaranja,parent,false)
    return RowListnaranjaVH(view)
  }

  override fun onBindViewHolder(holder: RowListnaranjaVH, position: Int) {
    val listnaranjaRowModel = ListnaranjaRowModel()
    // TODO uncomment following line after integration with data source
    // val listnaranjaRowModel = list[position]
    holder.binding.listnaranjaRowModel = listnaranjaRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListnaranjaRowModel>) {
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
      item: ListnaranjaRowModel
    ) {
    }
  }

  inner class RowListnaranjaVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListnaranjaBinding = RowListnaranjaBinding.bind(itemView)
  }
}
