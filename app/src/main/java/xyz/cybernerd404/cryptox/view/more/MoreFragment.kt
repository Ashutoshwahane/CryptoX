package xyz.cybernerd404.cryptox.view.more

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.databinding.FragmentMoreBinding
import xyz.cybernerd404.cryptox.utils.SessionManager
import xyz.cybernerd404.cryptox.utils.debug
import xyz.cybernerd404.cryptox.utils.showToast
import kotlin.math.absoluteValue

class MoreFragment : Fragment(R.layout.fragment_more), AdapterView.OnItemSelectedListener {

    lateinit var binding: FragmentMoreBinding
    lateinit var sessionManager: SessionManager
    var postion = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sessionManager = SessionManager(requireContext())
        val selectedCurrency = sessionManager.fetchCurrency()
        debug("selectedCurrency: $selectedCurrency")

        if (selectedCurrency == null) {
            binding.languageSpinner.setSelection(1, false)
        } else {
            postion = getPosition(selectedCurrency)
            debug("postion: $postion")
            binding.languageSpinner.setSelection(postion, false)
        }



        binding.languageSpinner.onItemSelectedListener = this
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.currency,
            R.layout.spinner_text
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(R.layout.spinner_text)
            // Apply the adapter to the spinner
            binding.languageSpinner.adapter = adapter
        }

        binding.languageSpinner.setSelection(postion)
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (view != null) {
            val currency = parent?.selectedItem.toString()
            sessionManager.saveCurrency(currency)
            debug("itemSelected: $currency")
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    private fun getPosition(currency: String): Int {
        var index = 0
        val arr = resources.getStringArray(R.array.currency).toList()
        arr.forEach {
            if (currency.equals(it, true)) {
                index = arr.indexOf(it)
            }
        }
        return index
    }


}