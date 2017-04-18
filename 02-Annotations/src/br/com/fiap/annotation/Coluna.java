package br.com.fiap.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Anotacao estara presente ate a execucao
@Retention(RetentionPolicy.RUNTIME)
//Anotacao somente para os atributos e metodos
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Coluna {
	String nome();
}