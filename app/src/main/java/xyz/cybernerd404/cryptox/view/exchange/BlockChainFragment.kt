package xyz.cybernerd404.cryptox.view.exchange

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.cybernerd404.cryptox.adapter.BlockAdapter
import xyz.cybernerd404.cryptox.databinding.FragmentBlockchainBinding
import xyz.cybernerd404.cryptox.model.BlockModel
import xyz.cybernerd404.cryptox.utils.hashString
import java.text.SimpleDateFormat
import java.util.*


class BlockChainFragment : Fragment() {

    lateinit var binding: FragmentBlockchainBinding
    lateinit var blockAdapter: BlockAdapter
    lateinit var list: MutableList<BlockModel>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlockchainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = arrayListOf()
        blockAdapter = BlockAdapter()

        binding.blockRv.layoutManager = LinearLayoutManager(requireContext())
        binding.blockRv.adapter = blockAdapter

        updateUI()

        var previousHash = "0"
        binding.addIv.setOnClickListener {

            if (binding.addMessageEt.text.isEmpty()) {
                Toast.makeText(requireContext(), "Message is Empty", Toast.LENGTH_SHORT).show()
            } else {
                val blockModel = BlockModel()
                blockModel.message = binding.addMessageEt.text.toString()
                blockModel.previous_hash = previousHash
                blockModel.hash = hashString(blockModel, "SHA-256")
                previousHash = blockModel.hash
                blockModel.time_stamp = SimpleDateFormat("yyyy/MM/dd/ hh-mm").format(Date().time)
                Log.d("debug", "date: $blockModel")
                list.add(blockModel)
                blockAdapter.setBlock(list)
                binding.addMessageEt.text.clear()
                updateUI()

            }

        }
    }

    private fun updateUI() {
        if (list.isNotEmpty()) {
            binding.titleTv.visibility = View.GONE
            binding.blockRv.visibility = View.VISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
    }


}