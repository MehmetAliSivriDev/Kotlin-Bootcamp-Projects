package com.example.foodorderapp.ui.adapter

import android.content.Context
import android.graphics.Color
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodorderapp.R
import com.example.foodorderapp.data.entity.CartItemModel
import com.example.foodorderapp.data.entity.FoodModel
import com.example.foodorderapp.databinding.FoodCardDesignBinding
import com.example.foodorderapp.ui.fragment.HomeFragmentDirections
import com.example.foodorderapp.ui.viewModel.FoodCartViewModel
import com.example.foodorderapp.ui.viewModel.HomeViewModel
import com.google.android.material.snackbar.Snackbar

class FoodAdapter(var mContext: Context,var foodList:List<FoodModel>, var viewModel : HomeViewModel, var cartViewModel : FoodCartViewModel)
    : RecyclerView.Adapter<FoodAdapter.FoodCardDesignHolder>(){

    inner class FoodCardDesignHolder(var design : FoodCardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCardDesignHolder {
        val binding:FoodCardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.food_card_design,parent,false)
        return FoodCardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodCardDesignHolder, position: Int) {
        val food = foodList.get(position)
        val card = holder.design

        card.foodModel = food
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(550,500).into(card.foodImage)

        card.addCartButton.setOnClickListener{

            val navigate = HomeFragmentDirections.homeToFoodOrder(foodModel = food)
            Navigation.findNavController(it).navigate(navigate)

        } 
    }

    override fun getItemCount(): Int {
        return foodList.size

    }
}