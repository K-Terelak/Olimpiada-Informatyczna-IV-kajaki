import java.util.Arrays;
import java.util.Scanner;

public class main {

    static Scanner s = new Scanner(System.in);

    static final int max = 30_000;

    static int n, w, wynik, k;
    static int[] waga_osob;

    public static void main(String[] args) {
        getData();

        Arrays.sort(waga_osob);

        for (int i = 0; i < n; i++) {
            while (true) {
                if (k <= i) break;
                if (waga_osob[k] + waga_osob[i] <= w) {
                    wynik--;
                    k--;
                    break;
                }
                if (waga_osob[k] + waga_osob[i] > w) k--;
            }
        }
        System.out.println("Minimalna liczba kajaków do wynajęcia:" + wynik);
    }

    public static void getData() {

        System.out.println("podaj maksymalne obciążenie kajaka:");
        w = s.nextInt();

        // czy maksymalne obciążenie kajaka spełnia warunki zadania
        if (w < 80 || w > 200) {
            System.out.println("Błąd: podaj liczbę od 80 do 200");
            return;
        }

        System.out.println("podaj licczbę osób:");
        n = s.nextInt();

        // czy liczba uczestników spełnia warunki zadania
        if (n < 1 || n > max) {
            System.out.println("Błąd: liczba uczestników musi być w zakresie 1-" + max);
            return;
        }

        wynik = n;
        k = n - 1;
        waga_osob = new int[n];

        // dodaj do tablicy wagę każdego uczestnika
        for (int i = 0; i < n; i++) {
            waga_osob[i] = s.nextInt();
        }
    }
}
