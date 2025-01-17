package in.akash.test;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.akash.model.InsurancePolicy1;
import in.akash.util.hibernateUtil;

public class ClientApp2 {
	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		Boolean flag = false;

		int id = 1;
		try {
			session = hibernateUtil.getSession();

			if (session != null) {
				trnxn = session.beginTransaction();
				InsurancePolicy1 ipp = session.get(InsurancePolicy1.class, id,LockMode.UPGRADE_NOWAIT);
				System.out.println(ipp);

				ipp.setTenure(110);
				flag = true;

			}

			else {
				System.out.println("Record not available for this id.." + id);
			}

		}

		catch (

		HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				trnxn.commit();
				System.out.println("object updated with id::" + id);
			} else {
				trnxn.rollback();
				System.out.println("object not updated ::" + id);
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
