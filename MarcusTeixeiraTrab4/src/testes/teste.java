/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import classes.Aula;
import classes.Curso;
import classes.Estudante;
import classes.Exercicio;
import classes.Instituicao;
import classes.Status;
import dao.AulaDAO;
import dao.CursoDAO;
import dao.EstudanteDAO;
import dao.ExercicioDAO;
import dao.InstituicaoDAO;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Roberta
 */
public class teste {
    publicF static void main(String[] args) {
        /*Fiz todos os testes todos em apenas uma classe por conta dos relacionamentos, que para fazer o teste de uma implicaria no testes de outra entidade assim faria mais sentido fazer tudo em uma classe de testes apenas, para que sejam testadas não só a instancia quanto os relacionamentos
	como tinha que fazer varios testes existem alguns relacionamentos que foram deixados em branco para não ter que muitas coisas há mais*/
        InstituicaoDAO instDao = new InstituicaoDAO();
        EstudanteDAO estDao = new EstudanteDAO();
        CursoDAO cursoDao = new CursoDAO();
        AulaDAO aulaDao = new AulaDAO();
        ExercicioDAO exerDao = new ExercicioDAO();
        
        // teste instituição
        instDao.salvar(new Instituicao("Instituto federal poa","IFRS POA", "83.107.692/0001-07", new Date(), "duabud@dabdab.com", "fundador", "12345678"));
        instDao.salvar(new Instituicao("Iacnncsddn","sjdnsdnfldskfm", "83.944r94/0001-07", new Date(), "dddfdfsb.com", "fundador", "12345678"));
        List<Curso> c = new LinkedList<>();
        c.add(new Curso("java para iniciantes","ndaduasdknduashdusahdasdisnanddsa", new Date(), Status.ATIVO, "sasahsauhduisadsiddsa", "doasuhdasuhduiasdisau", 10));
        c.add(new Curso("java avançado","ndaduasdknduashdusahdasdisnanddsa", new Date(), Status.ATIVO, "sasahsauhduisadsiddsa", "doasuhdasuhduiasdisau", 5));
        Instituicao inst = new Instituicao("busbckvsdkjvsd","IcnsindoA", "83.107.692/0001-07", new Date(), "duabud@dabdab.com", "fundador", "12345678",c);
        instDao.salvar(inst);
        instDao.remover(2);
        Instituicao instituto = instDao.buscarId(1);
        instituto.setNomeFantazia("bom engove");
        instituto.setRazaoSocial("benegripe");
        instDao.atualizar(instituto);
        System.out.println("");
        List<Instituicao> instituicoes = instDao.buscarTodos();
        for(Instituicao in : instituicoes){
            System.out.println(in.toString());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        
        
        
        // Teste de curso
        cursoDao.salvar(new Curso("desenvolvimento android","ndaduasdknduashdusahdasdisnanddsa", new Date(), Status.ATIVO, "sasahsauhduisadsiddsa", "doasuhdasuhduiasdisau", 10));
        
        List<Curso> cursos = cursoDao.buscarTodos();
        for(Curso curso : cursos){
            System.out.println(curso.toString());
        }
        cursoDao.remover(1);
        System.out.println();
        Curso cur = cursoDao.buscarId(2);
        cur.setNome("carpintaria");
        cur.setStatus(Status.INDISPONIVEL);
        cursoDao.atualizar(cur);
        System.out.println(cursoDao.buscarId(2).toString());
        System.out.println("------------------------------------------------------------------------------------------------------------------------");        
        
        
        
        
        //testes estudante
        estDao.salvar(new Estudante("masmsa moamdoa sadmsad", "241.142.124-21", new Date(), "ndsndasldisa", "dnsadlasndias","dsuaou sasudo"));
        estDao.salvar(new Estudante("masmsa moamdoa sadmsad", "241.142.124-21", new Date(), "ndsndasldisa", "dnsadlasndias","dsuaou sasudo"));
        estDao.salvar(new Estudante("masmsa moamdoa sadmsad", "241.142.124-21", new Date(), "ndsndasldisa", "dnsadlasndias","dsuaou sasudo"));
        estDao.remover(2);
        
        List<Estudante> estu = estDao.buscarTodos();
        for(Estudante e : estu){
            System.out.println(e.toString());
        }
        System.out.println("");
        Estudante est1 = estDao.buscarId(1);
        est1.setNomeCompleto("israel antunes");
        est1.setEmail("asdksau@djsnd.com");
        estDao.atualizar(est1);
        System.out.println(estDao.buscarId(1).toString());
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        
        
        
        
        // teste Aula
        Curso curs = cursoDao.buscarId(2);
        aulaDao.salvar(new Aula("criar objeto", "huednadkuadnsadnuadnasdnksau", 1, curs));
        aulaDao.salvar(new Aula("usar objeto", "isdsdvnusdnvsnvosdnoisni", 2, curs));
        aulaDao.salvar(new Aula("excluir objeto", "buiwcudhnuskdfnufsdi", 3, curs));
        curs.setAulas(aulaDao.buscarTodos());
        cursoDao.atualizar(curs);
        
        aulaDao.remover(3);
        
        Aula au = aulaDao.buscarId(2);
        au.setTitulo("usar metodo do objeto");
        aulaDao.atualizar(au);
        
        List<Aula> aulas = aulaDao.buscarTodos();
        for(Aula a : aulas){
            System.out.println(a.toString());
        }
        // adicionei essa nova aula para ter 3 aulas para relacionar com os 3 exercicios ue seriam criados
        aulaDao.salvar(new Aula("persistir objeto", "buiwcudhnuskdfnufsdi", 3, curs));
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        
        
        
        // teste exercicio
        exerDao.salvar(new Exercicio("debkufwuibgigerg", "estancie um objeto", "jewfwbufewew", "wefwekufwfweg", "adaffdfsdfdserg", "kkkkkkkbgigerg", "wiefniwefiwebgigerg"));
        exerDao.salvar(new Exercicio("jewfwbufewew", "use um ojeto", "aaaaaaaanwffnnwuerg", "rrrrrfwfweg", "ewwwwwwwfsdfdserg", "dssssssskbgigerg", "wiefniwefiwebgigerg"));
        exerDao.salvar(new Exercicio("smdoasdmoasdmoawew", "pesista um ojeto na DB", "lllllllllbgigerg", "mmmmmmmmmmwfweg", "oooooooooofsdfdserg", "aaaaaaaakbgigerg", "wiefniwefiwebgigerg"));
        
        Aula aula1 = aulaDao.buscarId(1);
        aula1.setExercicio(exerDao.buscarId(1));
        aulaDao.atualizar(aula1);
        
        Aula aula2 = aulaDao.buscarId(2);
        aula2.setExercicio(exerDao.buscarId(2));
        aulaDao.atualizar(aula2);
        
        Aula aula4 = aulaDao.buscarId(4);
        aula4.setExercicio(exerDao.buscarId(3));
        aulaDao.atualizar(aula4);
        
        Exercicio exerci = exerDao.buscarId(3);
        exerci.setPergunta("como passar um objeto para o banco?");
        exerDao.atualizar(exerci);
        
        Aula aulExer = aulaDao.buscarId(2);
        aulExer.setExercicio(null);
        aulaDao.atualizar(aulExer);
        exerDao.remover(2);
        
        List<Exercicio> exercicios = exerDao.buscarTodos();
        for(Exercicio e : exercicios){
            System.out.println(e.toString());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        
        
        
        //teste da matricula de um aluno em em um curso
        Curso curso01 = cursoDao.buscarId(3);
        Curso curso02 = cursoDao.buscarId(2);
        Estudante est01 = estDao.buscarId(1);
        Estudante est02 = estDao.buscarId(3);
        
        List<Estudante> es = estDao.buscarTodos();
        
        List<Curso> cursos1 = new LinkedList<>();
        cursos1.add(curso01);
        cursos1.add(curso02);
        
        est01.setCursos(cursos1);
        est02.setCursos(cursos1);
        
        curso01.setEstudantes(es);
        curso02.setEstudantes(es);
        
        estDao.atualizar(est01);
        estDao.atualizar(est02);
        /*foi feita uma tabela chamada matricula_estudante aluno onde mostra em que curso o aluno esta 
        matriculado e vice versa*/
    }
}
