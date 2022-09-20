import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Random;

public class Player {

    String nome;
    String cognome;
    int eta;
    int abilita;
    int prezzo;
    int gol;
    Team team;
Random r=new Random();
String[] nomi={"Claudio","Nicola","Vito","Leo","Andrea","Carlo","Vanni","Massimo","Luca","Stefano","Piero","Fabio","Alex","Patrizio","Domingo"};
String[] cognomi={"Lopez","Torres","Ferri","Aldisco","Costa","Giordano","Rizzo","Lombardi","Moretti","Barbieri","Mancini","Conti","Gallo","Bruno","Greco","Russo","Ferrari","Esposito","Romano","Colombo","Ricci","Marino","Bianchi","Rossi","De Caro","Verdi","Pioli","De lio","Dalla","Monti","Rupi","Madi","Di Nero","Di Mauro","Pani"};


    Player() {
        nome=nomi[r.nextInt(15)];
        cognome=cognomi[r.nextInt(35)];
        eta=r.nextInt(16,39);
        abilita=r.nextInt(60,99);
        prezzo=abilita*1000-eta*570;
        gol=0;
    }
    public Team getTeam(){
        return team;
    }
    public void setTeam(Team t){
        team=t;
    }
    public void copia(Player p){

            nome=p.getNome();
            cognome = p.getCognome();
            eta = p.getEta();
            abilita = p.getAbilita();
            prezzo = p.getPrezzo();
            gol = p.getGol();
        }

    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public int getEta(){
        return eta;
    }
    public int getPrezzo(){
        return prezzo;
    }
    public int getGol(){
        return gol;
    }
    public int getAbilita(){
        return abilita;
    }
    public void  addGol(){
        gol=gol+1;
    }
    public void addEta(){
        eta=eta+1;
    }

}
