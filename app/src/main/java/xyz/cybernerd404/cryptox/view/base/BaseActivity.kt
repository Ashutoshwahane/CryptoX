package xyz.cybernerd404.cryptox.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import xyz.cybernerd404.cryptox.network.PrivateDataSource
import xyz.cybernerd404.cryptox.network.RemoteDataSource
import xyz.cybernerd404.cryptox.repository.BaseRepository

/**
 *
 * viewModel, repository, and data binding for every fragment
 *
 * */

abstract class BaseActivity<VM : ViewModel, B : ViewBinding, R : BaseRepository>(val bindingFactory: (LayoutInflater) -> B) : AppCompatActivity() {

    protected lateinit var binding: B
    protected val remoteDataSource = RemoteDataSource()
    protected val privateDataSource = PrivateDataSource()
    protected lateinit var viewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory.invoke(layoutInflater)
        setContentView(binding.root)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
    }

    abstract fun getViewModel(): Class<VM>


    abstract fun getFragmentRepository(): R
}