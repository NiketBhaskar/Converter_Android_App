package com.example.unitconverterbridgelabz

class LengthConversion {
    var result: String = ""
    fun cmToMeter(inputQuant:Double):String{
        result = (inputQuant/100).toString()
        return result
    }
    fun cmToKm(inputQuant:Double):String{
        result = ((inputQuant/100)/1000).toString()
        return result
    }
    fun meterToCm(inputQuant:Double):String{
        result = (inputQuant*100).toString()
        return result
    }
    fun meterToKm(inputQuant:Double):String{
        result = (inputQuant/1000).toString()
        return result
    }
    fun kmToCm(inputQuant:Double):String{
        result = ((inputQuant*100)*1000).toString()
        return result
    }
    fun kmToMeter(inputQuant:Double):String{
        result = (inputQuant*1000).toString()
        return result
    }
}