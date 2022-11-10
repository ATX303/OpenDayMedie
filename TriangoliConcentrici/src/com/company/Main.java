package com.company;

import zuclib.Tartaruga;

import java.awt.*;

import static zuclib.GraficaSemplice.*;

public class Main {

    public static void triangoli(Tartaruga t1, double lato, int n) {
        if(n==0){
        }else{
            for(int i = 0; i<3; i++){
                t1.avanti(lato);
                t1.destra(120);
            }
            t1.avanti(lato/2);
            t1.destra(60);
            triangoli(t1, lato/2, n-1);
        }
    }

    public static void aspirale(Tartaruga t2, double lato, int n){
        if(n==0){
        }else{
            t2.avanti(lato);
            t2.destra(90);
            aspirale(t2, (lato/3)*2, n-1);
        }
    }

    public static void poligono(Tartaruga t1, double lato, int n){
        for(int i = 0; i<n; i++){
            t1.avanti(lato);
            t1.destra(360/n);
        }
    }

    public static void cerchioni(Tartaruga tu, int n, double r){
        Color colore;
        do {
            colore = coloreACaso();
        } while (colore == BIANCO);
        if (n == 0 || r<=0) {
            return;
        } else {
            cerchioPieno(tu.getX(), tu.getY(), r, colore);
            tu.sinistra(25);
            tu.avanti(r);
            r -= 0.005;
            tu.avanti(r);
            cerchioni(tu, n - 1, r);
        }
    }

    public static void albero(Tartaruga t1, double lungRamo, int n){
        t1.avanti(lungRamo);
        if(n==1){
            int x = (int)(t1.getX() * 255);
            int y = (int)(t1.getY() * 255);
            int z = (int)(t1.getAngolo());

            t1.setColore(new Color(z%255, x%255, y%255));
            t1.sinistra(45);
            t1.avanti(lungRamo/2);
            t1.indietro(lungRamo/2);
            t1.destra(90);
            t1.avanti(lungRamo/2);
            t1.indietro(lungRamo/2);
            t1.sinistra(45);
            //t1.setColore(MARRONE);
            x = (int)(t1.getX() * 255);
            y = (int)(t1.getY() * 255);
            z = (int)(t1.getAngolo());

            t1.setColore(new Color(z%255, x%255, y%255));
        }else{
            t1.sinistra(45);
            albero(t1, lungRamo/1.22, n-1);
            t1.destra(45);
            t1.destra(45);
            albero(t1, lungRamo/1.22, n-1);
            t1.sinistra(45);
        }
        t1.indietro(lungRamo);
    }

    public static void albero1(Tartaruga t1, double lungRamo, int n){
        t1.avanti(lungRamo);
        if(n==1){
            int x = (int)(t1.getX() * 255);
            int y = (int)(t1.getY() * 255);
            int z = (int)(t1.getAngolo());

            t1.setGrossezza(n*0.005/2);
            t1.setColore(new Color(z%255, x%255, y%255));
            t1.sinistra(45);
            t1.avanti(lungRamo/2);
            t1.pennaSu();
            t1.indietro(lungRamo/2);
            t1.destra(90);
            t1.pennaGiu();
            t1.avanti(lungRamo/2);
            t1.pennaSu();
            t1.indietro(lungRamo/2);
            t1.sinistra(45);
            t1.pennaGiu();
            //t1.setColore(MARRONE);
            x = (int)(t1.getX() * 255);
            y = (int)(t1.getY() * 255);
            z = (int)(t1.getAngolo());

            t1.setColore(new Color(z%255, x%255, y%255));
        }else{
            int angolo = numCasuale();

            t1.setGrossezza(n*0.005/2);
            t1.sinistra(angolo);
            albero1(t1, lungRamo/1.22, n-1);
            t1.destra(angolo);

            angolo = numCasuale();
            t1.setGrossezza(n*0.005/2);
            t1.destra(angolo);
            albero1(t1, lungRamo/1.22, n-1);
            t1.sinistra(angolo);
        }
        t1.pennaSu();
        t1.indietro(lungRamo);
        t1.pennaGiu();
    }

    public static int numCasuale(){
        return (int)(Math.random() * 45)+25;
    }

    public static void curvaDiKoch(Tartaruga t1, double lung, int n){
        if(n==0){
            int x = (int)(t1.getX() * 255);
            int y = (int)(t1.getY() * 255);
            int z = (int)(t1.getAngolo());

            t1.setColore(new Color(z%255, x%255, y%255));
            t1.avanti(lung);
        }else{
            curvaDiKoch(t1, lung/3, n-1);
            t1.sinistra(60);
            curvaDiKoch(t1, lung/3, n-1);
            t1.destra(120);
            curvaDiKoch(t1, lung/3, n-1);
            t1.sinistra(60);
            curvaDiKoch(t1, lung/3, n-1);
        }
    }

    public static void fiocchiDiNeve(Tartaruga t1, double lung, int n){
        if(n==0){
            int x = (int)(t1.getX() * 255);
            int y = (int)(t1.getY() * 255);
            int z = (int)(t1.getAngolo());

            t1.setColore(new Color(z%255, x%255, y%255));
            t1.avanti(lung);
        }else{
            curvaDiKoch(t1, lung/3, n-1);
            t1.sinistra(60);
            curvaDiKoch(t1, lung/3, n-1);
            t1.destra(120);
            curvaDiKoch(t1, lung/3, n-1);
            t1.sinistra(60);
            curvaDiKoch(t1, lung/3, n-1);
        }
    }

    public static void triforza(Tartaruga t1, double lung, int n){
        if (n==0){
            t1.avanti(lung);
            t1.destra(120);
            t1.avanti(lung);
            t1.destra(120);
            t1.avanti(lung);
            t1.destra(120);
            t1.avanti(lung);
        }else{
            triforza(t1, lung / 2, n - 1);
            triforza(t1, lung/2, n-1);
            t1.destra(120);
            t1.avanti(lung/2);
            triforza(t1, lung/2, n-1);
            t1.destra(120);
            t1.avanti(lung);
            t1.destra(120);
            t1.avanti(lung);
        }
    }

    /*public static void frattaleCerchio(double x, double y, double diametro, int n){
        if(n==0){
            cerchio(x, y, diametro);
            cerchio(x,y,diametro/3);
            cerchio(x-(diametro/7)*4, y-(diametro/3), diametro/3);
            cerchio(x, y-(diametro/3)*2, diametro/3);
            cerchio(x+(diametro/7)*4, y-(diametro/3), diametro/3);
            cerchio(x, y+(diametro/3)*2, diametro/3);
            cerchio(x+(diametro/7)*4, y+(diametro/3), diametro/3);
            cerchio(x-(diametro/7)*4, y+(diametro/3), diametro/3);

            cerchio(x,y,diametro/3);
            cerchio(x-(diametro/8)*7, y, (diametro/8));
            cerchio(x+(diametro/8)*7, y, (diametro/8));
            cerchio(x+(diametro/9)*4, y+(diametro/8)*6, diametro/8);
            //cerchio(x-(diametro/8)*7, y+(diametro/3), diametro/8);
        }else{
            cerchio(x, y, diametro);
            frattaleCerchio(x, y, diametro/3, n-1);
            frattaleCerchio(x-(diametro/7)*4, y-(diametro/3), diametro/3, n-1);
            frattaleCerchio(x, y-(diametro/3)*2, diametro/3, n-1);
            frattaleCerchio(x+(diametro/7)*4, y-(diametro/3), diametro/3, n-1);
            frattaleCerchio(x, y+(diametro/3)*2, diametro/3, n-1);
            frattaleCerchio(x+(diametro/7)*4, y+(diametro/3), diametro/3, n-1);
            frattaleCerchio(x-(diametro/7)*4, y+(diametro/3), diametro/3, n-1);
        }
    }*/

    public static void frattaleCerchio(Tartaruga t1, double raggio, int n){
        if(n==0){
            cerchio(t1.getX(), t1.getY(), raggio);
            cerchio(t1.getX(), t1.getY(), raggio/3);
            t1.avanti((raggio/3)*2);
            t1.destra(60);
            for(int i=0; i<6; i++) {
                cerchio(t1.getX(), t1.getY(), raggio / 3);
                t1.destra(60);
                t1.avanti((raggio/3)*2);
            }
            t1.sinistra(60);
            t1.indietro((raggio/3)*2);
        }else{
            cerchio(t1.getX(), t1.getY(), raggio);
            frattaleCerchio(t1, raggio/3, n-1);
            t1.avanti((raggio/3)*2);
            t1.destra(60);
            for(int i=0; i<6; i++) {
                frattaleCerchio(t1, raggio/3, n-1);
                t1.destra(60);
                t1.avanti((raggio/3)*2);
            }
            t1.sinistra(60);
            t1.indietro((raggio/3)*2);
        }
    }

    public static void main(String[] args) {
        /*double lato = 0.5;
        int n = 2;
        Tartaruga t1 = new Tartaruga(0.5-lato/2, 0.5-lato/2, 60, BLU);
        t1.setGrossezza(0.005);
        triangoli(t1, lato, n);*/

        /*double lato = 0.7;
        int n = 10;
        Tartaruga t2 = new Tartaruga(0.5-lato/2, 0.5-lato/2, 90, BLU);
        t2.setGrossezza(0.005);
        aspirale(t2, lato, n);*/

        /*double lato = 0.5;
        int n = 3;
        Tartaruga t1 = new Tartaruga(0.5, 0.5, 360/n, BLU);
        poligono(t1, lato, n);*/

        /*int n = 50;
        double r = 0.1;
        Tartaruga tu = new Tartaruga(0.5, 0.15, 0, NERO);
        tu.pennaSu();
        cerchioni(tu, n, r);*/

        /*double lungRamo = 0.1;
        setFinestra(1000, 1000, "banana");
        int n = 15;
        Tartaruga t1 = new Tartaruga(0.5, 0.2, 90, MARRONE);
        t1.setGrossezza(0.003);
        albero(t1, lungRamo, n);*/

        double lungRamo = 0.4;
        setFinestra(1000, 1000, "banana");
        int n = 15;
        Tartaruga t1 = new Tartaruga(0.5, 0.2, 90, MARRONE);
        t1.setGrossezza(n*0.005/2);

        int x = (int)(t1.getX() * 255);
        int y = (int)(t1.getY() * 255);
        int z = (int)(t1.getAngolo());

        t1.setColore(new Color(z%255, x%255, y%255));
        lungRamo = 0.1;
        t1.avanti(lungRamo);
        albero1(t1, lungRamo, n);

        /*double lung=1, y=1, x=0;
        int n=7;
        Tartaruga t1 = new Tartaruga(0, 0.5, 0, BLU);
        t1.setGrossezza(0.005);
        curvaDiKoch(t1, lung, n);*/

        /*double lung=0.85;
        int n=5;
        Tartaruga t1 = new Tartaruga(0.5 - lung/2, 0.54 - (lung/3), 60, BLU);
        t1.setGrossezza(0.025);
        for(int i = 0; i<3; i++) {
            curvaDiKoch(t1, lung, n);
            t1.destra(120);
        }*/

        /*double lung = 0.5;
        int n = 10;
        Tartaruga t1 = new Tartaruga(0.5 - lung/2, 0.5 - (lung/3), 60, BLU);
        t1.setGrossezza(0.005);
        triforza(t1, lung, n);*/

        /*double diametro=0.5, x=0.5, y=0.5;
        int n=5;
        Tartaruga t1 = new Tartaruga(0.5, 0.5, 270, BLU);
        t1.pennaSu();
        frattaleCerchio(t1, diametro, n);*/
    }
}