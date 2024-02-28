package com.cs4520.assignment3

class Presenter(private var mainView: IView) : IPresenter {
    private fun inputError() {
        mainView.displayMessage("Input missing or invalid.")
        mainView.clearInputs()
    }
    override fun onAddClicked(n1: Double?, n2: Double?) {
        if (n1 == null || n2 == null) {
            inputError()
        } else {
            val result = n1 + n2
            mainView.clearInputs()
            mainView.displayResult(result)
        }
    }
    override fun onSubtractClicked(n1: Double?, n2: Double?) {
        if (n1 == null || n2 == null) {
            inputError()
        } else {
            val result = n1 - n2
            mainView.clearInputs()
            mainView.displayResult(result)
        }
    }
    override fun onMultiplyClicked(n1: Double?, n2: Double?) {
        if (n1 == null || n2 == null) {
            inputError()
        } else {
            val result = n1 * n2
            mainView.clearInputs()
            mainView.displayResult(result)
        }
    }
    override fun onDivideClicked(n1: Double?, n2: Double?) {
        if (n1 == null || n2 == null || n2 == 0.0) {
            inputError()
        } else {
            val result = n1 / n2
            mainView.clearInputs()
            mainView.displayResult(result)
        }
    }
}