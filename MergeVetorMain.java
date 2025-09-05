
import java.util.Scanner;

public class MergeVetorMain {

    private class FilaVetor {
        private int[] elementos;
        private int inicio;
        private int fim;
        private int tamanho;
        private int capacidade;

        public FilaVetor(int capacidade) {
            elementos = new int[capacidade];
            inicio = 0;
            fim = -1;
            tamanho = 0;
            this.capacidade = capacidade;
        }

        public boolean vazia() {
            return tamanho == 0;
        }

        public boolean cheia() {
            return tamanho == capacidade;
        }

        public void enfileirar(int valor) {
            if (cheia()) {
                System.out.println("Fila cheia!");
                return;
            }
            fim = (fim + 1) % capacidade;
            elementos[fim] = valor;
            tamanho++;
        }

        public int desenfileirar() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return -1;
            }
            int valor = elementos[inicio];
            inicio = (inicio + 1) % capacidade;
            tamanho--;
            return valor;
        }

        public int primeiro() {
            if (vazia()) return -1;
            return elementos[inicio];
        }

        public void imprimir() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return;
            }
            int idx = inicio;
            for (int i = 0; i < tamanho; i++) {
                System.out.print(elementos[idx] + " ");
                idx = (idx + 1) % capacidade;
            }
            System.out.println();
        }
    }

    private class MergeVetor {
        public FilaVetor merge(FilaVetor A, FilaVetor B, int capacidade) {
            FilaVetor C = new FilaVetor(capacidade);

            while (!A.vazia() && !B.vazia()) {
                if (A.primeiro() <= B.primeiro()) {
                    C.enfileirar(A.desenfileirar());
                } else {
                    C.enfileirar(B.desenfileirar());
                }
            }

            while (!A.vazia()) {
                C.enfileirar(A.desenfileirar());
            }
            while (!B.vazia()) {
                C.enfileirar(B.desenfileirar());
            }

            return C;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeVetorMain outer = new MergeVetorMain();
        FilaVetor A = outer.new FilaVetor(20);
        FilaVetor B = outer.new FilaVetor(20);
        FilaVetor C = null;
        MergeVetor mergeUtil = outer.new MergeVetor();
        int opc = 1;
        while (opc != 0) {
            System.out.println("");
            System.out.println("Inserir em Fila A (1)");
            System.out.println("Inserir em Fila B (2)");
            System.out.println("Imprimir Fila A (3)");
            System.out.println("Imprimir Fila B (4)");
            System.out.println("Realizar Merge (gerar Fila C) (5)");
            System.out.println("Imprimir Fila C (6)");
            System.out.println("Encerrar (0)");
            System.out.print("Digite uma opcao: ");
            opc = sc.nextInt();

            if (opc == 1) {
                System.out.print("Digite o número para Fila A: ");
                A.enfileirar(sc.nextInt());
            }
            if (opc == 2) {
                System.out.print("Digite o número para Fila B: ");
                B.enfileirar(sc.nextInt());
            }
            if (opc == 3) {
                System.out.print("Fila A: ");
                A.imprimir();
            }
            if (opc == 4) {
                System.out.print("Fila B: ");
                B.imprimir();
            }
            if (opc == 5) {
                C = mergeUtil.merge(A, B, 40);
                System.out.println("Merge realizado!");
            }
            if (opc == 6) {
                if (C == null) System.out.println("Primeiro faça o merge!");
                else {
                    System.out.print("Fila C: ");
                    C.imprimir();
                }
            }
        }
        sc.close();
    }
}
