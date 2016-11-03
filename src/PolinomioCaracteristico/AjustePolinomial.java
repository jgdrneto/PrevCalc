package PolinomioCaracteristico;

import java.util.ArrayList;
import java.util.List;

public class AjustePolinomial {
	
	private Matriz sistema;
	private Matriz resultado;
	
    public AjustePolinomial(List<Double> valoresIniciais, List<Double> valoresFinais, int grau) {
		if(grau>0 && valoresIniciais.size()==valoresFinais.size()){
			EncontrarSistemaLinear(valoresIniciais, valoresFinais, grau);
		}
	}
		
    private void EncontrarSistemaLinear(List<Double> valoresIni, List<Double> valoresFim, int grau) {
		 
		sistema = new Matriz(grau+1,grau+1);
		
		resultado = new Matriz(grau+1,1);
		
		ConstruirMatrizPrin(valoresIni);
		
		ConstruirMatrizResul(valoresIni,valoresFim);
		
	}
	
	private List<Double> listaExp(List<Double> valores, int j){
		
		List<Double> resultado = new ArrayList<Double>();
		
		for(int i=0;i<valores.size();i++){
			resultado.add(Math.pow(valores.get(i),j));
		}
		return resultado;
	}
	
	private double somatorio(int inicio, int fim, List<Double> v){
		
		double contador=0;
		
		for(int i=inicio-1;i<fim;i++){
			contador+=v.get(i);
		}
		
		return contador;
	}
	
    private void ConstruirMatrizPrin(List<Double> valoresIni) {

		List<Double>r = new ArrayList<Double>();
		
		for(int j=0;j<sistema.getNumLinhas();j++){
		 
			for(int i=j;i<sistema.getNumLinhas()+j;i++){
				r.add(somatorio(1,valoresIni.size(),listaExp(valoresIni, i)));
			}
			
			sistema.setLinha(j, r);
			r.clear();
		}
	}
	
	private void ConstruirMatrizResul(List<Double> valoresIni, List<Double> valoresFim){
		
		for(int i=0;i<resultado.getNumLinhas();i++){
			resultado.getM()[i][0] = somatorio(1,valoresFim.size(),multiplicaLista(valoresFim,listaExp(valoresIni, i)));		
		}
							
	}
	
	private List<Double> multiplicaLista(List<Double> valoresIni, List<Double> valoresFim){
		
		List<Double> resultado = new ArrayList<Double>();
		
		if(valoresFim.size()==valoresIni.size()){
			for(int i=0;i<valoresFim.size();i++){
				resultado.add(valoresIni.get(i)* valoresFim.get(i));
			}
			
			return resultado;
		}
		
		System.out.println("Erro, tamanhos de listas diferentes diferentes");
		System.exit(0);
		
		return null;
	}

	public Matriz getResultado() {
		return resultado;
	}

	public Matriz getSistema() {
		return sistema;
	}

}
