package com.example.abc;

import android.widget.TextView;

import java.util.Random;

public class Campionato {
    Team[] teams; //classifica
    String[][] calendario=new String[380][10];

    Campionato(String[] s){
        Random r=new Random();

        teams=new Team[s.length];

        for(int i=0;i<s.length;i++){
            teams[i]=new Team(s[i]);
            if(s[i].equals("Juventus")||s[i].equals("Inter")||s[i].equals("Milan")||
                    s[i].equals("Napoli")||s[i].equals("Roma")||s[i].equals("Lazio")||
                    s[i].equals("Atalanta")){
                for(int j=0;j<10;j++){
                    int[]n={89,88,87,86};
                    teams[i].getPlayer(j).setAbilita(n[r.nextInt(4)]);
                }
                }

        }
        berger(s);
    }
    void azzeraClassifica(){
        for(int i=0;i<20;i++){
            teams[i].azzeraPWDL();
        }
    }
    public void ordinaTeamP(){
        Team t=new Team ("t");//temp
        for(int j=20;j>0;j--) {
            for (int i = 0; i + 1 < j; i++) {
                if (teams[i].getP() < teams[i+1].getP()) {
                    t.copia(teams[i+1]);
                    teams[i+1].copia(teams[i]);
                    teams[i].copia(t);
                }
            }
        }
    }
    Team getTeam(int i){
        return teams[i];
    }
    Team getTeamByName(String s){
       for(int i=0;i< teams.length;i++){
            if(getTeam(i).getNome().equals(s)){
                return getTeam(i);
            }
        }
       return getTeam(0);
    }

        private void berger(String [] squadre){
            int n = squadre.length;
            int giornate = n - 1;

            String[] casa = new String[squadre.length / 2];
            String[] fuori = new String[squadre.length / 2];

            for (int i = 0; i < n / 2; i++) {
                casa[i] = squadre[i];
                fuori[i] = squadre[n - 1 - i];
            }
            for (int i = 0; i < giornate*2; i++) {
                /* stampa le partite di questa giornata */
                //System.out.printf("%d^ Giornata\n", i + 1);

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

        public int[] match(Team t1,Team t2) {
            Random r = new Random();

            int[] golcasafuori = {0,0};
            int gol = r.nextInt(7);
            int golt1 = 0;
            int golt2 = 0;
                while (gol > 0) {
                    int p1 = r.nextInt(20);
                    int p2 = r.nextInt(20);

                    if (t1.getPlayer(p1).getAbilita() > t2.getPlayer(p2).getAbilita()) {
                        t1.getPlayer(p1).addGol();
                        golt1 = golt1 + 1;
                    }
                    if (t1.getPlayer(p1).getAbilita() <= t2.getPlayer(p2).getAbilita()) {
                        t2.getPlayer(p2).addGol();
                        golt2 = golt2 + 1;
                    }
                    gol--;
                }

                golcasafuori[0] = golt1;
                golcasafuori[1] = golt2;
                if (golt1 > golt2) {
                    t1.addP3();
                    t1.addW();
                    t2.addL();
                    return golcasafuori;
                }
                if (golt1 < golt2) {
                    t2.addP3();
                    t2.addW();
                    t1.addL();
                    return golcasafuori;
                }
                    t1.addP1();
                    t2.addP1();
                    t1.addD();
                    t2.addD();
                    return golcasafuori;

            }
}

