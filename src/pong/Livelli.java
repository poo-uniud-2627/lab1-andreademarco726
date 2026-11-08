// Pong — Programmazione Orientata agli Oggetti e Laboratori, Udine, a.a. 2026-27
// Consegna 3: i livelli. Scadenza: domenica 8 novembre 2026.
package pong;

/**
 * Il gioco a livelli contro il giocatore automatico: a che livello si è e quante vite restano.
 * Si vince un livello vincendo una partita; perdendo una partita si perde una vita.
 * La Partita gli dice com'è finita ogni partita; il giocatore automatico e la velocità della palla
 * dipendono dal livello.
 *
 * IL PEZZO MANCANTE: i corpi dei metodi qui sotto (e i campi che vi servono).
 * Ogni metodo ha il suo contratto, nel commento sopra. I test ufficiali (ConsegnaTreTest) lo controllano.
 */
public class Livelli {

    // scrivete qui i campi che vi servono
    private int livello = 1;
    private int numeroLivelli;
    private int vite;
    private int maxVite;
    private Lato umano;
    /**
     * Un gioco nuovo.
     * Pretende: niente.
     * Promette: livello 1, con tutte le vite; il gioco non è completato né perso.
     * Lancia IllegalArgumentException se numeroLivelli o vite è minore di 1, o se umano è null.
     */
    public Livelli(int numeroLivelli, int vite, Lato umano) {
        // scrivete qui
        try {
            if(numeroLivelli < 1 || vite < 1 || umano == null) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
        this.numeroLivelli = numeroLivelli;
        this.vite = vite;
        this.umano = umano;
        this.maxVite = vite;
    }

    /** Il livello a cui si gioca, fra 1 e getNumeroLivelli(). */
    public int getLivello() {
        return livello; // scrivete qui
    }

    /** Quanti livelli ha il gioco. */
    public int getNumeroLivelli() {
        return numeroLivelli; // scrivete qui
    }

    /** Le vite che restano, fra 0 e quelle iniziali. */
    public int getVite() {
        return vite; // scrivete qui
    }

    /** Il lato su cui gioca la persona (l'altro è il giocatore automatico). */
    public Lato getUmano() {
        return umano; // scrivete qui
    }

    /** Vero se è stato vinto l'ultimo livello. */
    public boolean isCompletato() {
        return (livello > numeroLivelli); // scrivete qui
    }

    /** Vero se le vite sono finite. */
    public boolean isPerso() {
        return (vite == 0); // scrivete qui
    }

    /** Vero se il gioco è completato o perso. */
    public boolean isFinito() {
        return (isCompletato() || isPerso()); // scrivete qui
    }

    /**
     * Registra com'è finita una partita.
     * Pretende: niente.
     * Promette: se il gioco è finito (completato o perso), non cambia niente. Altrimenti:
     *           se ha vinto umano, si passa al livello dopo; se era l'ultimo, il gioco è completato
     *           e il livello resta l'ultimo; le vite non cambiano.
     *           Se ha vinto l'altro lato, una vita in meno e il livello non cambia;
     *           con l'ultima vita il gioco è perso.
     * Lancia IllegalArgumentException se vincitore è null, e non cambia niente.
     */
    public void partitaFinita(Lato vincitore) {
        // scrivete qui
        try {
                if(vincitore == null) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                throw e;
        }
        if(!isCompletato() && !isPerso()){
            
            if(vincitore == umano) {    
                livello++;
            } else {
                vite--;
            }
        }
    }

    /**
     * Si ricomincia da capo.
     * Pretende: niente.
     * Promette: livello 1, con tutte le vite; il gioco non è completato né perso.
     */
    public void ricomincia() {
        // scrivete qui
        livello = 1;
        vite = maxVite;
    }
}
