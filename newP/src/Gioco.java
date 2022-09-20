import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Gioco  implements ActionListener {
   public ImageIcon juventus = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\juventus.png");
   public ImageIcon bologna = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\bologna.png");
   public ImageIcon monza = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\monza.png");
   public ImageIcon inter = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\inter.png");
   public ImageIcon verona = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\verona.png");
   public ImageIcon lecce = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\lecce.png");
  public ImageIcon milan = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\milan.png");
  public ImageIcon udinese = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\udinese.png");
  public ImageIcon empoli = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\empoli.png");
  public ImageIcon lazio = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\lazio.png");
  public ImageIcon spezia = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\spezia.png");
  public ImageIcon cremonese = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\cremonese.png");
  public ImageIcon roma = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\roma.png");
  public ImageIcon sassuolo = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\sassuolo.png");
  public ImageIcon fiorentina = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\fiorentina.png");
  public ImageIcon napoli = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\napoli.png");
  public ImageIcon sampdoria = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\sampdoria.png");
  public ImageIcon torino = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\torino.png");
  public ImageIcon atalanta = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\atalanta.png");
  public ImageIcon salernitana = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\salernitana.png");
  public ImageIcon imm = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\25.png");
  public ImageIcon immStart = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\newP\\media\\R.png");

    Team[] team = new Team[20];
    JLabel labelStadio = new JLabel(imm);
    JFrame frame = new JFrame("FM");
    JPanel panel = new JPanel();
    JTable table=new JTable(20,6);
    JButton startButton =new JButton("START");
    JPanel panelCl=new JPanel();
    JButton playButton= new JButton("PLAY");
    JTable classifica=new JTable(20,5);


    Gioco() {
        team[0] = new Team("Juventus", juventus);
        team[1] = new Team("Inter", inter);
        team[2] = new Team("Milan", milan);
        team[3] = new Team("Napoli", napoli);
        team[4] = new Team("Roma", roma);
        team[5] = new Team("Lazio", lazio);
        team[6] = new Team("Atalanta", atalanta);
        team[7] = new Team("Udinese", udinese);
        team[8] = new Team("Torino", torino);
        team[9] = new Team("Fiorentina", fiorentina);
        team[10] = new Team("Sassuolo", sassuolo);
        team[11] = new Team("Spezia", spezia);
        team[12] = new Team("Salernitana", salernitana);
        team[13] = new Team("Empoli", empoli);
        team[14] = new Team("Lecce", lecce);
        team[15] = new Team("Bologna", bologna);
        team[16] = new Team("Verona", verona);
        team[17] = new Team("Monza", monza);
        team[18] = new Team("Cremonese", cremonese);
        team[19] = new Team("Sampdoria", sampdoria);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.add(panel,BorderLayout.CENTER);
        panel.setLayout(new BorderLayout());
        panel.add(labelStadio,BorderLayout.CENTER);
        labelStadio.setLayout(new BorderLayout());
        panelCl.setLayout(new BoxLayout(panelCl,BoxLayout.Y_AXIS));
        labelStadio.add(panelCl,BorderLayout.WEST);
        for (int i = 0; i < 20; i++) {
            panelCl.add(team[i].getButton());
            team[i].getButton().addActionListener(this);
        }
        table.setEnabled(false);
        table.setBackground(Color.white);
        labelStadio.add(table,BorderLayout.CENTER);
        table.setOpaque(false);

        panelCl.setVisible(false);
        table.setVisible(false);
        labelStadio.setIcon(immStart);
        panel.setBackground(Color.black);
        startButton.setBackground(Color.white);
        startButton.setFont(new Font("Sans Serif", Font.PLAIN, 50));
        labelStadio.add(startButton,BorderLayout.NORTH);
        startButton.setOpaque(true);
        startButton.addActionListener(this);


    }
    public void ordinaTeam(){
        Team t=new Team ("t",juventus);//temp
        for(int j=20;j>0;j--) {
            for (int i = 0; i + 1 < j; i++) {
                if (team[i].getP() < team[i+1].getP()) {
                    t.copia(team[i+1]);
                    team[i+1].copia(team[i]);
                    team[i].copia(t);
                }
            }
        }
    }
    public void serieA(){
        for(int j=0;j<20;j++)
        for(int i=0;i<20;i++){
            match(team[i],team[j]);}

        for(int j=0;j<20;j++)
            for(int i=0;i<20;i++){
                team[j].getPlayer(i).addEta();
                team[j].ritiro40();
            }
        ordinaTeam();
        System.out.println(team[0].getPlayer(0).getNome()+team[0].getNome());
    }
    public int match(Team t1,Team t2){
        Random r=new Random();
        int gol=r.nextInt(7);
        int golt1=0;
        int golt2=0;
        while(gol>0) {
            int p1 = r.nextInt(20);
            int p2 = r.nextInt(20);

            if (t1.getPlayer(p1).getAbilita() > t2.getPlayer(p2).getAbilita()) {
                t1.getPlayer(p1).addGol();
                golt1=golt1+1;
            }
            if (t1.getPlayer(p1).getAbilita() <= t2.getPlayer(p2).getAbilita()) {
                t2.getPlayer(p2).addGol();
                golt2=golt2+1;
            }
            gol--;
        }
        if(golt1>golt2){
            t1.addP3();t1.addW();  t2.addL();
            return 1;
        }
        if(golt1<golt2){
            t2.addP3();t2.addW();  t1.addL();
            return 2;
        }
        if(golt1==golt2){
            t1.addP1();t2.addP1();
            t1.addD();t2.addD();
            return 0;
        }
        return 3;
        }
    public void setClassifica(){
        for (int i = 0; i < 20; i++) {
                classifica.setValueAt(team[i].getNome(),i ,0);
                classifica.setValueAt(team[i].getP(),i,1);
                classifica.setValueAt(team[i].getW(),i,2);
                classifica.setValueAt(team[i].getD(),i,3);
                classifica.setValueAt(team[i].getL(),i,4);
                classifica.setVisible(true);
            }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==playButton){
            serieA();
            setClassifica();
        }
        if(e.getSource()==startButton){
            panelCl.setVisible(true);
            labelStadio.setIcon(imm);
            labelStadio.remove(startButton);
            labelStadio.add(playButton,BorderLayout.SOUTH);
            playButton.setFont(new Font("Sans Serif", Font.ITALIC, 50));
            playButton.addActionListener(this);
            classifica.setEnabled(false);
            panelCl.setBorder(BorderFactory.createLineBorder(Color.black,1));
            classifica.setBorder(BorderFactory.createLineBorder(Color.blue,1));
            labelStadio.add(classifica,BorderLayout.EAST);
            setClassifica();

        }
        if(e.getSource()==playButton){

        }
            if(e.getSource()==team[0].getButton()) {
           for(int i=0;i<20;i++){
               table.setValueAt(team[0].getPlayer(i).getNome(),i,0);
               table.setValueAt(team[0].getPlayer(i).getCognome(),i,1);
               table.setValueAt(team[0].getPlayer(i).getEta(),i,2);
               table.setValueAt(team[0].getPlayer(i).getGol(),i,3);
               table.setValueAt(team[0].getPlayer(i).getPrezzo(),i,4);
               table.setValueAt(team[0].getPlayer(i).getAbilita(),i,5);
               table.setVisible(true);

           }
        }
        if(e.getSource()==team[1].getButton()) {

            for(int i=0;i<20;i++){
                table.setValueAt(team[1].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[1].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[1].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[1].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[1].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[1].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[2].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[2].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[2].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[2].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[2].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[2].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[2].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[3].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[3].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[3].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[3].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[3].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[3].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[3].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[4].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[4].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[4].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[4].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[4].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[4].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[4].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[5].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[5].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[5].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[5].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[5].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[5].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[5].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[6].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[6].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[6].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[6].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[6].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[6].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[6].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[7].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[7].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[7].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[7].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[7].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[7].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[7].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[8].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[8].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[8].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[8].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[8].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[8].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[8].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[9].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[9].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[9].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[9].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[9].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[9].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[9].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[10].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[10].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[10].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[10].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[10].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[10].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[10].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[11].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[11].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[11].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[11].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[11].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[11].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[11].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[12].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[12].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[12].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[12].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[12].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[12].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[12].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[13].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[13].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[13].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[13].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[13].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[13].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[13].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[14].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[14].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[14].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[14].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[14].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[14].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[14].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[15].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[15].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[15].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[15].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[15].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[15].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[15].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            };
        }
        if(e.getSource()==team[16].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[16].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[16].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[16].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[16].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[16].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[16].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[17].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[17].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[17].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[17].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[17].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[17].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[17].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[18].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[18].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[18].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[18].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[18].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[18].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[18].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
        if(e.getSource()==team[19].getButton()) {
            for(int i=0;i<20;i++){
                table.setValueAt(team[19].getPlayer(i).getNome(),i,0);
                table.setValueAt(team[19].getPlayer(i).getCognome(),i,1);
                table.setValueAt(team[19].getPlayer(i).getEta(),i,2);
                table.setValueAt(team[19].getPlayer(i).getGol(),i,3);
                table.setValueAt(team[19].getPlayer(i).getPrezzo(),i,4);
                table.setValueAt(team[19].getPlayer(i).getAbilita(),i,5);

                table.setVisible(true);

            }
        }
    }
}