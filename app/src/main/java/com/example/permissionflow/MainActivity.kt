package com.example.permissionflow

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mylibrary.PermissionHelper
import com.example.permissionflow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
    }

    private fun initData() {
        binding.btnPhoneCall.setOnClickListener {
            PermissionHelper.request(
                this,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS,
            ) { allPassed, deniedList ->
                if (allPassed) {
                    val callIntent = Intent(Intent.ACTION_CALL)
                    callIntent.data = Uri.parse("tel:10086")
                    startActivity(callIntent)
                } else {
                    Toast.makeText(this, "你拒绝了权限：$deniedList", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}