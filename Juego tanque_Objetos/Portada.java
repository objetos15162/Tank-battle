import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Portada principal
 * 
 * @author (Fidel Tellez) 
 * @version (1.0)
 */
public class Portada extends World
{
    private Nivel1 level1;
    /**
     * Constructor for objects of class Portada.
     * 
     */
    public Portada()
    {
        super(650, 500, 1);
        setBackground("portada.png");
        level1=new Nivel1();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(level1); 
        }
    }
}
