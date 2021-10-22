package com.test.marvelapptest.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.test.domain.CharacterResult
import com.test.marvelapptest.ui.common.loadImage
import com.test.marvelapptest.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val CHARACTER_ID = "DetailActivity:id"
    }


    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.load.observe(this, Observer { binding.pb.isVisible = if (it) true else false })
        viewModel.model.observe(this, Observer { getDatas(it) })

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun getDatas(character: CharacterResult) {
        binding.toolbarLayout.title = character.name
        binding.toolbarImage.loadImage(
            character.thumbnail.path,
            character.thumbnail.extension
        )
        binding.heroName.text = character.name
        binding.heroContent.text = if(character.description.length>0) character.description else "This Hero does't contain description"

    }

}