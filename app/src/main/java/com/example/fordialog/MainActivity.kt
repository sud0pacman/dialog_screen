package com.example.fordialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fordialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.showBtn.setOnClickListener() {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        // animation
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationClose

        val btnYes = dialog.findViewById<TextView>(R.id.btn_yes)
        val btnNo = dialog.findViewById<TextView>(R.id.btn_no)

        btnYes.setOnClickListener {
            "click on Yo'q".toToast()
        }

        btnNo.setOnClickListener {
            dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationClose
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun String.toToast() {
        Toast.makeText(this@MainActivity, this, Toast.LENGTH_SHORT).show()
    }
}