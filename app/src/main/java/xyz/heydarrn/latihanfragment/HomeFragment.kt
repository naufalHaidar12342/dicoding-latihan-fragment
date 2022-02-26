package  xyz.heydarrn.latihanfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment(), View.OnClickListener {
    lateinit var keFragmentKategori:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        keFragmentKategori = view.findViewById(R.id.button_category)
        keFragmentKategori.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //TODO("Not yet implemented")
        if (v?.id  ==R.id.button_category){
            val kategoriFragment=FragmentKategori()
            val fragmentManager=parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container,kategoriFragment,FragmentKategori::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }


}