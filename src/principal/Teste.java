package principal;

import java.util.ArrayList;
import java.util.List;

import PolinomioCaracteristico.AjustePolinomial;
import PolinomioCaracteristico.FatoracaoLUPivotamentoParcial;

public class Teste {

    public static void main(String[] args) {

        List<Double> listaDosX;
        List<Double> listaDosY;
        AjustePolinomial ajuste;
        
        listaDosX = new ArrayList<Double>();
        listaDosY = new ArrayList<Double>();

        listaDosX.add((double)0);
        listaDosX.add((double)0.25);
        listaDosX.add((double)0.5);
        listaDosX.add((double)0.75);
        listaDosX.add((double)1);
               
        listaDosY.add((double)1);
        listaDosY.add((double)1.2840);
        listaDosY.add((double)1.6487);
        listaDosY.add((double)2.1170);
        listaDosY.add((double)2.7183);

        ajuste = new AjustePolinomial(listaDosX, listaDosY, 2);
        System.out.println("Sistema Linear\n");        
        ajuste.getSistema().imprimir();
            
        System.out.println("\n\nResultado\n");
            
        ajuste.getResultado().imprimir();
            
        FatoracaoLUPivotamentoParcial algoritmo = new FatoracaoLUPivotamentoParcial(ajuste.getSistema(), ajuste.getResultado());
            
        System.out.print("\nPolinomio: ");
            
        algoritmo.getP().imprimir();
            
        System.out.println("Resultado aplicado numero 1: " + algoritmo.getP().getResultado(1));
        
    }
}
