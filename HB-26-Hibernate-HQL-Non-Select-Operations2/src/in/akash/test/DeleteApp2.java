package in.akash.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.akash.model.products;
import in.akash.util.hibernateUtil;

//always remember ,while working with non select part in HIBERNATE transaction object is mandatory
public class DeleteApp2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args)

	{

//
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		int rowAffected =0;
		try

		{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			// prepare query object to hold hql

			// writing update query(Non-Select iN HQL and updating the qty of products )
			Query<products> query = session.createQuery(
					"DELETE FROM in.ineuron.model.products WHERE pname like :initialLetter");

			// set the parameters
			query.setParameter("initialLetter", "s%");
			

			// execute the query and update the table ->same as JDBC part
		 rowAffected = query.executeUpdate();

			flag = true;
		}

		catch (HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("rows affected is ::" + rowAffected);
				
			}else {
				transaction.rollback();
				System.out.println("no rows affected.");
			}
		}

	}
}
