package in.akash.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.akash.model.Student;
import in.akash.util.hibernateUtil;

public class XMLJavaApp {

	public static void main(String[] args) {
		Session session = null;
		SessionFactory sessionFactory = null;

		int id = 1;

		try {

			// empty configuration object got created
			Configuration configuration = new Configuration();// this line will search for hibernate.properties file

			// it is important to give properties or XML file name as HIBERNTE otherwise we
			// have to give it manually as it is unable to search the file .
			configuration.configure();// this line will search for cfg.xml file

			// providing information about mapping file
			configuration.addAnnotatedClass(Student.class);

			// from configuration object ,trying to build a session factory object
			sessionFactory = configuration.buildSessionFactory();

			// from sessionFactory Objectt ,trying to open a neew session
			session = sessionFactory.openSession();

			Student student = session.get(Student.class, id);
			System.out.println("Before updation in the table:" + student);
			if (student != null) {
				System.in.read();// go to db and make the changes
				session.refresh(student);
				System.out.println("after updation in the table :" + student);
			} else {
				System.out.println("Record available for the given id::" + id);

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}
}
