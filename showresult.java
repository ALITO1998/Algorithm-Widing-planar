/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testalgo;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author alial
 */
public class showresult extends Application{
    private HashMap<String,String[]> T;
    private ArrayList <String> str ;

    public showresult(HashMap<String, String[]> T, ArrayList<String> str) {
        this.T = T;
        this.str = str;
    }
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        Text footer = new Text("powred by @Alito");
        footer.setFont(Font.font("roman", 8));
        root.setBottom(footer);
        int n = numtable.num_table(str, T);
        Label L = new Label("You shoud have "+n+" table at least!");
        L.setPadding(new Insets(5, 25, 5, 10));
        root.setTop(L);
        Button btnback = new Button("Thank You");
        btnback.setOnAction((event) -> {
            primaryStage.close();
        });
        HBox hbtn = new HBox(btnback);
        hbtn.setAlignment(Pos.CENTER);
        hbtn.setPadding(new Insets(5,25,25,25));
        root.setCenter(hbtn);
        //root.setPadding(new Insets(0,25,0,25));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Widding Planner Resulte");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
