package br.com.fiap.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.fiap.bo.impl.CotacaoBOImpl;

public class server {
	public static void main(String[] args) throws Exception{
		Registry registry = LocateRegistry.createRegistry(1234);
		registry.bind("objetoNome", new CotacaoBOImpl());
		
		System.out.println("Objeto Registrado!");
	}
}
