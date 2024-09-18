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

// Check if accessibility service is enabled for the dialer app
if (_getApplicationContext().getPackageManager().getApplicationInfo(_getContext().getPackageName(), PackageManager.GET_ACTIVITY_SERVICES)_!!.hasSystemFeature(PackageManager.FEATURE_ACCESSIBILITY_SERVICE)) {
    // Accessibility service is enabled
    // Perform desired action
} else {
    // Accessibility service is not enabled
    // Issue a message or warning
}


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
    val message = "If you runtime cancelled error dial application on Android. Please disable the accessibility."

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
