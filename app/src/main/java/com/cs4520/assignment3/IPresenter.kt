package com.cs4520.assignment3

interface IPresenter {
    fun onAddClicked(n1: Double?, n2: Double?)
    fun onSubtractClicked(n1: Double?, n2: Double?)
    fun onMultiplyClicked(n1: Double?, n2: Double?)
    fun onDivideClicked(n1: Double?, n2: Double?)
}