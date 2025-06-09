package com.supunishara.androidpermissionssample.util

import android.Manifest
import android.content.pm.PackageManager
import android.content.Context
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

object PermissionUtils {
    fun requestCameraPermission(
        activity: Context,
        onResult: (Boolean) -> Unit
    ) {
        if (activity is AppCompatActivity) {
            val launcher = (activity as AppCompatActivity).activityResultRegistry.register(
                "camera_permission_request",
                ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                onResult(isGranted)
            }

            when {
                ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
                    onResult(true)
                }
                else -> {
                    launcher.launch(Manifest.permission.CAMERA)
                }
            }
        } else if (activity is ComponentActivity) {
            val launcher = (activity as ComponentActivity).activityResultRegistry.register(
                "camera_permission_request_compose",
                ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                onResult(isGranted)
            }

            when {
                ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
                    onResult(true)
                }
                else -> {
                    launcher.launch(Manifest.permission.CAMERA)
                }
            }
        } else {
            Toast.makeText(activity, "Permission context not supported", Toast.LENGTH_SHORT).show()
            onResult(false)
        }
    }
}