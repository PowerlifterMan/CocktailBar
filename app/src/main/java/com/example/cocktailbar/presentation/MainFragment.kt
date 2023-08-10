package com.example.cocktailbar.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cocktailbar.R
import com.example.cocktailbar.databinding.FragmentMainScreenBinding
import com.example.cocktailbar.domain.Coctail

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private var _binding: FragmentMainScreenBinding? = null
    private val binding: FragmentMainScreenBinding
        get() = _binding ?: throw RuntimeException("FragmentMainScreenBinding? == null")

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val coctailAdapter = CoctailAdapter()
    private val viewModel: MainFragmentViewModel by lazy {
        ViewModelProvider(requireActivity())[MainFragmentViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvList = viewModel.getList()
        binding.fabMainFragment.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_editCoctailFragment)
        }
        rvList.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.mainFragmentRecyclerView.visibility = View.VISIBLE
                coctailAdapter.submitList(it)
            } else {
                binding.mainFragmentRecyclerView.visibility = View.GONE
            }

        }
        binding.mainFragmentRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        coctailAdapter.coctailItemClickListener =
            object : CoctailAdapter.OnCoctailItemClickListener {
                override fun itemClick(coctail: Coctail) {
                    Navigation.findNavController(
                        requireActivity(),
                        R.id.fragment_container_view
                    ).navigate(R.id.action_mainScreenFragment_to_coctailCardFragment)

                }
            }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainScreenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String = "", param2: String = "") =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}