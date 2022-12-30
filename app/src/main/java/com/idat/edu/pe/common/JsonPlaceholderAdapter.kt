package com.idat.edu.pe.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.idat.edu.pe.R
import com.idat.edu.pe.model.JsonPlacehoder

class JsonPlaceholderAdapter : RecyclerView.Adapter<JsonPlaceholderAdapter.ViewHolder> {

    var jsonplaceholderList: List<JsonPlacehoder>
    var context: Context

    constructor(context: Context, jsonplaceholderList: List<JsonPlacehoder>) {
        this.context = context
        this.jsonplaceholderList = jsonplaceholderList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.jsonplaceholder_template, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txvUserId.text = "UserId: ${jsonplaceholderList[position].userId}"
        holder.txvId.text = "Id: ${jsonplaceholderList[position].id}"
        holder.txvTitle.text = "Title: ${jsonplaceholderList[position].title}"
        holder.txvCompleted.text =
            "Completed: ${jsonplaceholderList[position].completed.toString()}"
    }

    override fun getItemCount(): Int {
        return jsonplaceholderList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvUserId: TextView
        val txvId: TextView
        val txvTitle: TextView
        val txvCompleted: TextView

        init {
            txvUserId = itemView.findViewById(R.id.txvUserId)
            txvId = itemView.findViewById(R.id.txvId)
            txvTitle = itemView.findViewById(R.id.txvTitle)
            txvCompleted = itemView.findViewById(R.id.txvCompleted)
        }
    }
}