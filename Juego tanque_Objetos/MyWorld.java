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
     
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(650, 500, 1);
        imagenB=new GreenfootImage("Tanque_Jugador_Blindaje_SinFondo.png");
        imagenN=new GreenfootImage("Tanque_Jugador_SinFondo.png");
        prepare();
        //ponContador();
        
       
    }
    /**act del mundo*/
    public void act(){
        //tocoBalaPozo();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {  
        creaJugador();
        ponContador();
        generaEscenario();
        creaEnemigos();
        ponPozo();
        ponFabrica();
        ponBlindaje();
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
        Fabrica fabrica = new Fabrica();
        addObject(fabrica,603,52);
    }
    /**Crea los pozos en el escenario*/
    public void ponPozo()
    {
        Pozo p1 = new Pozo();
        addObject(p1,321,33);
        
        Pozo p2= new Pozo();
        addObject(p2,70,30);
        
        Pozo p3=new Pozo();
        addObject(p3,609,138);
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
        //for(int i=0;i<5;i++)
        //{
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
        //}
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
   /**Cambia el nivel de escenario*/
   public void cambiaNivel()
   {
       int pozo=0,enemigo=0,fabrica=0;
       pozo=obtenPozos();
       enemigo=obtenEnemigos();
       fabrica=obtenFabrica();
       
       if(pozo==0 && enemigo==0&&fabrica==0)
       {
           nNivel=2;
       }
   }
}
