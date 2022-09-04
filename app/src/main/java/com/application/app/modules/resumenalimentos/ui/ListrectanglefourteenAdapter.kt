package com.application.app.modules.resumenalimentos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowListrectanglefourteen1Binding
import com.application.app.modules.resumenalimentos.`data`.model.Listrectanglefourteen1RowModel
import kotlin.Int
import kotlin.collections.List

class ListrectanglefourteenAdapter(
  var list: List<Listrectanglefourteen1RowModel>
) : RecyclerView.Adapter<ListrectanglefourteenAdapter.RowListrectanglefourteen1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectanglefourteen1VH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectanglefourteen1,parent,false)
    return RowListrectanglefourteen1VH(view)
  }

  override fun onBindViewHolder(holder: RowListrectanglefourteen1VH, position: Int) {
    val listrectanglefourteen1RowModel = Listrectanglefourteen1RowModel()
    // TODO uncomment following line after integration with data source
    // val listrectanglefourteen1RowModel = list[position]
    holder.binding.listrectanglefourteen1RowModel = listrectanglefourteen1RowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectanglefourteen1RowModel>) {
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
      item: Listrectanglefourteen1RowModel
    ) {
    }
  }

  inner class RowListrectanglefourteen1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectanglefourteen1Binding = RowListrectanglefourteen1Binding.bind(itemView)
  }
}
