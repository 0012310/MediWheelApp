package com.example.mediwheelapp.Activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class TextChangedListener<T> implements TextWatcher {

    private T target;


    public TextChangedListener(T target) {
        this.target = target;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        this.onTextChanged(target, editable);

    }

    public abstract void onTextChanged(T target, Editable s);
}

