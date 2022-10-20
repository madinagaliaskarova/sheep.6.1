package kg.geektech.sheep61.ui.fragments.main

import androidx.lifecycle.ViewModel
import kg.geektech.sheep61.R
import kg.geektech.sheep61.ui.models.ImageModel

class MainViewModel : ViewModel() {
    fun createList() = arrayListOf(
        ImageModel(R.drawable.tiger),
        ImageModel(R.drawable.hippo),
        ImageModel(R.drawable.elephant),
        ImageModel(R.drawable.lion),
        ImageModel(R.drawable.bee),
        ImageModel(R.drawable.cow),
        ImageModel(R.drawable.turtle),
        ImageModel(R.drawable.bat),
        ImageModel(R.drawable.dinosaur),
        ImageModel(R.drawable.wolf),
        ImageModel(R.drawable.chicken),
        ImageModel(R.drawable.unicorn),
        ImageModel(R.drawable.cat),
        ImageModel(R.drawable.dog),
        ImageModel(R.drawable.giraffe)
    )
}