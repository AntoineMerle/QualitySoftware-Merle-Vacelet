/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.SystemObservable;
/**
 *
 * @author antoinemerle
 */
public final class Gear extends SystemObservable{
    private boolean isMoving;
    private boolean isDown;
    private boolean isUp;
    //-Constructor-//
    public Gear(){
        super();
        set(1);
    }
    //-GETTER-//
    public boolean getIsMoving(){
        return isMoving;
    }
     public boolean getIsUp(){
        return isUp;
    }
          public boolean getIsDown(){
        return isDown;
    }
     
        //-SETTER-//
    public void set(int state){
      if(state==1)
      {
         isDown=true;
         isMoving=false;
         isUp=false;
      }
      else if(state==2)
      {
      isDown=false;
         isMoving=true;
         isUp=false;
      }
      else if(state==3)
      {
        isDown=false;
        isMoving=false;
        isUp=true;
      }
      Update();
    }

    @Override
    public void Update() {
        setChanged();
        notifyObservers();
    }

    
}
    
    


    
