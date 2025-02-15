package com.example.filmleruygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmleruygulamasi.R
import com.example.filmleruygulamasi.data.entity.Filmler
import com.example.filmleruygulamasi.databinding.CardTasarimBinding
import com.example.filmleruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext: Context, var filmlerListesi:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
       val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim ,parent,false)

        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        val card = holder.tasarim
        card.filmNesnesi = film

        card.imageViewFilm.setImageResource(mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))

        card.cardViewFilm.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayaGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }

        card.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${film.ad} Sepete Eklendi!", Snackbar.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}