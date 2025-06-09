package com.supunishara.androidpermissionssample

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.supunishara.androidpermissionssample.util.PermissionUtils

class XmlPermissionActivity : AppCompatActivity() {
    private lateinit var btnRequest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml)

        btnRequest = findViewById(R.id.btnGrantPermission)

        btnRequest.setOnClickListener {
            PermissionUtils.requestCameraPermission(this) { granted ->
                Toast.makeText(
                    this,
                    if (granted) "✅ Camera permission granted" else "❌ Camera permission denied",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}