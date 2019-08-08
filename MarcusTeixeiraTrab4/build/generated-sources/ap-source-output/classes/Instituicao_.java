package classes;

import classes.Curso;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-29T17:39:41")
@StaticMetamodel(Instituicao.class)
public class Instituicao_ extends Usuario_ {

    public static volatile ListAttribute<Instituicao, Curso> cursos;
    public static volatile SingularAttribute<Instituicao, String> cnpj;
    public static volatile SingularAttribute<Instituicao, String> nomeFantazia;
    public static volatile SingularAttribute<Instituicao, String> razaoSocial;
    public static volatile SingularAttribute<Instituicao, Date> dataCriacao;
    public static volatile SingularAttribute<Instituicao, String> email;

}