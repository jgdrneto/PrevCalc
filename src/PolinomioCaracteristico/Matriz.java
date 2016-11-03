package PolinomioCaracteristico;

import java.util.List;

public class Matriz {
	private double[][] m;
	private int linha;
	private int coluna;
	
    public Matriz(int nX, int nY) {

        this.linha = nX;
        this.coluna = nY;
				
        this.m = new double[this.linha][this.coluna];
				
        // Limpando a matriz, zerando os valores
        this.limpar();

	}
	
	public void limpar(){
		//Iniciando valores
		for(int i=0; i<this.linha;i++){
			for(int j=0;j<this.coluna;j++){
				this.m[i][j]=0;
			}
		}
	}
	
	public double[][] getM() {
		return m;
	}

	public int getNumLinhas() {
		return this.linha;
	}

	public int getNumColunas() {
		return this.coluna;
	}

	public void imprimir(){
		for(int i = 0;i < this.linha; i++){
			for(int j = 0;j < this.coluna;j++){
				System.out.printf("%.4f \t", m[i][j]);
			}
			System.out.println("");
		}
	}
	
    public Matriz somar(Matriz matriz2) {
		//Verificando se pode fazer a soma de matriz

        Matriz resultado = new Matriz(this.linha, this.coluna);
				
        // Fazendo a soma de matriz
        for (int l = 0; l < this.linha; l++) {
            for (int c = 0; c < this.coluna; c++) {
                resultado.m[l][c] = m[l][c] + matriz2.m[l][c];
            }
        }
				
        return resultado;

	}
	
    public Matriz subtrair(Matriz matriz2) {
		//Verificando se pode fazer a soma de matriz

        Matriz resultado = new Matriz(this.linha, this.coluna);
				
        // Fazendo a soma de matriz
        for (int l = 0; l < this.linha; l++) {
            for (int c = 0; c < this.coluna; c++) {
                resultado.m[l][c] = m[l][c] - matriz2.m[l][c];
            }
        }
        return resultado;
	}
	
	
    public Matriz multiplicar(Matriz matriz2) {

        // Criando a cara da matriz final
        Matriz resultado = new Matriz(this.linha, matriz2.coluna);
        // Criando contador
        double acumula = 0;
					
        // Fazendo a multiplicação de matriz
        for (int l = 0; l < this.linha; l++) {
            for (int c = 0; c < matriz2.coluna; c++) {
                acumula = 0;
                for (int i = 0; i < this.coluna; i++) {
                    acumula += this.m[l][i] * matriz2.m[i][c];
				}
                resultado.m[l][c] = acumula;
			}
        }
        return resultado;
	}
	
    public Matriz identidade() {
		
        // Criando a cara da matriz final
        Matriz resultado = new Matriz(this.linha, this.coluna);

        // Criando a matriz identidade
        for (int l = 0; l < this.linha; l++) {
            for (int c = 0; c < this.coluna; c++) {
                if (l == c) {
                    resultado.m[l][c] = 1;
                } else {
                    resultado.m[l][c] = 0;
                }
            }
        }

        return resultado;
	}
	
    Matriz transposta() {
        // Nova mariz com os valores da transposta
        Matriz resultado = new Matriz(this.coluna, this.linha);
			
        for (int i = 0; i < resultado.linha; i++) {
            for (int j = 0; j < resultado.coluna; j++) {
                resultado.m[i][j] = this.m[j][i];
            }
        }
				
        return resultado;
	}

    Matriz diagonalMat() {

        // Matriz que guardará a diagonal
        Matriz diagonal = new Matriz(this.linha, this.coluna);
				
        for (int i = 0; i < this.linha; i++) {
            for (int j = 0; j < this.coluna; j++) {
                if (i == j) {
                    diagonal.m[i][j] = this.m[i][j];
                } else {
                    diagonal.m[i][j] = 0;
				}
			}
		}
        return diagonal;

	}
	
    boolean verificaSimetria() {
		if(this.coluna!=this.linha){
            return false;
		}else{
			for(int i=0;i<this.linha;i++){
				for(int j=0;j<this.coluna;j++){
					if(this.m[i][j] != this.m[j][i]){
						return false;	
					}
				}	
			}
			return true;
		}
	}
	
    public void setLinha(int l, List<Double> lista) {
		
        for (int i = 0; i < this.coluna; i++) {
            this.m[l][i] = lista.get(i);
		}
		
	}
	
    public Matriz multiplicaPorEscalar(double escalar) {

        Matriz resultado = new Matriz(this.linha, this.coluna);
			
        for (int i = 0; i < this.linha; i++) {
            for (int j = 0; j < this.coluna; j++) {
                resultado.m[i][j] = this.m[i][j] * escalar;
			}
        }
	
        return resultado;
	}

	public void atribuirValorUnico(double valor){
		for(int i = 0; i < this.linha; i++){
			for(int j = 0; j < this.coluna; j++){
				this.m[i][j] = valor;
			}
		}
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(obj instanceof Matriz){
			
			Matriz m2 = (Matriz)obj;
			
			if(this.getNumLinhas()==m2.getNumLinhas() && this.getNumColunas()==m2.getNumColunas()){
				for(int i=0;i<this.linha;i++){
					for(int j=0;j<this.coluna;j++){
						if(this.m[i][j]!=m2.m[i][j]){
							return false;
						}
					}
				}
				return true;
			}
		}
		return false;
	}
	
    public Matriz getMatrizGrau(int i) {
		
        return subMatriz(i + 1, i + 1);
	}
	
    public Matriz subMatriz(int l, int c) {
		
        Matriz subM = new Matriz(l, c);
					
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                subM.m[i][j] = this.m[i][j];
            }
        }
					
        return subM;

	}
	
	public boolean linhasOuColunasLD(){
		return true;
	}
	
	public void trocarLinhas(int i, int j){

        for (int k = 0; k < this.coluna; k++) {
            swap(this.m[i][k], this.m[j][k]);
		}
	}

	private void swap(double d, double e) {
		// TODO Auto-generated method stub
		double x = d;
		d = e;
		e = x;
	}
	
}
