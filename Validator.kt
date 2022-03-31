package com.example.unitconverterbridgelabz

object Validator {
    fun validateInput(inputQuant:String,quantityInDouble: Double):Boolean{
        return!(quantityInDouble <= 0 || inputQuant.isEmpty())
    }
}