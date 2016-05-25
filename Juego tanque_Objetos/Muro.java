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
        Niveles mundo=(Niveles)getWorld();
        Actor bala=getOneIntersectingObject(BalaJugador.class);
        if(bala != null)
        {
            getWorld().removeObject(bala);
        }
    }

    public void checaBalaEnemigo()
    {
        Niveles mundo=(Niveles)getWorld();
        Actor bala=getOneIntersectingObject(BalaEnemigo.class);
        if(bala!= null)
        {
            getWorld().removeObject(bala);
        }
    }
}
