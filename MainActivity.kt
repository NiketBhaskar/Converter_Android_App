package com.example.unitconverterbridgelabz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.core.view.get
import com.example.unitconverterbridgelabz.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //declare and initialize collections
    val listOfUnits = arrayOf("Length", "Weight", "Volume")
    var listOfUnitsConversion = mutableListOf<String>()
    val unitsOfLength = arrayOf("CM", "Meter", "KM")
    val unitsOfWeight = arrayOf("Gram", "KG", "Tonne")
    val unitsOfVolume = arrayOf("ML", "Litre", "Gallon")

    lateinit var inputQuantity: EditText
    lateinit var convertedQuantity: TextView
    lateinit var convertButton: Button
    lateinit var addButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        inputQuantity = findViewById(R.id.enterQuantity)
        convertedQuantity = findViewById(R.id.convertedQuantity)
        convertButton = findViewById(R.id.Button1)
        addButton = findViewById(R.id.Button2)
        //Creating objects of diff classes
        val lengthConversion = LengthConversion()
        val weightConversion = WeightConversion()
        val volumeConversion = VolumeConversion()
        //array adaptor for main spinner
        val spinnerMainAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,listOfUnits)
        binding.spinnerMain.adapter= spinnerMainAdapter

        binding.spinnerMain.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                inputQuantity.text.clear()

                convertedQuantity.text = ""
                if(p2 == 0){
                    val spinnerInputAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,unitsOfLength)
                    binding.spinnerOne.adapter = spinnerInputAdapter
                    binding.spinnerTwo.adapter = spinnerInputAdapter
                }
                if(p2 == 1){
                    val spinnerInputAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,unitsOfWeight)
                    binding.spinnerOne.adapter = spinnerInputAdapter
                    binding.spinnerTwo.adapter = spinnerInputAdapter
                }
                if(p2 == 2){
                    val spinnerInputAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,unitsOfVolume)
                    binding.spinnerOne.adapter = spinnerInputAdapter
                    binding.spinnerTwo.adapter = spinnerInputAdapter
                }

                Toast.makeText(
                    this@MainActivity,
                    "You select " + listOfUnits.get(p2),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        binding.spinnerOne.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        binding.spinnerTwo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        convertButton.setOnClickListener {
            var inputQuantity = inputQuantity.text.toString()
            var validatingInput = Validator.validateInput(inputQuantity, inputQuantity.toDouble())
        //    convertedQuantity.text = "spinnerOne.selectedItem.toString()"



            if(spinnerMain.selectedItemPosition == 0){          //if length is selected in main spinner
                if(spinnerOne.selectedItemPosition == 0){       //if cm is selected in input spinner
                    when(spinnerTwo.selectedItemPosition){
                        0 -> convertedQuantity.text = (inputQuantity.toDouble()).toString()
                        1 -> convertedQuantity.text = lengthConversion.cmToMeter(inputQuantity.toDouble())
                        2 -> convertedQuantity.text = lengthConversion.cmToKm(inputQuantity.toDouble())
                    }
                }
                if(spinnerOne.selectedItemPosition == 1){       //if meter is selected in input spinner
                    when(spinnerTwo.selectedItemPosition){
                        0 -> convertedQuantity.text = lengthConversion.meterToCm(inputQuantity.toDouble())
                        1 -> convertedQuantity.text = (inputQuantity.toDouble()).toString()
                        2 -> convertedQuantity.text = lengthConversion.meterToKm(inputQuantity.toDouble())
                    }
                }
                if(spinnerOne.selectedItemPosition == 2){
                    when(spinnerTwo.selectedItemPosition){      //if KM is selected in input spinner
                        0 -> convertedQuantity.text = lengthConversion.kmToCm(inputQuantity.toDouble())
                        1 -> convertedQuantity.text = lengthConversion.kmToMeter(inputQuantity.toDouble())
                        2 -> convertedQuantity.text = (inputQuantity.toDouble()).toString()
                    }
                }
            }
            if(spinnerMain.selectedItemPosition == 1){          //if weight is selected in main spinner
                if(spinnerOne.selectedItemPosition == 0){       //if gram is selected in input spinner
                    when(spinnerTwo.selectedItemPosition){
                        0 -> convertedQuantity.text = (inputQuantity.toDouble()).toString()
                        1 -> convertedQuantity.text = weightConversion.gramToKg(inputQuantity.toDouble())
                        2 -> convertedQuantity.text = weightConversion.gramToTonne(inputQuantity.toDouble())
                    }
                }
                if(spinnerOne.selectedItemPosition == 1){       //if KG is selected in input spinner
                    when(spinnerTwo.selectedItemPosition){
                        0 -> convertedQuantity.text = weightConversion.kgToGram(inputQuantity.toDouble())
                        1 -> convertedQuantity.text = (inputQuantity.toDouble()).toString()
                        2 -> convertedQuantity.text = weightConversion.kgToTonne(inputQuantity.toDouble())
                    }
                }
                if(spinnerOne.selectedItemPosition == 2){
                    when(spinnerTwo.selectedItemPosition){      //if Tonne is selected in input spinner
                        0 -> convertedQuantity.text = weightConversion.tonneToGram(inputQuantity.toDouble())
                        1 -> convertedQuantity.text = weightConversion.tonneToKg(inputQuantity.toDouble())
                        2 -> convertedQuantity.text = (inputQuantity.toDouble()).toString()
                    }
                }
            }
            if(spinnerMain.selectedItemPosition == 2){          //if volume is selected in main spinner
                if(spinnerOne.selectedItemPosition == 0){       //if ml is selected in input spinner
                    when(spinnerTwo.selectedItemPosition){
                        0 -> convertedQuantity.text = (inputQuantity.toDouble()).toString()
                        1 -> convertedQuantity.text = volumeConversion.mlToLitre(inputQuantity.toDouble())
                        2 -> convertedQuantity.text = volumeConversion.mlToGallon(inputQuantity.toDouble())
                    }
                }
                if(spinnerOne.selectedItemPosition == 1){       //if litre is selected in input spinner
                    when(spinnerTwo.selectedItemPosition){
                        0 -> convertedQuantity.text = volumeConversion.litreToMl(inputQuantity.toDouble())
                        1 -> convertedQuantity.text = (inputQuantity.toDouble()).toString()
                        2 -> convertedQuantity.text = volumeConversion.litreToGallon(inputQuantity.toDouble())
                    }
                }
                if(spinnerOne.selectedItemPosition == 2){
                    when(spinnerTwo.selectedItemPosition){      //if gallon is selected in input spinner
                        0 -> convertedQuantity.text = volumeConversion.gallonToMl(inputQuantity.toDouble())
                        1 -> convertedQuantity.text = volumeConversion.gallonToLitre(inputQuantity.toDouble())
                        2 -> convertedQuantity.text = (inputQuantity.toDouble()).toString()
                    }
                }
            }

        }
        addButton.setOnClickListener {
            var name = inputQuantity.text
            convertedQuantity.text = "Button2 $name"

        }
    }
}

