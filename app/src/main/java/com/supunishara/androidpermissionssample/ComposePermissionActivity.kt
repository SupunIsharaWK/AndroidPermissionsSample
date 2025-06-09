package com.supunishara.androidpermissionssample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.supunishara.androidpermissionssample.ui.theme.AppTheme
import com.supunishara.androidpermissionssample.util.PermissionUtils

class ComposePermissionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                PermissionScreen()
            }
        }
    }

    @Composable
    fun PermissionScreen() {
        val context = this
        var granted by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                PermissionUtils.requestCameraPermission(context) {
                    granted = it
                }
            }) {
                Text("Request Camera Permission")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = if (granted) "✅ Permission Granted" else "❌ Not Granted")
        }
    }
}