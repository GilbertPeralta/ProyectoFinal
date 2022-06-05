package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectofinal.databinding.FragmentProfileBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONArray

class ProfileFragment : Fragment(){
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View?{
        binding = FragmentProfileBinding.inflate(layoutInflater)
        val database = Firebase.database
        val myRef = database.reference

//        myRef.child("Usuarios").child("1").setValue(Users("JoseAlberto", "5", "10"))
//        myRef.child("Usuarios").child("2").setValue(Users("MariaJose", "2", "1"))
//        myRef.child("Usuarios").child("3").setValue(Users("JuanPanfilo", "3", "4"))

        myRef.child("Usuarios").get().addOnSuccessListener { response ->
            val resmap = response.value as ArrayList<Map <String, String>>
            Log.d("firebaseRes", resmap.toString())
            resmap.forEach{ Usuario ->
                if(!Usuario.isNullOrEmpty()){
                    Log.d("firebaseRes", "Nombre : ${Usuario["nombre"]}")
                    binding.tvNombre.setText("${Usuario["nombre"]}")
                    binding.tvNivel.setText("${Usuario["nivel"]}")
                    binding.tvProductos.setText("${Usuario["productos"]}")
                }
            }}.addOnFailureListener{
            Log.e("firebaseRes", "Error getting data", it)
        }
        return binding.root
    }

}