package in.akash.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.akash.model.Student;


public class hibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	private hibernateUtil() {

	}

	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null) {
			session = sessionFactory.openSession();

		}
		return session;

	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();

		}

	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();

		}
	}
}
