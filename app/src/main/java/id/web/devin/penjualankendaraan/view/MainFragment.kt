package id.web.devin.penjualankendaraan.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.web.devin.penjualankendaraan.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var b:FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        b = FragmentMainBinding.inflate(layoutInflater)
        return b.root
    }
}