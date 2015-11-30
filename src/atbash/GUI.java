package atbash;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        Scene stseen = new Scene(grid);


        primaryStage.setScene(stseen);
        primaryStage.setTitle("Atbash Cipher");
        primaryStage.getIcons().add(new Image(("file:Icon.png")));
        primaryStage.show();



        Label tahestikLabel = new Label("Tähestik: ");
        TextField tahestikInput = new TextField();
        Label sisendLabel = new Label("Šifreeritav sõna: ");
        TextField sisendInput = new TextField();
        Button sisesta = new Button("Sisesta");

        Label tahestik = new Label();
        Label sona = new Label();
        Label output = new Label();


        Button clear = new Button("Tühjenda väljad");

        grid.add(tahestikLabel,1,1);
        grid.add(tahestikInput,2,1);
        grid.add(sisendLabel,1,2);
        grid.add(sisendInput,2,2);
        grid.add(output,1,3);
        grid.add(sisesta,1,4);
        grid.add(clear,2,4);


        clear.setOnAction(event1 -> {
            tahestikInput.clear();
            sisendInput.clear();
            output.setText("");
        });

        sisesta.setOnAction(event -> {
            String ABC = tahestikInput.getText();
            String ABCnew = ABC.trim().replaceAll("\\s", "").toLowerCase();
            //System.out.println("Sisestatud tähestik on: " + ABCnew);
            tahestik.setText("Sisestatud tähestik on: " + ABCnew);
            java.util.List<String> abclist = new ArrayList<String>(Arrays.asList(ABCnew.split(""))); // tähestik listiks
            int LettersInABC = abclist.size(); // tähestiku pikkus

            String sisend = sisendInput.getText();
            String sisendNew = sisend.toLowerCase();
            sona.setText("Sisestatud sõna on: " + sisendNew);
            int WordLength = sisendNew.length(); // sõna pikkus
            List<String> CipherWordList = new ArrayList<String>(Arrays.asList(sisendNew.split(""))); // sõna listiks
            int LettersInWord = CipherWordList.size(); //sõna listi pikkus

            List<String> CipherOutputList = new ArrayList<String>(); // väljundi (dešifreeritud sõna) list

            for (int i=0; i<LettersInWord;i++){
                int ABCIndex = abclist.indexOf(CipherWordList.get(i));
                int ABCIndex2 = (LettersInABC - 1) - ABCIndex;
                CipherOutputList.add(i, abclist.get(ABCIndex2));
            }

            //Listi tegemine sõnaks
            String CipherOutput = String.join("",CipherOutputList);
            output.setText("Šifreeritud sõna on: " + CipherOutput);
        });


    }
}
