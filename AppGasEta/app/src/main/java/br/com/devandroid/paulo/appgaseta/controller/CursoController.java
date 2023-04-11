package br.com.devandroid.paulo.appgaseta.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.devandroid.paulo.appgaseta.model.Curso;

public class CursoController {
    private List listCursos; //objejo lista que sera preenchido
    public List getListaDeCursos(){
        listCursos = new ArrayList<Curso>(); //instanciando

        //adicionando objetos à lista
        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("Html"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("Python"));
        listCursos.add(new Curso("Flutter"));
        listCursos.add(new Curso("Dart"));


        return listCursos;
    }

    //metodo novo
    public ArrayList<String> dadosParaSpiner(){
        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i<getListaDeCursos().size(); i++){
            Curso objeto = (Curso) getListaDeCursos().get(i);
            dados.add(objeto.getNomeDoCurso());
        }
        return dados;
    }
}
