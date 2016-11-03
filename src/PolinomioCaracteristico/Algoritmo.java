package PolinomioCaracteristico;

import java.util.List;

public class Algoritmo {
	
	public static Polinomio gerarPolinomio(List<Double> dominio, List<Double> contraDominios){
		
		if(dominio.size()==contraDominios.size()){
			
			//Realizando o ajuste polinomial
			AjustePolinomial ajuste = new AjustePolinomial(dominio, contraDominios, dominio.size()-1);
			
			//Resolvendo o sistema linear
			FatoracaoLUPivotamentoParcial algoritmo = new FatoracaoLUPivotamentoParcial(ajuste.getSistema(), ajuste.getResultado());
			
			algoritmo.getP();
		}else{
			System.out.println("Domínio com tamanho diferente do contra-domínio");
		}
		
		return null;
	}
	
}
