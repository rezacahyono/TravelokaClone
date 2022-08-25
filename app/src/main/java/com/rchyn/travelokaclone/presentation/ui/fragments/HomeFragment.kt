package com.rchyn.travelokaclone.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayout
import com.rchyn.travelokaclone.databinding.FragmentHomeBinding
import com.rchyn.travelokaclone.domain.model.Cities
import com.rchyn.travelokaclone.presentation.adapter.HotelListAdapter
import com.rchyn.travelokaclone.presentation.adapter.PromoLandscapeListAdapter
import com.rchyn.travelokaclone.presentation.adapter.PromoListAdapter
import com.rchyn.travelokaclone.presentation.ui.fragments.menu.MenuPagerAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var menuPagerAdapter: MenuPagerAdapter
    private lateinit var promoLandscapeListAdapter: PromoLandscapeListAdapter
    private lateinit var hotelAdapter: HotelListAdapter
    private lateinit var hotelByCitiesAdapter: HotelListAdapter
    private lateinit var promoAdapter: PromoListAdapter

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menuPagerAdapter = MenuPagerAdapter(this)
        promoLandscapeListAdapter = PromoLandscapeListAdapter()
        hotelAdapter = HotelListAdapter { }
        hotelByCitiesAdapter = HotelListAdapter { }
        promoAdapter = PromoListAdapter {  }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPagerMenu = binding.pagerMenu
        viewPagerMenu.adapter = menuPagerAdapter

        binding.indicatorView.attachTo(viewPagerMenu)

        setupRecyclerPromoLandscape()
        setupRecyclerHotelFlashSale()
        setupRecyclerHotelByCities()
        setupRecyclerPromo()

        homeViewModel.time.observe(viewLifecycleOwner) { time ->
            binding.tvCountDownValue.text = time
        }

        binding.tabCities.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> homeViewModel.searchQuery.value = Cities.BALI
                    1 -> homeViewModel.searchQuery.value = Cities.JAKARTA
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    private fun setupRecyclerPromoLandscape() {
        binding.recyclerPromoLandscape.adapter = promoLandscapeListAdapter
        homeViewModel.listPromoLandscape.observe(viewLifecycleOwner) { images ->
            promoLandscapeListAdapter.submitList(images)
        }
    }

    private fun setupRecyclerHotelFlashSale() {
        binding.recyclerHotel.adapter = hotelAdapter
        homeViewModel.listHotel.observe(viewLifecycleOwner) { hotels ->
            hotelAdapter.submitList(hotels)
        }
    }

    private fun setupRecyclerHotelByCities() {
        binding.recyclerHotelByCities.adapter = hotelByCitiesAdapter
        homeViewModel.listHotelByCities.observe(viewLifecycleOwner) { hotels ->
            hotelByCitiesAdapter.submitList(hotels)
        }
    }

    private fun setupRecyclerPromo(){
        binding.recyclerPromo.adapter = promoAdapter
        homeViewModel.listPromo.observe(viewLifecycleOwner){ promos ->
            promoAdapter.submitList(promos)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}