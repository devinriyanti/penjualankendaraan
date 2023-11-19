package id.web.devin.penjualankendaraan.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Kendaraan::class), version = 1)
abstract class PenjualanDatabase:RoomDatabase() {
    abstract fun penjualanDAO(): PenjualanDAO
    companion object{
        @Volatile private var instance:PenjualanDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PenjualanDatabase::class.java,
            "penjualandb"
        ).build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
            buildDatabase(context)
        }
    }
}