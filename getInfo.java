/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testalgo;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author alial
 */
public class getInfo extends Application{
    private int n;

    public getInfo(int n) {
        this.n = n;
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
        
        Label[] label = new Label[this.n];
        TextField[] textfield = new TextField[this.n];
        
        for (int i = 0; i < this.n; i++) {
            Label L = new Label("Enter Guste Name Num("+Integer.toString(i+1)+") :");
            label[i] = L;
            TextField T = new TextField();
            textfield [i] = T;
            gride.add(label[i], 0, i);
            gride.add(textfield[i], 1, i);
        }
        
        Button btnback = new Button("Back");
        btnback.setOnAction((event) -> {
            primaryStage.close();
        });
        Button btn = new Button("Go");
        btn.setOnAction((event) -> {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if(isValidName(textfield[i].getText())){
                    continue;
                }else {
                    flag = false;
                    break;
                }
            }
            if (flag){
                ArrayList<String> str = new ArrayList<String>();
                for (int i = 0; i < n; i++) {
                    str.add(textfield[i].getText());
                }
                primaryStage.close();
                getInfo2 x = new getInfo2(str);
                Stage stage = new Stage();
                x.start(stage);
                stage.show();
            
            
            }
        });
        HBox hbtn = new HBox(btnback,btn);
        hbtn.setAlignment(Pos.CENTER);
        gride.add(hbtn, 0, n+1, 2, 1);
        root.setCenter(gride);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Widding Planner Info");
        primaryStage.setScene(scene);
        primaryStage.show();
        
}
    
    public static boolean isValidName(String s){      
     String regex="[A-Za-z\\s]+";      
      return s.matches(regex);//returns true if input and regex matches otherwise false;
 }
}