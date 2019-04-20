/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testalgo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author alial
 */
public class TestAlgo extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        Text footer = new Text("powred by @Alito");
        footer.setFont(Font.font("roman", 8));
        root.setBottom(footer);
        
        GridPane gride = new GridPane();
        gride.setHgap(10);
        gride.setVgap(10);
        gride.setPadding(new Insets(25,25,25,25));
        Label header = new Label("Widding Planner Table Manegment");
        root.setTop(header);
        
        Label L1 = new Label("How many pepole attende to your party ?");
        gride.add(L1, 0, 1);
        
        TextField TF = new TextField();
        gride.add(TF, 1, 2);
        
        Button btn = new Button("Go");
        HBox hbtn = new HBox(btn);
        hbtn.setAlignment(Pos.CENTER);
        gride.add(hbtn, 0, 5, 2, 1);
        
        btn.setOnAction((event) -> {
            if(isValidInt(TF.getText())){
                getInfo x = new getInfo(Integer.parseInt(TF.getText()));
                Stage stage = new Stage();
                x.start(stage);
                stage.show();
            }
        });
        root.setRight(gride);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Widding Planner");
        primaryStage.setScene(scene);
        primaryStage.show();
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public boolean isValidInt(String s){      
     String regex="[1-9]+";      
      return s.matches(regex);//returns true if input and regex matches otherwise false;
 }
    
}
