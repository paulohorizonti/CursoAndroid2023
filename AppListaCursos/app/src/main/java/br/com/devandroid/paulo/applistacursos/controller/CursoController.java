package br.com.devandroid.paulo.applistacursos.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.devandroid.paulo.applistacursos.model.Curso;

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
}
