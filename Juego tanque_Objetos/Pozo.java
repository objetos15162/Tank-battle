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
        try{
        if(bala!=null)
        {
            touch=true;
            getWorld().removeObject(bala); 
            int P=mundo.obtenPozos();
            System.out.println(P);
        }else
        {
            touch=false;
        }
        if (touch==true)
        {
            mundo.removeObject(this);
        }
    }
    catch(Exception e)
        {
         System.out.println(e.getMessage());
        } 
    }
    
    /**Metodo que regresa F/V al tocar una bala*/
    public boolean tocoBala()
    {
        Actor bala=getOneIntersectingObject(Bala_Jugador.class);
            
            if(bala != null)
                return true;
            else
                return false;
    }
}
