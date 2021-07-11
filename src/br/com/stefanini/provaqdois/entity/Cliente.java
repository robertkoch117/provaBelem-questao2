package br.com.stefanini.provaqdois.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	public Cliente() {

	}

	public Cliente(Long id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void gerarCriptografia() throws Exception{
		String chave = "robertkoch@gmail.com;www.robertkoch.com.@=1=1;*123+;";
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		this.setSenha(this.getSenha() + chave);
		byte[] messageDigest = md5.digest(this.senha.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashText = no.toString(16);
		while(hashText.length()<32) {
			hashText = "0"+hashText;
		}
		String chave2 = "robertkoch@gmail.com;www.robertkoch.com.@=1=1;*123+;";
		MessageDigest md52 = MessageDigest.getInstance("MD5");
		this.setSenha(this.getSenha() + chave2);
		byte[] messageDigest2 = md5.digest(this.senha.getBytes());
		BigInteger no2 = new BigInteger(1, messageDigest2);
		String hashText2 = no.toString(16);
		while(hashText2.length()<32) {
			hashText2 = "0"+hashText2;
		}
		this.setSenha(hashText + hashText2);
	}

}
