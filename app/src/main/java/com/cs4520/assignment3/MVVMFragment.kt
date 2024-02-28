package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cs4520.assignment3.databinding.MvvmFragmentBinding

class MVVMFragment: Fragment() {
    private var _binding: MvvmFragmentBinding? = null
    private val binding get() = _binding!!

    private val calculatorViewModel: CalculatorViewModel by viewModels()

    private var number1: EditText? = null
    private var number2: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MvvmFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.calculatorViewModel = calculatorViewModel
        binding.lifecycleOwner = this

        number1 = binding.number1
        number2 = binding.number2

        if (savedInstanceState != null) {
            calculatorViewModel.restoreState(
                savedInstanceState.getString("number1Field"),
                savedInstanceState.getString("number2Field")
            )
        }

        binding.add.setOnClickListener {
            calculatorViewModel.onAddClicked(
                number1?.text.toString().toDoubleOrNull(),
                number2?.text.toString().toDoubleOrNull()
            )
        }
        binding.subtract.setOnClickListener {
            calculatorViewModel.onSubtractClicked(
                number1?.text.toString().toDoubleOrNull(),
                number2?.text.toString().toDoubleOrNull()
            )
        }
        binding.multiply.setOnClickListener {
            calculatorViewModel.onMultiplyClicked(
                number1?.text.toString().toDoubleOrNull(),
                number2?.text.toString().toDoubleOrNull()
            )
        }
        binding.divide.setOnClickListener {
            calculatorViewModel.onDivideClicked(
                number1?.text.toString().toDoubleOrNull(),
                number2?.text.toString().toDoubleOrNull()
            )
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (number1?.text != null) {
            outState.putString("number1Field", number1?.text.toString())
        }
        if (number2?.text != null) {
            outState.putString("number2Field", number2?.text.toString())
        }
    }
}