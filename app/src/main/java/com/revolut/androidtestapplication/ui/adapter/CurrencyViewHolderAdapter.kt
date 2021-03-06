package com.revolut.androidtestapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.revolut.androidtestapplication.R
import com.revolut.androidtestapplication.databinding.ItemCurrencyBinding
import com.revolut.androidtestapplication.model.AmountListener
import com.revolut.androidtestapplication.model.CurrencyItem
import com.revolut.androidtestapplication.ui.view.MoveObjectListener
import java.lang.ref.WeakReference
import kotlin.collections.ArrayList


class CurrencyAdapter(
    val currencies: ArrayList<CurrencyItem>
) : RecyclerView.Adapter<CurrencyViewHolder>(), AmountListener {


    private lateinit var adapterContext: Context
    var listener: WeakReference<MoveObjectListener>? = null


    override fun getItemCount() = currencies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        adapterContext = parent.context
        val itemCurrencyBinding: ItemCurrencyBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_currency,
            parent,
            false
        )
        return CurrencyViewHolder(itemCurrencyBinding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.itemCurrencyBinding.currency = currencies[position]
        (holder.itemCurrencyBinding.currency as CurrencyItem).listener = WeakReference(this)
        holder.itemCurrencyBinding.currencyCard.setOnClickListener {
            Toast.makeText(
                adapterContext,
                "Taped on ${currencies[position].shortName}",
                Toast.LENGTH_SHORT
            ).show()
            listener?.get()?.moveObjectToFirstPlace(
                position,
                currencies[position].flag,
                currencies[position].shortName,
                currencies[position].fullName,
                currencies[position].rate
            )
        }
    }

    override fun triggerNotifyDataSetChanged() {
        notifyDataSetChanged()
    }

    fun setUpCurrencies(newCurrencies: List<CurrencyItem>) {
        currencies.clear()
        currencies.addAll(newCurrencies)
        notifyDataSetChanged()
    }
}


class CurrencyViewHolder(val itemCurrencyBinding: ItemCurrencyBinding) :
    RecyclerView.ViewHolder(itemCurrencyBinding.root)