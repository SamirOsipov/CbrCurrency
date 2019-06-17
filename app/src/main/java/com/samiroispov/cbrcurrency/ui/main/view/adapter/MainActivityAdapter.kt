package com.samiroispov.cbrcurrency.ui.main.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samiroispov.cbrcurrency.R
import com.samiroispov.cbrcurrency.data.model.ValuteProperties
import kotlinx.android.synthetic.main.value_list_item.view.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * Created by samirosipov on 17/06/2019
 */
class MainActivityAdapter : RecyclerView.Adapter<MainActivityAdapter.MainViewHolder>() {

    private val list = ArrayList<ValuteProperties>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.value_list_item, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun setData(valutes: HashMap<String, ValuteProperties>) {
        list.addAll(valutes.values)
        notifyDataSetChanged()
    }


    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(valute: ValuteProperties) = itemView.apply {
            tv_title.text = valute.name
            tv_nominal.text =
                valute.nominal.toString() + " " + valute.charCode + " = " + valute.value.toString() + " RUB"

            var diff = valute.value!! - valute.previous!!
            tv_diff.text =  if (diff > 0) {
                ("(" + "+" + String.format(Locale("ru"), "%.2f", diff) + ")")
            } else {
                ("(" + String.format(Locale("ru"), "%.2f", diff) + ")")
            }

        }
    }
}
