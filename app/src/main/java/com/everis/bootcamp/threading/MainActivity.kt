package com.everis.bootcamp.threading

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODOà: 018 - fazer o handle do clique do botão
        btn_load_data.setOnClickListener {
            lauchAstroTask()
        }
    }


    //TODàO: 013 - Criar função para exibir os dados carregados

    fun ShowData(list:List<AstrosPeople>){
        tv_data.text = ""
        list?.forEach { people ->
            tv_data.append("${people.name} - ${people.craft} \n \n")

        }

    }


    //TOD0O: 014 - Criar função para exibir a ProgressBar
    //TODO0: 015 - Criar função para esconder a ProgressBar
    fun showLoadingIndicator(boolean: Boolean) {
        if (boolean) pb_load_indicator.visibility = View.VISIBLE else pb_load_indicator.visibility = View.GONE
    }





    //TODàO: 017 - Criar função para lançar a Task

    fun lauchAstroTask(){
        val task = TaskAstros()
        task.execute()
    }


    //TODOà: 016 - Criar classe interna para rodar a tarefa assincrona
    //inner class eh uma classe dentro de outra, esta herda os metodos
    //da classe em que ela esta inserida
    inner class TaskAstros(): AsyncTask<Void,Int, List<AstrosPeople>>(){
        val repository = AstrosRepository()

        //executa antes de rodar o codigo principal
        override fun onPreExecute() {
            super.onPreExecute()
            showLoadingIndicator(true)
        }

        override fun doInBackground(vararg p0: Void?): List<AstrosPeople> = repository.loadData()


        override fun onPostExecute(result: List<AstrosPeople>) {
            super.onPostExecute(result)
            showLoadingIndicator(false)
            ShowData(result)
        }






    }


}
