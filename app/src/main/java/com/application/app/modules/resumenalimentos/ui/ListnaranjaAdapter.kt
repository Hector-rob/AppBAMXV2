package com.application.app.modules.resumenalimentos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowListnaranja1Binding
import com.application.app.modules.resumenalimentos.`data`.model.Listnaranja1RowModel
import kotlin.Int
import kotlin.collections.List

class ListnaranjaAdapter(
  var list: List<Listnaranja1RowModel>
) : RecyclerView.Adapter<ListnaranjaAdapter.RowListnaranja1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListnaranja1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listnaranja1,parent,false)
    return RowListnaranja1VH(view)
  }

  override fun onBindViewHolder(holder: RowListnaranja1VH, position: Int) {
    val listnaranja1RowModel = Listnaranja1RowModel()
    // TODO uncomment following line after integration with data source
    // val listnaranja1RowModel = list[position]
    holder.binding.listnaranja1RowModel = listnaranja1RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listnaranja1RowModel>) {
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
      item: Listnaranja1RowModel
    ) {
    }
  }

  inner class RowListnaranja1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListnaranja1Binding = RowListnaranja1Binding.bind(itemView)
  }
}
