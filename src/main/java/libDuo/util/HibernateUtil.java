package libDuo.util;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import libDuo.model.Amics;
import libDuo.model.Avatar;
import libDuo.model.Botiga;
import libDuo.model.Categoria;
import libDuo.model.Curs;
import libDuo.model.CursosFets;
import libDuo.model.Exercicis;
import libDuo.model.ExercicisResolts;
import libDuo.model.Idioma;
import libDuo.model.Lliga;
import libDuo.model.Monedes;
import libDuo.model.Nivells;
import libDuo.model.PuntsExperiencia;
import libDuo.model.TipusExercici;
import libDuo.model.Usuari;



public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/BaseDuolingo?severTimezone=UTC");
				settings.put(Environment.USER, "admin");
				settings.put(Environment.PASS, "admin");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				
				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(Amics.class);
				configuration.addAnnotatedClass(Avatar.class);
				configuration.addAnnotatedClass(Botiga.class);
				configuration.addAnnotatedClass(Categoria.class);
				configuration.addAnnotatedClass(Curs.class);
				configuration.addAnnotatedClass(CursosFets.class);
				configuration.addAnnotatedClass(Exercicis.class);
				configuration.addAnnotatedClass(ExercicisResolts.class);
				configuration.addAnnotatedClass(Idioma.class);
				configuration.addAnnotatedClass(Lliga.class);
				configuration.addAnnotatedClass(Monedes.class);
				configuration.addAnnotatedClass(Nivells.class);
				configuration.addAnnotatedClass(PuntsExperiencia.class);
				configuration.addAnnotatedClass(TipusExercici.class);
				configuration.addAnnotatedClass(Usuari.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}