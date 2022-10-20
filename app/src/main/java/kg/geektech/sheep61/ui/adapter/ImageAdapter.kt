package kg.geektech.sheep61.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.sheep61.ui.models.ImageModel
import kg.geektech.sheep61.databinding.ItemImageBinding

class ImageAdapter(
    private val data: ArrayList<ImageModel>,
    private val onClick: ((imageModel: ImageModel) -> Unit)? = null
) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private var lastSelectedPosition = RecyclerView.NO_POSITION


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imageModel: ImageModel) = with(binding) {
            imageModel.apply {
                isSelected = when (lastSelectedPosition == adapterPosition) {
                    true -> true
                    false -> false
                }
                when (isSelected) {
                    true -> {
                        imageView.isSelected = true
                        imCheck.isVisible = true
                    }
                    false -> {
                        imageView.isSelected = false
                        imCheck.isVisible = false
                    }
                }
            }
            imageView.setImageResource(imageModel.image)
            root.setOnClickListener {
                onClick?.let {
                    lastSelectedPosition = adapterPosition
                    notifyItemChanged(lastSelectedPosition)
                    it(data[adapterPosition])
                }
            }
        }
    }
}