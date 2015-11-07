/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.SystemObservable;
import javafx.scene.control.Button;

/**
 *
 * @author antoinemerle
 */
public final class RemoteGear extends SystemObservable{
 
    
    private  Button Up;
    private  Button Down;
    private boolean isUp;
    
    public RemoteGear(Button Up, Button Down)
    {
        super();
        this.Down = Down;
        this.Up = Up;
        set(2);
        this.Up.setVisible(true);
       
        
    }
    
    public Button getUp()
    {
        return this.Up;
    }
    
    public Button getDown()
    {
        return this.Down;
    }

    public boolean isUp() 
    {
        return this.isUp;
    }
    
    @Override
    public void set(int state)
    {
        if(state==1){
              isUp= true;
              Up.setVisible(false);
              System.out.println("Hello World!"); //Display the string.
                
            }
        else if(state==2)
            {
               isUp = false;
               Down.setVisible(false);
            }
        Update();
  }
    
    @Override
    public void Update()
    {
        System.out.println("setchanged!"); //Display the string.
      setChanged();
      System.out.println("notify"); //Display the string.
       notifyObservers(); 
    }

 }
    
