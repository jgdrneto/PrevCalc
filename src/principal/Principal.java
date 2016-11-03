package principal;

import java.io.IOException;

import hibernate.conexao.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.telaInicial.TelaInicialControlador;
import javafx.telaInicial.borderpane.BorderPaneInicioControlador;

public class Principal extends Application{

	
	/*
	 * Descrição: Método principal da aplicação
	 * 
	 * @params String[] : Argumentos passados por parâmetros na execução
	 */
	public static void main(String[] args) {
	
		launch(args);

	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		if(stage==null){
			System.out.println("Nulo");
		}
		
		iniciar(stage);
		
		HibernateUtil.finalizarConexao();
	}

	private void iniciar(Stage stage) {
		try {
			
			stage.setTitle("PrevCalc™");
			
			FXMLLoader loaderAnchor = new FXMLLoader();
		    loaderAnchor.setLocation(TelaInicialControlador.class.getResource("TelaInicial.fxml"));
		    AnchorPane tela = (AnchorPane) loaderAnchor.load();
		        
		    //-----------------------------------------------------------------------
		    FXMLLoader loaderBorder = new FXMLLoader();
		    loaderBorder.setLocation(BorderPaneInicioControlador.class.getResource("BorderPaneInicio.fxml"));
		    BorderPane rootLayout = (BorderPane) loaderBorder.load();
		        
		    rootLayout.setPrefSize(tela.getPrefWidth(), tela.getPrefHeight());
		        
		    rootLayout.setCenter(tela);
		    		    
		    Scene scene = new Scene(rootLayout);
		    stage.setScene(scene);
		    
		    // Define o controlador para o ADM
	        TelaInicialControlador aControlador = loaderAnchor.getController();	        
			aControlador.setStage(stage);

	        BorderPaneInicioControlador bControlador = loaderBorder.getController();
	        bControlador.setStage(stage);
	        
	        bControlador.settIControlador(aControlador);
	        aControlador.setbPIControlador(bControlador);
		    
		    stage.show();
	         
		} catch (IOException e) {
			e.printStackTrace();
	    }
	
	}

}
