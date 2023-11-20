package id.web.devin.penjualankendaraan.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import id.web.devin.penjualankendaraan.R
import id.web.devin.penjualankendaraan.databinding.FragmentStokBinding
import id.web.devin.penjualankendaraan.viewmodel.ListStokViewModel

class StokFragment : Fragment() {
    private lateinit var b:FragmentStokBinding
    private lateinit var vmStok:ListStokViewModel
    private val stokListAdapter = StokAdapter(arrayListOf(), listOf(), listOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        b = FragmentStokBinding.inflate(layoutInflater)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vmStok = ViewModelProvider(this).get(ListStokViewModel::class.java)

        b.recViewStok.layoutManager = GridLayoutManager(context, 2)
        b.recViewStok.adapter = stokListAdapter

//        vmStok.refresh()
        observeView()
    }

    private fun observeView() {
        vmStok.stokLD.observe(viewLifecycleOwner, Observer {
            stokListAdapter.updateStokList(it)
        })
    }
}