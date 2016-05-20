import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Es el muro de ladrillo que se crea en cada escenario
 */
public class Muro extends Actor
{
    
    public void act() 
    {
       checaBalaJugador();
       checaBalaEnemigo();
    }    
    /**
    * checa si el muro fue tocado por una bala
    * y desaparece
    */
    public void checaBalaJugador()
    {
        MyWorld mundo=(MyWorld)getWorld();
        Actor bala=getOneIntersectingObject(Bala_Jugador.class);
        if(bala != null)
        {
            getWorld().removeObject(bala);
        }
    }
    
    public void checaBalaEnemigo()
    {
        MyWorld mundo=(MyWorld)getWorld();
        Actor bala=getOneIntersectingObject(Bala_Enemigo.class);
        if(bala!= null)
        {
            getWorld().removeObject(bala);
        }
    }
}
