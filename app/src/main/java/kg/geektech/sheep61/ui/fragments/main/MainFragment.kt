package kg.geektech.sheep61.ui.fragments.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import kg.geektech.sheep61.ui.models.ImageModel
import kg.geektech.sheep61.R
import kg.geektech.sheep61.databinding.FragmentMainBinding
import kg.geektech.sheep61.ui.adapter.ImageAdapter
import kg.geektech.sheep61.ui.fragments.second.SecondFragment

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: ImageAdapter
    private val viewModel by viewModels<MainViewModel>()
    private val sheepList = arrayListOf<ImageModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sheepList.clear()
        createSheeps()
        setupListeners()
        binding.rvSheeps.adapter = adapter
        if (sheepList.isEmpty())
            binding.tvTheAmountOfPhotoChoosen.text =
                getString(R.string.the_amount_of_photo_choosen, "0")
    }

    private fun setupListeners() {
        binding.btnReady.setOnClickListener {
            if (sheepList.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putParcelableArrayList("sheeps", sheepList)
                val secondFragment = SecondFragment()
                secondFragment.arguments = bundle
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, secondFragment).addToBackStack("main")
                    .commit()
            }
        }
    }

    private fun createSheeps() {
        adapter =
            ImageAdapter(
                viewModel.createList(), this::onClick
            )
    }

    private fun onClick(imageModel: ImageModel) {
        if (!sheepList.contains(imageModel))
            sheepList.add(imageModel)

        binding.tvTheAmountOfPhotoChoosen.text =
            getString(R.string.the_amount_of_photo_choosen, sheepList.size.toString())
    }
}