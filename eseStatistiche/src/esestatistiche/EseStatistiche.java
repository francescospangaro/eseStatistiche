/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esestatistiche;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc_000
 */
public class EseStatistiche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Scanner input = new Scanner(System.in);
            int numCaratteri;
            System.out.println("Inserisci il numero di caratteri che vuoi venga randomicamente generato");
            numCaratteri = input.nextInt();
            DatiCondivisi ptrDati = new DatiCondivisi(numCaratteri);
            ThGenera thGenera = new ThGenera(ptrDati);
            ThLeggiPunti thLeggiPunti = new ThLeggiPunti(ptrDati);
            ThLeggiSpazi thLeggiSpazi = new ThLeggiSpazi(ptrDati);
            ThScrivi thScrivi = new ThScrivi(ptrDati);
            
            thGenera.start();
            thLeggiPunti.start();
            thLeggiSpazi.start();
            thScrivi.start();
            
            thGenera.join();
            thLeggiPunti.join();
            thLeggiSpazi.join();
            thScrivi.join();
            System.out.println("Fine programma");
        } catch (InterruptedException ex) {
            Logger.getLogger(EseStatistiche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
