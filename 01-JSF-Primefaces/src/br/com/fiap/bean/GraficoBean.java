package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.com.fiap.bo.ClienteBO;

@ManagedBean
public class GraficoBean {

	private PieChartModel pizza;
	private LineChartModel linha;
	
	private ClienteBO bo;
	
	@PostConstruct
	private void init(){
		pizza = new PieChartModel();
		bo = new ClienteBO();
		pizza.set("Ótimo", bo.buscarPorRating(10));
		pizza.set("Regular", bo.buscarPorRating(5));
		pizza.set("Ruim", bo.buscarPorRating(1));

		pizza.setShowDataLabels(true);
		pizza.setLegendPosition("e");
		
		/*Para criar o grafico
		1 - cria um atributo no grafico bean
		2 - cria um metodo pro grafico no Cliente DAO
		3 - Implementa o metodo pro grafico no Cliente DAO Imp
		4 - Faz a conexao com o metodo DAO no ClienteBO
		5 - Implementa na pagina xhtml
		*/
		
		//grafico linha
		linha = new LineChartModel();
		linha.setLegendPosition("e");
		linha.getAxes().put(AxisType.X, new CategoryAxis("Meses"));
		
		//criar linha no grafico
		LineChartSeries serie = new LineChartSeries();
		serie.setLabel("Cliente");
		
		for(int i = 1; i<=12; i++){
			serie.set(i, bo.contarPorMes(i));
		}
		
		linha.addSeries(serie);
	}

	public LineChartModel getLinha() {
		return linha;
	}

	public void setLinha(LineChartModel linha) {
		this.linha = linha;
	}
	
	public PieChartModel getPizza() {
		return pizza;
	}

	public void setPizza(PieChartModel pizza) {
		this.pizza = pizza;
	}
}
