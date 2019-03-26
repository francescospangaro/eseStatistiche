/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc_000
 */
public class DatiCondivisi {
    private Semaphore syncGenSpa;
    private Semaphore syncSpaPun;
    private Semaphore syncPunScr;
    private Semaphore syncScrGen;
    private char[] caratteri = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', ' ', '.'}; ; 
    private char buffer;
    private int spaziScritti;
    private int puntiScritti;
    private int spaziLetti;
    private int puntiLetti;
    private int num;

    public DatiCondivisi(int num) {
        this.num = num;
        this.syncGenSpa = new Semaphore(0);
        this.syncSpaPun = new Semaphore(0);
        this.syncPunScr = new Semaphore(0);
        this.syncScrGen = new Semaphore(1);
    }

    public DatiCondivisi(Semaphore syncGenSpa, Semaphore syncSpaPun, Semaphore syncPunScr, Semaphore syncScrGen, char buffer, int spaziScritti, int puntiScritti, int spaziLetti, int puntiLetti, int num) {
        this.syncGenSpa = new Semaphore(0);
        this.syncSpaPun = new Semaphore(0);
        this.syncPunScr = new Semaphore(0);
        this.syncScrGen = new Semaphore(1);
        this.buffer = buffer;
        this.spaziScritti = spaziScritti;
        this.puntiScritti = puntiScritti;
        this.spaziLetti = spaziLetti;
        this.puntiLetti = puntiLetti;
        this.num = num;
    }

    public Semaphore getSyncGenSpa() {
        return syncGenSpa;
    }

    public void setSyncGenSpa(Semaphore syncGenSpa) {
        this.syncGenSpa = syncGenSpa;
    }

    public Semaphore getSyncSpaPun() {
        return syncSpaPun;
    }

    public void setSyncSpaPun(Semaphore syncSpaPun) {
        this.syncSpaPun = syncSpaPun;
    }

    public Semaphore getSyncPunScr() {
        return syncPunScr;
    }

    public void setSyncPunScr(Semaphore syncPunScr) {
        this.syncPunScr = syncPunScr;
    }

    public Semaphore getSyncScrGen() {
        return syncScrGen;
    }

    public void setSyncScrGen(Semaphore syncScrGen) {
        this.syncScrGen = syncScrGen;
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

    public int getSpaziScritti() {
        return spaziScritti;
    }

    public void setSpaziScritti(int spaziScritti) {
        this.spaziScritti = spaziScritti;
    }

    public int getPuntiScritti() {
        return puntiScritti;
    }

    public void setPuntiScritti(int puntiScritti) {
        this.puntiScritti = puntiScritti;
    }

    public int getSpaziLetti() {
        return spaziLetti;
    }

    public void setSpaziLetti(int spaziLetti) {
        this.spaziLetti = spaziLetti;
    }

    public int getPuntiLetti() {
        return puntiLetti;
    }

    public void setPuntiLetti(int puntiLetti) {
        this.puntiLetti = puntiLetti;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public void incPuntiLetti(){
        this.puntiLetti++;
    }
    
    public void incPuntiScrtti(){
        this.puntiScritti++;
    }

    public void incSpaziLetti(){
        this.spaziLetti++;
    }
    
    public void incSpaziScritti(){
        this.spaziScritti++;
    }
    
    public void waitSyncGenSpa(){
        try {
            syncGenSpa.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitSyncSpaPun(){
        try {
            syncSpaPun.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitSyncPunScr(){
        try {
            syncPunScr.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitSyncScrGen(){
        try {
            syncScrGen.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DatiCondivisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void signalSyncGenSpa(){
        syncGenSpa.release();
    }
    
    public void signalSyncSpaPun(){
        syncSpaPun.release();
    }
    
    public void signalSyncPunScr(){
        syncPunScr.release();
    }
    
    public void signalSyncScrGen(){
        syncScrGen.release();
    }
}
