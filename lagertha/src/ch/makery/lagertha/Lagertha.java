package ch.makery.lagertha;

import ch.makery.lagertha.models.Gramatica;
import ch.makery.lagertha.view.FXMLlagerthaController;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Kleyson
 */
public class Lagertha extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    public Gramatica gramatica;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Lagertha");
        
        // Set the application icon.
        //this.primaryStage.getIcons().add(new Image("file:resources/images/icone3.png"));
        
        ArrayList<String> regrasDeProducao = new ArrayList<>();
        ArrayList<String> variaveis = new ArrayList<>();
        
        variaveis.add("R");
        variaveis.add("E");
        variaveis.add("G");
        variaveis.add("L");
        
        String a = "R -> a | s | £";
        String b = "E -> as";
        String c = "G -> aEs";
        String d = "L -> a | s | £";
        
        regrasDeProducao.add(a);
        regrasDeProducao.add(b);
        regrasDeProducao.add(c);
        regrasDeProducao.add(d);
        
        gramatica = new Gramatica(variaveis, variaveis, regrasDeProducao, "s");
        
        
        initRootLayout();
        showPersonOverview();
        
    }
    
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Lagertha.class.getResource("view/Palco.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra o person overview dentro do root layout.
     */
    public void showPersonOverview() {
        try {
            // Carrega o person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Lagertha.class.getResource("view/FXMLlagertha.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Define o person overview dentro do root layout.
            rootLayout.setCenter(personOverview);

            // Dá ao controlador acesso à the main app.
            //FXMLlagerthaController controller = loader.getController();
            //controller.setRagnarok(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
