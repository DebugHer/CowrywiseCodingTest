package com.adegoke.cowrywisecodingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.lifecycle.*
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.spinner_layout.*
import kotlinx.android.synthetic.main.spinner_layout_2.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: CurrencyViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       App.getInstance().getAppComponent().inject(this)

        // Initializing a String Array
        val currencies = arrayOf("AED","AFN","ALL","AMD","ANG","AOA","ARS")

        // Initializing an ArrayAdapter
        val adapter = ArrayAdapter(
            this, // Context
            android.R.layout.simple_spinner_item, // Layout
            currencies // Array
        )

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        spinner2.adapter = adapter

        // Set an on item selected listener for spinner object
        spinner2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                Toast.makeText(this@MainActivity, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callbac
            }
        }

        var currencyViewModel: MainViewModel = ViewModelProviders.of(this@MainActivity, viewModelFactory)
            .get(MainViewModel::class.java)

//        currencyViewModel.currencyLiveData?.observe(this@MainActivity, Observer<RatesResponse> {
//                response -> updateView(response)
//            })

        currencyViewModel.apiResponse().observe(this@MainActivity, Observer<RatesResponse> {
                response -> updateView(response)

        })


        convertbtn.setOnClickListener {  }
    }

    private fun updateView(response: RatesResponse?) {
        //testing
       Toast.makeText(this@MainActivity, response?.rates?.aFN.toString(), Toast.LENGTH_SHORT).show()
    }





}

