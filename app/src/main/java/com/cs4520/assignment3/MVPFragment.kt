package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.MvpFragmentBinding

class MVPFragment: Fragment(), IView {
    private var _binding: MvpFragmentBinding? = null
    private val binding get() = _binding!!

    private var presenter: IPresenter? = null
    private var number1: EditText? = null
    private var number2: EditText? = null
    private var errorText: TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MvpFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        presenter = Presenter(this)

        number1 = binding.number1
        number2 = binding.number2

        errorText = binding.toast

        binding.add.setOnClickListener(View.OnClickListener{
            presenter!!.onAddClicked(number1?.text.toString().toDoubleOrNull(), number2?.text.toString().toDoubleOrNull())
        })
        binding.subtract.setOnClickListener(View.OnClickListener{
            presenter!!.onSubtractClicked(number1?.text.toString().toDoubleOrNull(), number2?.text.toString().toDoubleOrNull())
        })
        binding.multiply.setOnClickListener(View.OnClickListener{
            presenter!!.onMultiplyClicked(number1?.text.toString().toDoubleOrNull(), number2?.text.toString().toDoubleOrNull())
        })
        binding.divide.setOnClickListener(View.OnClickListener{
            presenter!!.onDivideClicked(number1?.text.toString().toDoubleOrNull(), number2?.text.toString().toDoubleOrNull())
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun displayMessage(message: String) {
        errorText?.text = message
    }
    override fun displayResult(result: Double) {
        errorText?.text = String.format("Result: %.2f", result)
    }
    override fun clearInputs() {
        number1?.text?.clear()
        number2?.text?.clear()
    }
}