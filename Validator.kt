package com.example.unitconverterbridgelabz

object Validator {
    fun validateInput(inputQuant:String):Boolean{
        return!(inputQuant.isEmpty() && inputQuant.isBlank())
    }
}