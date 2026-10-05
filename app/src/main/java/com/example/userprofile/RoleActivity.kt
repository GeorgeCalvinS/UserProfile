package com.example.userprofile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RoleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_role)

        val btnAdmin = findViewById<Button>(R.id.btnAdmin)
        val btnUser = findViewById<Button>(R.id.btnUser)
        val btnGuest = findViewById<Button>(R.id.btnGuest)

        fun selectRoleAndReturn(roleName: String) {
            val resultIntent = Intent()
            resultIntent.putExtra("SELECTED_ROLE", roleName)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        btnAdmin.setOnClickListener { selectRoleAndReturn("Admin") }
        btnUser.setOnClickListener { selectRoleAndReturn("User") }
        btnGuest.setOnClickListener { selectRoleAndReturn("Guest") }
    }
}