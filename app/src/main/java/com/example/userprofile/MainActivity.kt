package com.example.userprofile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvRoleValue: TextView
    private lateinit var tvEmailValue: TextView
    private lateinit var tvPhoneValue: TextView

    private val roleActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val selectedRole = result.data?.getStringExtra("SELECTED_ROLE")
            if (selectedRole != null) { tvRoleValue.text = selectedRole
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutEmail = findViewById<LinearLayout>(R.id.layoutEmail)
        val layoutPhone = findViewById<LinearLayout>(R.id.layoutPhone)
        val layoutRole = findViewById<LinearLayout>(R.id.layoutRole)

        tvEmailValue = findViewById(R.id.tvEmailValue)
        tvPhoneValue = findViewById(R.id.tvPhoneValue)
        tvRoleValue = findViewById(R.id.tvRoleValue)

        layoutEmail.setOnClickListener {
            val emailStr = tvEmailValue.text.toString()
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$emailStr")
            }
            startActivity(emailIntent)
        }

        layoutPhone.setOnClickListener {
            val phoneStr = tvPhoneValue.text.toString()
            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneStr")
            }
            startActivity(phoneIntent)
        }

        layoutRole.setOnClickListener {
            val intent = Intent(this, RoleActivity::class.java)
            roleActivityResultLauncher.launch(intent)
        }
    }
}