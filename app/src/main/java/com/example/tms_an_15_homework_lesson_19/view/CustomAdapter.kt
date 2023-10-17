package com.example.tms_an_15_homework_lesson_19.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_15_homework_lesson_19.R
import com.example.tms_an_15_homework_lesson_19.model.MovieData

class CustomAdapter(val moviesList: ArrayList<MovieData>) :
    RecyclerView.Adapter<CustomAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name = v.findViewById<TextView>(R.id.mTitle)
        val mvGen = v.findViewById<TextView>(R.id.mSubTitle)
        val date = v.findViewById<TextView>(R.id.mDate)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val newList = moviesList[position]
        holder.name.text = newList.movieName
        holder.mvGen.text = newList.movieGenre
        holder.date.text = newList.currentData
    }
}