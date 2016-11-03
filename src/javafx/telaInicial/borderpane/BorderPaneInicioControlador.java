package javafx.telaInicial.borderpane;

import javafx.fxml.FXML;
import util.Controlador;

public class BorderPaneInicioControlador extends Controlador{
	
	@FXML
    private void initialize() {
    	//Nada a se inicializar
    }
	
	@FXML
	private void sair(){
		this.getStage().close();
	}
}
