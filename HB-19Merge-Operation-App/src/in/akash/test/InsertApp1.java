package in.akash.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.akash.model.Student;
import in.akash.util.hibernateUtil;

public class InsertApp1 {

	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;

		try {
			session = hibernateUtil.getSession();
			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {
				// in this case PROGRAMMER should know that record inside the table.
				Student student = new Student();
				student.setsName("chris");
				student.setSid(04);
				student.setsAge(47);
				student.setsAddres("tnt");

				session.save(student);
				flag = true;

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				trnxn.commit();
				System.out.println("object updated to the databse .");

			} else {
				trnxn.rollback();
				System.out.println("object not updated to database.....");
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
