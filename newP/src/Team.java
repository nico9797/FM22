
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Team  implements ActionListener{
    String nome;
    int abilita;
    int p;
    int w;
    int d;
    int l;
    int trofei;
    Player[] rosa=new Player[20];
    ImageIcon imm=new ImageIcon();
    JButton button=new JButton();
    Color color=new Color(8);
    Team(String s,ImageIcon a){
        nome=s;
      p=0;
      w=0;
      d=0;
      l=0;
     for(int i=0;i<20;i++){
         rosa[i]=new Player();
         rosa[i].setTeam(this);
     }
     abilita=getMediaAbilitaRosa();
     imm=a;
     button.addActionListener(this);
     button.setIcon(imm);
     button.setText(nome);
     setColor();
    }
    public void setColor(){
        if(nome=="Juventus") color=Color.white;
        if(nome=="Napoli") color=Color.CYAN;
        if(nome=="Inter") color=Color.blue;
        if(nome=="Milan") color=Color.red;
        if(nome=="Roma") color=Color.ORANGE;
        if(nome=="Lazio") color=Color.CYAN;
        if(nome=="Atalanta") color=Color.blue;
        if(nome=="Fiorentina") color=Color.MAGENTA;
        if(nome=="Sampdoria") color=Color.white;
        if(nome=="Sassuolo") color=Color.GREEN;
        if(nome=="Torino") color=Color.pink;
        if(nome=="Bologna") color=Color.pink;
        if(nome=="Lecce") color=Color.GREEN;
        if(nome=="Cremonese") color=Color.white;
        if(nome=="Verona") color=Color.yellow;
        if(nome=="Spezia") color=Color.white;
        if(nome=="Monza") color=Color.red;
        if(nome=="Empoli") color=Color.blue;
        if(nome=="Salernitana") color=Color.pink;
        if(nome=="Udinese") color=Color.white;

    }
    public Color getColor(){
        return color;
    }
public void addTrofei(){
        trofei=trofei+1;
}
public int getTrofei(){
        return trofei;
    }
    void copia(Team t){
        nome=t.getNome();
        abilita=t.getMediaAbilitaRosa();
        p=t.getP();
        w=t.getW();
        d=t.getD();
        l=t.getL();
        trofei=t.getTrofei();
        for(int i=0;i<20;i++){
            rosa[i].copia(t.getPlayer(i));
        }
        imm=t.getIcon();
        button=t.getButton();
        color=t.getColor();
    }
    public void ritiro40(){
        Random r=new Random();
        for(int i=0;i<20;i++){
            if(rosa[i].getEta()>40){
                rosa[i]=new Player();
                if(nome=="Juventus"||nome=="Inter"||nome=="Milan"||nome=="Napoli"||nome=="Roma"){
                    rosa[i].setAbilita(r.nextInt(80,99));
                }
                if(nome=="Lazio"||nome=="Atalanta"||nome==""||nome=="Fiorentina"||nome=="Torino"){
                    rosa[i].setAbilita(r.nextInt(70,99));
                }
            }
        }
    }
    public JButton getButton(){
        return button;
    }
    public ImageIcon getIcon(){
        return imm;
    }
    public int getMediaAbilitaRosa(){
        int media=0;
        for(int i=0;i<19;i++){
            media=media+rosa[i].getAbilita();
        }
        media=media/19;
        return media;
        }
        public Player getPlayer(int i){
        return rosa[i];
        }
        public String getNome(){
        return nome;
        }
        public int getP(){
        return p;
        }
        public int getW(){
        return w;
        }
        public int getD(){
        return d;
        }
        public int getL(){
        return l;
        }
        public void addP3(){
        p=p+3;
        }
    public void addP1(){
        p=p+1;
    }
    public void addW(){
        w=w+1;
    }
    public void addD(){
        d=d+1;
    }
    public void addL(){
        l=l+1;
    }
    public void azzeraPWDL(){
        p=0;
        w=0;
        d=0;
        l=0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
