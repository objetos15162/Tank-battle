import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que representa al pozo petrolero
 */
public class Pozo extends Actor
{
    /**
     *
     */
    public void act() 
    {
        ChecaBalaJugador();
    } 
    
    public void ChecaBalaJugador()
    {
        boolean touch=false;
        MyWorld mundo=(MyWorld)getWorld();
        Actor bala=getOneIntersectingObject(Bala_Jugador.class);
        if(bala!=null)
        {
            touch=true;
            getWorld().removeObject(bala);            
        }else
        {
            touch=false;
        }
        if (touch==true)
        {
            mundo.removeObject(this);
        }
    }
    
}
