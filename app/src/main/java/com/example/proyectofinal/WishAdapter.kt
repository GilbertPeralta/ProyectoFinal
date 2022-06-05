package com.example.proyectofinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.databinding.ItemWishlistBinding
import org.json.JSONObject

class WishAdapter(private val products: Array<JSONObject>): RecyclerView.Adapter<WishAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishAdapter.MainHolder {
        val binding = ItemWishlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: WishAdapter.MainHolder, position: Int) {
        holder.render(products[position])
    }

    override fun getItemCount(): Int = products.size

    class MainHolder(val binding: ItemWishlistBinding): RecyclerView.ViewHolder(binding.root){
        fun render(product: JSONObject){
            binding.tvNombreProducto.setText(product.getString("nombre"))
            binding.tvPrecio.setText(product.getString("precio"))
            binding.tvDescripcion.setText(product.getString("descripcion"))
            binding.tvCalificacion.setText(product.getString("calificacion"))
        }
    }
}