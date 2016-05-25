import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bala del Enemigo
 */
public class BalaEnemigo extends MoverObjeto
{
    private int dir; //direccion de la bala del Enemigo
    Blindaje blindaje;
    tanqueJugador tanqueJ;
    public void act() 
    {
        move();
        DesapareceTanque();
    }    

    BalaEnemigo(int direccion){
        dir=direccion; 
        setRotation(dir);
    }

    /**Metodo que Borra el tanque del jugador si lo alcanzo una bala*/
    public void DesapareceTanque()
    {
        boolean touch=false;
        World mundo=getWorld();
        Niveles MYWorld= (Niveles) mundo;
        Actor Tanque=getOneIntersectingObject(tanqueJugador.class);
        try
        {
            if(Tanque!=null)
            {
                touch=true;
                getWorld().removeObject(Tanque);
                ReapareceJugador(1);            
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

    public void ReapareceJugador(int i){
        if(i==1){
            World mundo=getWorld();
            Niveles MYWorld= (Niveles) mundo;
            MYWorld.quitaVida(1);
        }
        if(i==0)
        {
            World mundo=getWorld();
            Niveles MYWorld= (Niveles) mundo;
            MYWorld.quitaVida(2);
        }

    }
}