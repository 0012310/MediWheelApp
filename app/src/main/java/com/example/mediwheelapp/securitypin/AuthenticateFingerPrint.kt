package com.example.mediwheelapp.securitypin
import android.app.Activity
import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.CancellationSignal
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.concurrent.Executor

abstract class AuthenticateFingerPrint : AppCompatActivity() {

    lateinit var executor: Executor
    lateinit var biometricPrompt: BiometricPrompt
    lateinit var promptInfo: BiometricPrompt.PromptInfo

    private var cancellationSignal: CancellationSignal? = null
    lateinit var context: Activity


    @RequiresApi(Build.VERSION_CODES.P)
    fun authintecate(context: Activity) {
        this.context = context
        executor = ContextCompat.getMainExecutor(context)
        if (checkBiometricSupport(context)) {
            showAuthDialog(context)
        }
    }

    private fun showAuthDialog(context: Activity) {
        biometricPrompt =
            BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    //   "Error $errString".notifyUser(context)
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    //   "Authentication Success!".notifyUser(context)
                    setResult(2000, Intent().putExtra("enter_pin", true))
                    finish()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    //      "Authentication Failed!".notifyUser(context)
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric Auth")
            .setSubtitle("Login using Fingerprint")
            .setNegativeButtonText("Cancel")
            .build()
        biometricPrompt.authenticate(promptInfo)
    }

    private fun checkBiometricSupport(context: Activity): Boolean {
        val keyguardManager: KeyguardManager =
            context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        if (!keyguardManager.isKeyguardSecure) {
            // notifyUser(context, "Fingerprint has not been enabled in settings.")
            return false
        }
        if (ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.USE_BIOMETRIC
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            //  notifyUser(context, "Fingerprint has not been enabled in settings.")
            return false
        }
        return if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_FACE)) {
            //  notifyUser(context, "Face auth is available.")
            true
        } else if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            //   notifyUser(context, "Fingerprint auth is available.")
            true
        } else true
    }

}



