package br.com.stefanini.provaqdois.persistence;

public interface IDao {
	
	public void open() throws Exception;
	public void close() throws Exception;
}
