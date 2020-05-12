package br.com.kely.alcoolougasolina

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view: View) {

        //recupera valores digitados
        //val precoAlcool = findViewById<EditText>(R.id.editTextPrecoAlcool)
        //val precoGasolina = findViewById<EditText>(R.id.editTextPrecoGasolina)

        //Converte o EditText para String
        //val textoRecuperado = precoAlcool.text.toString()

        //OU
        //recupera valores digitados e Converte o EditText para String
        val precoAlcool = editTextPrecoAlcool.text.toString()
        val precoGasolina = editTextPrecoGasolina.text.toString()

        //Log.i("RESULTADO", "texto recuperado: $precoAlcool")

        //Validar os campos através da chamada do metodo validarCampos
        val validarCampos = validarCampos(precoAlcool, precoGasolina)
        if(validarCampos){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        }else{
            textViewResultado.setText("Preencha os campos primeiro!")
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String) : Boolean{

        var camposValidados : Boolean = true

        //valida o preenchimento dos campos
        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if(precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }

        return camposValidados

    }

    fun calcularMelhorPreco(precoAlcool : String, precoGasolina : String){

        //Converte valores String para numero
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /*Faz cálculo(precoAlcool/ precoGasolina)
        *** Se resultado >= 0.7 melhor utilizar gasolina
        *** Senão melhor utilizar alcool
        */
        val resultadoPreco = valorAlcool/valorGasolina

        if(resultadoPreco >= 0.7){
            textViewResultado.setText("Melhor utilizar Gasolina!")
        }else{
            textViewResultado.setText("Melhor utilizar Àlcool!")
        }
    }
}
