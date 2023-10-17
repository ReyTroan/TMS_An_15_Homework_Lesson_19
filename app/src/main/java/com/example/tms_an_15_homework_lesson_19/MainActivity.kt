package com.example.tms_an_15_homework_lesson_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_15_homework_lesson_19.model.MovieData
import com.example.tms_an_15_homework_lesson_19.view.CustomAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var movieList: ArrayList<MovieData>
    private lateinit var movieAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieList = ArrayList()

        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.mRecycler)

        movieAdapter = CustomAdapter(movieList)

        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = movieAdapter


        addsBtn.setOnClickListener {
            val intent = Intent(this, MovieDataActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val name = data?.getStringExtra("name")
        val genre = data?.getStringExtra("genre")
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        movieList.add(MovieData("Name: $name", "Genre: $genre", currentDate))
        movieAdapter.notifyItemInserted(movieList.size - 1)
    }
}


