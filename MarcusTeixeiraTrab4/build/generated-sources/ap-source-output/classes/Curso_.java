package classes;

import classes.Status;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-29T17:39:41")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, Integer> horas;
    public static volatile SingularAttribute<Curso, Date> ultimaAtualizacao;
    public static volatile SingularAttribute<Curso, String> imagem;
    public static volatile SingularAttribute<Curso, String> nome;
    public static volatile SingularAttribute<Curso, Long> id;
    public static volatile SingularAttribute<Curso, String> conteudoProgramatico;
    public static volatile SingularAttribute<Curso, Status> status;
    public static volatile SingularAttribute<Curso, String> descricao;

}