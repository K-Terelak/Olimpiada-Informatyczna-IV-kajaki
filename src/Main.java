import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner s = new Scanner(System.in);

    static final int max = 30_000;

    static int n, w, wynik, k;
    static int[] waga_osob;

    public static void main(String[] args) {
        try {
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
        } catch (InputMismatchException e) {
            System.out.println("Podano błędne dane");
        } catch (Exception e) {
            System.out.println("Błąd");
        }
    }

    public static void getData() {

        System.out.println("podaj maksymalne obciążenie kajaka:");
        w = s.nextInt();

        // czy maksymalne obciążenie kajaka spełnia warunki zadania
        if (w < 80 || w > 200) {
            System.out.println("Błąd: podaj liczbę od 80 do 200");
            throw new InputMismatchException();
        }

        System.out.println("podaj licczbę osób:");
        n = s.nextInt();

        // czy liczba uczestników spełnia warunki zadania
        if (n < 1 || n > max) {
            System.out.println("Błąd: liczba uczestników musi być w zakresie 1-" + max);
            throw new InputMismatchException();
        }

        wynik = n;
        k = n - 1;
        waga_osob = new int[n];

        // dodaj do tablicy wagę każdego uczestnika
        for (int i = 0; i < n; i++) {
            System.out.println("Podaj wagę " + (i + 1) + " uczestnika");
            try {
                int waga = s.nextInt();
                // waga jednej osoby przekracza maksymalna wage kajaka
                if (waga > w) {
                    throw new InputMismatchException();
                }
                waga_osob[i] = waga;
            } catch (Exception e) {
                throw new InputMismatchException();
            }
        }
    }
}
