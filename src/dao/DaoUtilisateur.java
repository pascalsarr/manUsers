package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Utilisateur;
@Stateless
public class DaoUtilisateur {
	private static final String		SELECT_ALL_USERS	= "SELECT u FROM Utilisateur u";
	
	
	@PersistenceContext(name = "man_users_pu")
	private static EntityManager	em;

	public  void ajouter(Utilisateur utilisateur) throws DaoException
	{
		try
		{	
			em.persist(utilisateur);	
		}
		catch (Exception e)
		{
			throw new DaoException(e);
		}
		finally
		{
			em.close();
		}

		
	}

	public List<Utilisateur> lister() throws DaoException
	{
		return em.createQuery(SELECT_ALL_USERS, Utilisateur.class)
				.getResultList();
	}
		
	

	public  void modifier(Utilisateur utilisateur)
	{
		// PreparedStatement preparedStatement;
		// try
		// {
		// preparedStatement = connexion
		// .prepareStatement(UPDATE_USER_PREPARED);
		// preparedStatement.setString(1, utilisateur.getNom());
		// preparedStatement.setString(2, utilisateur.getPrenom());
		// preparedStatement.setString(3, utilisateur.getPassword());
		// preparedStatement.setString(4, utilisateur.getLogin());
		// preparedStatement.executeUpdate();
		// }
		// catch (SQLException e)
		// {
		// throw new DaoException("Echec de la mise à jour", e);
		// }
	}

	public  void supprimer(Utilisateur utilisateur)throws DaoException
	                 {
		              em = ConnexionManager.getEntityManager();
                         try {
			               em.merge(utilisateur);
			                em.remove(utilisateur);
			 
                             } catch (Exception ex) {
       	                    throw new DaoException(ex);
                              } 
                         finally
                 		    {
                 		
                 			em.close();
                 	     	}
		                 }
       
		public  Utilisateur getUserByLogin(String login) 
	     	{
			em = ConnexionManager.getEntityManager();
			    try
		       	  {
			    	return  em.find(Utilisateur.class,login);
			      }
			    catch (Exception e)
			     {
				throw new DaoException(e);

			      }	
			
		    }
}
