package br.gms.wssispoker.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.gms.wssispoker.entity.Jogador;
import br.gms.wssispoker.persistence.ConfiguracaoDAO;
import br.gms.wssispoker.persistence.JogadorDAO;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.Credentials;
import br.gov.frameworkdemoiselle.security.InvalidCredentialsException;
import br.gov.frameworkdemoiselle.security.User;
import br.gov.frameworkdemoiselle.util.Beans;

@RequestScoped
public class AppAuthenticator implements Authenticator {

	private static final long serialVersionUID = 1L;

	private User user;

	@Inject
	private JogadorDAO jogadorDao;

	private static MessageDigest md = null;

	@Override
	public void authenticate() throws Exception {
		Credentials credentials = Beans.getReference(Credentials.class);

		Jogador jogador = new Jogador(credentials.getUsername());
		Jogador retorno = jogadorDao.getJogadorByEmail(jogador);

		if (retorno != null
				&& md5(credentials.getPassword()).equals(
						retorno.getSenha())) {
			this.user = new AppUser(credentials.getUsername());
		} else {
			throw new InvalidCredentialsException();
		}
	}
	
	
	//Função para criar hash da senha informada  
    public static String md5(String senha){  
        String sen = "";  
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  
        sen = hash.toString(16);              
        return sen;  
    }  

	@Override
	public void unauthenticate() throws Exception {
		this.user = null;
	}

	@Override
	public User getUser() {
		return this.user;
	}
}
