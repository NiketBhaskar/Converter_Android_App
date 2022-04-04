package com.example.unitconverterbridgelabz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.unitconverterbridgelabz.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //declare and initialize collections
    val listOfUnits = arrayOf("Length", "Weight", "Volume")
    val unitsOfLength = arrayOf("CM", "Meter", "KM")
    val unitsOfWeight = arrayOf("Gram", "KG", "Tonne")
    val unitsOfVolume = arrayOf("ML", "Litre", "Gallon")

    lateinit var inputQuantity: EditText
    lateinit var convertedQuantity: TextView
    lateinit var convertButton: Button
    lateinit var addButton: Button
    lateinit var addSymbol: TextView
    lateinit var equalSymbol: TextView
    lateinit var addQuantity: EditText
    lateinit var addLayout: LinearLayout
    lateinit var calculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        inputQuantity = findViewById(R.id.enterQuantity)
        convertedQuantity = findViewById(R.id.convertedQuantity)
        addQuantity = findViewById(R.id.enterAddQuantity)
        convertButton = findViewById(R.id.Button1)
        addButton = findViewById(R.id.Button2)
        addSymbol = findViewById(R.id.plus)
        equalSymbol = findViewById(R.id.equalTo)
        addLayout = findViewById(R.id.addLayout)
        calculate = findViewById(R.id.Button3)
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
                    binding.spinnerThree.adapter = spinnerInputAdapter
                }
                if(p2 == 1){
                    val spinnerInputAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,unitsOfWeight)
                    binding.spinnerOne.adapter = spinnerInputAdapter
                    binding.spinnerTwo.adapter = spinnerInputAdapter
                    binding.spinnerThree.adapter = spinnerInputAdapter
                }
                if(p2 == 2){
                    val spinnerInputAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,unitsOfVolume)
                    binding.spinnerOne.adapter = spinnerInputAdapter
                    binding.spinnerTwo.adapter = spinnerInputAdapter
                    binding.spinnerThree.adapter = spinnerInputAdapter
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
            val inputQuantity = inputQuantity.text.toString()
            val validatingInput = Validator.validateInput(inputQuantity)
            if(validatingInput){
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
            else{
                convertedQuantity.text = "Enter a Number"
            }
        }
        addButton.setOnClickListener {
            showHideOperation()
            inputQuantity.text.clear()
            convertedQuantity.text = ""

//            var name = inputQuantity.text
            //          convertedQuantity.text = "Button2 $name"

        }
        calculate.setOnClickListener {
            addOperations()

        }
    }
    fun showHideOperation(){
        addSymbol.visibility = if (addSymbol.visibility == View.GONE){
            View.VISIBLE
        } else{
            View.GONE
        }
        addLayout.visibility = if (addLayout.visibility == View.GONE){
            View.VISIBLE
        } else{
            View.GONE
        }
        equalSymbol.visibility = if (equalSymbol.visibility == View.GONE){
            View.VISIBLE
        } else{
            View.GONE
        }
        calculate.visibility = if (calculate.visibility == View.GONE){
            View.VISIBLE
        } else{
            View.GONE
        }
        convertButton.visibility = if (calculate.visibility == View.VISIBLE){
            View.GONE
        } else{
            View.VISIBLE
        }

        if (addButton.text == "Add Quantity"){
            addButton.text = "Hide Add Quantity"
        }
        else{
            addButton.text = "Add Quantity"
        }
    }
    fun addOperations(){
        //Creating objects of diff classes
        val lengthConversion = LengthConversion()
        val weightConversion = WeightConversion()
        val volumeConversion = VolumeConversion()
        var inputQuantity = inputQuantity.text.toString()
        var addQuantity = addQuantity.text.toString()

        var validatingInput = Validator.validateInput(inputQuantity)
        var validatingInputTwo = Validator.validateInput(addQuantity)
        if(validatingInput && validatingInputTwo){
            if(spinnerMain.selectedItemPosition == 0){
                if(spinnerOne.selectedItemPosition == 0){
                    if(spinnerThree.selectedItemPosition == 0){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                (inputQuantity.toDouble() + addQuantity.toDouble()).toString()
                            1 -> {
                                var sum = inputQuantity.toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = lengthConversion.cmToMeter(sum)
                            }
                            2 -> {
                                var sum = inputQuantity.toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = lengthConversion.cmToKm(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 1){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                (inputQuantity.toDouble() + (lengthConversion.meterToCm(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = inputQuantity.toDouble() + (lengthConversion.meterToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToMeter(sum)
                            }
                            2 -> {
                                var sum = inputQuantity.toDouble() + (lengthConversion.meterToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToKm(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 2){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                (inputQuantity.toDouble() + (lengthConversion.kmToCm(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = inputQuantity.toDouble() + (lengthConversion.kmToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToMeter(sum)
                            }
                            2 -> {
                                var sum = inputQuantity.toDouble() + (lengthConversion.kmToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToKm(sum)
                            }
                        }
                    }
                }
                if(spinnerOne.selectedItemPosition == 1){
                    if(spinnerThree.selectedItemPosition == 0){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((lengthConversion.meterToCm(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()).toString()
                            1 -> {
                                var sum = (lengthConversion.meterToCm(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = lengthConversion.cmToMeter(sum)
                            }
                            2 -> {
                                var sum = (lengthConversion.meterToCm(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = lengthConversion.cmToKm(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 1){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((lengthConversion.meterToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.meterToCm(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (lengthConversion.meterToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.meterToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToMeter(sum)
                            }
                            2 -> {
                                var sum = (lengthConversion.meterToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.meterToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToKm(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 2){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((lengthConversion.meterToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.kmToCm(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (lengthConversion.meterToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.kmToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToMeter(sum)
                            }
                            2 -> {
                                var sum = (lengthConversion.meterToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.kmToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToKm(sum)
                            }
                        }
                    }
                }
                if(spinnerOne.selectedItemPosition == 2){
                    if(spinnerThree.selectedItemPosition == 0){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((lengthConversion.kmToCm(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()).toString()
                            1 -> {
                                var sum = (lengthConversion.kmToCm(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = lengthConversion.cmToMeter(sum)
                            }
                            2 -> {
                                var sum = (lengthConversion.kmToCm(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = lengthConversion.cmToKm(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 1){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((lengthConversion.kmToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.meterToCm(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (lengthConversion.kmToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.meterToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToMeter(sum)
                            }
                            2 -> {
                                var sum = (lengthConversion.kmToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.meterToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToKm(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 2){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((lengthConversion.kmToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.kmToCm(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (lengthConversion.kmToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.kmToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToMeter(sum)
                            }
                            2 -> {
                                var sum = (lengthConversion.kmToCm(inputQuantity.toDouble())).toDouble() + (lengthConversion.kmToCm(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = lengthConversion.cmToKm(sum)
                            }
                        }
                    }
                }
            }
            if(spinnerMain.selectedItemPosition == 1){
                if(spinnerOne.selectedItemPosition == 0){
                    if(spinnerThree.selectedItemPosition == 0){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                (inputQuantity.toDouble() + addQuantity.toDouble()).toString()
                            1 -> {
                                var sum = inputQuantity.toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = weightConversion.gramToKg(sum)
                            }
                            2 -> {
                                var sum = inputQuantity.toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = weightConversion.gramToTonne(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 1){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                (inputQuantity.toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = inputQuantity.toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToKg(sum)
                            }
                            2 -> {
                                var sum = inputQuantity.toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToTonne(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 2){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                (inputQuantity.toDouble() + (weightConversion.tonneToGram(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = inputQuantity.toDouble() + (weightConversion.tonneToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToKg(sum)
                            }
                            2 -> {
                                var sum = inputQuantity.toDouble() + (weightConversion.tonneToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToTonne(sum)
                            }
                        }
                    }
                }
                if(spinnerOne.selectedItemPosition == 1){
                    if(spinnerThree.selectedItemPosition == 0){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((weightConversion.kgToGram(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()).toString()
                            1 -> {
                                var sum = (weightConversion.kgToGram(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = weightConversion.gramToKg(sum)
                            }
                            2 -> {
                                var sum = (weightConversion.kgToGram(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = weightConversion.gramToTonne(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 1){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((weightConversion.kgToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (weightConversion.kgToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToKg(sum)
                            }
                            2 -> {
                                var sum = (weightConversion.kgToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToTonne(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 2){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((weightConversion.kgToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (weightConversion.kgToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToKg(sum)
                            }
                            2 -> {
                                var sum = (weightConversion.kgToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.tonneToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToTonne(sum)
                            }
                        }
                    }
                }
                if(spinnerOne.selectedItemPosition == 2){
                    if(spinnerThree.selectedItemPosition == 0){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((weightConversion.tonneToGram(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()).toString()
                            1 -> {
                                var sum = (weightConversion.tonneToGram(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = weightConversion.gramToKg(sum)
                            }
                            2 -> {
                                var sum = (weightConversion.tonneToGram(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = weightConversion.gramToTonne(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 1){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((weightConversion.tonneToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (weightConversion.tonneToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToKg(sum)
                            }
                            2 -> {
                                var sum = (weightConversion.tonneToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.kgToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToTonne(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 2){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((weightConversion.tonneToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.tonneToGram(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (weightConversion.tonneToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.tonneToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToKg(sum)
                            }
                            2 -> {
                                var sum = (weightConversion.tonneToGram(inputQuantity.toDouble())).toDouble() + (weightConversion.tonneToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = weightConversion.gramToTonne(sum)
                            }
                        }
                    }
                }
            }
            if(spinnerMain.selectedItemPosition == 2){
                if(spinnerOne.selectedItemPosition == 0){
                    if(spinnerThree.selectedItemPosition == 0){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                (inputQuantity.toDouble() + addQuantity.toDouble()).toString()
                            1 -> {
                                var sum = inputQuantity.toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = volumeConversion.mlToLitre(sum)
                            }
                            2 -> {
                                var sum = inputQuantity.toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = volumeConversion.mlToGallon(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 1){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                (inputQuantity.toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = inputQuantity.toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToLitre(sum)
                            }
                            2 -> {
                                var sum = inputQuantity.toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.litreToGallon(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 2){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                (inputQuantity.toDouble() + (volumeConversion.gallonToMl(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = inputQuantity.toDouble() + (weightConversion.tonneToGram(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToLitre(sum)
                            }
                            2 -> {
                                var sum = inputQuantity.toDouble() + (volumeConversion.gallonToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToGallon(sum)
                            }
                        }
                    }
                }
                if(spinnerOne.selectedItemPosition == 1){
                    if(spinnerThree.selectedItemPosition == 0){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((volumeConversion.litreToMl(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()).toString()
                            1 -> {
                                var sum = (volumeConversion.litreToMl(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = volumeConversion.mlToLitre(sum)
                            }
                            2 -> {
                                var sum = (volumeConversion.litreToMl(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = volumeConversion.mlToGallon(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 1){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((volumeConversion.litreToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToLitre(sum)
                            }
                            2 -> {
                                var sum = (volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToGallon(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 2){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((volumeConversion.litreToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (volumeConversion.litreToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToLitre(sum)
                            }
                            2 -> {
                                var sum = (volumeConversion.litreToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToGallon(sum)
                            }
                        }
                    }
                }
                if(spinnerOne.selectedItemPosition == 2){
                    if(spinnerThree.selectedItemPosition == 0){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()).toString()
                            1 -> {
                                var sum = (volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = volumeConversion.mlToLitre(sum)
                            }
                            2 -> {
                                var sum = (volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + addQuantity.toDouble()
                                convertedQuantity.text = volumeConversion.mlToGallon(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 1){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToLitre(sum)
                            }
                            2 -> {
                                var sum = (volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.litreToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToGallon(sum)
                            }
                        }
                    }
                    if(spinnerThree.selectedItemPosition == 2){
                        when(spinnerTwo.selectedItemPosition) {
                            0 -> convertedQuantity.text =
                                ((volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.gallonToMl(addQuantity.toDouble())).toDouble()).toString()
                            1 -> {
                                var sum = (volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.gallonToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToLitre(sum)
                            }
                            2 -> {
                                var sum = (volumeConversion.gallonToMl(inputQuantity.toDouble())).toDouble() + (volumeConversion.gallonToMl(addQuantity.toDouble())).toDouble()
                                convertedQuantity.text = volumeConversion.mlToGallon(sum)
                            }
                        }
                    }
                }
            }
        }
    }
}

