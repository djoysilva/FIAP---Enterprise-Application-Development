package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.beans.Animal;

public class Teste {

	public static void main(String[] args) {

		Animal animal = new Animal();
		
		//Recuperar os atributos da classe animal
		Field[] atributos = animal.getClass().getDeclaredFields();
		//Exibir os nomes dos atributos
		for(Field field : atributos) {
			Coluna anotacao = field.getAnnotation(Coluna.class);
			if(field.getAnnotation(Coluna.class) != null) {
				System.out.println("Atributo: " + field.getName() + "\nColuna: " + anotacao.nome());
			}
		}
		//Recuperar os metodos da classe animal
		System.out.println("Metodos da classe: \n");
		Method[] metodos = animal.getClass().getDeclaredMethods();
		for(Method method : metodos) {
			System.out.println(method.getName() + "\n");
		}
	}

}
