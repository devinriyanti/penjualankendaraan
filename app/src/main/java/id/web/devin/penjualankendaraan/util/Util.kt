package id.web.devin.penjualankendaraan.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.web.devin.penjualankendaraan.R
import java.lang.Exception
import java.text.NumberFormat
import java.util.*

fun ImageView.loadImage(url:String, progressBar: ProgressBar){
    Picasso.get()
        .load(url)
        .resize(1000,1300)
        .centerCrop()
        .error(R.drawable.baseline_error_24)
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
                progressBar.visibility = View.GONE
            }
        })
}

fun formatCurrency(amount: Double): String {
    val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance("IDR")
    val formattedAmount = format.format(amount)
    return formattedAmount.replace(Regex("\\.00$"), "")
}