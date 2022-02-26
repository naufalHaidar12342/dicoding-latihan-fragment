package xyz.heydarrn.latihanfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class FragmentDialogKuis : DialogFragment() {
    lateinit var tombolClose:Button
    lateinit var tombolPilih:Button
    lateinit var radioGrupKuis:RadioGroup
    lateinit var pilihanSirAlex:RadioButton
    lateinit var pilihanMourinho:RadioButton
    lateinit var pilihanLouisVanGaal:RadioButton
    lateinit var pilihanMoyes:RadioButton
    var optionListener:OnOptionDialogListener?=null

    interface OnOptionDialogListener {
        fun opsiDipilih(text:String?)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_kuis, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tombolClose=view.findViewById(R.id.button_close)
        tombolPilih=view.findViewById(R.id.button_choose)
        radioGrupKuis=view.findViewById(R.id.grup_opsi_jawaban)
        pilihanLouisVanGaal=view.findViewById(R.id.opsi_louis_van_gaal)
        pilihanMourinho=view.findViewById(R.id.opsi_mourinho)
        pilihanMoyes=view.findViewById(R.id.opsi_david_moyes)
        pilihanSirAlex=view.findViewById(R.id.opsi_sir_alex_ferguson)

        tombolPilih.setOnClickListener {
            val opsiDipilih=radioGrupKuis.checkedRadioButtonId
            if (opsiDipilih!=-1){
                var namaPelatih= when(opsiDipilih){
                    R.id.opsi_sir_alex_ferguson->pilihanSirAlex.text.toString().trim()
                    R.id.opsi_david_moyes->pilihanMoyes.text.toString().trim()
                    R.id.opsi_mourinho->pilihanMourinho.text.toString().trim()
                    R.id.opsi_louis_van_gaal->pilihanLouisVanGaal.text.toString().trim()
                    else ->null
                }

                optionListener?.opsiDipilih(namaPelatih)
                dialog?.dismiss()


            }
        }

        tombolClose.setOnClickListener {
            dialog?.cancel()
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment=parentFragment
        if (fragment is FragmentDetailKategori){
            this.optionListener=fragment.optionListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionListener=null
    }
}