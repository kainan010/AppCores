package com.naniak.appcores

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.naniak.appcores.adapter.RgbAdapter
import com.naniak.appcores.adapter.RgbModel
import com.naniak.appcores.databinding.FragmentCardsBinding
import io.paperdb.Paper

class CardsFragment : Fragment() {

    private  var binding: FragmentCardsBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCardsBinding.inflate(inflater,container,false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  Log.d("TESTE", "onViewCreated: CardFragment ")
  /*     val  prefs = getActivity()?.getSharedPreferences("CORES", Context.MODE_PRIVATE);
        val  gson = Gson()
        val json = prefs?.getString("OBJETO", null);
        val  obj = gson.fromJson(json,RgbModel::class.java)*/
        val lista = mutableListOf<RgbModel?>()
        val cores = Paper.book().read("model", lista)







        val adapter = RgbAdapter(cores)
        binding?.rvCoresFragmentList?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvCoresFragmentList?.adapter = adapter
    }

      /*  fun createModel(hex:String?,R:Int?,G:Int?,B:Int?,resultado:Int?): RgbModel?{

            val lista= mutableListOf<RgbModel>()


            return RgbModel(resultado!!,Triple(R,G,B),hex)
        }*/

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}