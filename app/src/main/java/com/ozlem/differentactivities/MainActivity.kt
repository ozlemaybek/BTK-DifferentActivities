package com.ozlem.differentactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
// MainActivity ve XML arasındaki senkronizasyonu sağlamak için:
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("onCreate function called...")

    }

    override fun onStart() {
        super.onStart()
        println("onStart function called...")
    }

    override fun onResume() {
        super.onResume()
        println("onResume function called...")
    }

    override fun onPause() {
        super.onPause()
        println("onPause function called...")
    }

    override fun onStop() {
        super.onStop()
        println("onStop function called...")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy function called...")
    }

    fun onClickChangeActivity(view : View){
        // Ekran değişimini intent'ler yardımıyla yapıyoruz:
        // Intent benden sırayla context ve Class olmak üzere iki parametre isteyecek.
        // Context genel olarak içinde bulunduğumuz durumdur.
        // Activity'nin genel durumunu kontrol edebilmek için bazı context yapıları mevcut.
        // Burada context bulunduğumuz yer, Class ise gideceğimiz yer oluyor.
        // Context almak için applicationContext yazmamız yeterli.
        // "MainActivity2::class.java" yazımı; MainActivity2 sınıfına referans verir.
        val intent = Intent(applicationContext,MainActivity2::class.java)

        // Bir ekrandan diğer ekrana nasıl veri aktarırız?
        // Bunu yapmanın farklı yolları var.
        // Önce intent'lerle veri aktarmayı öğrenelim.
        // Intent sadece activitiy'yi başlatmak için kullanılmaz onunla birlikte verileri diğer tarafa yollayabiliriz:
        // Yollayacağımız veriyi alalım:
        val userData = plainTextNameID.text.toString()

        // Şimdi activity'yi başlatmadan önce veriyi yollayalım.
        // Put ile yollayıp get ile alabiliriz.
        // putExtra iki parametre alır. 1)anahtar kelime, 2) value(değer)
        // Anahtar kelimenin ne olduğu önemli değil.
        // Fakat başlattığımız activity'de veriyi alırken bu anahtar kelimeyi kullanacağız:
        intent.putExtra("dataSent" , userData)

        // Activity'ye geçişi başlatmak için startActivity() metodunu kullanırız.
        // Bu metod bizden bir Intent parametresi ister.
        // MainActivity2'yi başlatalım:
        startActivity(intent)
        // startActivity dedikten sonra finish() dersek İkinci activity'ye geçtiği anda birinci activity'yi yok eder
        // ve onDestroy çağrılır:
        finish()
    }
}