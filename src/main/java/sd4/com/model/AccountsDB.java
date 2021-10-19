/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd4.com.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;





/**
 *
 * @author alan.ryan
 */
public class AccountsDB {
    
    public static List<Accounts> getAllAccounts() {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        
        String query = "SELECT a from Accounts a";
        
        TypedQuery<Accounts> tq = em.createQuery(query, Accounts.class);
        
        List<Accounts> list = null;
        
        try {
            list = tq.getResultList();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        return list;
    }

    public static Accounts getAccountByID(int accountID) {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        Accounts account = null;
        try {
            account = em.find(Accounts.class, accountID);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return account;
    }
	public static void insert(Accounts customer)
	{
		 EntityManager em = DBUtil.getEMF().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(customer);
            trans.commit();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
            em.close();
        }  
        
    }//end insertAuthor()
	
	public static void delete(Accounts customer)
	{
		 EntityManager em = DBUtil.getEMF().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(customer));
            trans.commit();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
            em.close();
        }  
        
    }//end insertAuthor()
	
    
}
