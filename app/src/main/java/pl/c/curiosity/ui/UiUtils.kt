package pl.c.curiosity.ui

import android.content.Context
import androidx.annotation.StringRes
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import pl.c.curiosity.R

fun showMaterialDialog(context: Context, @StringRes messageId: Int){
    MaterialAlertDialogBuilder(context)
        .setMessage(messageId)
        .setNegativeButton(context.getText(R.string.close)){ dialog, _ ->
            dialog.dismiss()
        }
        .show()
}