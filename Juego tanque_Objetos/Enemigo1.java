import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo1 extends Enemigo
{
    /**
     * Act - do whatever the Enemigo1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //TocoEnemigo();
        //TocoEnemigo2();
    }    
    /**Metodo que verifica si la bala toco algun enemigo*/
    public void TocoEnemigo(){
         MyWorld mundo=(MyWorld)getWorld();
        //Actor bala=getOneIntersectingObject(Bala_Jugador.class);
        Actor bala=getOneObjectAtOffset(0,0,Bala_Jugador.class);
        if(bala!=null){
            getWorld().removeObject(bala);
        }
    }
    
    public void TocoEnemigo2(){
        
        if(isTouching(Bala_Jugador.class)){
            removeTouching(Bala_Jugador.class);
        }
    }
}

