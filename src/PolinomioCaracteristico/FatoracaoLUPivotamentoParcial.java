package PolinomioCaracteristico;

public class FatoracaoLUPivotamentoParcial {
	
	private Polinomio p;
	
	public Polinomio getP() {
		return p;
	}

    public FatoracaoLUPivotamentoParcial(Matriz sistema, Matriz resultado) {
		
		AnalisarMatrizes(sistema,resultado);
		
		resolverSistemaLinear(sistema,resultado);
	}
	
	private void AnalisarMatrizes(Matriz sistema, Matriz resultado) {
		// TODO Auto-generated method stub
		
		int linha = linhaMaiorCoeficiente(sistema);
		
		if(linha>1){
			sistema.trocarLinhas(1,linha);
			resultado.trocarLinhas(1,linha);
		}
		
	}

    private void resolverSistemaLinear(Matriz sistema, Matriz resultado) {
		// TODO Auto-generated method stub
		
		Matriz gauss = new Matriz(sistema.getNumLinhas(), sistema.getNumColunas());
		
		for(int i=0; i<gauss.getNumColunas()-1;i++){
			
			gauss = gauss.identidade();
			
			for(int r = i+1; r < gauss.getNumLinhas(); r++){
				gauss.getM()[r][i] =  sistema.getM()[r][i] * (-1.0) / sistema.getM()[i][i];
			}
			
            sistema = gauss.multiplicar(sistema);
            resultado = gauss.multiplicar(resultado);
				
			
			if(!SistemaPossivel(sistema)){
                //
			}
			
		}
		
		encontrarSolucao(sistema,resultado);
		
	}

	private void encontrarSolucao(Matriz sistema, Matriz resultado) {
		// TODO Auto-generated method stub
		
		double soma=0, aux=0;
		
		this.p = new Polinomio(resultado.getNumLinhas(),1);
		
		for(int i = sistema.getNumLinhas()-1; i >= 0; i--){
			for(int j = 0; j < sistema.getNumColunas(); j++){
				if(i == j){
					aux = sistema.getM()[i][j];
				}else{
					soma += sistema.getM()[i][j] * (this.p.getPolinomio().get(j));
				}
			}

			soma = soma * -1;
			this.p.getPolinomio().set(i,resultado.getM()[i][0] + soma);
			this.p.getPolinomio().set(i,this.p.getPolinomio().get(i)/aux);
			soma = 0;
		}

	}

	private boolean SistemaPossivel(Matriz sistema) {
		// TODO Auto-generated method stub
		//Verificando diagonal principal
		for(int i=0;i<sistema.getNumLinhas();i++){
			if(sistema.getM()[i][i]==0){
				return false;
			}
		}
		
		return true;
	}

	private int linhaMaiorCoeficiente(Matriz m){
		
		int lin=1; 
		double cont= modulo(m.getM()[0][0]);
		
		for(int i=1;i<m.getNumLinhas();i++){
			if(modulo(m.getM()[i][0]) > modulo(cont)){
				cont = modulo(m.getM()[i][0]);
				lin = i+1;
			}
		}
		
		return lin;
	}
	
	private double modulo(double cont){
		if(cont<0){
			return -1*cont;
		}else{
			return cont;
		}
	}
}
