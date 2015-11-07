/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.SystemObservable;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;

/**
 *
 * @author antoinemerle
 */
public final class Led extends SystemObservable{

    private boolean isRed;
    private boolean isOrange;
    private boolean isGreen;

    //-Constructor-//
    public Led(ImageView Ledpicture){
        super(Ledpicture);
        set(1);
        
    }
    //-GETTER-//
    public boolean getIsRed(){
        return isRed;
    }
     public boolean getIsOrange(){
        return isOrange;
    }
          public boolean getIsGreen(){
        return isGreen;
    }
     
        //-SETTER-//
    public void set(int state){
      if(state==1)
      {
        isGreen=true;
        isOrange=false;
        isRed=false;
      }
      else if(state==2)
      {
         isGreen=false;
         isOrange=true;
         isRed=false;
      }
      else if(state==3)
      {
         isGreen=false;
         isOrange=false;
         isRed=true;
      }
       Update();
    }
    
    @Override
    public void Update(){

        if(this.getIsRed())
        {
         GetImage().setImage(new Image(getClass().getResource("/images/vert.png").toString()));
        }
        else if(this.getIsOrange())
        {
           GetImage().setImage(new Image(getClass().getResource("/images/vert.png").toString()));
        }
        else if(this.getIsGreen())
        {
           this.GetImage().setImage(new Image(getClass().getResource("/images/vert.png").toString()));
        }
    }   

    
}
