package pl.c.curiosity.ui

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
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

fun Activity.hideKeyboard(){
    currentFocus?.let { view ->
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}