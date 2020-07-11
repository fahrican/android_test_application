package com.revolut.androidtestapplication.ui.adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.revolut.androidtestapplication.R
import com.revolut.androidtestapplication.databinding.ItemCurrencyBinding
import com.revolut.androidtestapplication.internal.userEnteredAmount
import com.revolut.androidtestapplication.model.CurrencyItem
import com.revolut.androidtestapplication.ui.view.MoveObjectListener
import kotlinx.android.synthetic.main.item_currency.view.*
import java.lang.ref.WeakReference
import kotlin.collections.ArrayList


class CurrencyAdapter(
    val currencies: ArrayList<CurrencyItem>
) : RecyclerView.Adapter<CurrencyViewHolder>() {


    lateinit var adapterContext: Context
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
        holder.itemCurrencyBinding.currencyCard.setOnClickListener {
            Toast.makeText(
                adapterContext,
                "Taped on ${currencies[position].shortName}",
                Toast.LENGTH_SHORT
            ).show()
            //listener?.get()?.moveObjectToFirstPlace(position, currencies[position])
            listener?.get()?.moveObjectToFirstPlace(
                position,
                currencies[position].flag,
                currencies[position].shortName,
                currencies[position].fullName,
                currencies[position].rate
            )
        }
        /*currencyAdapter.viewHolder.itemCurrencyBinding.currencyRate.addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                Log.v("onBindViewHolder", "afterTextChanged -> ${p0.toString()}")
                Log.v("onBindViewHolder after", "$userEnteredAmount")
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.v("onBindViewHolder", "beforeTextChanged")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.v("onBindViewHolder before", "$userEnteredAmount")
                userEnteredAmount = p0.toString().toDouble()
                Log.v("onBindViewHolder after", "$userEnteredAmount")
            }
        })*/
    }

    fun setUpCurrencies(newCurrencies: List<CurrencyItem>) {
        currencies.clear()
        currencies.addAll(newCurrencies)
        notifyDataSetChanged()
    }
}


class CurrencyViewHolder(val itemCurrencyBinding: ItemCurrencyBinding) :
    RecyclerView.ViewHolder(itemCurrencyBinding.root)