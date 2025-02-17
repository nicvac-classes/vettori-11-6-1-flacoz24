import java.util.*;
import java.lang.Math;

class Program {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int i, n, libroRestituito, scelta, countPrestiti;
        String libroRichiesto;

        System.out.println("qunati libri sono presenti in biblioteca: ");
        do {
            n = input.nextInt();
        } while (n < 5);
        String[] biblioteca = new String[n];
        String[] prestiti = new String[n];

        for (i = 0; i <= n - 1; i++) {
            System.out.println("scrivi il titolo del libro presente in biblioteca: ");
            biblioteca[i] = input.nextLine();
        }
        do {
            scelta = leggiComando();
            if (scelta == 1) {
                visualizzaBiblioteca(biblioteca, n);
            }
            if (scelta == 2) {
                visualizzaPrestiti(prestiti, n);
            }
            if (scelta == 3) {
                System.out.println("Quale libro vuoi prendere in prestito?");
                libroRichiesto = input.nextLine();
                countPrestiti = countPrestiti + 1;
                n = prendiPrestito(biblioteca, prestiti, n, libroRichiesto, countPrestiti);
            }
            if (scelta == 4) {
                visualizzaPrestiti(prestiti, n);
                System.out.println("Inserire il numero del libro da sostituire: ");
                do {
                    libroRestituito = input.nextInt();
                } while (libroRestituito < 0 || libroRestituito > n);
                n = restituisciPrestito(biblioteca, prestiti, n, libroRestituito - 1);
            }
            if (scelta == 5) {
                System.out.println("Chiusura programma...");
            }
        } while (scelta != 5);
    }
    
    public static int eliminaElemento(String[] vettore, int dimensione, int elemento) {
        int dimensione, i;

        dimensione = dimensione - 1;
        for (i = elemento + 1; i <= dimensione - 2; i++) {
            vettore[i] = vettore[i + 1];
        }
        
        return dimensione;
    }
    
    public static int inserisciElemento(String[] biblioteca, String[] prestiti, int dimensione, int elemento, String libro) {
        int i;

        for (i = dimensione; i >= elemento + 1; i--) {
            vettore[i] = vettore[i - 1];
        }
        vettore[elemento] = libro;
        dimensione = dimensione + 1;
        
        return dimensione;
    }
    
    public static int leggiComando() {
        int scelta;

        do {
            System.out.println("------ BIBLIOTECA ------");
            System.out.println("1. Visualizza libri in biblioteca");
            System.out.println("2. Visualizza libri in prestito");
            System.out.println("3. Prendi in prestito un libro");
            System.out.println("4. Restituisci un libro");
            System.out.println("5. Esci dal programma");
            scelta = input.nextInt();
        } while (scelta < 1 || scelta > 5);
        
        return scelta;
    }
    
    public static int prendiPrestito(String[] biblioteca, String[] prestiti, int dimensione, String libro, int count) {
        int elemento, i;
        boolean trovato;

        trovato = false;
        for (i = 0; i <= dimensione - 1; i++) {
            if (biblioteca[i].equals(libro)) {
                elemento = i;
                trovato = true;
                inserisciElemento(biblioteca, prestiti, dimensione, elemento, biblioteca[i], count);
                dimensione = eliminaElemento(biblioteca, dimensione, elemento);
                System.out.println("Il libro " + biblioteca[i] + " è stato preso in prestito");
            }
        }
        if (!trovato) {
            System.out.println("Libro non presente in libreria");
        }
        
        return dimensione;
    }
    
    public static int restituisciPrestito(int[] biblioteca, int[] prestiti, int dimensione, int elemento) {
        if (!(elemento < 0) && !(elemento > dimensione)) {
            int dimensione;

            dimensione = eliminaElemento(prestiti, dimensione, elemento);
            inserisciElemento(biblioteca, dimensione, prestiti[elemento], elemento);
        } else {
            System.out.println("Questo libro non è mai stato preso in prestito");
        }
        
        return dimensione;
    }
    
    public static void visualizzaBiblioteca(String[] vettore, int dimensione) {
        int i;

        for (i = 0; i <= dimensione - 1; i++) {
            if (dimensione > 0) {
                System.out.println(Integer.toString(i + 1) + ": " + vettore[i]);
            } else {
                System.out.println("La biblioteca è vuota, i libri sono stati presi tutti in prestito");
            }
        }
    }
    
    public static void visualizzaPrestiti(String[] vettore, int dimensione) {
        int i;

        for (i = 0; i <= dimensione - 1; i++) {
            if (dimensione > 0) {
                System.out.println(Integer.toString(i + 1) + ": " + vettore[i]);
            } else {
                System.out.println("La biblioteca è piena, nessun libro è stato preso in prestito");
            }
        }
    }
}
