package pt.rumos.academia.bd.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import pt.rumos.academia.bd.dao.DatabaseConfiguration;
import pt.rumos.academia.bd.dao.PostgresRegistosDao;
import pt.rumos.academia.bd.dao.RegistosDao;
import pt.rumos.academia.bd.dao.TestarRegistosDao;
import pt.rumos.academia.bd.entities.Registo;
import pt.rumos.academia.bd.utils.HashUtils;

public class RegistoService {
	
	private RegistosDao rDao = DatabaseConfiguration.obterRegistosDao();

	public Optional<Registo> listarRegistoByEmail(String curEmail) {
		return rDao.obterByEmail(curEmail);
	}
	
	public Optional<Registo> listarRegistoByUsername(String username) {
		return rDao.obterByUsername(username);
	}
	
	public List<Registo> listarRegisto() {
		
		var listaDeRegistos = rDao.obter();
		
		return listaDeRegistos;
	}
	
	public void criarRegisto(String email, String data, String username, String password) {
	    	var passwordHash = HashUtils.calcularHash(password);
	    	rDao.criar(new Registo(email, new Date(), username, passwordHash));  
	}
	
	public void removerRegisto(String email) {
		rDao.remover(email);
	}
	
	public void atualizarRegisto(String email, String data) {
		rDao.atualizar(email, data);
	}
	
	public void alterarPassword(String email, String password, String novapassword, String confirmacaopassword) {		
		
		// 1. obter o registo que existe na base de dados
		
		// 2. comparar a password que vem da BD com a password atual
		
		if(novapassword.equals(confirmacaopassword)) 
			rDao.atualizarpw(email, password, novapassword);
		
		else 
			System.out.println("Passwords incorretas!!");
	}
}
