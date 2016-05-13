import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bala del Enemigo
 */
public class Bala_Enemigo extends MoverObjetos
{
    private int dir; //direccion de la bala del Enemigo
    public void act() 
    {
        move();
        DesapareceTanque();
        //desapareceBalaEnemigo();
    }    
    
    Bala_Enemigo(int direccion){
        dir=direccion; 
        setRotation(dir);
    }
    /**Metodo que Borra el tanque del jugador si lo alcanzo una bala*/
    public void DesapareceTanque()
    {
        boolean touch=false;
        World mundo=getWorld();
        MyWorld MYWorld= (MyWorld) mundo;
        Actor Tanque=getOneIntersectingObject(Tanque_Jugador.class);
        try
        {
            if(Tanque!=null)
            {
                touch=true;
                getWorld().removeObject(Tanque);
                ReapareceJugador();
            }
            else
            {
                touch=false;
            }
            if(touch==true)
            { //Si la bala toco al tanque
                getWorld().removeObject(this); //borra la la bala, el "this" hace referencia al objeto mismo osea la bala
            }
            if(bordeMundo())
            {
               getWorld().removeObject(this);
            }
            }
       
        catch(Exception e)
        {
         System.out.println(e.getMessage());
        } 
    }
    /**Metodo para crear un nuevo jugador, una vez tocado por la bala enemiga*/
        
    public void ReapareceJugador(){
        World mundo=getWorld();
        MyWorld MYWorld= (MyWorld) mundo;
        MYWorld.quitaVida(1);
        
    }
        
}