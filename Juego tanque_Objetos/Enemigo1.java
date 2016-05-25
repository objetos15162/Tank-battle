import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Enemigo 1
 */
public class Enemigo1 extends Enemigo
{
    int vida=3;
    public void act() 
    {
        super.act();
        if(vida==0)
        {
            getWorld().removeObject(this);
        }
    }    
    /**Metodo que baja la vida del enemigo 1*/
    public void bajaVida()
    {
        vida--;
    }
    
    public int getVida()
    {
        return vida;
    }
}

