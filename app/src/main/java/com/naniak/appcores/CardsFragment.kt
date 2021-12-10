package com.naniak.appcores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.naniak.appcores.adapter.RgbAdapter
import com.naniak.appcores.adapter.RgbModel
import com.naniak.appcores.databinding.FragmentCardsBinding

class CardsFragment : Fragment() {

    private  var binding: FragmentCardsBinding? = null
    private val args: CardsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

      //  Log.d("TESTE", "onCreateView: CardFragment ", )
       binding = FragmentCardsBinding.inflate(inflater,container,false)


        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  Log.d("TESTE", "onViewCreated: CardFragment ")


        val colors = args.rgbModel as RgbModel

        val listcor = listOf(colors)


        val adapter = RgbAdapter(listcor)
        binding?.rvCoresFragmentList?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvCoresFragmentList?.adapter = adapter
    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}