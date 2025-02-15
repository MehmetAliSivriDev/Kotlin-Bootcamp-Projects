package com.example.foodorderapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderapp.R
import com.example.foodorderapp.data.entity.CartItemModel
import com.example.foodorderapp.data.entity.FoodModel
import com.example.foodorderapp.databinding.CartItemDesignBinding
import com.example.foodorderapp.databinding.FragmentFoodCartBinding
import com.example.foodorderapp.ui.viewModel.FoodCartViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class CartItemAdapter(var mContext: Context, var cartItems : List<CartItemModel>,var viewModel : FoodCartViewModel, var binding : FragmentFoodCartBinding)
    : RecyclerView.Adapter<CartItemAdapter.CartItemDesignHolder>(){

    inner class CartItemDesignHolder(var design : CartItemDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemDesignHolder {
        val binding:CartItemDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.cart_item_design,parent,false)
        return CartItemDesignHolder(binding)

    }

    override fun onBindViewHolder(holder: CartItemDesignHolder, position: Int) {
        var cartItem = cartItems.get(position)
        var card = holder.design

        card.cartItemModel = cartItem

        card.buttonDelete.setOnClickListener {
            MaterialAlertDialogBuilder(mContext)
                .setTitle("Sepetten Çıkarma")
                .setMessage("${cartItem.yemek_adi} adlı ürünü sepetten çıkartmak istediğinize emin misiniz?")
                .setPositiveButton("Tamam"){d,i ->
                    viewModel.deleteFoodFromCart(binding,cartItem.yemek_adi)
                    Snackbar.make(it,"Ürün sepetten başarıyla kaldırıldı",Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("İptal"){d,i ->

                }
                .show()
        }

    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

}