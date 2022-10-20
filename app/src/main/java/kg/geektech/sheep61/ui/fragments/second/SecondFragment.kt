package kg.geektech.sheep61.ui.fragments.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.geektech.sheep61.R
import kg.geektech.sheep61.databinding.FragmentSecondBinding
import kg.geektech.sheep61.ui.adapter.ImageAdapter
import kg.geektech.sheep61.ui.models.ImageModel

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var adapter: ImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireArguments().getParcelableArrayList<ImageModel>("sheeps")?.let {
            adapter = ImageAdapter(it)
        }
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSheeps.adapter = adapter
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}