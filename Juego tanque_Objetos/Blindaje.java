import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa el blindaje del jugador
 */
public class Blindaje extends Actor
{
    private Tanque_Jugador Tanque;
     private GreenfootImage imagenB; //Para cambiar la imagen blindaje
     private GreenfootImage imagenN; //Para cambiar la imagen normal
    public void act() 
    {
        Blindaje();
    }
    public Blindaje()
    {
        imagenB=new GreenfootImage("Tanque_Jugador_Blindaje_SinFondo.png");
        imagenN=new GreenfootImage("Tanque_Jugador_SinFondo.png");
    }
    /**Metodo para cambiar el blindaje del jugador*/
    public void Blindaje()
    {
        boolean touch=false;
        MyWorld mundo=(MyWorld)getWorld();
        Actor blindaje=getOneIntersectingObject(Tanque_Jugador.class);
        try{
        if(blindaje!=null)
        {
            touch=true;
                getWorld().removeObject(blindaje);
                mundo.creaJugador();
                Tanque.setImage(imagenB);
        }
        else
        {
            touch=false;
        }
        if(touch==true)
            { 
                getWorld().removeObject(this);
              
            }
    }
    catch(Exception e)
        {
         System.out.println(e.getMessage());
        } 
}
}
