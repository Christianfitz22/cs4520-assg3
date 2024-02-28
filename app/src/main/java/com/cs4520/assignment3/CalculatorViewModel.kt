package com.cs4520.assignment3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _resultMessage = MutableLiveData<String>()
    val resultMessage: LiveData<String> = _resultMessage

    private val _number1 = MutableLiveData<String>()
    val number1: LiveData<String> = _number1

    private val _number2 = MutableLiveData<String>()
    val number2: LiveData<String> = _number2

    private fun clearInputs() {
        _number1.value = ""
        _number2.value = ""
    }

    private fun displayMessage(string: String) {
        _resultMessage.value = string
    }

    private fun inputError() {
        clearInputs()
        displayMessage("Input missing or invalid.")
    }

    private fun displayResult(result: Double) {
        displayMessage(String.format("Result: %.2f", result))
    }

    fun onAddClicked(n1: Double?, n2: Double?) {
        if (n1 == null || n2 == null) {
            inputError()
        } else {
            val result = n1 + n2
            clearInputs()
            displayResult(result)
        }
    }
    fun onSubtractClicked(n1: Double?, n2: Double?) {
        if (n1 == null || n2 == null) {
            inputError()
        } else {
            val result = n1 - n2
            clearInputs()
            displayResult(result)
        }
    }
    fun onMultiplyClicked(n1: Double?, n2: Double?) {
        if (n1 == null || n2 == null) {
            inputError()
        } else {
            val result = n1 * n2
            clearInputs()
            displayResult(result)
        }
    }
    fun onDivideClicked(n1: Double?, n2: Double?) {
        if (n1 == null || n2 == null || n2 == 0.0) {
            inputError()
        } else {
            val result = n1 / n2
            clearInputs()
            displayResult(result)
        }
    }

    fun restoreState(n1: String?, n2: String?) {
        if (n1 != null) {
            _number1.value = n1!!
        }
        if (n2 != null) {
            _number2.value = n2!!
        }
    }
}