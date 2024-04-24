/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica_Cliente;

/**
 *
 * @author BIENVENIDO
 */
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creamos una mano de cartas desordenada
        ArrayList<Carta> mano = new ArrayList<>();
        mano.add(new Carta(3, "Corazones"));
        mano.add(new Carta(10, "Diamantes"));
        mano.add(new Carta(5, "Picas"));
        mano.add(new Carta(8, "Treboles"));
        mano.add(new Carta(2, "Corazones"));

        // Ordenamos la mano de cartas
        ordenarPorValorYTipo(mano);

        // Imprimimos la mano ordenada
        for (Carta carta : mano) {
            System.out.println(carta);
        }
    }

    // Método para ordenar una lista de cartas por valor y palo usando el algoritmo de burbuja
    public static void ordenarPorValorYTipo(ArrayList<Carta> mano) {
        int n = mano.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Comparamos las cartas por valor y, si es necesario, por palo
                if (mano.get(j).getValor() > mano.get(j + 1).getValor() ||
                        (mano.get(j).getValor() == mano.get(j + 1).getValor() &&
                                mano.get(j).getTipo().compareTo(mano.get(j + 1).getTipo()) > 0)) {
                    // Intercambiamos las cartas
                    Carta temp = mano.get(j);
                    mano.set(j, mano.get(j + 1));
                    mano.set(j + 1, temp);
                }
            }
        }
    }
}

class Carta {
    private int valor;
    private String tipo;

    public Carta(int valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return valor + " de " + tipo;
    }
}
