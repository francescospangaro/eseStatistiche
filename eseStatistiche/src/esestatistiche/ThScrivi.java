/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

/**
 *
 * @author franc_000
 */
public class ThScrivi extends Thread{
    DatiCondivisi ptrDati;
    char buffer;
    int spaziScritti;
    int spaziLetti;
    int puntiScritti;
    int puntiLetti;
    int num;

    public ThScrivi(DatiCondivisi ptrDati, char buffer, int spaziScritti, int spaziLetti, int puntiScritti, int puntLetti) {
        this.ptrDati = ptrDati;
        this.buffer = buffer;
        this.spaziScritti = spaziScritti;
        this.spaziLetti = spaziLetti;
        this.puntiScritti = puntiScritti;
        this.puntiLetti = puntLetti;
    }

    public ThScrivi(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.num = ptrDati.getNum();
    }

    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public char getBuffer() {
        return buffer;
    }

    public void setBuffer(char buffer) {
        this.buffer = buffer;
    }

    public int getSpaziScritti() {
        return spaziScritti;
    }

    public void setSpaziScritti(int spaziScritti) {
        this.spaziScritti = spaziScritti;
    }

    public int getSpaziLetti() {
        return spaziLetti;
    }

    public void setSpaziLetti(int spaziLetti) {
        this.spaziLetti = spaziLetti;
    }

    public int getPuntiScritti() {
        return puntiScritti;
    }

    public void setPuntiScritti(int puntiScritti) {
        this.puntiScritti = puntiScritti;
    }

    public int getPuntiLetti() {
        return puntiLetti;
    }

    public void setPuntiLetti(int puntLetti) {
        this.puntiLetti = puntLetti;
    }
    
    public void run(){
        for(int i = 0; i < num; i++){
            ptrDati.waitSyncPunScr();
            buffer = ptrDati.getBuffer();
            puntiLetti = ptrDati.getPuntiLetti();
            puntiScritti = ptrDati.getPuntiScritti();
            spaziLetti = ptrDati.getSpaziLetti();
            spaziScritti = ptrDati.getSpaziScritti();
            System.out.println("Lettera generata: " + buffer);
            System.out.println("Numero punti letti: " + puntiLetti);
            System.out.println("Numero punti scritti: " + puntiScritti);
            System.out.println("Numero spazi letti: " + spaziLetti);
            System.out.println("Numero spazi scritti: " + spaziScritti);
            ptrDati.signalSyncScrGen();
        }
        System.out.println("Fine ThScrivi");
    }
}
