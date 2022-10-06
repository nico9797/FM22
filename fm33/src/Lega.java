import javax.swing.*;

public class Lega{
    public ImageIcon juventus;
    public ImageIcon bologna;
    public ImageIcon monza;
    public ImageIcon inter;
    public ImageIcon verona;
    public ImageIcon lecce;
    public ImageIcon milan;
    public ImageIcon udinese;
    public ImageIcon empoli;
    public ImageIcon lazio;
    public ImageIcon spezia;
    public ImageIcon cremonese;
    public ImageIcon roma;
    public ImageIcon sassuolo;
    public ImageIcon fiorentina;
    public ImageIcon napoli;
    public ImageIcon sampdoria;
    public ImageIcon torino ;
    public ImageIcon atalanta;
    public ImageIcon salernitana;
    Team[] team;
    String[][] calendario=new String[760][4];

    Lega(){
        juventus = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\juventus.png");
        bologna = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\bologna.png");
        monza = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\monza.png");
        inter = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\inter.png");
        verona = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\verona.png");
        lecce = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\lecce.png");
        milan = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\milan.png");
        udinese = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\udinese.png");
        empoli = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\empoli.png");
        lazio = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\lazio.png");
        spezia = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\nfm33\\media\\spezia.png");
        cremonese = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\cremonese.png");
        roma = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\roma.png");
        sassuolo = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\sassuolo.png");
        fiorentina = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\fiorentina.png");
        napoli = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\napoli.png");
        sampdoria = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\sampdoria.png");
        torino = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\torino.png");
        atalanta = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\atalanta.png");
        salernitana = new ImageIcon("C:\\Users\\ndipi\\Desktop\\workspace\\fm33\\media\\salernitana.png");

        team = new Team[20];
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

        int n = 20;
        int giornate = n - 1;

        String[] casa = new String[n / 2];
        String[] fuori = new String[n / 2];

        for (int i = 0; i < n / 2; i++) {
            casa[i] = team[i].getNome();
            fuori[i] = team[n - 1 - i].getNome();
        }
        for (int i = 0; i < giornate*2; i++) {
            /* stampa le partite di questa giornata */
            //System.out.printf("%d^ Giornata\n", i + 1);
            //
                for (int j = 0; j < n / 2; j++) {
                    //System.out.printf("%d %s - %s\n", j + 1, casa[j], fuori[j]);
                    addCalendario(casa[j],fuori[j]);

                }
            String pivot = casa[0];
            String riporto = fuori[fuori.length - 1];

            fuori = shiftRight(fuori, casa[1]);
            casa = shiftLeft(casa, riporto);
            casa[0] = pivot;
        }
    }
    //senso orario
    Team getTeam(int i){
        return team[i];
    }

    String getElemento(int p1,int p2){
        return calendario[p1][p2];
    }
    void addCalendario(String s1,String s2){
        int i=0;
        boolean e=false;
        while(!e) {
            if (calendario[i][0] != null && calendario[i][1] != null) {
                i++;
            }
            else {
                calendario[i][0] = s1; calendario[i][1] = s2;
                e = true;
            }
        }
    }
    private String[] shiftRight(String[] data, String add) {
        String[] temp = new String[data.length];
        for (int i = 1; i < data.length; i++) {
            temp[i] = data[i - 1];
        }
        temp[0] = add;
        return temp;
    }
    private String[] shiftLeft(String[] data, String add) {
        String[] temp = new String[data.length];
        for (int i = 0; i < data.length-1; i++) {
            temp[i] = data[i + 1];
        }
        temp[data.length - 1] = add;
        return temp;
    }
    void stampaCalendario(){
        int k=0;
        int g=2;
        System.out.println("\n GIORNATA"+1);
        for(int i=0;i<380;i++){
            if(k==10){
                k=0;
                System.out.println("\n GIORNATA"+g); g++;
            }
            System.out.println(calendario[i][0] + " - " + calendario[i][1]);
            k++;
        }
    }
}