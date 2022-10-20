package kg.geektech.sheep61.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.sheep61.ui.fragments.main.MainFragment
import kg.geektech.sheep61.R
import kg.geektech.sheep61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, MainFragment())
            .commit()

    }


}