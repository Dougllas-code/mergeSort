import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] vetor = geradorDeArray(20);
        int[] vAux = new int[vetor.length];

        mergeSort(vetor, vAux, 0, vetor.length - 1);

        System.out.println(Arrays.toString(vetor));

    }

    public static int[] geradorDeArray(int n) {
        int[] v = new int[n];
        Random gerador = new Random();
        for (int i = 0; i < n; i++) {
            v[i] = gerador.nextInt(100);
        }
        return v;
    }

    private static void mergeSort(int[] vetor, int[] vAux, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, vAux, inicio, meio);
            mergeSort(vetor, vAux, meio + 1, fim);
            intercalar(vetor, vAux, inicio, meio, fim);
        }
    }

    private static void intercalar(int[] vetor, int[] vAux, int inicio, int meio, int fim) {
        for (int k = inicio; k <= fim; k++)
            vAux[k] = vetor[k];

        int i = inicio;
        int j = meio + 1;

        for (int k = inicio; k <= fim; k++) {
            if (i > meio) {
                vetor[k] = vAux[j++];
            } else if (j > fim) {
                vetor[k] = vAux[i++];
            } else if (vAux[i] < vAux[j]) {
                vetor[k] = vAux[i++];
            } else {
                vetor[k] = vAux[j++];
            }
        }
    }
}
