package org.kapit.peopledirectory.webservices;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kapit.peopledirectory.dao.impl.UserDAOImpl;
import org.kapit.peopledirectory.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/authentication")
public class AuthenticationResource {

	private static final Logger LG = LoggerFactory.getLogger(AuthenticationResource.class);

	// URL : http://localhost:8080/peopledirectory/rest/authentication/username/password
	/**
	 * Permet d'authentifier l'utilisateur
	 * 
	 * @param username le nom d'utilisateur 
	 * @param password le mot de passe de l'utilisateur
	 * @return vrai si l'utilisateur est authentifie 
	 */
	
	@GET
	@Path("/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public User authentify(@PathParam("username") String username,
			@PathParam("password") String password) {

		LG.debug("Authentification de l'utilisateur {} en cours avec mot de passe : {}", username, password);

		try {
			User user = new UserDAOImpl().findUserByUsername(username);
			if(user == null) {
				LG.debug("Utilisateur non authentifie");
			} else
				if(user.getPassword().equalsIgnoreCase(password)) {
					LG.debug("L'utilisateur {} est authentifie ", username);
					return user;
				} else {
					LG.error("Combinaison Nom d'utilisateur/Mot de passe erronee");
				}
		} catch (Exception e) {
			LG.error(e.getMessage());
		}
		
		return null;
	}
}