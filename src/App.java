
import java.util.Random;

/**
 * MIT License
 *
 * Copyright(c) 2024-255 João Caram <caram@pucminas.br>
 * Eveline Alonso Veloso
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class App {

    static int[] tamanhosTesteGrande = {500_000, 1_000_000, 2_000_000, 3_000_000, 5_000_000, 10_000_000};
    static int[] tamanhosTesteMedio = {12_500, 25_000, 50_000, 100_000, 200_000};
    static int[] tamanhosTestePequeno = {3, 6, 12, 24, 48};
    static Random aleatorio = new Random(42);

    /**
     * Código de teste 1. Este método...
     *
     * @param vetor Vetor com dados para teste.
     * @return Uma resposta que significa....
     */
    static int codigo1(int[] vetor) {
        int resposta = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i] % 2;
        }
        return resposta;
    }

    /**
     * Código de teste 2. Este método...
     *
     * @param vetor Vetor com dados para teste.
     * @return Uma resposta que significa....
     */
    static int codigo2(int[] vetor) {
        int contador = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
            }

        }
        return contador;
    }

    /**
     * Código de teste 3. Este método implementa o Selection Sort e conta suas
     * operações.
     *
     * @param vetor Vetor com dados para teste.
     * @return Número total de operações realizadas (comparações + trocas)
     */
    static int codigo3(int[] vetor) {
        int operacoes = 0;
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                operacoes++;
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }
            operacoes++;
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
        return operacoes;
    }

    /**
     * Código de teste 4 (recursivo). Este método...
     *
     * @param n Ponto inicial do algoritmo
     * @return Um inteiro que significa...
     */
    static int codigo4(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return codigo4(n - 1) + codigo4(n - 2);
        }
    }

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido.
     *
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2),
     * desordenado.
     */
    static int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho / 2);
        }
        return vetor;

    }

    public static void main(String[] args) {
        long inicio, fim;
        int contOp;

        //VETOR GRANDE
        for (int tam : tamanhosTesteGrande) {
            int[] vetorGrande = gerarVetor(tam);
            inicio = System.nanoTime();
            contOp = codigo1(vetorGrande);
            fim = System.nanoTime();
            long tempo = fim - inicio;
            System.out.println("Vetor Grande Tamanho: " + tam + " Operações: " + contOp + " Tempo: " + tempo);
            //========================================================================================
            inicio = System.nanoTime();
            contOp = codigo2(vetorGrande);
            fim = System.nanoTime();
            tempo = fim - inicio;
            System.out.println("Vetor Grande Tamanho: " + tam + " Operações: " + contOp + " Tempo: " + tempo);
        }
        //VETOR MEDIO
        for (int tam : tamanhosTesteMedio) {
            int[] vetor = gerarVetor(tam);
            contOp = 0;
            inicio = System.nanoTime();
            for (int i = 0; i < vetor.length - 1; i++) {
                int menor = i;
                for (int j = i + 1; j < vetor.length; j++) {
                    contOp++;
                    if (vetor[j] < vetor[menor]) {
                        menor = j;
                    }
                }
                int temp = vetor[i];
                vetor[i] = vetor[menor];
                vetor[menor] = temp;
                contOp += 3;
            }
            fim = System.nanoTime();
            long tempo = fim - inicio;
            System.out.println("Vetor Medio Tamanho: " + tam + " Operações: " + contOp + " Tempo: " + tempo);
        }
        //VETOR PEQUENO
        for (int tam : tamanhosTestePequeno) {
            inicio = System.nanoTime();
            contOp = codigo4(tam);
            fim = System.nanoTime();
            long tempo = fim - inicio;
            System.out.println("Vetor Pequeno Tamanho: " + tam + " Operações: " + contOp + " Tempo: " + tempo);
        }
    }
}
