import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Nivel 2
 */
public class Nivel2 extends Niveles
{
    private Nivel3 level3;
    /**
     * Constructor for objects of class Nivel2.
     * 
     */
    public Nivel2()
    {
        creaInterfaz(2);
        level3= new Nivel3();
    }
    public void act()
    {
        if(cambiaNivel())
        {
            Greenfoot.setWorld(level3); 
        }
        if(terminoJuego())
        {
            removeObjects(getObjects(null));
            setBackground("gameover.jpg");
            Greenfoot.stop();
            
        }
    }
}
