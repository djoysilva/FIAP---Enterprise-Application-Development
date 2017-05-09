package br.com.fiap.socket;

import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.fiap.bean.Aluno;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("10.10.63.71", 1234);
		while (true){
			ObjectOutputStream objectStream = new ObjectOutputStream(socket.getOutputStream());
			
			try{
				Aluno aluno = new Aluno("Joyce", "76983");
				
				objectStream.writeObject(aluno);
				System.out.println("Serializado");
				
				objectStream.close();
				socket.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
