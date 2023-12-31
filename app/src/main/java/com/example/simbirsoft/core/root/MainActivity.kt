package com.example.simbirsoft.core.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simbirsoft.notes.ui.NotesFragment
import com.example.simbirsoft.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, NotesFragment())
                .commit()
        }
    }
}