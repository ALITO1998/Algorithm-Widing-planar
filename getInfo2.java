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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author alial
 */
public class getInfo2 extends Application{
    private ArrayList <String> str ;

    public getInfo2(ArrayList<String> str) {
        this.str = str;
    }
    
    
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
        
        Label[] label = new Label[str.size()];
        CheckBox[][] check = new CheckBox[str.size()][str.size()];
        
        for (int i = 0; i < str.size(); i++) {
            Label L = new Label("Enter "+str.get(i)+" contacts :");
            label[i] = L;
            gride.add(label[i],0, i);
            for (int j = 0; j < str.size(); j++) {
                CheckBox C = new CheckBox(str.get(j));
                check[i][j]= C;
                gride.add(check[i][j], j+1, i);
            }
        }
        
        Button btnback = new Button("Back");
        btnback.setOnAction((event) -> {
            primaryStage.close();
        });
        Button btn = new Button("Go");
        //ArrayList<String[]> checked = new ArrayList<String[]>();
        btn.setOnAction((event) -> {
            int j = 0;
            HashMap<String,String[]> T=new HashMap<String,String[]>();
            for (int i = 0; i < str.size(); i++) {
                String[] c = new String[str.size()];
                int counter = 0;
                for (j = 0; j < str.size(); j++) {
                    if(check[i][j].isSelected()){
                        String l = str.get(j);
                        c[counter++] = l;
                    }
                    
                }
                
                T.put(str.get(i),c);
                

            }
            
            showresult x = new showresult(T,str);
            Stage stage = new Stage();
            x.start(stage);
            stage.show();
        });
        HBox hbtn = new HBox(25);
        hbtn.setAlignment(Pos.CENTER);
        HBox.setHgrow(btn, Priority.ALWAYS);
        HBox.setHgrow(btnback, Priority.ALWAYS);
        hbtn.getChildren().addAll(btnback, btn);
        gride.add(hbtn, 0, str.size(), str.size()+1, 1);
        root.setCenter(gride);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Widding Planner Info");
        primaryStage.setScene(scene);
        primaryStage.show();
        
}   
}
