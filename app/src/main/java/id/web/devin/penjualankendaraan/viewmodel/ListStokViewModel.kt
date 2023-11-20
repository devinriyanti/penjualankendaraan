package id.web.devin.penjualankendaraan.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import id.web.devin.penjualankendaraan.model.Kendaraan
import id.web.devin.penjualankendaraan.model.PenjualanDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListStokViewModel(application: Application):AndroidViewModel(application), CoroutineScope {
    val stokLD = MutableLiveData<List<Kendaraan>>()
    private var job = Job()

    fun refresh(){
//        launch {
//            val db = Room.databaseBuilder(getApplication(),
//            PenjualanDatabase::class.java, "penjualandb").build()
//            stokLD.value = db.penjualanDAO().selectAllKendaraan()
//        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

}