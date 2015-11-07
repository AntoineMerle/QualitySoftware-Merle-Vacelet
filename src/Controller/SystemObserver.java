/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.*;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author antoinemerle
 */


public  class SystemObserver implements Observer{
   
   private final Led led;
   private final Door door;
   private final Gear gear;
   private final RemoteGear remotegear;
   
   //-CONSTRUCTOR-//
   public SystemObserver(Led led,Door door,Gear gear,RemoteGear remotegear){
       
       this.led=led;
       this.door=door;
       this.gear=gear;
       this.remotegear=remotegear;
       this.led.addObserver(this);
       this.door.addObserver(this);
       this.gear.addObserver(this);
       this.remotegear.addObserver(this);
       
   }
   
   //-GETTER-//
   public Led GetLed(){
       return this.led;
   }
    public Door GetDoor(){
       return this.door;
   }
    public Gear GetGear(){
       return this.gear;
   }
    public RemoteGear GetRemoteGear(){
        return this.remotegear;
    }
   
   //-Update the view
   public void updateView(){
       if(this.door.getIsClosed() && this.gear.getIsUp())
       {
         this.led.setState(3);
         this.GetRemoteGear().getDown().setVisible(true);
         
       }
       else if(this.door.getIsSwitching() || this.gear.getIsMoving())
       {
           this.led.setState(2);
       }
       else if(this.door.getIsOpened() && this.gear.getIsDown())
       {
           this.led.setState(1);
           this.GetRemoteGear().getUp().setVisible(true);
       }
           
       
   }
   
   public void update(Observable observable, Object arg){
      if(this.remotegear.isUp()){ 
       if(observable.equals(door))
       {    
            if(this.door.getIsClosed() && this.gear.getIsUp())
            {  
               this.gear.setState(2);
            }
            else if(this.door.getIsSwitching() && this.gear.getIsMoving())
            {
               this.gear.setState(1);
            }
            else if(this.door.getIsOpened() && this.gear.getIsDown())
            {
               this.gear.setState(2);
            }
           
       }
       else if(observable.equals(gear))
       {
          if(this.door.getIsClosed() && this.gear.getIsUp())
               this.door.setState(2);
          else if(this.door.getIsSwitching() && this.gear.getIsMoving())
               this.door.setState(1);
          else if(this.door.getIsOpened() && this.gear.getIsDown())
               this.door.setState(2);
       }
      }
      else   
      {
                 if(observable.equals(door))
       {    
            if(this.door.getIsClosed() && this.gear.getIsUp())
            {  
               this.gear.setState(2);
            }
            else if(this.door.getIsSwitching() && this.gear.getIsMoving())
            {
               this.gear.setState(3);
            }
            else if(this.door.getIsOpened() && this.gear.getIsDown())
            {
               this.gear.setState(2);
            }
           
       }
       else if(observable.equals(gear))
       {
          if(this.door.getIsClosed() && this.gear.getIsUp())
               this.door.setState(2);
          else if(this.door.getIsSwitching() && this.gear.getIsMoving())
               this.door.setState(3);
          else if(this.door.getIsOpened() && this.gear.getIsDown())
               this.door.setState(2);
       }
      }
       this.updateView();
   }
           
}
