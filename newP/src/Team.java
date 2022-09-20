
import javax.swing.*;
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
    Player[] rosa=new Player[20];
    ImageIcon imm=new ImageIcon();
    JButton button=new JButton();
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

    }

    void copia(Team t){
        nome=t.getNome();
        abilita=t.getMediaAbilitaRosa();
        p=t.getP();
        w=t.getW();
        d=t.getD();
        l=t.getL();
        for(int i=0;i<20;i++){
            rosa[i].copia(t.getPlayer(i));
        }
        imm=t.getIcon();
        button=t.getButton();

    }
    public void ritiro40(){
        for(int i=0;i<20;i++){
            if(rosa[i].getEta()>40){
                rosa[i]=new Player();
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
