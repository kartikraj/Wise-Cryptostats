package com.example.wise.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wise.R
import com.example.wise.model.Crypto

class CryptoAdapter: RecyclerView.Adapter<CryptoAdapter.MyViewHolder>() {

    var marketinfo = ArrayList<Crypto>()

    fun setUpdated(marketinfo: ArrayList<Crypto>) {
        this.marketinfo = marketinfo
        notifyDataSetChanged()
    }
    class  MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val mid = view.findViewById<TextView>(R.id.exchange_id)
        val msymbol = view.findViewById<TextView>(R.id.symbol)
        val mpriceun = view.findViewById<TextView>(R.id.price_unconverted)
        val mchange = view.findViewById<TextView>(R.id.change_24)
        val mspread = view.findViewById<TextView>(R.id.spread)
        val mvolume = view.findViewById<TextView>(R.id.volume_24h)
        val mstatus = view.findViewById<TextView>(R.id.status)
        val mtime = view.findViewById<TextView>(R.id.time)
        fun bind(data: Crypto){
            mid.text = data.exchange_id
            msymbol.text = data.symbol
            mpriceun.text = data.price_unconverted.toString();
            mchange.text = data.change_24h.toString()
            mspread.text = data.spread.toString()
            mvolume.text = data.volume_24h.toString()
            mstatus.text = data.status
            mtime.text = "Updated on :"+data.time
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  marketinfo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(marketinfo[position])
    }


}