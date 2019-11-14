package com.example.insurancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        /*Toast.makeText(this,"Position = $position", Toast.LENGTH_SHORT).show()*/
        Toast.makeText(this, "Item = ${spinnerAge.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Associate spinner to Main Activity
        spinnerAge.onItemSelectedListener = this
        buttonCalculate.setOnClickListener(){
            calculatePremium()
        }
    }

    private fun calculatePremium() {
        //TODO calculate insurance premium
        var premium : Int = 0
        var male : Boolean = false
        //position = index of an item selected by user
        val age: Int = spinnerAge.selectedItemPosition
        premium += when(age){
            0 -> 60
            1 -> 70
            2 -> 90
            3 -> 120
            //TODO add the remaining
            else -> 150
        }
        //ID of a radioButton checked by user
        val gender: Int = radioGroupGender.checkedRadioButtonId
        male = when(gender){
            R.id.radioButtonMale -> true
            else -> false
        }
        if(male == true){
            premium += when(age){
                0 -> 0
                1 -> 50
                2 -> 100
                3 -> 150
                //TODO add the remaining
                else -> 200
            }
        }
        //Boolean value
        val smoker: Boolean = checkBoxSmoker.isChecked
        if(smoker == true){
            premium += when(age){
                0 -> 0
                1 -> 100
                2 -> 150
                3 -> 200
                4 -> 250
                //TODO add the remaining
                else -> 300
            }
        }
        textViewInsurancePremium.text = String.format("%s $%d",getString(R.string.insurance_premium), premium)
    }
    fun resetInput(view: View?) {
        //TODO clear all input and outputs
        spinnerAge.setSelection(0)
        textViewInsurancePremium.text = String.format("%s", getString(R.string.insurance_premium))
        radioGroupGender.clearCheck()
        checkBoxSmoker.isChecked = false
    }
}
