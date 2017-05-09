package br.com.fiap.socket;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.fiap.bean.Aluno;

public class Server {
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(1234);
		System.out.println("Aguardando conexão....");
		Socket socket = server.accept();
		
		ObjectInputStream objectSream = new ObjectInputStream(socket.getInputStream());
		Aluno aluno = (Aluno) objectSream.readObject();
		
		System.out.println(aluno.getNome());
		System.out.println(aluno.getRm());
		
		objectSream.close();
		socket.close();
		server.close();
	}
}
