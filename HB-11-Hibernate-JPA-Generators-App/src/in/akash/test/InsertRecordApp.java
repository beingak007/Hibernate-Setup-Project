package in.akash.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.akash.model.Student;
import in.akash.util.hibernateUtil;

public class InsertRecordApp {

//in this first we check whether whether the record exist  or not,if the record exist then it will 
	// perform delete
	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;
		Integer id=null;

		try {
			session = hibernateUtil.getSession();
		
			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {
				Student student=new Student();
				student.setsAddres("kiir");
				student.setsAge(673);
				student.setsName("AJio");
					id=(Integer)session.save(student);
					flag = true;
				
			}

		
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				trnxn.commit();
				System.out.println("object inserted to the databse ."+id);

			} else {
				trnxn.rollback();
				System.out.println("object not inserted to database.....");
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
