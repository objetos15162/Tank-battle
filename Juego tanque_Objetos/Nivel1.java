import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends Niveles
{
    private Nivel2 level2;
    /**
     * Constructor for objects of class Nivel1.
     * 
     */
    public Nivel1()
    {
        creaInterfaz(1);
        level2= new Nivel2();
    }
    
    public void act()
    {
        if(cambiaNivel())
        {
            setBackground("Nivel2_SinFondo.png");
            Greenfoot.setWorld(level2); 
        }
        if(terminoJuego())
        {
            removeObjects(getObjects(null));
            setBackground("gameover.jpg");
            Greenfoot.stop();
            
        }
    }
}
