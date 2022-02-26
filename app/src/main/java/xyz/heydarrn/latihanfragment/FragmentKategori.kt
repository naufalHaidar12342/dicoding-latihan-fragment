package xyz.heydarrn.latihanfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class FragmentKategori : Fragment(), View.OnClickListener {
    lateinit var btnDetailKategori:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kategori, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDetailKategori = view.findViewById(R.id.button_detail_kategori)
        btnDetailKategori.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        //TODO("Not yet implemented")
        if (p0?.id==R.id.button_detail_kategori){
            val mFragmentDetailKategori=FragmentDetailKategori()

            //mengirim String dengan Bundle
            val mBundle=Bundle()
            mBundle.putString(FragmentDetailKategori.EXTRA_NAME," ✨ Lifestyle")
            val deskripsi="Kategori ini akan berisi produk lifestyle"

            mFragmentDetailKategori.arguments=mBundle
            mFragmentDetailKategori.description=deskripsi

            val mFragmentManager=parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container,mFragmentDetailKategori,FragmentDetailKategori::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}