/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd;

//import static java.awt.SystemColor.menu;
//import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.Group;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

//import javafx.scene.paint.Color;
import javafx.stage.Stage;
//import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
//import static jdk.nashorn.tools.ShellFunctions.input;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
//import javafx.stage.FileChooser.ExtensionFilter;
//import javafx.stage.WindowEvent;

/**
 *
 * @author SKD
 */
public class ASD extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Setting up the title
        primaryStage.setTitle("Image Viewer");
        //Creating the menu bar and it's sub items
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuItem1 = new Menu("Open Image");
        menuFile.getItems().addAll(menuItem1);

        MenuItem menuItem2 = new Menu("Save Image");
        menuFile.getItems().addAll(menuItem2);

        MenuItem menuItem3 = new Menu("Exit");
        menuFile.getItems().addAll(menuItem3);
        menuBar.getMenus().addAll(menuFile);
     
        //Setting up the menubar and all visual stuff to display
        VBox vbox = new VBox();
        Scene scene = new Scene(new VBox(), 650, 550);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, vbox);

        
        //The action/ program that is suppose to be executed when Option of 'Open Image' is clicked.
        menuItem1.setOnAction((ActionEvent O) -> {
            //Creating a File chooser
            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            FileChooser.ExtensionFilter extFilterTIF = new FileChooser.ExtensionFilter("TIF files (*.tif)", "*.TIF");
            FileChooser.ExtensionFilter extFilterGIF = new FileChooser.ExtensionFilter("GIF files (*.GIF)", "*.GIF");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG, extFilterTIF, extFilterGIF);

            //Show open file dialog
            File file = fileChooser.showOpenDialog(primaryStage);
            
            //Initializing the input stream to null and storing the file path selected by the user.
            FileInputStream input = null;
            try {
                input = new FileInputStream(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ASD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //converting the file path into image object
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            
            
            //The action/ program that is suppose to be executed when Option of 'Save Image' is clicked.
            menuItem2.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    //Creating a File chooser
                    FileChooser fileChooser = new FileChooser();
                    //set the title of window opened when option of 'Save Image' is clicked.
                    fileChooser.setTitle("Save Image");
                    //Set extension filter
                    FileChooser.ExtensionFilter j_extFilter = new FileChooser.ExtensionFilter("JPG (*.jpg)", "*.jpg");
                    FileChooser.ExtensionFilter p_extFilter = new FileChooser.ExtensionFilter("PNG (*.png)", "*.png");
                    FileChooser.ExtensionFilter t_extFilter = new FileChooser.ExtensionFilter("TIF (*.tif)", "*.tif");
                    FileChooser.ExtensionFilter g_extFilter = new FileChooser.ExtensionFilter("GIF (*.gif)", "*.gif");
                    fileChooser.getExtensionFilters().addAll(j_extFilter, p_extFilter, t_extFilter, g_extFilter);
                    //Show open file dialog
                    File file = fileChooser.showSaveDialog(primaryStage);
                    //Taking the image and saving it at the destination selected by the user.
                    if (file != null) {
                        try {
                            ImageIO.write(SwingFXUtils.fromFXImage(imageView.getImage(),
                                    null), "png", file);
                        } catch (IOException ex) {
                            Logger.getLogger(
                                    ASD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            //Set the height and width of the Image.
            imageView.setImage(image);
            imageView.setFitWidth(400);
            imageView.setFitHeight(600);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);
            vbox.getChildren().add(imageView);

        });
        
        
        //The action/ program that is suppose to be executed when Option of 'Open Image' is clicked.
        menuItem3.setOnAction(e -> Platform.exit());

        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
