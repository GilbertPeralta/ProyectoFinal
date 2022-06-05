package com.example.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectofinal.databinding.FragmentSearchBinding
import com.example.proyectofinal.remote.ProductsEntry
import com.example.proyectofinal.remote.RetrofitBuilder
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment(){
    private lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View?{
        binding = FragmentSearchBinding.inflate(layoutInflater)

        binding.btnBuscar.setOnClickListener {
            val productid = binding.etSearch.text.toString()
            val retrofit = RetrofitBuilder.create().getProductById("${productid}")

            retrofit.enqueue(object: Callback<ProductsEntry> {
                override fun onResponse(call: Call<ProductsEntry>, response: Response<ProductsEntry>) {
                    val nombre = response.body()?.title
                    if(nombre != null){
                        Log.d("retrofitRes", "nombre: ${nombre}")
                        binding.tvNombreProducto.setText(nombre)

                    }

                    val descricion = response.body()?.description
                    if(descricion != null){
                        Log.d("retrofitRes", "descr: ${descricion}")
                        binding.tvDescripcion.setText(descricion)
                    }

                    val precio = response.body()?.price
                    if(precio != null){
                        Log.d("retrofitRes", "precio: ${precio}")
                        binding.tvPrecio.setText(precio.toString())

                    }

                    val calificacion = response.body()?.rating
                    if(calificacion != null){
                        Log.d("retrofitRes", "cal: ${calificacion}")
                        binding.tvCalificacion.setText(calificacion.toString())
                    }
                    



                }

                override fun onFailure(call: Call<ProductsEntry>, t: Throwable) {
                    Log.e("retrofitRes","Error: ${t.message}")
                }
            })

        }


//        binding.rvSearchEntries.adapter = SearchAdapter(res)
        return binding.root
    }
}