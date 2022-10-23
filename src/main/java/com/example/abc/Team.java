package com.example.abc;

import java.util.Random;

public class Team {
   private String nome;
   private Player[] rosa;
   int denaro,p,w,d,l;

Team(String s){
    Random r=new Random();
    nome=s;
    rosa=new Player[20];
    for(int i=0;i<20;i++){
        rosa[i]=new Player();
    }
    denaro=r.nextInt(200000);
}
void azzeraPWDL(){
    p=0;
    w=0;
    d=0;
    l=0;
}
    String getNome(){
        return nome;
    }
    Player getPlayer(int i){
    return rosa[i];
    }
    void addP1(){
    p=p+1;
    }
    void addP3(){
    p=p+3;
    }
    void addW(){
    w=w+1;
    }
    void addD(){
    d=d+1;
    }
    void addL(){
    l=l+1;
    }
    int getP(){
    return p;
    }
    int getW(){
    return w;
    }
    int getD(){
    return d;
    }
    int getL(){
    return l;
    }
    void copia(Team t){
        nome=t.getNome();
        denaro=t.denaro;
        p=t.getP();
        w=t.getW();
        d=t.getD();
        l=t.getL();
        for(int i=0;i<20;i++){
            rosa[i].copia(t.getPlayer(i));
        }
    }
}
