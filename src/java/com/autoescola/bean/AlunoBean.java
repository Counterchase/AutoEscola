/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoescola.bean;

import com.autoescola.model.Aluno;
import com.autoescola.repository.Alunos;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Counterchase
 */
@Named
@RequestScoped
public class AlunoBean implements Serializable{
    @Inject
    private Alunos alunos;
    private List<Aluno> listaDeAlunos;
    
    public void todosOsAlunos(){
        listaDeAlunos = alunos.pesquisarTodos();
    }
    
    public List<Aluno> getListaDeAlunos(){
        return listaDeAlunos;
    }
}
