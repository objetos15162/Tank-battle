import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Mi mundo
 */
public class MyWorld extends World
{
     private Tanque_Jugador Tanque;
     private GreenfootImage imagenB; //Para cambiar la imagen blindaje
     private GreenfootImage imagenN; //Para cambiar la imagen normal
     private int vidas=5; //Vidas del jugador
     private Contador vida;  // para el contador
     private Contador puntaje;
     private int nNivel=1;  //Para generar el escenario de acuerdo al nivel
     private Bala_Enemigo balaE;
     private Enemigo enemigo;
     private int tipo=1; //variable del escenario para saber como va a actuar
     
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(650, 500, 1);
        imagenB=new GreenfootImage("Tanque_Jugador_Blindaje_SinFondo.png");
        imagenN=new GreenfootImage("Tanque_Jugador_SinFondo.png");
        //prepare();
        /**Lo pongo al principio del juego para que se cree la interfaz del primer nivel*/
       creaInterfaz();
       
    }
    /**ACT del mundo---Se cambio el nombre al metodo por juego*/
    public void act()  //started
    {
        
        switch(nNivel)
        {
            case 1: //Nivel 1
                    //creaInterfaz();
                    if(cambiaNivel())
                    {
                        nNivel=2;
                        cambiaEscenario(1);
                        //removeObjects(getObjects(null));
                        tipo=2;
                    }
                    
                    break;
            case 2: 
                    /*if(Greenfoot.isKeyDown("enter")) //se uso un condicional para que no creara varios objetos
                   {
                     setBackground("muroLadrillo.jpg");
                     creaInterfaz();
                     
                   }
                    if(cambiaNivel())
                  {
                      nNivel=3;
                     cambiaEscenario(2); 
                     tipo=3;
                    }
                  */
                    break;
                    
            case 3://if(Greenfoot.isKeyDown("enter"))
                    //{
                    //setBackground("muroLadrillo.jpg");
                //}
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {  
        /*creaJugador();
        ponContador();
        generaEscenario();
        creaEnemigos();
        ponPozo();
        ponFabrica();
        ponBlindaje();*/
    }
    
    /**Crea la interfaz del juego */
    public void creaInterfaz()
    {
        switch(nNivel){
            case 1:
                    creaJugador();
                    ponContador();
                    generaEscenario();
                    creaEnemigos();
                    ponPozo();
                    ponFabrica();
                    ponBlindaje();
                    break;
            case 2:
                    creaJugador();
                    ponContador();
                    generaEscenario();
                    creaEnemigos();
                    ponPozo();
                    ponFabrica();
                    ponBlindaje();
                    break;
    }
    }
    /**Crea el poder delblindaje*/
    public void ponBlindaje()
    {
        Blindaje blindaje = new Blindaje();
        addObject(blindaje,500,280);
    }
    /**Crea la fabrica en el escenario*/
    public void ponFabrica()
    {
        switch(nNivel){
            
            case 1:
                    Fabrica f1 = new Fabrica();
                    addObject(f1,603,52);
                    break;
            case 2: 
                    Fabrica f2 = new Fabrica();
                    addObject(f2,456,28);
                    break;
    }
    }
    /**Crea los pozos en el escenario*/
    public void ponPozo()
    {
        switch(nNivel){
            
            case 1:
                    Pozo p1 = new Pozo();
                    addObject(p1,321,33);
        
                    Pozo p2= new Pozo();
                    addObject(p2,70,30);
        
                    Pozo p3=new Pozo();
                    addObject(p3,609,138);
                    break;
                    
            case 2:
                    Pozo p4=new Pozo();
                    addObject(p4,48,61);
                    
                    Pozo p5=new Pozo();
                    addObject(p5,98,466);
                    
                    Pozo p6=new Pozo();
                    addObject(p6,245,52);
                    break;
                    
                }   
    }
    /**Crea el tanque del jugador en la posicion X,Y seleccionados
       *Junto con una rotacion establecida*/
   public void creaJugador()
   {    
        MoverObjetos a=new Tanque_Jugador();
        addObject(a,225,380);
        a.turn(270);

    }
    /**Crea enemigos en el mundo*/
    public void creaEnemigos()
    {
         switch(nNivel){
             
             case 1:
                    MoverObjetos e1= new Enemigo2();
                    addObject(e1,120,340);
                    e1.turn(180);
        
                    MoverObjetos e2= new Enemigo2();
                    addObject(e2,450,50);
                    e2.turn(180);

                    MoverObjetos e3= new Enemigo2();
                    addObject(e3,50,100);
                    e3.turn(180);
        
                    MoverObjetos e4= new Enemigo2();
                    addObject(e4,80,250);
                    e4.turn(180);
        
                    MoverObjetos e5= new Enemigo2();
                    addObject(e5,537,180);
                    e5.turn(180);
        
                    MoverObjetos e6= new Enemigo2();
                    addObject(e6,205,25);
                    e6.turn(180);
                
                    break;
             
             case 2:
                    MoverObjetos e7=new Enemigo3();
                    addObject(e7,56,333);
                    e7.turn(180);
                    
                    MoverObjetos e8=new Enemigo3();
                    addObject(e8,107,45);
                    e8.turn(180);
                    
                    MoverObjetos e9=new Enemigo3();
                    addObject(e9,358,218);
                    e9.turn(180);
                    
                    MoverObjetos e10=new Enemigo3();
                    addObject(e10,514,450);
                    e10.turn(180);
                    
                    MoverObjetos e11=new Enemigo3();
                    addObject(e11,535,65);
                    e11.turn(180);
                
                    
                    break;
          
    }
        
    }
    /**al recibir un 1, se descuenta la vida del jugador*/
    public void quitaVida(int V)
    {
        if(V==1)
        {
            vidas--;
            creaJugador();
            vida.setValue(vidas);
            //System.out.println(vidas);
        }
    }  
    /**Metodo para el puntaje*/
    public void agregaPuntaje()
    {
        if(enemigo.tocoBala()==true)
        {
            puntaje.setValue(10);
        }
        
    }
    /**Agrega contador de vidas y puntaje*/
    public void ponContador()
    {
          vida=new Contador("Vidas: ");
          addObject(vida,600,480);
          vida.setValue(5);
          
          //puntaje=new Contador("Puntaje: ");
          //addObject(puntaje,500,480);
          //puntaje.setValue(0);
    }
    /**Regresa el numero de vidas del jugador, esto es para el Contador*/
    public int getVidas()
    {
        return vidas;
    }
    /**Metodo que crea los muros en el juego*/
    public void generaEscenario()
    {
        switch(nNivel)
        {
            case 1:
                generaEscenarioNivel1();
                break;
            case 2:
                //Escenario nivel 2
                generaEscenarioNivel2();
                break;
            case 3:
                //Escenario nivel 3
                break;
                
                
        }
    }
    /**Genera escenario por nivel*/
    public void generaEscenarioNivel1()
    {
                int x1=240;
                for(int i=0; i<8;i++)
                    {
                        Actor m1= new Muro();
                        addObject(m1,x1,300);
                        x1=x1+30;
                    }
                    int y1=5;
                for(int i=0;i<7;i++) //Primer pila de ladrillos
                {
                    Actor m2=new Muro();
                    addObject(m2,3,y1);
                    y1=y1+30;
                }
                    int x2=33;
                for(int i=0;i<3;i++)
                {
                    Actor m3=new Muro();
                    addObject(m3,x2,185);
                    x2=x2+30;
                }
                    int y2=6;
                for(int i=0;i<3;i++)
                {
                     Actor m4=new Muro();
                    addObject(m4,120,y2);
                    y2=y2+30;
                }
                    int x3=120;
                for(int i=0;i<4;i++)
                {
                     Actor m5=new Muro();
                    addObject(m5,x3,66);
                    x3=x3+30;
                }
                    int y3=95;
                for(int i=0;i<4;i++)
                {
                     Actor m6=new Muro();
                    addObject(m6,210,y3);
                    y3=y3+30;
                }
                    int y4=14;
                for(int i=0;i<3;i++)
                {
                     Actor m7=new Muro();
                    addObject(m7,362,y4);
                    y4=y4+30;
                }
                int x4=305;
                for(int i=0;i<2;i++)
                {
                    Actor m8=new Muro();
                    addObject(m8,x4,73);
                    x4=x4+30;
                }
                int y5=103;
                for(int i=0;i<4;i++)
                {
                    Actor m9=new Muro();
                    addObject(m9,305,y5);
                    y5=y5+30;
                }
                int x5=504;
                for(int i=0;i<6;i++)
                {
                    Actor m10=new Muro();
                    addObject(m10,x5,3);
                    x5=x5+30;
                }
                int y6=32; //Fabrica
                for(int i=0;i<8;i++)
                {
                    Actor m11=new Muro();
                    addObject(m11,649,y6);
                    y6=y6+30;
                }
                int x6=562;
                for(int i=0;i<3;i++)
                {
                    Actor m12=new Muro();
                    addObject(m12,x6,92);
                    x6=x6+30;
                }
                int x7=574;
                for(int i=0;i<3;i++)
                {
                    Actor m13=new Muro();
                    addObject(m13,x7,182);
                    x7=x7+30;
                }
    }
    /**Genera escenario para el nivel 2*/
    public void generaEscenarioNivel2()
    {
        int y1=15;
        for(int i=0; i<3;i++)
        {
             Actor m1= new Muro();
             addObject(m1,3,y1);
             y1=y1+30;
        }
        
        int x1=3;
        for(int i=0;i<3;i++)
        {
            Actor m2=new Muro();
            addObject(m2,x1,103);
            x1=x1+30;
        }
        
        int y2=103;
        for(int i=0;i<4;i++)
        {
            Actor m3=new Muro();
            addObject(m3,91,y2);
            y2=y2+30;
        }
        
        int y3=9;
        for(int i=0;i<7;i++)
        {
            Actor m4=new Muro();
            addObject(m4,195,y3);
            y3=y3+30;
        }
        
        int x2=195;
        for(int i=0;i<7;i++)
        {
            Actor m5=new Muro();
            addObject(m5,x2,9);
            x2=x2+30;
        }
        
        int y4=9;
        for(int i=0;i<4;i++)
        {
            Actor m6=new Muro();
            addObject(m6,397,y4);
            y4=y4+30;
        }
        
        int x3=223;
        for(int i=0;i<2;i++)
        {
            Actor m7=new Muro();
            addObject(m7,x3,97);
            x3=x3+30;
        }
        
        int x4=397;
        for(int i=0;i<2;i++)
        {
            Actor m8=new Muro();
            addObject(m8,x4,128);
            x4=x4+30;
        }
        
        int y5=5;
        for(int i=0;i<6;i++)
        {
            Actor m9=new Muro();
            addObject(m9,640,y5);
            y5=y5+30;
        }
        
        int y6=174;
        for(int i=0;i<4;i++)
        {
            Actor m10=new Muro();
            addObject(m10,552,y6);
            y6=y6+30;
        }
        
        int y7=203;
        for(int i=0;i<2;i++)
        {
            Actor m11=new Muro();
            addObject(m11,552,y7);
            y7=y7+30;
        }
        
        int x5=155;
        for(int i=0;i<9;i++)
        {
            Actor m12=new Muro();
            addObject(m12,x5,305);
            x5=x5+30;
        }
        
        int y8=425;
        for(int i=0;i<3;i++)
        {
            Actor m13=new Muro();
            addObject(m13,140,y8);
            y8=y8+30;
        }
        
    }
    /**Genera escenario para el nivel 3*/
    public void generaEscenarioNivel3()
    {
        
    }
    
    /**Obtiene el numero de pozos deljuego*/
    public int obtenPozos()
    {
        int NPozos=0;
        List listP;
        listP=getObjects(Pozo.class);
        NPozos=listP.size();
        return NPozos;
    }
    /**Obtiene el numero de enemigos*/
    public int obtenEnemigos()
    {
        int NEnemigos=0;
        List listE;
        listE=getObjects(Enemigo.class);
        NEnemigos=listE.size();
        return NEnemigos;      
    }
    /**Obtiene el numero de fabricas*/
    public int obtenFabrica()
    {
        int NFabrica=0;
        List listF;
        listF=getObjects(Fabrica.class);
        NFabrica=listF.size();
        return NFabrica;
    }
   /**Regresa F/V si los objetos del mundo son ceros*/
   public boolean cambiaNivel()
   {
       int pozo=0,enemigo=0,fabrica=0;
       pozo=obtenPozos();
       enemigo=obtenEnemigos();
       fabrica=obtenFabrica();
       
       if(pozo==0 && enemigo==0&&fabrica==0)
       {
           return true; //true
       }
       else
       {
           return false;     //false
        }
      
   }
   
   /**Cambia el escenario para avanzar de nivel*/
   public void cambiaEscenario(int nivel)
   {
       switch(nivel)
       {
           case 1:  removeObjects(getObjects(null));
                    setBackground("Nivel2_SinFondo.png");
                    break;
           case 2:  removeObjects(getObjects(null));
                    setBackground("Nivel3_SinFondo.png");
                    break;
        }
    }
}
