package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.bean.Animal;

public class teste {
	public static void main(String[] args){
		Animal animal = new Animal();
		
		//Recuperar os atributos da classe animal
		Field[] atributos = animal.getClass().getDeclaredFields();
		
		//exibir atributos
		for(Field field:atributos){
			if(field.getAnnotation(Coluna.class) != null){
				Coluna anotacao = field.getAnnotation(Coluna.class);
				System.out.println("Atributo: " + field.getName() + 
							   		"\nColuna: "  + anotacao.nome());;
			}
		}
		
		//recuperar os metodos da classe animal
		Method[] metodos = animal.getClass().getDeclaredMethods();
		
		//Exibir o nome dos metodos
		
		for(Method method : metodos){
			//exibir o nome dos metodos
			System.out.println(method.getName());
		}
	}
}
