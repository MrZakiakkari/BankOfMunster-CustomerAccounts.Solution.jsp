package sd4.com.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author alan.ryan
 */
public class AccountsDB
{
	public static List<Accounts> getAllAccounts() throws Exception
	{
		EntityManager entityManager = DBUtil.getEMF().createEntityManager();
		String sql = "SELECT a from Accounts a";
		TypedQuery<Accounts> query = entityManager.createQuery(sql, Accounts.class);
		try
		{
			return query.getResultList();
		}
		finally
		{
			entityManager.close();
		}
	}
	public static Accounts getAccountByID(int accountId) throws Exception
	{
		EntityManager entityManager = DBUtil.getEMF().createEntityManager();
		try
		{
			return entityManager.find(Accounts.class, accountId);
		}
		finally
		{
			entityManager.close();
		}
	}
	public static void insert(Accounts customer) throws Exception
	{
		EntityManager entityManager = DBUtil.getEMF().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try
		{
			transaction.begin();
			entityManager.persist(customer);
			transaction.commit();
		}
		finally
		{
			entityManager.close();
		}
	}
	public static void delete(Accounts customer) throws Exception
	{
		EntityManager entityManager = DBUtil.getEMF().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try
		{
			transaction.begin();
			entityManager.remove(entityManager.merge(customer));
			transaction.commit();
		}
		finally
		{
			entityManager.close();
		}
	}
	public static void update(Accounts customer) throws Exception
	{
		EntityManager entityManager = DBUtil.getEMF().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try
		{
			transaction.begin();
			entityManager.merge(customer);
			transaction.commit();
		}
		finally
		{
			entityManager.close();
		}
	}
}
