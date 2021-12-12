package com.naniak.appcores

import android.content.Context
import android.content.SharedPreferences
import android.graphics.ColorSpace
import android.os.Bundle
import android.util.Log
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
       val  prefs = getActivity()?.getSharedPreferences("CORES", Context.MODE_PRIVATE);
        val hex =  prefs?.getString("HEX",null)
        val R =  prefs?.getInt("R",0)
        val G =  prefs?.getInt("G",0)
        val B =  prefs?.getInt("B",0)
        val resultado =  prefs?.getInt("RESULTADO",0)

        val modelo = resultado?.let { RgbModel(resultado = it, Triple(R,G,B),hex) }

        val lista = mutableListOf<RgbModel>()
        modelo?.let { lista.add(it) }


       // Log.d("TESTE", "onViewCreated: $valor ")



            //val listcor = listOf(lista)


        val adapter = RgbAdapter(lista)
        binding?.rvCoresFragmentList?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvCoresFragmentList?.adapter = adapter
    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}