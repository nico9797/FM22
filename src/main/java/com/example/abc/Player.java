package com.example.abc;

import java.io.PipedOutputStream;
import java.util.Random;

public class Player {
    String nome,cognome,posizione,squadra;
    int eta,abilita,prezzo,gol,sviluppo;
    String[][] carriera;

    String[]nomi={"Nicola","Vito","Andrea","Antonio","Alessandro","Biagio","Carlo","Donato","Diego","Domingo","Ernesto","Enrico",
            "Edoardo","Francesco","Federico","Fabio","Fernando","Fausto","Gabriele","Gianni","Guglielmo"};
    String[]cognomi={"Tedeschi","Tarducci","Dipinto","Dilorenzo","Dimauro","Altini","Biasco","Bellanova","Zanotti","Acerbi","D'Ambrosio","Fontanarosa","Bastoni","Cordaz","Dimarco",
            "Darmian","Verdi","Vini","Rossi","Ricci","Saponaro","Colucci","Edan","Ballini","Lucarello","Pani","Pinzi","Pirandelli"};
    String[] posizioni={"AT","AS","AD","TR","CS","CC","CD","DC","PO"};
    String squadre[]={"Juventus","Inter","Milan","Napoli","Roma","Lazio","Atalanta","Torino","Bologna","Sampdoria","Empoli",
            "Monza","Lecce","Salernitana","Sassuolo","Udinese","Verona","Spezia","Fiorentina","Cremonese"};

    Random r=new Random();
    Player(){

        nome=nomi[r.nextInt(nomi.length)];
        cognome=cognomi[r.nextInt(cognomi.length)];
        posizione=posizioni[r.nextInt(posizioni.length)];
        squadra=squadre[r.nextInt(squadre.length)];
        while(eta<16)eta=r.nextInt(40);
        while(abilita<60)abilita=r.nextInt(90);
        sviluppo=r.nextInt(3);
        prezzo=abilita*1000-eta*500;
        gol=0;
        carriera=new String[25][3];
        carriera[0][0]=squadra;
        carriera[0][2]=String.valueOf(gol);
    }
    void invecchia(){
        eta=eta+1;
        if(eta<20) {
            abilita = abilita + sviluppo;
            prezzo=prezzo+(sviluppo*1000);
        }
        if(eta>35){
            abilita = abilita - 1;
            prezzo=prezzo-5000;
        }
        if(eta>40){
            nome=nomi[r.nextInt(nomi.length)];
            cognome=cognomi[r.nextInt(cognomi.length)];
            posizione=posizioni[r.nextInt(posizioni.length)];
            squadra=squadre[r.nextInt(squadre.length)];
            while(eta<16)eta=r.nextInt(40);
            while(abilita<60)abilita=r.nextInt(90);
            sviluppo=r.nextInt(3);
            prezzo=abilita*1000-eta*500;
            gol=0;
            carriera=new String[25][3];
            carriera[0][0]=squadra;
            carriera[0][2]=String.valueOf(gol);
        }

    }
    public void copia(Player p){

        nome=p.getNome();
        cognome = p.getCognome();
        posizione=p.posizione;
        squadra=p.squadra;
        eta = p.getEta();
        abilita = p.getAbilita();
        prezzo = p.getPrezzo();
        gol = p.getGol();
        sviluppo=p.sviluppo;
        carriera=p.carriera;
    }
    String getNome(){
        return nome;
    }
    String getCognome(){
        return cognome;
    }
    int getEta(){
        return eta;
    }
    String getPos(){
        return posizione;
    }
    int getAbilita(){
        return abilita;
    }
    int getPrezzo(){
        return prezzo;
    }
    int getGol()
    {
        return gol;
    }
    void addGol(){
        gol=gol+1;
    }
}
