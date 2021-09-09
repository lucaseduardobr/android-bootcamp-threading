package com.everis.bootcamp.threading

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request


//TODOà: 010 - Criar a classe responsável por carregar os dados
//carregar nossos dados do servidor
class AstrosRepository {

    //TODO0: 011 - Criar função para carregar os astronautas
    fun loadData():List<AstrosPeople>{
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("http://api.open-notify.org/astros.json")
            .build()

        val response = client.newCall(request).execute()
        //agora temos que converter ele para o tipo
        //Astro Result
        val result = parseJsonToResult(response.body?.string())
        return result.people

    }

    //TODOà: 012 - Criar função para converter o json
    fun parseJsonToResult(json:String?) = Gson().fromJson(json, AstrosResult::class.java)

}