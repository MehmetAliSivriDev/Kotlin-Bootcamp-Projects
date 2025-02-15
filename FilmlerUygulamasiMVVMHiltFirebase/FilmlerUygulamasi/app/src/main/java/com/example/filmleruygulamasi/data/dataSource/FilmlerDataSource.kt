package com.example.filmleruygulamasi.data.dataSource

import androidx.lifecycle.MutableLiveData
import com.example.filmleruygulamasi.data.entity.Filmler
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDataSource(var collectionFilmler:CollectionReference) {
    var filmlerListesi = MutableLiveData<List<Filmler>>()

    fun filmleriYukle() : MutableLiveData<List<Filmler>> {

        collectionFilmler.get().addOnCompleteListener {
            val liste = ArrayList<Filmler>()

            for(d in it.result){
                val film = d.toObject(Filmler::class.java)
                film.id = d.id
                liste.add(film)
            }

            filmlerListesi.value = liste

        }
        return filmlerListesi
    }
}