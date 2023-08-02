package br.com.devandroid.paulo.appgaseta.util;

public class AppUtilGasEta {
    public void metodoNaoEstatico(){}

    public static void metodoEstatico(){}

    public static String mensagem(){
        return "Qualquer mensagem";
    }

    public static String calcularMelhorOpcao(double gasolina, double etanol){
        //mensagem de retorno
        String mensagemDeRetorno;


            double precoIdeial = gasolina *0.70;



            //condicional
            /**
             if(etanol <=precoIdeial) //se for menor que o preõ ideal, ou igual
             {
             mensagemDeRetorno = "Abastecer com Etanol"; //lança essa mensagem

             }else{
             mensagemDeRetorno = "Abastecer com Gasolina"; //lança essa
             }
             **/

            //SEIMPLIFICADA
            mensagemDeRetorno = (etanol <=precoIdeial) ? "ABASTECER COM ETANAOL":"ABASTECER COM GASOLINA";




        //Retorna
       return  mensagemDeRetorno;

    }

}
