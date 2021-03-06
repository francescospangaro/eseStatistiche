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
public class ThLeggiSpazi extends Thread{
    DatiCondivisi ptrDati;
    char buffer;
    int num;

    public ThLeggiSpazi(DatiCondivisi ptrDati, char buffer) {
        this.ptrDati = ptrDati;
        this.buffer = buffer;
    }

    public ThLeggiSpazi(DatiCondivisi ptrDati) {
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
    
    @Override
    public void run(){
        for(int i = 0; i < num; i++){
            ptrDati.waitSyncGenSpa();
            buffer=ptrDati.getBuffer();
            if(buffer == ' ')
                ptrDati.incSpaziLetti();
            ptrDati.signalSyncSpaPun();
        }
        System.out.println("Fine ThLeggiSpazi");
    }
}
