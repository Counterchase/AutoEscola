package com.autoescola.repository;


import com.autoescola.model.Aluno;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Dependent
public class Alunos implements Serializable {

    //Responsável por gerencial o ciclo de vida das entidades
    @Inject
    private EntityManager em;
    

    //Construtor
    public Alunos() {
    }

    //Construtor recebe como parametros um EntityManager
    public Alunos(EntityManager em) {
        this.em = em;
    }

    //Localizar Aluno pelo ID
    public Aluno porID(Long id) {
        return em.find(Aluno.class, id);
    }

    public List<Aluno> pesquisarPorNome(String nome) {
        TypedQuery<Aluno> query = em.createQuery("from Aluno where nome like :nome", Aluno.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();
    }

    public List<Aluno> pesquisarTodos() {
        return em.createQuery("from Aluno", Aluno.class).getResultList();
    }

    //Salvar ou Alterar um Aluno
    public Aluno salvar(Aluno Aluno) {
        return em.merge(Aluno);
    }

    public void excluir(Aluno aluno) {
        aluno = porID(aluno.getId());
        em.remove(aluno);
    }

}
