import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Mi mundo
 */
public class Niveles extends World
{
    private tanqueJugador Tanque;
    private GreenfootImage imagenB; //Para cambiar la imagen blindaje
    private GreenfootImage imagenN; //Para cambiar la imagen normal
    private Blindaje blindaje;
    private int vidas; //Vidas del jugador
    private Contador vida;  // para el contador

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Niveles()
    {    
        super(650, 500, 1);
        imagenB=new GreenfootImage("Tanque_Jugador_Blindaje_SinFondo.png");
        imagenN=new GreenfootImage("Tanque_Jugador_SinFondo.png");
        vidas=5;
    }

    /**Crea la interfaz del juego */
    public void creaInterfaz(int nivel)
    {
        switch(nivel)
        {
            case 1:
            creaJugador();
            ponContador();
            generaEscenarioNivel1();
            creaEnemigos(1);
            ponPozo(1);
            ponFabrica(1);
            ponBlindaje();
            break;
            
            case 2:
            creaJugador();
            ponContador();
            generaEscenarioNivel2();
            creaEnemigos(2);
            ponPozo(2);
            ponFabrica(2);
            ponBlindaje();
            break;
            
            case 3:
            creaJugador();
            ponContador();
            generaEscenarioNivel3();
            creaEnemigos(3);
            ponPozo(3);
            ponFabrica(3);
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
    public void ponFabrica(int Nivel)
    {
        switch(Nivel){

            case 1:
            Fabrica f1 = new Fabrica();
            addObject(f1,603,52);
            break;
            case 2: 
            Fabrica f2 = new Fabrica();
            addObject(f2,456,28);
            break;

            case 3:
            Fabrica f3 = new Fabrica();
            addObject(f3,276,67);
            break;
        }
    }

    /**Crea los pozos en el escenario*/
    public void ponPozo(int Nivel)
    {
        switch(Nivel){

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

            case 3:
            Pozo p7=new Pozo();
            addObject(p7,183,66);

            Pozo p8=new Pozo();
            addObject(p8,66,264);

            Pozo p9=new Pozo();
            addObject(p9,557,82);

            Pozo p10=new Pozo();
            addObject(p10,290,184);
            break;
        }   
    }

    /**Crea el tanque del jugador en la posicion X,Y seleccionados
     *Junto con una rotacion establecida*/
    public void creaJugador()
    {    
        MoverObjeto a=new tanqueJugador();
        addObject(a,225,380);
        a.turn(270);
    }

    /**Crea enemigos en el mundo*/
    public void creaEnemigos(int Nivel)
    {
        switch(Nivel){

            case 1:
            MoverObjeto e1= new Enemigo2();
            addObject(e1,120,340);
            e1.turn(180);

            MoverObjeto e2= new Enemigo2();
            addObject(e2,450,50);
            e2.turn(180);

            MoverObjeto e3= new Enemigo2();
            addObject(e3,50,100);
            e3.turn(180);

            /*MoverObjeto e4= new Enemigo2();
            addObject(e4,80,250);
            e4.turn(180);

            MoverObjeto e5= new Enemigo2();
            addObject(e5,537,180);
            e5.turn(180);

            MoverObjeto e6= new Enemigo2();
            addObject(e6,205,25);
            e6.turn(180);*/

            break;

            case 2:
            MoverObjeto e7=new Enemigo3();
            addObject(e7,56,333);
            e7.turn(180);

            MoverObjeto e8=new Enemigo3();
            addObject(e8,107,45);
            e8.turn(180);

            MoverObjeto e9=new Enemigo3();
            addObject(e9,358,218);
            e9.turn(180);
            /*
            MoverObjeto e10=new Enemigo3();
            addObject(e10,514,450);
            e10.turn(180);

            MoverObjeto e11=new Enemigo3();
            addObject(e11,535,65);
            e11.turn(180);*/
            break;
            case 3:
            MoverObjeto e12=new Enemigo1();
            addObject(e12,81,391);
            e12.turn(180);

            MoverObjeto e13=new Enemigo1();
            addObject(e13,66,101);
            e13.turn(180);

            /*MoverObjeto e14=new Enemigo1();
            addObject(e14,420,163);
            e14.turn(180);

            MoverObjeto e15=new Enemigo1();
            addObject(e15,450,450);
            e15.turn(180);
                */
            break;

        }

    }

    /**al recibir un 1, se descuenta la vida del jugador*/
    public void quitaVida(int V)
    {
        switch(V)
        {
            case 1:
            vidas--;
            creaJugador();
            vida.setValue(vidas);
            break;
            case 2:
            vidas++;
            vida.setValue(vidas);
            break;
        }
    }  
    /**Agrega contador de vidas y puntaje*/
    public void ponContador()
    {
        vida=new Contador("Vidas: ");
        addObject(vida,600,480);
        vida.setValue(5);
    }

    /**Regresa el numero de vidas del jugador, esto es para el Contador*/
    public int getVidas()
    {
        return vidas;
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
        int x1=17;
        for(int i=0; i<3;i++)
        {
            Actor m1= new Muro();
            addObject(m1,x1,219);
            x1=x1+30;
        }
        int y1=218;
        for(int i=0; i<4;i++)
        {
            Actor m2= new Muro();
            addObject(m2,106,y1);
            y1=y1+30;
        }
        int x2=165;
        for(int i=0; i<6;i++)
        {
            Actor m3= new Muro();
            addObject(m3,x2,106);
            x2=x2+30;
        }
        int y2=15;
        for(int i=0; i<3;i++)
        {
            Actor m4= new Muro();
            addObject(m4,223,y2);
            y2=y2+30;
        }
        int x3=547;
        for(int i=0; i<5;i++)
        {
            Actor m5= new Muro();
            addObject(m5,x3,122);
            x3=x3+30;
        }
        int y3=92;
        for(int i=0; i<2;i++)
        {
            Actor m6= new Muro();
            addObject(m6,517,y3);
            y3=y3+30;
        }
        int x4=17;
        for(int i=0; i<3;i++)
        {
            Actor m7= new Muro();
            addObject(m7,x4,218);
            x4=x4+30;
        }
        int y4=219;
        for(int i=0; i<4;i++)
        {
            Actor m8= new Muro();
            addObject(m8,108,y4);
            y4=y4+30;
        }
        int y5=455;
        for(int i=0; i<2;i++)
        {
            Actor m9= new Muro();
            addObject(m9,162,y5);
            y5=y5+30;
        }
        int x5=235;
        for(int i=0; i<5;i++)
        {
            Actor m10= new Muro();
            addObject(m10,x5,225);
            x5=x5+30;
        }
        int y6=277;
        for(int i=0; i<5;i++)
        {
            Actor m10= new Muro();
            addObject(m10,547,y6);
            y6=y6+30;
        }
        int x6=548;
        for(int i=0; i<5;i++)
        {
            Actor m11= new Muro();
            addObject(m11,x6,427);
            x6=x6+30;
        }
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

    /**checa si perdio el jugador*/
    public boolean terminoJuego()
    {
        if(vidas==0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}