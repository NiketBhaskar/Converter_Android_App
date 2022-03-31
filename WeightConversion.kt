package com.example.unitconverterbridgelabz

class WeightConversion {
    var result: String = ""
    fun gramToKg(inputQuant:Double):String{
        result = (inputQuant/1000).toString()
        return result
    }
    fun gramToTonne(inputQuant:Double):String{
        result = ((inputQuant/1000)/1000).toString()
        return result
    }
    fun kgToGram(inputQuant:Double):String{
        result = (inputQuant*1000).toString()
        return result
    }
    fun kgToTonne(inputQuant:Double):String{
        result = (inputQuant/1000).toString()
        return result
    }
    fun tonneToGram(inputQuant:Double):String{
        result = ((inputQuant*1000)*1000).toString()
        return result
    }
    fun tonneToKg(inputQuant:Double):String{
        result = (inputQuant*1000).toString()
        return result
    }
}