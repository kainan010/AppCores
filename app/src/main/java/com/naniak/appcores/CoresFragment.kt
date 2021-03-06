package com.naniak.appcores

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.naniak.appcores.adapter.RgbModel
import com.naniak.appcores.databinding.FragmentCoresBinding
import io.paperdb.Paper

class CoresFragment : Fragment(), SeekBar.OnSeekBarChangeListener {


    private var binding: FragmentCoresBinding? = null
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //  Log.d("TESTE", "onCreateView: CoresFragment ", )
        // Inflate the layout for this fragment
        binding = FragmentCoresBinding.inflate(inflater, container, false)

        Paper.init(context)

        val sharedPref = context?.getSharedPreferences("CORES", Context.MODE_PRIVATE)
        var editor = sharedPref?.edit()
        val listaCores = mutableListOf<RgbModel>()
        binding?.apply {

            seekBarCoresVermelho.setOnSeekBarChangeListener(this@CoresFragment)
            seekBarCoresVerde.setOnSeekBarChangeListener(this@CoresFragment)
            seekBarCoresAzul.setOnSeekBarChangeListener(this@CoresFragment)


            botaoSorteio.setOnClickListener {

                val randomVermelho = (0..255).random()
                val randomVerde = (0..255).random()
                val randomAzul = (0..255).random()
                val resultado = Color.rgb(randomVermelho, randomVerde, randomAzul)


                seekBarCoresVermelho.progress = randomVermelho
                seekBarCoresVerde.progress = randomVerde
                seekBarCoresAzul.progress = randomAzul
                viewResultadoRgb.setBackgroundColor(resultado)




                val hexString = Integer.toHexString(resultado).uppercase()

                val model = RgbModel(resultado, Triple(randomVermelho, randomVerde, randomAzul), hexString)

                listaCores.add(model)

                Paper.book().write("model",listaCores)

                /*val gson = Gson()
                val json = gson.toJson(model)

                    editor?.apply {
                        putString("OBJETO",json)
                        apply()
                    }*/




            }


        }

        return binding?.root


    }


    @SuppressLint("SetTextI18n")
    override fun onProgressChanged(seekBar: SeekBar?, p1: Int, p2: Boolean) {
        binding?.let {

            it.textoValorCorVermelho.text = "Cor Vermelha : ${it.seekBarCoresVermelho.progress} "
            it.textoValorCorVerde.text = "Cor Verde : ${it.seekBarCoresVerde.progress} "
            it.textoValorCorAzul.text = "Cor Azul : ${it.seekBarCoresAzul.progress} "
            val cores = Color.rgb(
                it.seekBarCoresVermelho.progress,
                it.seekBarCoresVerde.progress,
                it.seekBarCoresAzul.progress
            )
            binding?.viewResultadoRgb?.setBackgroundColor(cores)
        }

    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}