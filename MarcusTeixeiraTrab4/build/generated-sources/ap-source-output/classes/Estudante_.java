package classes;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-29T17:39:41")
@StaticMetamodel(Estudante.class)
public class Estudante_ extends Usuario_ {

    public static volatile SingularAttribute<Estudante, String> cnpj;
    public static volatile SingularAttribute<Estudante, Date> dataNascimento;
    public static volatile SingularAttribute<Estudante, String> email;
    public static volatile SingularAttribute<Estudante, String> nomeCompleto;

}