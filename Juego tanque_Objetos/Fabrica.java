import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Fabrica
 */
public class Fabrica extends Actor
{
    
    public void act() 
    {
       ChecaBalaJugador();
    }    
    /**Verifica si la bala del jugador toco alobjeto fabrica*/
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
