package com.everis.bootcamp.threading

import com.google.gson.annotations.SerializedName


//TOD0O: 009 Criar classe para representar o resultado da api
data class AstrosResult(
    //acesse esse link http://api.open-notify.org/astros.json
    //veremos um json
    //pessoas eh uma lista
    //por isso fizemos a classe astros people
    //para depois aqui fazermos um objeto people
    //ser uma lista de AstrosPeople
    @SerializedName("message") val message:String,
    @SerializedName("number") val number:Int,
    @SerializedName("people") val people: List<AstrosPeople>



        )