/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;
import javafx.scene.layout.GridPane;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author uclak
 */
public class FXMLDocumentController implements Initializable {
    Operations history = new Operations();
    Float data = 0f;
    int operation = -1;
    
      @FXML
    private Button nine;

    @FXML
    private Button minus;

    @FXML
    private Button six;

    @FXML
    private Button one;

    @FXML
    private Button clear;

    @FXML
    private Button seven;

    @FXML
    private Label label;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button plus;

    @FXML
    private Button eight;

    @FXML
    private Button zero;

    @FXML
    private Button four;

    @FXML
    private Button equals;

    @FXML
    private Button divide;

    @FXML
    private Button multiply;

    @FXML
    private Button five;

    @FXML
    private TextField Display;

    @FXML
    private GridPane grid;
    
    @FXML
    private TextArea HistoryText;
    
    @FXML
    private ToggleButton History;
    @FXML
    void handleButtonAction(ActionEvent event) {
        String regex = "\\d{0,15}"; 
        if(Pattern.matches(regex, Display.getText()))
        {
            if(event.getSource()== one){
            Display.setText(Display.getText() + "1");
        }else if(event.getSource()== two){
             Display.setText(Display.getText() + "2");
        }else if(event.getSource()== three){
             Display.setText(Display.getText() + "3");
        }else if(event.getSource()== four){
             Display.setText(Display.getText() + "4");
        }else if(event.getSource()== five){
             Display.setText(Display.getText() + "5");
        }else if(event.getSource()== six){
             Display.setText(Display.getText() + "6");
        }else if(event.getSource()== seven){
             Display.setText(Display.getText() + "7");
        }else if(event.getSource()== eight){
             Display.setText(Display.getText() + "8");
        }else if(event.getSource()== nine){
             Display.setText(Display.getText() + "9");
        }else if(event.getSource()== zero){
             Display.setText(Display.getText() + "0");
        }else if(event.getSource()==clear){
            System.out.println("1");
             Display.setText("");
        }else if(event.getSource()== plus){
             data = Float.parseFloat(Display.getText());
             operation =  1;
             Display.setText("");
        }else if(event.getSource()== minus){
             data = Float.parseFloat(Display.getText());
             operation =  2;
             Display.setText("");
        }else if(event.getSource()== multiply){
             data = Float.parseFloat(Display.getText());
             operation =  3;
             Display.setText("");
        }else if(event.getSource()== divide){
             data = Float.parseFloat(Display.getText());
             operation =  4;
             Display.setText("");
        }else if(event.getSource()== equals){
            Float secondOperation = Float.parseFloat(Display.getText());
            switch(operation){
                case 1:
                    Float ans = data + secondOperation;
                    history.addOperation(data + " + " + secondOperation + " = " + ans);
                    Display.setText(String.valueOf(ans));
                        FileOutputStream fos = null;
                        File file;
                        String mycontent = String.valueOf(ans); 
                        try {
                        //Specify the file path here
                        file = new File("Calculator_History.txt");
                        fos = new FileOutputStream(file);

                        if (!file.exists()) {
                        file.createNewFile();
                        }
                        byte[] bytesArray = mycontent.getBytes();

                        fos.write(bytesArray);
                        fos.flush();
                        fos.close();
                        }
                    catch(IOException e)
                    {
                    System.out.printf("Exception");
                    }
                    break;
                case 2:
                     ans = data - secondOperation;
                     history.addOperation(data + " - " + secondOperation + " = " + ans);
                    Display.setText(String.valueOf(ans));
                        fos = null;
                        mycontent = String.valueOf(ans); 
                        try {
                        //Specify the file path here
                        file = new File("Calculator_History.txt");
                        fos = new FileOutputStream(file);

                        if (!file.exists()) {
                        file.createNewFile();
                        }
                        byte[] bytesArray = mycontent.getBytes();

                        fos.write(bytesArray);
                        fos.flush();
                        fos.close();
                        }
                    catch(IOException e)
                    {
                    System.out.printf("Exception");
                    }
             
                    break;
                case 3:
                     ans = data * secondOperation;
                     history.addOperation(data + " * " + secondOperation + " = " + ans);
                    Display.setText(String.valueOf(ans));
                         fos = null;
                         mycontent = String.valueOf(ans); 
                        try {
                        //Specify the file path here
                        file = new File("Calculator_History.txt");
                        fos = new FileOutputStream(file);

                        if (!file.exists()) {
                        file.createNewFile();
                        }
                        byte[] bytesArray = mycontent.getBytes();

                        fos.write(bytesArray);
                        fos.flush();
                        fos.close();
                        }
                    catch(IOException e)
                    {
                    System.out.printf("Exception");
                    }
             
                    break;
                case 4:
                    ans = 0f;
                    try{
                    ans = data / secondOperation;
                    history.addOperation(data + " / " + secondOperation + " = " + ans);
                    }catch(Exception e){Display.setText("Error");} 
                    Display.setText(String.valueOf(ans));
                        fos = null;              
                        mycontent = String.valueOf(ans); 
                        try {
                        //Specify the file path here
                        file = new File("Calculator_History.txt");
                        fos = new FileOutputStream(file);

                        if (!file.exists()) {
                        file.createNewFile();
                        }
                        byte[] bytesArray = mycontent.getBytes();

                        fos.write(bytesArray);
                        fos.flush();
                        fos.close();
                        }
                    catch(IOException e)
                    {
                    System.out.printf("Exception");
                    }
             
                    break;
                }   
            }
        }
        else
        {
            if(event.getSource()==clear){
            Display.setText("");
            }else if(Display.getText().length() == 15){
            }else if(event.getSource()== plus){
            data = Float.parseFloat(Display.getText());
            operation =  1;
            Display.setText("");
            }else if(event.getSource()== minus){
            data = Float.parseFloat(Display.getText());
            operation =  2;
            Display.setText("");
            }else if(event.getSource()== multiply){
            data = Float.parseFloat(Display.getText());
            operation =  3;
            Display.setText("");
            }else if(event.getSource()== divide){
            data = Float.parseFloat(Display.getText());
            operation =  4;
            Display.setText("");
            }else if(event.getSource()== equals){
            Float secondOperation = Float.parseFloat(Display.getText());
            switch(operation){
                case 1:
                    Float ans = data + secondOperation;
                    history.addOperation(data + " + " + secondOperation + " = " + ans);
                    Display.setText(String.valueOf(ans));
                    FileOutputStream fos = null;
                        File file;
                        String mycontent = String.valueOf(ans); 
                        try {
                        file = new File("Calculator_History.txt");
                        fos = new FileOutputStream(file);

                        if (!file.exists()) {
                        file.createNewFile();
                        }
                        byte[] bytesArray = mycontent.getBytes();

                        fos.write(bytesArray);
                        fos.flush();
                        fos.close();
                        }
                    catch(IOException e)
                    {
                    System.out.printf("Exception");
                    }
                    break;
                case 2:
                     ans = data - secondOperation;
                     history.addOperation(data + " - " + secondOperation + " = " + ans);
                    Display.setText(String.valueOf(ans));
                    fos = null;
                        mycontent = String.valueOf(ans); 
                        try {
                        file = new File("Calculator_History.txt");
                        fos = new FileOutputStream(file);

                        if (!file.exists()) {
                        file.createNewFile();
                        }
                        byte[] bytesArray = mycontent.getBytes();

                        fos.write(bytesArray);
                        fos.flush();
                        fos.close();
                        }
                    catch(IOException e)
                    {
                    System.out.printf("Exception");
                    }
             
                    break;
                case 3:
                     ans = data * secondOperation;
                     history.addOperation(data + " * " + secondOperation + " = " + ans);
                    Display.setText(String.valueOf(ans));
                    fos = null;
                        mycontent = String.valueOf(ans); 
                        try {
                        file = new File("Calculator_History.txt");
                        fos = new FileOutputStream(file);

                        if (!file.exists()) {
                        file.createNewFile();
                        }
                        byte[] bytesArray = mycontent.getBytes();

                        fos.write(bytesArray);
                        fos.flush();
                        fos.close();
                        }
                    catch(IOException e)
                    {
                    System.out.printf("Exception");
                    }
             
                    break;
                case 4:
                    ans = 0f;
                    try{
                    ans = data / secondOperation;
                    history.addOperation(data + " / " + secondOperation + " = " + ans);
                    }catch(Exception e){Display.setText("Error");} 
                    Display.setText(String.valueOf(ans));
                    fos = null;
                        mycontent = String.valueOf(ans); 
                        try {
                        file = new File("Calculator_History.txt");
                        fos = new FileOutputStream(file);

                        if (!file.exists()) {
                        file.createNewFile();
                        }
                        byte[] bytesArray = mycontent.getBytes();

                        fos.write(bytesArray);
                        fos.flush();
                        fos.close();
                        }
                    catch(IOException e)
                    {
                    System.out.printf("Exception");
                    }
             
                    break;
                }  
            }
        }
    }
    @FXML
    void historyAction(ActionEvent event) throws FileNotFoundException 
    {
        
        if(History.isSelected()){
        try {
        String strCurrentLine;
        BufferedReader objReader = new BufferedReader(new FileReader("Calculator_History.txt"));
        while ((strCurrentLine = objReader.readLine()) != null) {
        HistoryText.appendText(strCurrentLine + System.getProperty("line.separator"));
        }
        } catch (IOException e) {
    }
}
        else
        {
            PrintWriter writer = new PrintWriter(new File("Calculator_History.txt"));
            writer.print("");
            writer.close();
        }
        if(grid.isVisible())
        {
            grid.setVisible(false);
        }
        else
        {
            grid.setVisible(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
    }    
    
    public void serialize() {
        System.out.println("Serialized");
        Operations op = this.history;
        try
        {    
            FileOutputStream outPutFile = new FileOutputStream("calc_history.txt"); 
            ObjectOutputStream outputStream = new ObjectOutputStream(outPutFile); 
            outputStream.writeObject(op); 
            outputStream.close(); 
            outPutFile.close();     
        } 
          
        catch(IOException ex) 
        { 
            System.err.println(ex);
            System.out.println("an IO error occured"); 
        }
    }
    public void deserialize() {
        System.out.println("Deserialized");
        Operations op = null;
        try
        {    
            FileInputStream inputFile = new FileInputStream("calc_history.txt"); 
            ObjectInputStream inputStream = new ObjectInputStream(inputFile); 
            try {
                op = (Operations)inputStream.readObject(); 
            }
            catch(ClassNotFoundException e) {
                System.err.println(e);
                System.out.println("Operations class not found");
            }
            inputStream.close(); 
            inputFile.close();     
        } 
          
        catch(IOException ex) 
        { 
            System.err.println(ex);
            System.out.println("calc_history.txt not found/unreadable"); 
        }
        if(op != null) {
            this.history = op;
        }
    }
    
    public void displayHistory() {
        System.out.println(history.displayHistory());
        JOptionPane.showMessageDialog(null, this.history.displayHistory());
    } 
}
