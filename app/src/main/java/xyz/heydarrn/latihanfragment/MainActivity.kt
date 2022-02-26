package xyz.heydarrn.latihanfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager=supportFragmentManager
        val homeFragment=HomeFragment()
        val fragment=fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment ){
            Log.d("MyFlexibleFragment", "Fragment name : " +HomeFragment::class.java.simpleName)
            //kita tambahkan HomeFragment ke dalam activity, menggunakan add()
            fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,homeFragment,HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}