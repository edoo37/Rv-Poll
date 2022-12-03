package com.yasinsenel.rv_poll


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.yasinsenel.rv_poll.databinding.ItemsLayoutBinding


class ItemAdapter : RecyclerView.Adapter<ItemAdapter.Holder>() {

    private var clickedListener = false
    private val list: ArrayList<Data> = arrayListOf()


    var item_position = -1


    inner class Holder(val binding: ItemsLayoutBinding,val context : Context) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : Data){

            binding.apply {
                recyclerViewButton.text = data.ans

                // Adapter pozisyonunu alıp ona eşitliyor. Öteki itemleri default yapıyor
                if (item_position==adapterPosition) {
                    recyclerViewButton.setBackgroundColor(ContextCompat.getColor(context,R.color.teal_200))

                } else {
                    recyclerViewButton.setBackgroundColor(ContextCompat.getColor(context,R.color.main_color))

                }
                recyclerViewButton.setOnClickListener {
                    //removeUnSelectedItem(data)
                    item_position=adapterPosition
                    notifyDataSetChanged();
                }

            }

        }
}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
    val binding = ItemsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return Holder(binding,parent.context)

}

override fun onBindViewHolder(holder: Holder, position: Int) {

        val data = list[position]
        holder.bind(data)


    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun fillList(fillList: ArrayList<Data>) {
        list.addAll(fillList)
        notifyDataSetChanged()
    }

    private fun removeUnSelectedItem(data : Data) {
        clickedListener = true
        val newList: ArrayList<Data> = arrayListOf()
        newList.add(data)
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

}