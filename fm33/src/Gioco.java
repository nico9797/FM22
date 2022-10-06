import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Gioco implements ActionListener {

    public ImageIcon imm = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\25.png");
    public ImageIcon immStart = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\R.png");
    public ImageIcon coppe = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\coppe.png");
    public ImageIcon serieA = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\serieA.png");
    public ImageIcon fin = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\fin.png");
    public ImageIcon tat = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\tat.png");
    public ImageIcon v = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\v3.png");

    Random r=new Random();
    JFrame frame =new JFrame("FM");
    JPanel panel=new JPanel();
    JButton[] button=new JButton[10];
    JLabel homeLabel=new JLabel(immStart);
    JTable clTabel=new JTable(20,5);
    JLabel teamsLabel=new JLabel("Squadre");
    JTable squadra=new JTable(20,6);
    JTable rosa=new JTable(20,5);
    JLabel allenatoreLabel=new JLabel(coppe);
    JLabel trasfLabel=new JLabel();
    JLabel finanzeLabel=new JLabel(fin);
    JLabel tatticheLabel=new JLabel(tat);
    JTable calendarioTabel=new JTable(380,4);
    JScrollPane scroll=new JScrollPane(calendarioTabel);
    JLabel alboLabel=new JLabel(coppe);
    Lega calendario=new Lega();
    JButton playButton= new JButton("Prossima partita");
    JLabel alboTabel=new JLabel();
    JButton ok=new JButton("OK");
    JTextArea text;

    int k=0;
    Gioco(){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(1000,1000);

        panel.setLayout(null);
        panel.setBounds(0,0,1000,1000);
        panel.setBackground(Color.black);
        //add all to panel
        int y=30;
        for(int i=0;i<10;i++){
            if(i!=1) { //tolto bott 1
                button[i] = new JButton();
                button[i].addActionListener(this);
                panel.add(button[i]);
                button[i].setBounds(0, y, 140, 20);
                y = y + 30;
            }
        }
        button[0].setText("Home");
        button[2].setText("Squadre");button[3].setText("Rosa");
        button[4].setText("Allenatore");button[5].setText("Mercato");
        button[6].setText("Finanze");button[7].setText("Tattiche");
        button[8].setText("Calendario");button[9].setText("Albo");
        panel.add(playButton);
        panel.add(clTabel);
        panel.add(homeLabel);
        panel.add(teamsLabel);
        panel.add(squadra);
        panel.add(rosa);
        panel.add(allenatoreLabel);
        panel.add(trasfLabel);
        panel.add(finanzeLabel);
        panel.add(tatticheLabel);
        panel.add(scroll);
        panel.add(alboLabel);

        //home
        homeLabel.setBounds(0,0,1000,720);
        homeLabel.setLayout(null);
        homeLabel.setVisible(true);
//playButton
        playButton.setBounds(0,320,100,50);
        playButton.setVisible(true);
        playButton.addActionListener(this);
        playButton.setBackground(Color.yellow);
        //cl
        clTabel.setBounds(690,0,300,330);
        clTabel.setVisible(true);
        clTabel.setEnabled(false);

        //teams
        teamsLabel.setBounds(190,40,450,400);
        teamsLabel.setLayout(new GridLayout(5,4));
        teamsLabel.setVisible(false);
        for(int i=0;i<20;i++){
            calendario.team[i].getButton().addActionListener(this);
            teamsLabel.add(calendario.team[i].getButton());
        }

        //squadra
        squadra.setVisible(false);
        squadra.setBounds(670,50,310,320);
        //rosa
        rosa.setVisible(false);
        rosa.setBounds(250,50,400,320);
        rosa.setEnabled(false);
        //all
        allenatoreLabel.setVisible(false);
        allenatoreLabel.setBounds(0,0,1000,1000);
        allenatoreLabel.setLayout(null);

        //trasf
        trasfLabel.setVisible(false);
        trasfLabel.setBounds(0,0,1000,1000);
        trasfLabel.setLayout(null);

        //fin
        finanzeLabel.setVisible(false);
        finanzeLabel.setBounds(0,0,1000,1000);
        finanzeLabel.setLayout(null);

        //tatt
        tatticheLabel.setVisible(false);
        tatticheLabel.setBounds(0,0,1000,1000);
        tatticheLabel.setLayout(null);

        //cal
        calendarioTabel.setLayout(null);
        calendarioTabel.setBounds(250,50,400,300);
        calendarioTabel.setVisible(false);
        calendarioTabel.setEnabled(false);
        for(int i=0;i<380;i++) {
            calendarioTabel.setValueAt(calendario.getElemento(i, 0), i, 0);
            calendarioTabel.setValueAt(calendario.getElemento(i, 1), i, 1);
        }

        //scroll
        scroll.setBounds(250,50,400,500);
        scroll.setVisible(false);

        //stad
        alboLabel.setVisible(false);
        alboLabel.setBounds(0,0,1000,1000);
        alboLabel.setLayout(null);

        //alboT
        alboTabel.setBounds(250,250,300,300);
        alboTabel.setVisible(false);

        inizializzaCl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ok&&k==380){
            panel.remove(ok);
            panel.remove(text);
            panel.add(homeLabel);
            inizializzaCl();
            inizalizzaCalen();
    for(int j=0;j<20;j++) {
            for (int i = 0; i < 20; i++) {
                calendario.team[j].getPlayer(i).addEta();
                calendario.team[j].ritiro40();
                if (calendario.team[j].getPlayer(i).getEta() > 35) {
                    calendario.team[j].getPlayer(i).decPrezzo1000();
                    calendario.team[j].getPlayer(i).decAbilita1();
                }
                if (calendario.team[j].getPlayer(i).getEta() < 25) {
                    calendario.team[j].getPlayer(i).incPrezzo1000();
                    calendario.team[j].getPlayer(i).incAbilita1();
                }
            }
            for(int i=0;i<20;i++){
                calendario.team[i].azzeraPWDL();
            }
        }
        }
        if(e.getSource()==playButton){
            serieA();
            ordinaClTable();
        }
        for(int i=0;i<20;i++){
            if(e.getSource()==calendario.team[i].getButton()){
                for(int j=0;j<20;j++){
                    squadra.setValueAt(calendario.team[i].getPlayer(j).getNome(),j,0);
                    squadra.setValueAt(calendario.team[i].getPlayer(j).getCognome(),j,1);
                    squadra.setValueAt(calendario.team[i].getPlayer(j).getEta(),j,2);
                    squadra.setValueAt(calendario.team[i].getPlayer(j).getPrezzo(),j,3);
                    squadra.setValueAt(calendario.team[i].getPlayer(j).getGol(),j,4);
                    squadra.setValueAt(calendario.team[i].getPlayer(j).getAbilita(),j,5);

                }
                squadra.setVisible(true);
            }
        }
        if(e.getSource()==button[0]){
            homeLabel.setVisible(true);
            playButton.setVisible(true);
            clTabel.setVisible(true);
            teamsLabel.setVisible(false);
            rosa.setVisible(false);
            allenatoreLabel.setVisible(false);
            trasfLabel.setVisible(false);
            finanzeLabel.setVisible(false);
            tatticheLabel.setVisible(false);
            scroll.setVisible(false);
            alboLabel.setVisible(false);
            squadra.setVisible(false);
        }

        if(e.getSource()==button[2]){
            homeLabel.setVisible(false);
            playButton.setVisible(false);
            clTabel.setVisible(false);
            teamsLabel.setVisible(true);
            rosa.setVisible(false);
            allenatoreLabel.setVisible(false);
            trasfLabel.setVisible(false);
            finanzeLabel.setVisible(false);
            tatticheLabel.setVisible(false);
            scroll.setVisible(false);
            alboLabel.setVisible(false);
            squadra.setVisible(false);
        }
        if(e.getSource()==button[3]){
            homeLabel.setVisible(false);
            playButton.setVisible(false);
            clTabel.setVisible(false);
            teamsLabel.setVisible(false);
            rosa.setVisible(true);
            allenatoreLabel.setVisible(false);
            trasfLabel.setVisible(false);
            finanzeLabel.setVisible(false);
            tatticheLabel.setVisible(false);
            scroll.setVisible(false);
            alboLabel.setVisible(false);
            squadra.setVisible(false);
        }
        if(e.getSource()==button[4]){
            homeLabel.setVisible(false);
            playButton.setVisible(false);
            clTabel.setVisible(false);
            teamsLabel.setVisible(false);
            rosa.setVisible(false);
            allenatoreLabel.setVisible(true);
            trasfLabel.setVisible(false);
            finanzeLabel.setVisible(false);
            tatticheLabel.setVisible(false);
            scroll.setVisible(false);
            alboLabel.setVisible(false);
            squadra.setVisible(false);
        }
        if(e.getSource()==button[5]){
            homeLabel.setVisible(false);
            playButton.setVisible(false);
            clTabel.setVisible(false);
            teamsLabel.setVisible(false);
            rosa.setVisible(false);
            allenatoreLabel.setVisible(false);
            trasfLabel.setVisible(true);
            finanzeLabel.setVisible(false);
            tatticheLabel.setVisible(false);
            scroll.setVisible(false);
            alboLabel.setVisible(false);
            squadra.setVisible(false);
        }
        if(e.getSource()==button[6]){
            homeLabel.setVisible(false);
            playButton.setVisible(false);
            clTabel.setVisible(false);
            teamsLabel.setVisible(false);
            rosa.setVisible(false);
            allenatoreLabel.setVisible(false);
            trasfLabel.setVisible(false);
            finanzeLabel.setVisible(true);
            tatticheLabel.setVisible(false);
            scroll.setVisible(false);
            alboLabel.setVisible(false);
            squadra.setVisible(false);
        }
        if(e.getSource()==button[7]){
            homeLabel.setVisible(false);
            playButton.setVisible(false);
            clTabel.setVisible(false);
            teamsLabel.setVisible(false);
            rosa.setVisible(false);
            allenatoreLabel.setVisible(false);
            trasfLabel.setVisible(false);
            finanzeLabel.setVisible(false);
            tatticheLabel.setVisible(true);
            scroll.setVisible(false);
            alboLabel.setVisible(false);
            squadra.setVisible(false);
        }
        if(e.getSource()==button[8]){
            homeLabel.setVisible(false);
            playButton.setVisible(false);
            clTabel.setVisible(false);
            teamsLabel.setVisible(false);
            rosa.setVisible(false);
            allenatoreLabel.setVisible(false);
            trasfLabel.setVisible(false);
            finanzeLabel.setVisible(false);
            tatticheLabel.setVisible(false);
            scroll.setVisible(true);
            calendarioTabel.setVisible(true);
            alboLabel.setVisible(false);
            squadra.setVisible(false);

        }
        if(e.getSource()==button[9]){
            homeLabel.setVisible(false);
            playButton.setVisible(false);
            clTabel.setVisible(false);
            teamsLabel.setVisible(false);
            rosa.setVisible(false);
            allenatoreLabel.setVisible(false);
            trasfLabel.setVisible(false);
            finanzeLabel.setVisible(false);
            tatticheLabel.setVisible(false);
            scroll.setVisible(false);
            alboLabel.setVisible(true);
            squadra.setVisible(false);
            alboTabel.setVisible(true);
        }
    }
    void inizializzaCl(){
        for(int i=0;i<20;i++){
            clTabel.setValueAt(calendario.getTeam(i).getNome(),i,0);
            clTabel.setValueAt(0,i,1);
            clTabel.setValueAt(0,i,2);
            clTabel.setValueAt(0,i,3);
            clTabel.setValueAt(0,i,4);

        }
    }
    void inizalizzaCalen(){
        k=0;
        for(int i=0;i<380;i++) {

            calendarioTabel.setValueAt(null, i, 2);
            calendarioTabel.setValueAt(null, i, 3);
        }
    }
    public void serieA(){

       int v[];
       int partite=k+10;
                while(k<partite&&k<380) {
                v = match(findByNameCalend((String) calendarioTabel.getValueAt(k, 0)),
                          findByNameCalend((String) calendarioTabel.getValueAt(k, 1)));
                calendarioTabel.setValueAt(v[0],k,2);
                calendarioTabel.setValueAt(v[1],k,3);
                k++;
        }
    }
    void ordinaClTable(){
        JTable t=new JTable(1,5);

        for(int j=20;j>0;j--) {
            for (int i = 0; i + 1 < j; i++) {
                if ((int) clTabel.getValueAt(i,1) < (int) clTabel.getValueAt(i+1,1)) {
                    t.setValueAt(clTabel.getValueAt(i,0) ,0,0);
                    t.setValueAt(clTabel.getValueAt(i,1) ,0,1);
                    t.setValueAt(clTabel.getValueAt(i,2) ,0,2);
                    t.setValueAt(clTabel.getValueAt(i,3) ,0,3);
                    t.setValueAt(clTabel.getValueAt(i,4) ,0,4);

                    clTabel.setValueAt(clTabel.getValueAt(i+1,0) ,i,0);
                    clTabel.setValueAt(clTabel.getValueAt(i+1,1) ,i,1);
                    clTabel.setValueAt(clTabel.getValueAt(i+1,2) ,i,2);
                    clTabel.setValueAt(clTabel.getValueAt(i+1,3) ,i,3);
                    clTabel.setValueAt(clTabel.getValueAt(i+1,4) ,i,4);

                    clTabel.setValueAt(t.getValueAt(0,0) ,i+1,0);
                    clTabel.setValueAt(t.getValueAt(0,1) ,i+1,1);
                    clTabel.setValueAt(t.getValueAt(0,2) ,i+1,2);
                    clTabel.setValueAt(t.getValueAt(0,3) ,i+1,3);
                    clTabel.setValueAt(t.getValueAt(0,4) ,i+1,4);


                }
            }
        }

            text = new JTextArea(clTabel.getValueAt(0, 0) + " e' campione d'Italia.\nContinuare?");
            text.setBounds(250, 410, 500, 90);
            text.setForeground(Color.white);
            text.setBackground(Color.black);
            text.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 29));
            text.setEnabled(false);
            ok.addActionListener(this);
            ok.setBounds(250, 500, 200, 70);
        if(k==380) {
            panel.add(text);
            panel.add(ok);
            panel.remove(homeLabel);
        }
    }
    Team findByNameCalend(String s){
        Team t=new Team("nulla",v);
        for(int i=0;i<20;i++){
            if(calendario.team[i].getNome()==s){
                return calendario.team[i];
            }
        }
        return t;
    }
    int findRowTeamByNameCl(String s){
        for(int i=0;i<20;i++) {
            if (clTabel.getValueAt(i, 0)==s){
                return i;
            }
        }
        return 0;
    }
    public int[] match(Team t1, Team t2){
        int []v=new int[2];
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
            v[0]=golt1; v[1]=golt2;

        }
        if(golt1<golt2){
            t2.addP3();t2.addW();  t1.addL();
            v[0]=golt1; v[1]=golt2;

        }
        if(golt1==golt2){
            t1.addP1();t2.addP1();
            t1.addD();t2.addD();
            v[0]=golt1; v[1]=golt2;
        }
        int rigat1=findRowTeamByNameCl(t1.getNome());
        int rigat2=findRowTeamByNameCl(t2.getNome());
        clTabel.setValueAt(t1.getP(),rigat1,1);
        clTabel.setValueAt(t1.getW(),rigat1,2);
        clTabel.setValueAt(t1.getD(),rigat1,3);
        clTabel.setValueAt(t1.getL(),rigat1,4);

        clTabel.setValueAt(t2.getP(),rigat2,1);
        clTabel.setValueAt(t2.getW(),rigat2,2);
        clTabel.setValueAt(t2.getD(),rigat2,3);
        clTabel.setValueAt(t2.getL(),rigat2,4);
        return v;
    }



}
