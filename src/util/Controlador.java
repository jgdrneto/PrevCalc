package util;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.telaInicial.TelaInicialControlador;
import javafx.telaInicial.borderpane.BorderPaneInicioControlador;

public class Controlador {
	Stage stage;
	
	TelaInicialControlador tIControlador;
	
	BorderPaneInicioControlador bPIControlador;

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		
		stage.getIcons().add(new Image("file:arquivos/logo.png"));
		
		this.stage = stage;
	}

	public TelaInicialControlador gettIControlador() {
		return tIControlador;
	}

	public void settIControlador(TelaInicialControlador tIControlador) {
		this.tIControlador = tIControlador;
	}

	public BorderPaneInicioControlador getbPIControlador() {
		return bPIControlador;
	}

	public void setbPIControlador(BorderPaneInicioControlador bPIControlador) {
		this.bPIControlador = bPIControlador;
	}
	
	
	
}
