package com.example.clickup.Activivties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.clickup.R
import com.example.clickup.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var notes=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(findViewById<BottomNavigationView>(binding.bottomNav.id), navController)
        val db = Firebase.database
        val myRef = db.reference
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val snap= snapshot.hasChild("Notes")
                if(snap){
                    val count=snapshot.child("Notes").childrenCount
                    for(i in 0 ..count-1){
                        notes.add(snapshot.child("Notes").child(i.toString()).value.toString())
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) { }
        })
        binding.fab.setOnClickListener {
            val database = Firebase.database
            val myRef = database.getReference("message")
            myRef.setValue("Hello, World!")



        }
    }
}