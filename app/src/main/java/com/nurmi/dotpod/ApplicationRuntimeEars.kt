package com.nurmi.dotpod

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.nurmi.dotpod.R // Adjust to your own package structure
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.telephony.TelephonyManager
import android.widget.Toast

class CallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null && context != null) {
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)

            if (state == TelephonyManager.EXTRA_STATE_IDLE) {
                handleCallCancelled(context)
            }
        }
    }

    private fun handleCallCancelled(context: Context) {
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val isBluetoothConnected = audioManager.isBluetoothA2dpOn || audioManager.isBluetoothScoOn

        if (!isBluetoothConnected) {
            audioManager.mode = AudioManager.MODE_IN_COMMUNICATION
            
            // Force audio routing to the earpiece
            audioManager.setSpeakerphoneOn(false)
            Toast.makeText(context, "Audio routed to earpiece", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Bluetooth is connected. No action taken.", Toast.LENGTH_SHORT).show()
        }
    }
}

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
