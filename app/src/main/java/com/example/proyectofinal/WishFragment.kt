package com.example.proyectofinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyectofinal.databinding.FragmentWishBinding
import org.json.JSONObject

class WishFragment : Fragment() {
    private lateinit var binding: FragmentWishBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWishBinding.inflate(layoutInflater)


//        val fakeVideoData: Array<JSONObject> = arrayOf(
//            JSONObject("{\"nombre\": \"Producto\", \"precio\": \"89\", \"descripcion\": \"Roto\", \"calificacion\": \"5 \"}"),
//            JSONObject("{\"nombre\": \"Producto1\", \"precio\": \"99\", \"descripcion\": \"Rota\", \"calificacion\": \"3 \"}"),
//            JSONObject("{\"nombre\": \"Producto2\", \"precio\": \"100\", \"descripcion\": \"Rote\", \"calificacion\": \"4 \"}"),
//        )
//        binding.rvWishEntries.adapter = WishAdapter(fakeVideoData)
        return binding.root
    }
}