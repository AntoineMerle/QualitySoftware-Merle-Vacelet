/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.Observable;
import javafx.scene.image.*;
/**
 *
 * @author antoinemerle
 */
public abstract class SystemObservable extends Observable{
   private int state;
   private final ImageView image;
   
   //-Constructor-//

      public SystemObservable(ImageView image){
       this.image=image;
       this.setState(0);
   }
      public SystemObservable(){
          this.setState(0);
          this.image=null;
      }
      
  
   
   //-GETTER-//
   public int getState() {
      return state;
   }
   public ImageView GetImage(){
       return image;
   }
   
   //-SETTER-//
   public final void setState(int state) {
      this.state = state;
   }
   public abstract void set(int state);
   public abstract void Update();
}
