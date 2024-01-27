package com.examenp.dillan.dispositivosm_recyclewie_dc.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.examenp.dillan.dispositivosm_recyclewie_dc.R
import com.examenp.dillan.dispositivosm_recyclewie_dc.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {



    private lateinit var binding: FragmentDetailBinding

     val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailBinding.bind(inflater.inflate(R.layout.fragment_detail, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtIdAnime.text= args.idAnime.toString()
        binding.animDesc.text=args.animeDesc.toString()
       binding.animName.text=args.animeNombre.toString()
        binding.imgAnim.load(args.animeImg)
    }

}