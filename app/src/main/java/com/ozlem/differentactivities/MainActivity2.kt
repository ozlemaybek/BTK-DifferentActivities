package com.ozlem.differentactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
// MainActivity2 ve XML arasındaki senkronizasyonu sağlamak için:
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Diğer ekrandan gelen veriyi alalım:
        // java'da getIntent() olarak isimlendirilirdi fakat kotlinde getIntent "intent" şeklinde yazılıyor:
        val intent = intent

        // Veriyi alırken hangi tip veri alacağımızı ve anahtar kelimeyi söylemeliyiz:
        // Aldığımız veriyi bir değişkene atayalım:
        val getData = intent.getStringExtra("dataSent")

        // Alınan veriyi MainActivity2'deki textView'a atayalım:
        textViewResultID.text = getData
    }

    fun onClickChangeScreen(view : View){
        // İlk ekrana geri dönmek için bir intent oluşturalım:
        val intent = Intent(applicationContext,MainActivity::class.java)
        // startActivity dediğim için gideceğim Activity baştan oluşturuluyor.
        // Bu yüzden onCreate o activity için baştan oluşturuluyor.
        startActivity(intent)
    }
}