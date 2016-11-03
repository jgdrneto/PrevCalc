package PolinomioCaracteristico;

import java.util.ArrayList;
import java.util.List;

public class Polinomio {
	List<Double> polinomio;
	
	public Polinomio(int grau) {
		// TODO Auto-generated constructor stub
		
		if(grau<0){
			//Excessao
		}else{
			polinomio = new ArrayList<>();
			
			for (int i = 0; i < grau; i++) {
				polinomio.add(0.0);
			}
			
		}
		
	}
	
	public Polinomio(int grau, double valor) {
		// TODO Auto-generated constructor stub
		
		if(grau<0){
			//Excessao
		}else{
			polinomio = new ArrayList<>();
			
			for (int i = 0; i < grau; i++) {
				polinomio.add(1.0);
			}
		}
		
	}
	
	public List<Double> getPolinomio() {
		return polinomio;
	}

	public void setPolinomio(List<Double> polinomio) {
		this.polinomio = polinomio;
	}

	public void imprimir(){
		//imprime o polinômio
		for(int i=this.polinomio.size()-1;i>=0;i--){
			//Imprime o valor de "+" do polinômio, caso exista
			if(this.polinomio.get(i)>=0){
				System.out.print("+");
			}
			System.out.print(this.polinomio.get(i) + "x^" + i + " "); 	
		}
		System.out.print("\n");
	}
	
	public int getGrau(){
		return polinomio.size()-1;
	}
	
	public double getResultado(double x){
		double soma=0;

		//Somatório da aplicação do x em cada termo do polinômio
		for(Double i : this.polinomio){
			soma+= i * Math.pow(x,this.polinomio.indexOf(i)); 
		}

		return soma;
	}
	
}
