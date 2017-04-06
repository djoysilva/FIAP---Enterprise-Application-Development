package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView {

	public static void main(String[] args) {
		//Chamar o listar do PacoteDAO e exibir os pacotes
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		TransporteDAO tDao = new TransporteDAOImpl(em);
		ClienteDAO cDao = new ClienteDAOImpl(em);
		PacoteDAO dao = new PacoteDAOImpl(em);
		
		List<Pacote> pacotes = dao.listar();
		Transporte transporte = tDao.pesquisar(1);
		
		
		
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao() + " - R$" + pacote.getPreco() + " - " + pacote.getQtdDias());
		}
		
		//Buscar os pacotes pelo preço maximo
		List<Pacote> lista = dao.buscarPorPreco(2100);
		
		for (Pacote pacote : lista) {
			System.out.println(pacote.getDescricao() + " - Preço:" + pacote.getPreco());
		}
		
		//Buscar por transporte
		List<Pacote> pPorTransporte = dao.buscarPorTransporte(transporte);
		
		for (Pacote pacote : pPorTransporte) {
			System.out.println(pacote.getDescricao());
		}
		
		//Buscar por estado
		List<Cliente> clientes = cDao.buscarPorEstado("SP");
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome() + " - " + cliente.getEndereco().getCidade().getNome());
		}
		
		//Buscar por dia de Reserva
		List<Cliente> cPorDia = cDao.buscarPorDiaReserva(10);
		
		for (Cliente cliente : cPorDia) {
			System.out.println(cliente.getNome());
		}
		
		//Buscar entre datas
		List<Pacote> entreData = dao.buscarPorDatas(new GregorianCalendar(2017, Calendar.SEPTEMBER, 22), new GregorianCalendar(2017, Calendar.SEPTEMBER, 27));
		
		for (Pacote pacote : entreData) {
			System.out.println("--------" + pacote.getDescricao());
		}
		
		em.close();
		System.exit(0);
	}
}
