package com.yasinsenel.rv_poll


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.yasinsenel.rv_poll.databinding.ItemsLayoutBinding




class ItemAdapter : RecyclerView.Adapter<ItemAdapter.Holder>() {

    private var clickedListener = false

    private val list: ArrayList<String> = arrayListOf()


    inner class Holder(val binding: ItemsLayoutBinding,val context : Context) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : String){

            binding.apply {
                textView.text = data
                //Burda renk değiştirme ve silme işlemleri yapılıyor
                if (clickedListener) {
                    textView.setBackgroundResource(R.drawable.back_button)
                    textView.setTextColor(ContextCompat.getColor(context, R.color.purple_500))
                }
                textView.setOnClickListener {
                    removeUnSelectedItem(data)
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

    fun fillList(fillList: ArrayList<String>) {
        list.addAll(fillList)
        notifyDataSetChanged()
    }

    private fun removeUnSelectedItem(data: String) {
        clickedListener = true
        val newList: ArrayList<String> = arrayListOf()
        newList.add(data)
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

}