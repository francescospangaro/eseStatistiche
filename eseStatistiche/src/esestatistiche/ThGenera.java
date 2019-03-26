/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Random;

/**
 *
 * @author franc_000
 */
public class ThGenera extends Thread{
    DatiCondivisi ptrDati;
    char[] caratteri;
    char buffer;
    int num;

    public ThGenera(DatiCondivisi ptrDati, char[] caratteri, char buffer) {
        this.ptrDati = ptrDati;
        this.caratteri = caratteri;
        this.buffer = buffer;
    }

    public ThGenera(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.caratteri = ptrDati.getCaratteri();
        this.num =ptrDati.getNum();
    }

    public DatiCondivisi getPtrDati() {
        return ptrDati;
    }

    public void setPtrDati(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public char[] getCaratteri() {
        return caratteri;
    }

    public void setCaratteri(char[] caratteri) {
        this.caratteri = caratteri;
    }

    public char getBuffer() {
        return buffer;
    }

    public void setBuffer(char buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run(){
        
        Random rand = new Random();
        for(int i = 0; i < num; i++){
            ptrDati.waitSyncScrGen();
            int posizioneCarattereGenerato = rand.nextInt(28);
            buffer = caratteri[posizioneCarattereGenerato];
            if(buffer == ' ')
                ptrDati.incSpaziScritti();
            if(buffer == '.')
                ptrDati.incPuntiScrtti();
            ptrDati.setBuffer(buffer);
            ptrDati.signalSyncGenSpa();
        }
        System.out.println("Fine generazione caratteri");
    }
}
