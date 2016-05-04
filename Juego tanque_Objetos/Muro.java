import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Muro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Muro extends Actor
{
    
    public void act() 
    {
       checaBala();
       //checaBala2();
       //checaBala3();
    }    
    /**
    * checa si el muro fue tocado por una bala
    * y desaparece
    */
    public void checaBala()
    {
        MyWorld mundo=(MyWorld)getWorld();
        Actor bala=getOneIntersectingObject(Bala_Jugador.class);
        if(bala != null)
        {
            getWorld().removeObject(bala);
        }
    }
    public void checaBala2(){
        Muro muro;
        if(isTouching(Bala_Jugador.class)){
            removeTouching(Bala_Jugador.class);
            removeTouching(Muro.class);
        }
    }
    public void checaBala3(){
        Actor bala= getOneObjectAtOffset(0,0,Bala_Jugador.class);
        if(bala!=null){
            MyWorld mundo=(MyWorld)getWorld();
            mundo.removeObject(bala);
        }
            
    }
}
