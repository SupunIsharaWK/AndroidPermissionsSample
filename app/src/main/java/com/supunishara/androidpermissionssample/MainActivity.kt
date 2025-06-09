package com.supunishara.androidpermissionssample

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val xmlButton: Button = findViewById(R.id.btnXmlPermission)
        val composeButton: Button = findViewById(R.id.btnComposePermission)

        xmlButton.setOnClickListener {
            startActivity(Intent(this, XmlPermissionActivity::class.java))
        }

        composeButton.setOnClickListener {
            startActivity(Intent(this, ComposePermissionActivity::class.java))
        }
    }
}