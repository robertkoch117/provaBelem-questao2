package br.com.stefanini.provaqdois.controller;

import br.com.stefanini.provaqdois.dto.ClienteDto;
import br.com.stefanini.provaqdois.persistence.ClienteDao;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ClienteDto cdto = new ClienteDto();
		ClienteDao cdao = new ClienteDao();
		
		// Mock de Insercao no banco de dados
		//cdto.setNome("robert");
		//cdto.setEmail("robert@gmail.com");
		//cdto.setSenha("12345");
		//cdto.gerarCriptografia();
		//System.out.println("Id gerada: "+cdao.createCliente(cdto)); 
		
		// Mock de selecao no banco de dados
		
		//cdto = cdao.findByCode(3);
		//System.out.println(cdto);
		
		// Mock de atualizacao no banco de dados
		//cdto.setIdCliente(2);
		//cdto.setNome("Edson");
		//cdto.setEmail("edson@gmail.com");
		//cdto.setSenha("12345123");
		//cdto.gerarCriptografia();
		//cdto = cdao.update(cdto);
		
		//Mock de selecao total no banco de dados
		//System.out.println(cdao.findAllCliente());
		
		//Mock de delecao de usuario no banco de dados
		cdto.setIdCliente(3);
		cdao.delete(cdto);
		System.out.println("Delete feito com sucesso");
	}

}
