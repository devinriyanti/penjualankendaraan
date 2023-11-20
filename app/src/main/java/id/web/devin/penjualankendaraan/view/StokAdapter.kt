package id.web.devin.penjualankendaraan.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.web.devin.penjualankendaraan.databinding.StokItemBinding
import id.web.devin.penjualankendaraan.model.Jenis
import id.web.devin.penjualankendaraan.model.Kendaraan
import id.web.devin.penjualankendaraan.model.Warna
import id.web.devin.penjualankendaraan.util.formatCurrency

class StokAdapter(val stokList:ArrayList<Kendaraan>, val jenisList:List<Jenis>, val warnaList:List<Warna>):RecyclerView.Adapter<StokAdapter.StokViewHolder>() {
    class StokViewHolder(val b: StokItemBinding):RecyclerView.ViewHolder(b.root)

    fun updateStokList(newStokList: List<Kendaraan>) {
        stokList.clear()
        stokList.addAll(newStokList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StokAdapter.StokViewHolder {
        val b =StokItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StokViewHolder(b)
    }

    override fun onBindViewHolder(holder: StokAdapter.StokViewHolder, position: Int) {
        val stok = stokList[position]
        val jenis = jenisList.find { it.idjenis == stok.idjenis }
        val warna = warnaList.find { it.idwarna == stok.idwarna }
        with(holder.b){
            txtNamaKendaraan.text = jenis?.nama ?: "Unavailable"
            txtHargaKendaraan.text = formatCurrency(stok.harga)
            txtStokKendaraan.text = "Stok : ${stok.stok}"
            txtWarnaKendaraan.text = warna?.nama ?: "-"
        }
    }

    override fun getItemCount(): Int {
        return stokList.size
    }
}