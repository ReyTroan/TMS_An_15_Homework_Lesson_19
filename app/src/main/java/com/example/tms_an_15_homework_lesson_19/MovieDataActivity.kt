package com.example.tms_an_15_homework_lesson_19

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MovieDataActivity : AppCompatActivity() {

    private lateinit var movieName: EditText
    private lateinit var movieGen: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_data)

        movieName = findViewById(R.id.movieName)
        movieGen = findViewById(R.id.movieGen)
        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val names = movieName.text.toString()
        val genre = movieGen.text.toString()

        val resultIntent = Intent()
        resultIntent.putExtra("name", names)
        resultIntent.putExtra("genre", genre)

        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}
