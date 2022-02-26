package xyz.heydarrn.latihanfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class FragmentDetailKategori : Fragment() {
    lateinit var tvNamaKategori:TextView
    lateinit var tvDeskripsiKategori:TextView
    lateinit var btnTampilkanProfil:Button
    lateinit var btnTampilkanDialog:Button

    var description: String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }

    internal var optionListener:FragmentDialogKuis.OnOptionDialogListener=object :FragmentDialogKuis.OnOptionDialogListener{
        override fun opsiDipilih(text: String?) {
            Toast.makeText(requireActivity(),text,Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_kategori, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvDeskripsiKategori=view.findViewById(R.id.tv_deskripsi_kategori)
        tvNamaKategori=view.findViewById(R.id.tv_nama_kategori)
        btnTampilkanDialog=view.findViewById(R.id.button_show_dialog)
        btnTampilkanProfil=view.findViewById(R.id.button_profil)

        //savedInstansce adalah Bundle. kemudian kita cek jika tidak null
        if (savedInstanceState!=null){
            //mengambil kiriman dari FragmentKategori. Dikirim dengan Bundle
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }
        //akan mengembalikan arguments ketika fragment di bentuk
        if (arguments!=null){
            val NAMA_KATEGORI=arguments?.getString(EXTRA_NAME)
            tvNamaKategori.text=NAMA_KATEGORI
            tvDeskripsiKategori.text=description
        }

        btnTampilkanDialog.setOnClickListener {
            val tFragmentDialog=FragmentDialogKuis()
            val tFragmentManager=childFragmentManager

            tFragmentDialog.show(tFragmentManager,FragmentDialogKuis::class.java.simpleName)

        }

        btnTampilkanProfil.setOnClickListener {
            val intentTampilkanProfile=Intent(requireActivity(),ProfileActivity::class.java)
            startActivity(intentTampilkanProfile)
        }
    }
}