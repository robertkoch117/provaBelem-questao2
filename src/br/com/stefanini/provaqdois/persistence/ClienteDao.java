package br.com.stefanini.provaqdois.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.provaqdois.dto.ClienteDto;

public class ClienteDao extends Dao implements IClienteDao {

	@Override
	public ClienteDto findByCode(int code) throws Exception {
		open();
		stmt = conn.prepareStatement("SELECT * from cliente where idCliente=?");
		stmt.setInt(1, code);
		rs = stmt.executeQuery();
		ClienteDto clientedto = null;
		if (rs.next()) {
				clientedto = new ClienteDto();
				clientedto.setIdCliente(rs.getInt(1));
				clientedto.setNome(rs.getString(2));
				clientedto.setEmail(rs.getString(3));
				clientedto.setSenha(rs.getString(4));
		}
		close();
		return clientedto;
	}

	public Integer createCliente(ClienteDto cliente) throws Exception {
		open();
		Integer chave = 0;
		try {
			stmt = conn.prepareStatement("INSERT INTO cliente VALUES (null, ?, ?, ?)");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getSenha());
			System.out.println(cliente);
			stmt.executeUpdate();
			stmt.close();
			
			System.out.println("Inserido no banco com sucesso!");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();
		}
		return chave;
	}

	public List<ClienteDto> findAllCliente() throws Exception{
		ArrayList<ClienteDto> listaClientes = new ArrayList<ClienteDto>();
		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM cliente");
			rs = stmt.executeQuery();
			while(rs.next()) {
				ClienteDto cli = new ClienteDto();
				cli.setIdCliente(rs.getInt(1));
				cli.setNome(rs.getString(2));
				cli.setEmail(rs.getString(3));
				cli.setSenha(rs.getString(4));
				listaClientes.add(cli);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		return listaClientes;
	}

	@Override
	public ClienteDto update(ClienteDto clientedto) throws Exception {

		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("UPDATE cliente SET nome = ?, email = ?, senha = ?  WHERE idCliente = ?");
			stmt.setString(1,clientedto.getNome());
			stmt.setString(2,clientedto.getEmail());
			stmt.setString(3,clientedto.getSenha());
			stmt.setInt(4,clientedto.getIdCliente());
			stmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		
		return null;
	}
	
	public ClienteDto delete(ClienteDto clientedto) throws Exception {

		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");
			stmt.setLong(1,clientedto.getIdCliente());
			stmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		
		return clientedto;
	}
	
	public static void main(String[] args) {
		
		try{
			ClienteDto cdto = new ClienteDto();
			ClienteDao cdao = new ClienteDao();
			
			// Mock de Insercao no banco de dados
			//cdto.setNome("robert");
			//cdto.setEmail("robert@gmail.com");
			//cdto.setSenha("12345");
			//cdto.gerarCriptografia();
			//System.out.println("Id gerada: "+cdao.createCliente(cdto)); 
			
			// Mock de selecao no banco de dados
			
			//cdto = cdao.findByCode(2);
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
			//cdto.setIdCliente(3);
			//cdao.delete(cdto);
			//System.out.println("Delete feito com sucesso");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
