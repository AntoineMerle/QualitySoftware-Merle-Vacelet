/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;

/**
 *
 * @author antoinemerle
 */
public class SampleControllerView implements Initializable {

    @FXML
    private Button Up;
    @FXML
    private Button Down;
    @FXML
    private ImageView led;
    
    private RemoteGear remoteGear;
    private Gear gear;
    private Door door;
    private Led MaLed;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       RemoteGear remoteGear=new RemoteGear(Up,Down);
       Led MaLed = new Led(led);
       Gear gear=new Gear();
       Door door=new Door();
       new SystemObserver(MaLed, door, gear, remoteGear);
       
    }

    @FXML
    private void UpAction(ActionEvent event)throws InterruptedException{
       remoteGear.set(1);
        
    }
    
    @FXML
    private void DownAction(ActionEvent event) throws InterruptedException{
        remoteGear.set(2);
    }
    
    
}
