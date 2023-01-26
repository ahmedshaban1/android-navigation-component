package com.example.navigationcomponentsexample.fragments

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SearchModel(val query: String = "") : Parcelable