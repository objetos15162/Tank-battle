import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Nivel 3
 */
public class Nivel3 extends Niveles
{

    /**
     * Constructor for objects of class Nivel3.
     * 
     */
    public Nivel3()
    {
        creaInterfaz(3);
    }
    
    public void act()
    {
        if(cambiaNivel())
        {
            removeObjects(getObjects(null));
            setBackground("Ganaste.png");
            Greenfoot.stop();
        }
    }
}
