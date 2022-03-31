package com.example.unitconverterbridgelabz

class VolumeConversion {
    var result: String = ""
    fun mlToLitre(inputQuant:Double):String{
        result = (inputQuant/1000).toString()
        return result
    }
    fun mlToGallon(inputQuant:Double):String{
        result = ((inputQuant/1000)/4.54609).toString()
        return result
    }
    fun litreToMl(inputQuant:Double):String{
        result = (inputQuant*1000).toString()
        return result
    }
    fun litreToGallon(inputQuant:Double):String{
        result = (inputQuant/4.54609).toString()
        return result
    }
    fun gallonToMl(inputQuant:Double):String{
        result = ((inputQuant*4.54609)*1000).toString()
        return result
    }
    fun gallonToLitre(inputQuant:Double):String{
        result = (inputQuant*4.54609).toString()
        return result
    }
}