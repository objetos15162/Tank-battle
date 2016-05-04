import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Esta es la clase del Jugador
 */
public class Tanque_Jugador extends MoverObjetos
{
    private final int IZQ=-45;  //Grados que gira hacia la izquierda
    private final int DER=45;   //Grados que gira hacia la derecha
    private int direccion=2;    //Direccion del tanque
    private int velocidad=0;    //Velocidad del tanque
    private GreenfootImage imagenB; //Para cambiar la imagen blindaje
    private GreenfootImage imagenN; //Para cambiar la imagen normal
    public void act() 
    {
        muevete();
        dispara();
        blindaje();
    } 
    public Tanque_Jugador()
    {
        imagenB=new GreenfootImage("Tanque_Jugador_Blindaje_SinFondo.png");
        imagenN=new GreenfootImage("Tanque_Jugador_SinFondo.png");
        setImage(imagenN);
    }
    /**Metodo de movimiento y verifica si existe un muro*/
    public void muevete(){
        boolean hay=false; //Bandera que checa si hay objetos
        
          if(ExisteMuro())
         {
             hay=true; //Checa si hay un objeto a su alrededor 
         }
        if(getX()<542)
            if(Greenfoot.isKeyDown("up")) // Checa si se preciona la tecla flecha arriba
            {
                if(hay==false)
                    move();
            }
        
        if(velocidad%10 == 0)
         {                             
             if(Greenfoot.isKeyDown("left")) // Checa si se preciona la tecla flecha izquierda y gira el tanque a la derecha
             {
                 if(hay==true)
                 {
                     cambiaPosicion();
                     hay=false;
                 }
                 turn(IZQ);
                 if (getRotation()<=-360)
                    setRotation(0);
             }
             else 
                if(Greenfoot.isKeyDown("right")) // Checa si se preciona la tecla flecha derecha y gira el tanque a la izquierda
                {
                    if(hay==true)
                    {
                        cambiaPosicion();
                        hay=false;
                    }
                    turn(DER);
                    if (getRotation()>=360)
                        setRotation(0);
                }
         }
         cambiaDireccion(getRotation());
    } 
    /**
     * Cuando se encuentra con una pared da vuelta 
     * y cambia de posicion
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
     * Cambia la Direccion del tanque del jugador dependiendo hacia donde se haya girado
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
     * Hace que el tanque del usuario dispare con la tecla abajo del las teclas de direccion
     */       
    public void dispara()
    {
        if(velocidad%70==0)
        {
            if(Greenfoot.isKeyDown("space")) //Checa si se presiono la tecla Espacio
            {
                /**Crea un nuevo objeto Bala, en la posicion X,Y del tanque*/
                Actor A=new Bala_Jugador(getRotation()); 
                int x=getX();
                int y=getY();
                World world=getWorld();
                world.addObject(A,x,y);
            }
        }
    }
    /**Cambia la imagen del tanquue*/
    public void cambiaImagen()
    {
        if(getImage()==imagenN)
        {
            setImage(imagenB);
        }else
        {
            setImage(imagenN);
        }
    }
    
    public void blindaje()
    {
        boolean touch=false;
        MyWorld mundo=(MyWorld)getWorld();
        Actor blindaje=getOneIntersectingObject(Blindaje.class);
        if(blindaje!=null)
        {
            getWorld().removeObject(blindaje);
            cambiaImagen();
        }
    }
}
