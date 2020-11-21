/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.example.aboutme.R

/**
 * Main Activity of the AboutMe app. This app demonstrates:
 *     * EditText
 *     * Entering, getting, and displaying text.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var doneButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doneButton = findViewById(R.id.done)
        doneButton.setOnClickListener{
            addNickname(it)
        }
    }
    private fun addNickname(view: View) {
        val editNickname = findViewById<EditText>(R.id.nickname_edit)
        val showNickname = findViewById<TextView>(R.id.nickname_text)
        showNickname.text = editNickname.text
        showNickname.visibility = View.VISIBLE
        editNickname.visibility = View.GONE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}