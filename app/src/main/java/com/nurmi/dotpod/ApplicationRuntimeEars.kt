package com.nurmi.dotpod

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.dotpod.R // Adjust to your own package structure

fun showRuntimeCancelledDialog(context: Context) {
    val title = "If you enabled is apps buds"
    val message = "Runtime-cancelled the do the dialer!"

    val alertDialogBuilder = AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss() // Dismiss the dialog.
        }

    // Create the AlertDialog and show it
    val alertDialog = alertDialogBuilder.create()
    alertDialog.show()

     showRuntimeCancelledDialog(this) // Call this from an Activity
}
