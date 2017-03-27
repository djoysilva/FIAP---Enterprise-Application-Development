package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AutorDAO;
import br.com.fiap.dao.EditoraDAO;
import br.com.fiap.dao.EmprestimoDAO;
import br.com.fiap.dao.ExemplarDAO;
import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.imp.AutorDAOImpl;
import br.com.fiap.dao.imp.EditoraDAOImpl;
import br.com.fiap.dao.imp.EmprestimoDAOImpl;
import br.com.fiap.dao.imp.ExemplarDAOImpl;
import br.com.fiap.dao.imp.LivroDAOImpl;
import br.com.fiap.dao.imp.UsuarioDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Emprestimo;
import br.com.fiap.entity.Exemplar;
import br.com.fiap.entity.Livro;
import br.com.fiap.entity.Sexo;
import br.com.fiap.entity.Situacao;
import br.com.fiap.entity.Usuario;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class TesteDAO {
	
	public static void main(String[] args){
		Autor autor = new Autor(0, "Nome autor", "Sobrenome autor", Sexo.FEMININO, new GregorianCalendar(2017, Calendar.MARCH, 27));
		Editora editora = new Editora(0, "cnpj", "Nome Editora", "Endereço");
		Livro livro = new Livro(0, "titulo", 10, new GregorianCalendar(1988, Calendar.JUNE, 22), null);
		Usuario usuario = new Usuario(0, "nome usuario", "nomeU", "sobrenome usuario", "cpf");
		Exemplar exemplar = new Exemplar(0, new GregorianCalendar(1988, Calendar.JUNE, 22), Situacao.DISPONIVEL);
		Emprestimo emprestimo = new Emprestimo(0, new GregorianCalendar(1988, Calendar.APRIL, 22), new GregorianCalendar(1988, Calendar.AUGUST, 22));
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//AutorDAO
		AutorDAO autorDao = new AutorDAOImpl(em);
		autorDao.insert(autor);
		
		Autor autor2 = autorDao.findByid(1);
		autorDao.insert(autor2);
		System.out.println("\nNome busca: " + autor2.getNome());
		
		autor.setNome("Nome 2");
		autorDao.update(autor);
		System.out.println("Novo nome: " + autor.getNome());
		
		autorDao.delete(1);
		
		//EditoraDAO
		EditoraDAO editoraDao = new EditoraDAOImpl(em);
		editoraDao.insert(editora);
		
		Editora editora2 = editoraDao.findByid(1);
		editoraDao.insert(editora2);
		System.out.println("\nNome busca: " + editora2.getNome());
		
		editora.setNome("Editora2");
		editoraDao.update(editora);
		System.out.println("Novo nome: " + editora.getNome());
		
		editoraDao.delete(1);
	
		//LiroDAO
		LivroDAO livroDao = new LivroDAOImpl(em);
		livroDao.insert(livro);
		
		Livro livro2 = livroDao.findByid(1);
		livroDao.insert(livro2);
		System.out.println("\nNome busca: " + livro2.getTitulo());
		
		livro.setTitulo("Livro2");
		livroDao.update(livro);
		System.out.println("Novo nome: " + livro.getTitulo());
		
		livroDao.delete(1);
		
		//usuario
		UsuarioDAO usuarioDao = new UsuarioDAOImpl(em);
		usuarioDao.insert(usuario);
		
		Usuario usuario2 = usuarioDao.findByid(1);
		usuarioDao.insert(usuario2);
		System.out.println("\nNome busca: " + usuario2.getNome_usuario());
		
		usuario.setNome_usuario("Usuario2");
		usuarioDao.update(usuario);
		System.out.println("Novo nome: " + usuario.getNome_usuario());
		
		usuarioDao.delete(1);
		
		//exemplar
		ExemplarDAO exemplarDao = new ExemplarDAOImpl(em);
		exemplarDao.insert(exemplar);
		
		Exemplar exemplar2 = exemplarDao.findByid(1);
		exemplarDao.insert(exemplar2);
		System.out.println("\nSituação busca: " + exemplar2.getSituacao());
		
		exemplar.setSituacao(Situacao.EMPRESTADO);
		exemplarDao.update(exemplar);
		System.out.println("Nova Situação: " + exemplar.getSituacao());
		
		exemplarDao.delete(1);
		
		//emprestimo
		EmprestimoDAO emprestimoDao = new EmprestimoDAOImpl(em);
		emprestimoDao.insert(emprestimo);
		
		Emprestimo emprestimo2 = emprestimoDao.findByid(1);
		emprestimoDao.insert(emprestimo2);
		System.out.println("\nData busca: " + emprestimo2.getData_emprestimo().toString());
		
		emprestimo.setData_emprestimo(new GregorianCalendar(2017, Calendar.DECEMBER, 17));
		emprestimoDao.update(emprestimo);
		System.out.println("Nova data: " + emprestimo.getData_emprestimo().toString());
		
		emprestimoDao.delete(1);
		
		System.exit(0);
	}
}
