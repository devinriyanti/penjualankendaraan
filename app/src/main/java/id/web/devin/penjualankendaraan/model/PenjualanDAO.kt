package id.web.devin.penjualankendaraan.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PenjualanDAO {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(vararg kendaraan: Kendaraan)
//
//    @Query("SELECT * FROM kendaraan")
//    suspend fun selectAllKendaraan():List<Kendaraan>
//
//    @Delete
//    suspend fun deleteKendaraan(kendaraan: Kendaraan)
}
