package com.cs4520.assignment3

import androidx.databinding.BaseObservable
import java.util.Objects

class BindableString: BaseObservable() {
    var value: String? = null;

    fun get(): String {
        if (value == null) {
            return ""
        } else {
            return value as String
        }
    }

    fun set(string: String) {
        if (Objects.equals(value, string)) {
            value = string
            notifyChange()
        }
    }

    fun isEmpty(): Boolean {
        return value == null || value!!.isEmpty()
    }
}