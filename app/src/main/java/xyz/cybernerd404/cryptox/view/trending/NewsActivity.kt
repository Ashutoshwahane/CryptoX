package xyz.cybernerd404.cryptox.view.trending

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.extras
        val newUrl = intent?.getString("newUrl", "https://github.com/Ashutoshwahane")

        if (newUrl != null) {
            binding.webview.loadUrl(newUrl)
        }

    }
}