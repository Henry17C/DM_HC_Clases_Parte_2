package com.examenp.dillan.dispositivosm_recyclewie_dc.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.examenp.dillan.dispositivosm_recyclewie_dc.R
import com.examenp.dillan.dispositivosm_recyclewie_dc.databinding.FragmentDetailBinding
import com.examenp.dillan.dispositivosm_recyclewie_dc.logic.entities.FullInfoAnimeLG
import com.examenp.dillan.dispositivosm_recyclewie_dc.logic.usercases.jikan.JikanAnimeUserCase
import com.examenp.dillan.dispositivosm_recyclewie_dc.ui.viewmodels.DetailViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    val args: DetailFragmentArgs by navArgs() //el by es un delegado

    private var usersList: FullInfoAnimeLG? = null

    private val detailVM: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentDetailBinding.bind(inflater.inflate(R.layout.fragment_detail, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        initListener()
        detailVM.loadInfoAnime(args.idAnime)
    }

    private fun initListener() {
        binding.btnRefresh.setOnClickListener {
            detailVM.loadInfoAnime(28977)
        }
    }

    private fun initObservers() {
        detailVM.anime.observe(requireActivity()) { anime ->
            binding.txtTitleEnglish.text = anime.name
            binding.txtEpisodes.text = anime.type
            binding.imgAnime.load(anime.big_image)
        }

        detailVM.error.observe(requireActivity()) { errorMesage ->
            Snackbar
                .make(
                    requireActivity(),
                    binding.btnRefresh,
                    errorMesage, Snackbar.LENGTH_LONG
                ).show()
        }
    }


    private fun loadDataRecyclerView() {
        var id = args.idAnime.toInt()

        lifecycleScope.launch(Dispatchers.Main) {

            val resp = withContext(Dispatchers.IO) {
                JikanAnimeUserCase().getFullAnimeInfo(id)
            }
            resp.onSuccess {
                binding.txtIdAnime.text = id.toString()
                binding.txtDuration.text = it.duration.toString()
                binding.txtTitleEnglish.text = it.name.toString()
                binding.txtEpisodes.text = it.duration.toString()
                binding.txtYear.text = it.year.toString()
                binding.txtUrl.text = it.url.toString()

            }
            resp.onFailure { ex ->
                Snackbar.make(
                    requireActivity(),
                    binding.linear,
                    ex.message.toString(),
                    Snackbar.LENGTH_LONG
                ).show()
            }


        }
    }


}