package id.web.devin.penjualankendaraan.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(entity = Warna::class, parentColumns = ["idwarna"], childColumns = ["idwarna"]),
    ForeignKey(entity = Jenis::class, parentColumns = ["idjenis"], childColumns = ["idjenis"])
])
data class Kendaraan(
    var tahun_keluaran:String,
    var harga:Double,
    var stok:Int,
    var idwarna:Int,
    var idjenis:Int
){
    @PrimaryKey(autoGenerate = true)
    var idkendaraan:Int = 0
}

@Entity
data class Warna(
    var nama:String
){
    @PrimaryKey(autoGenerate = true)
    var idwarna:Int = 0
}

@Entity
data class Jenis(
    var nama:String,
    var mesin:String,
    var tipe_suspensi:String,
    var tipe_transmisi:String,
    var kapasitas_penumpang:String,
    var tipe:String
){
    @PrimaryKey(autoGenerate = true)
    var idjenis:Int = 0
}

@Entity
data class Penjualan(
    var tanggal:String,
    var total_harga:String,
){
    @PrimaryKey(autoGenerate = true)
    var idpenjualan:Int = 0
}

@Entity(tableName = "detail_penjualan",primaryKeys = ["idkendaraan", "idpenjualan"])
data class DetailPenjualan(
    var idkendaraan:Int,
    var idpenjualan:Int,
    var kuantitas:Int,
    var harga:Double,
)