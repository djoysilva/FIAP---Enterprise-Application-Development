package br.com.fiap.rmi;

import java.rmi.Naming;

import br.com.fiap.bo.CotacaoBO;

public class Client {
	public static void main(String[] args) throws Exception{
		CotacaoBO bo = (CotacaoBO) Naming.lookup("rmi://127.0.0.1:1234/objetoNome");
		
		double real = bo.converterBitCoinParaReal(20);
		
		System.out.println("R$" + real);
		
	}
}
