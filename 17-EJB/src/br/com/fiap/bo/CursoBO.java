package br.com.fiap.bo;

import javax.ejb.Local;

@Local
public interface CursoBO {

	float calcularMedia(float nac, float ps, float am, float enade);
	
}