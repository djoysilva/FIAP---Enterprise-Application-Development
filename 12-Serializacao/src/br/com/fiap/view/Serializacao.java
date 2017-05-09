package br.com.fiap.view;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import br.com.fiap.bean.Aluno;

public class Serializacao {
	public static void main(String[] args) throws Exception{
		FileOutputStream fileStream = new FileOutputStream("arquivo.txt");
		ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
		
		Aluno aluno = new Aluno("Joyce", "76983");
		objectStream.writeObject(aluno);
		
		System.out.println("Aluninha serializada, linda");
		
		objectStream.close();
		
		fileStream.close();
	}
}
