package br.com.devandroid.paulo.appgaseta.util;

public class AppUtilGasEta {
    public void metodoNaoEstatico(){}

    public static void metodoEstatico(){}

    public static String mensagem(){
        return "Qualquer mensagem";
    }

    public static String calcularMelhorOpcao(double gasolina, double etanol){
        double precoIdeial = gasolina *0.70;

        String mensagemDeRetorno;

        mensagemDeRetorno = (etanol <=precoIdeial) ? "ABASTECER COM ETANAOL":"ABASTECER COM GASOLINA";

       return  mensagemDeRetorno;

    }

}
