import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase del Enemigo
 */
public class Enemigo extends MoverObjetos
{
    private int velocidadBala=0; //velocidad de la bala del enemigo
    private int tiempoGiro=0; //tiempo en que el tanque enemigo da giro
    private int velocidad=0; //velocidad  de avance del enemigo
    private int direccion;
    
    public void act() 
    {
        muevete();
        dispara();
        tiempoGiro++;
        velocidadBala++;
        velocidad++;
    }
    public void muevete()
    {
        boolean hay=false;
        
        if(ExisteMuro())
        {
            hay=true;
        }
     
        if(velocidad%3==0 &&  getX()<543)
            if(hay==false)//si no hay pared puede caminar
                move();

        if(getX()>=543)//si se pasa del limite del mundo
        {
            turn(90);
            move();
        }

        //checa tiempo de giro
        if(tiempoGiro%20 == 0)
        {
            if(hay==true)
            {
                cambiaPosicion();
                hay=false;}
                int grados=Greenfoot.getRandomNumber(360); 
                turn(grados);
                if(getRotation()>=360)
                setRotation(0);
            }
            cambiaDireccion(getRotation());
        }
    /**
    * Cuando Hay pared da vuelta y cambia de posicion
    */
    public void cambiaPosicion()
     {
      switch(direccion)
       {
         case 1: setLocation(getX(),getY()+5);
                 break;

         case 2: setLocation(getX()-5,getY());
                 break;

        case 3: setLocation(getX(),getY()-5);
                break;

        case 4: setLocation(getX()+5,getY());
                break;
            }
        }
    /**
     * Cambia la Direccion dependiendo hacia donde se haya girado
     * 270= Arriba
     * 90= Abajo
     * 0= Deracha
     * 180=Izquierda
     */
    public void cambiaDireccion(int Rotacion)
     {
       if (Rotacion==270 || Rotacion==-90)
           direccion=1;
            
       if(Rotacion==0)
          direccion=2;
                
       if(Rotacion==90 || Rotacion==-270)
          direccion=3;
            
       if(Rotacion==180 || Rotacion==-180)
          direccion=4;
        }    
     /**
     * Metodo que hace disparar al enemigo en la posicion X,Y del enemigo
     */    
    public void dispara()
    {
        if(velocidadBala%70 == 0)
        {
            Actor Bala=new Bala_Enemigo(getRotation()); //crea la bala del enemigo
            int x=getX();
            int y=getY();
            World world=getWorld();
            world.addObject(Bala,x,y);
        }
    }
}
