package br.com.stefanini.provaqdois.persistence;

import java.util.List;

import br.com.stefanini.provaqdois.dto.ClienteDto;

public interface IClienteDao {
	public ClienteDto findByCode(int code) throws Exception;
	public List<ClienteDto> findAllCliente() throws Exception;
	public Integer createCliente(ClienteDto cliente) throws Exception;
	public ClienteDto update(ClienteDto clientedto) throws Exception;
}
