package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] italiane = {"Juventus", "Inter", "Milan", "Napoli", "Roma", "Lazio", "Atalanta", "Torino", "Bologna", "Sampdoria", "Empoli",
            "Monza", "Lecce", "Salernitana", "Sassuolo", "Udinese", "Verona", "Spezia", "Fiorentina", "Cremonese"};
    Button legheButton, homeButton, play, reset;
    Button seriea, premierleague, laliga, bundesliga, eredivise, ligue1, serieb, championship, ligaportugal, seriec;
    Button juventus, inter, milan, napoli, roma, lazio, atalanta, sampdoria, sassuolo, bologna, torino, udinese, salernitana, empoli, fiorentina, spezia, verona, cremonese, lecce, monza;
    LinearLayout leghelayout;
    TableLayout italianetable;
    TextView[] g = new TextView[20];
    TextView giornata;
    int contatore = 0;
    TextView[] classifica = new TextView[20];

    Campionato serieA = new Campionato(italiane);
    TableLayout table;

    void giornata(int i) {
        if (i < 380) {
            int[] v0, v1, v2, v3, v4, v5, v6, v7, v8, v9;
            v0 = serieA.match(serieA.getTeamByName(serieA.calendario[i][0]), serieA.getTeamByName(serieA.calendario[i][1]));
            v1 = serieA.match(serieA.getTeamByName(serieA.calendario[i + 1][0]), serieA.getTeamByName(serieA.calendario[i + 1][1]));
            v2 = serieA.match(serieA.getTeamByName(serieA.calendario[i + 2][0]), serieA.getTeamByName(serieA.calendario[i + 2][1]));
            v3 = serieA.match(serieA.getTeamByName(serieA.calendario[i + 3][0]), serieA.getTeamByName(serieA.calendario[i + 3][1]));
            v4 = serieA.match(serieA.getTeamByName(serieA.calendario[i + 4][0]), serieA.getTeamByName(serieA.calendario[i + 4][1]));
            v5 = serieA.match(serieA.getTeamByName(serieA.calendario[i + 5][0]), serieA.getTeamByName(serieA.calendario[i + 5][1]));
            v6 = serieA.match(serieA.getTeamByName(serieA.calendario[i + 6][0]), serieA.getTeamByName(serieA.calendario[i + 6][1]));
            v7 = serieA.match(serieA.getTeamByName(serieA.calendario[i + 7][0]), serieA.getTeamByName(serieA.calendario[i + 7][1]));
            v8 = serieA.match(serieA.getTeamByName(serieA.calendario[i + 8][0]), serieA.getTeamByName(serieA.calendario[i + 8][1]));
            v9 = serieA.match(serieA.getTeamByName(serieA.calendario[i + 9][0]), serieA.getTeamByName(serieA.calendario[i + 9][1]));

            giornata.setText(v0[0] + "-" + v0[1] + " " + serieA.calendario[i][0] + "-" + serieA.calendario[i][1] + "\n" +
                    v1[0] + "-" + v1[1] + " " + serieA.calendario[i + 1][0] + "-" + serieA.calendario[i + 1][1] + "\n" +
                    v2[0] + "-" + v2[1] + " " + serieA.calendario[i + 2][0] + "-" + serieA.calendario[i + 2][1] + "\n" +
                    v3[0] + "-" + v3[1] + " " + serieA.calendario[i + 3][0] + "-" + serieA.calendario[i + 3][1] + "\n" +
                    v4[0] + "-" + v4[1] + " " + serieA.calendario[i + 4][0] + "-" + serieA.calendario[i + 4][1] + "\n" +
                    v5[0] + "-" + v5[1] + " " + serieA.calendario[i + 5][0] + "-" + serieA.calendario[i + 5][1] + "\n" +
                    v6[0] + "-" + v6[1] + " " + serieA.calendario[i + 6][0] + "-" + serieA.calendario[i + 6][1] + "\n" +
                    v7[0] + "-" + v7[1] + " " + serieA.calendario[i + 7][0] + "-" + serieA.calendario[i + 7][1] + "\n" +
                    v8[0] + "-" + v8[1] + " " + serieA.calendario[i + 8][0] + "-" + serieA.calendario[i + 8][1] + "\n" +
                    v9[0] + "-" + v9[1] + " " + serieA.calendario[i + 9][0] + "-" + serieA.calendario[i + 9][1] + "\n");

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leghelayout = findViewById(R.id.leghelayout);
        italianetable = findViewById(R.id.italianetable);
        legheButton = findViewById(R.id.campionatIButton);
        homeButton = findViewById(R.id.home);
        seriea = findViewById(R.id.seriea);
        premierleague = findViewById(R.id.premierleague);
        laliga = findViewById(R.id.laliga);
        bundesliga = findViewById(R.id.bundesliga);
        eredivise = findViewById(R.id.eredivise);
        ligue1 = findViewById(R.id.ligue1);
        serieb = findViewById(R.id.serieb);
        championship = findViewById(R.id.campionship);
        ligaportugal = findViewById(R.id.ligaportugal);
        seriec = findViewById(R.id.seriec);
        juventus = findViewById(R.id.juventus);
        inter = findViewById(R.id.inter);
        milan = findViewById(R.id.milan);
        napoli = findViewById(R.id.napoli);
        roma = findViewById(R.id.roma);
        lazio = findViewById(R.id.lazio);
        atalanta = findViewById(R.id.atalanta);
        sampdoria = findViewById(R.id.sampdoria);
        sassuolo = findViewById(R.id.sassuolo);
        bologna = findViewById(R.id.bologna);
        torino = findViewById(R.id.torino);
        udinese = findViewById(R.id.udinese);
        salernitana = findViewById(R.id.salernitana);
        empoli = findViewById(R.id.empoli);
        fiorentina = findViewById(R.id.fiorentina);
        spezia = findViewById(R.id.spezia);
        verona = findViewById(R.id.verona);
        cremonese = findViewById(R.id.cremonese);
        lecce = findViewById(R.id.lecce);
        monza = findViewById(R.id.monza);
        play = findViewById(R.id.play);
        giornata = findViewById(R.id.giornata);
        classifica[0] = findViewById(R.id.textView1);
        classifica[1] = findViewById(R.id.textView2);
        classifica[2] = findViewById(R.id.textView3);
        classifica[3] = findViewById(R.id.textView4);
        classifica[4] = findViewById(R.id.textView5);
        classifica[5] = findViewById(R.id.textView6);
        classifica[6] = findViewById(R.id.textView7);
        classifica[7] = findViewById(R.id.textView8);
        classifica[8] = findViewById(R.id.textView9);
        classifica[9] = findViewById(R.id.textView10);
        classifica[10] = findViewById(R.id.textView11);
        classifica[11] = findViewById(R.id.textView12);
        classifica[12] = findViewById(R.id.textView13);
        classifica[13] = findViewById(R.id.textView14);
        classifica[14] = findViewById(R.id.textView15);
        classifica[15] = findViewById(R.id.textView16);
        classifica[16] = findViewById(R.id.textView17);
        classifica[17] = findViewById(R.id.textView18);
        classifica[18] = findViewById(R.id.textView19);
        classifica[19] = findViewById(R.id.textView20);
        table = findViewById(R.id.classificatable);
        reset = findViewById(R.id.reset);

        seriea.setOnClickListener(this);
        legheButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        juventus.setOnClickListener(this);
        inter.setOnClickListener(this);
        milan.setOnClickListener(this);
        napoli.setOnClickListener(this);
        roma.setOnClickListener(this);
        lazio.setOnClickListener(this);
        atalanta.setOnClickListener(this);
        sampdoria.setOnClickListener(this);
        sassuolo.setOnClickListener(this);
        bologna.setOnClickListener(this);
        udinese.setOnClickListener(this);
        salernitana.setOnClickListener(this);
        torino.setOnClickListener(this);
        empoli.setOnClickListener(this);
        fiorentina.setOnClickListener(this);
        spezia.setOnClickListener(this);
        verona.setOnClickListener(this);
        cremonese.setOnClickListener(this);
        lecce.setOnClickListener(this);
        monza.setOnClickListener(this);
        play.setOnClickListener(this);
        reset.setOnClickListener(this);

        g[0] = findViewById(R.id.formazione13);
        g[1] = findViewById(R.id.formazione14);
        g[2] = findViewById(R.id.formazione15);
        g[3] = findViewById(R.id.formazione16);
        g[4] = findViewById(R.id.formazione17);
        g[5] = findViewById(R.id.formazione18);
        g[6] = findViewById(R.id.formazione19);
        g[7] = findViewById(R.id.formazione20);
        g[8] = findViewById(R.id.formazione21);
        g[9] = findViewById(R.id.formazione22);
        g[10] = findViewById(R.id.formazione23);
        g[11] = findViewById(R.id.formazione24);
        g[12] = findViewById(R.id.formazione25);
        g[13] = findViewById(R.id.formazione26);
        g[14] = findViewById(R.id.formazione27);
        g[15] = findViewById(R.id.formazione28);
        g[16] = findViewById(R.id.formazione29);
        g[17] = findViewById(R.id.formazione30);
        g[18] = findViewById(R.id.formazione31);
        g[19] = findViewById(R.id.formazione32);
    }

    @Override
    public void onClick(View v) {

        if (((Button) v) == reset) {
            reset.setVisibility(View.INVISIBLE);
            serieA.azzeraClassifica();
            contatore = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    serieA.getTeam(i).getPlayer(j).invecchia();
                }
            }
        }
        if (((Button) v) == play) {
            if (serieA.getTeam(0).getW() + serieA.getTeam(0).getD() + serieA.getTeam(0).getL() == 38) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.INVISIBLE);
                }
                reset.setVisibility(View.VISIBLE);
                return;
            }

            for (int i = 0; i < 20; i++) {
                g[i].setVisibility(View.INVISIBLE);
                classifica[i].setVisibility(View.INVISIBLE);
            }
            giornata.setVisibility(View.VISIBLE);
            leghelayout.setVisibility(View.INVISIBLE);
            italianetable.setVisibility(View.INVISIBLE);

            giornata(contatore);
            contatore = contatore + 10;

            table.setVisibility(View.VISIBLE);
            serieA.ordinaTeamP();
            for (int i = 0; i < 20; i++) {
                classifica[i].setVisibility(View.VISIBLE);
                classifica[i].setText(serieA.teams[i].getP() + " " + serieA.teams[i].getW() + " " + serieA.teams[i].getD()
                        + " " + serieA.teams[i].getL() + " " + serieA.teams[i].getNome());
            }
        }
            if (((Button) v) == legheButton) {
                reset.setVisibility(View.INVISIBLE);
                table.setVisibility(View.INVISIBLE);
                giornata.setVisibility(View.INVISIBLE);
                leghelayout.setVisibility(View.VISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.INVISIBLE);
                    classifica[i].setVisibility(View.INVISIBLE);

                }
            }
            if (((Button) v) == homeButton) {
                reset.setVisibility(View.INVISIBLE);
                table.setVisibility(View.INVISIBLE);
                giornata.setVisibility(View.INVISIBLE);
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.INVISIBLE);
                    classifica[i].setVisibility(View.INVISIBLE);
                }
            }
            if (((Button) v) == seriea) {
                reset.setVisibility(View.INVISIBLE);
                table.setVisibility(View.INVISIBLE);
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.VISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.INVISIBLE);
                    classifica[i].setVisibility(View.INVISIBLE);

                }

            }
            if (((Button) v) == juventus) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);

                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Juventus").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Juventus").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Juventus").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Juventus").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Juventus").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Juventus").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == inter) {

                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Inter").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Inter").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Inter").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Inter").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Inter").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Inter").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == milan) {

                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Milan").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Milan").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Milan").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Milan").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Milan").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Milan").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == napoli) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Napoli").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Napoli").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Napoli").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Napoli").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Napoli").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Napoli").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == roma) {

                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Roma").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Roma").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Roma").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Roma").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Roma").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Roma").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == lazio) {

                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Lazio").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Lazio").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Lazio").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Lazio").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Lazio").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Lazio").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == atalanta) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Atalanta").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Atalanta").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Atalanta").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Atalanta").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Atalanta").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Atalanta").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == sampdoria) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Sampdoria").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Sampdoria").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Sampdoria").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Sampdoria").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Sampdoria").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Sampdoria").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == sassuolo) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Sassuolo").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Sassuolo").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Sassuolo").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Sassuolo").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Sassuolo").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Sassuolo").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == bologna) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Bologna").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Bologna").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Bologna").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Bologna").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Bologna").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Bologna").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == torino) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Torino").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Torino").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Torino").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Torino").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Torino").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Torino").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == udinese) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Udinese").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Udinese").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Udinese").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Udinese").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Udinese").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Udinese").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == salernitana) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Salernitana").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Salernitana").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Salernitana").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Salernitana").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Salernitana").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Salernitana").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == empoli) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Empoli").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Empoli").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Empoli").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Empoli").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Empoli").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Empoli").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == fiorentina) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Fiorentina").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Fiorentina").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Fiorentina").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Fiorentina").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Fiorentina").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Fiorentina").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == spezia) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Spezia").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Spezia").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Spezia").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Spezia").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Spezia").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Spezia").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == verona) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Verona").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Verona").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Verona").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Verona").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Verona").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Verona").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == cremonese) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Cremonese").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Cremonese").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Cremonese").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Cremonese").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Cremonese").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Cremonese").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == lecce) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Lecce").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Lecce").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Lecce").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Lecce").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Lecce").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Lecce").getPlayer(i).getCognome()));

                }
            }
            if (((Button) v) == monza) {
                leghelayout.setVisibility(View.INVISIBLE);
                italianetable.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 20; i++) {
                    g[i].setVisibility(View.VISIBLE);
                    g[i].setText(String.valueOf(
                            serieA.getTeamByName("Monza").getPlayer(i).getEta()
                                    + " " + serieA.getTeamByName("Monza").getPlayer(i).getPos()
                                    + " " + serieA.getTeamByName("Monza").getPlayer(i).getAbilita()
                                    + " " + serieA.getTeamByName("Monza").getPlayer(i).getGol()
                                    + " " + serieA.getTeamByName("Monza").getPlayer(i).getNome()
                                    + " " + serieA.getTeamByName("Monza").getPlayer(i).getCognome()));

                }
            }

    }
}