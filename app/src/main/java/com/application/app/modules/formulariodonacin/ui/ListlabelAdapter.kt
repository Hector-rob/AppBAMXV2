package com.application.app.modules.formulariodonacin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.app.R
import com.application.app.databinding.RowListlabelBinding
import com.application.app.modules.formulariodonacin.`data`.model.ListlabelRowModel
import kotlin.Int
import kotlin.collections.List

class ListlabelAdapter(
  var list: List<ListlabelRowModel>
) : RecyclerView.Adapter<ListlabelAdapter.RowListlabelVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListlabelVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listlabel,parent,false)
    return RowListlabelVH(view)
  }

  override fun onBindViewHolder(holder: RowListlabelVH, position: Int) {
    val listlabelRowModel = ListlabelRowModel()
    // TODO uncomment following line after integration with data source
    // val listlabelRowModel = list[position]
    holder.binding.listlabelRowModel = listlabelRowModel
  }

  override fun getItemCount(): Int = 5
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListlabelRowModel>) {
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
      item: ListlabelRowModel
    ) {
    }
  }

  inner class RowListlabelVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListlabelBinding = RowListlabelBinding.bind(itemView)
  }
}
