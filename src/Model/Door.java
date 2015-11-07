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
public final class Door extends SystemObservable{
    
    private boolean isSwitching;
    private boolean isClosed;
    private boolean isOpened;
   
    //-Constructor-//
    public Door(){
        super();
        set(1);
    }

    //-GETTER-//
    public boolean getIsSwitching(){
        return isSwitching;
    }
     public boolean getIsClosed(){
        return isClosed;
    }
          public boolean getIsOpened(){
        return isOpened;
    }
     
        //-SETTER-//
    public void set(int state){
      if(state==1)
      {
         isOpened=true;
         isSwitching=false;
         isClosed=false;
      }
      else if(state==2)
      {
         isClosed=false;
         isSwitching=true;
         isClosed=false;
      }
      else if(state==3)
      {
         isClosed=false;
         isSwitching=false;
         isClosed=true;
      }
      Update();
    }

    @Override
    public void Update() {
        setChanged();
        notifyObservers();
    }


    
}
