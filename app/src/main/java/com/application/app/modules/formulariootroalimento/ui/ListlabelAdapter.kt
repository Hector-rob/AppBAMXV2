package com.application.app.modules.formulariootroalimento.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowListlabel1Binding
import com.application.app.modules.formulariootroalimento.`data`.model.Listlabel1RowModel
import kotlin.Int
import kotlin.collections.List

class ListlabelAdapter(
  var list: List<Listlabel1RowModel>
) : RecyclerView.Adapter<ListlabelAdapter.RowListlabel1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListlabel1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listlabel1,parent,false)
    return RowListlabel1VH(view)
  }

  override fun onBindViewHolder(holder: RowListlabel1VH, position: Int) {
    val listlabel1RowModel = Listlabel1RowModel()
    // TODO uncomment following line after integration with data source
    // val listlabel1RowModel = list[position]
    holder.binding.listlabel1RowModel = listlabel1RowModel
  }

  override fun getItemCount(): Int = 5
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listlabel1RowModel>) {
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
      item: Listlabel1RowModel
    ) {
    }
  }

  inner class RowListlabel1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListlabel1Binding = RowListlabel1Binding.bind(itemView)
  }
}
