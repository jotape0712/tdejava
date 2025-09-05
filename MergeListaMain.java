
import java.util.Scanner;

public class MergeListaMain {

    private class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private class FilaLista {
        private No inicio;
        private No fim;

        public FilaLista() {
            inicio = null;
            fim = null;
        }

        public boolean vazia() {
            return inicio == null;
        }

        public void enfileirar(int valor) {
            No novo = new No(valor);
            if (fim == null) {
                inicio = fim = novo;
            } else {
                fim.proximo = novo;
                fim = novo;
            }
        }

        public int desenfileirar() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return -1;
            }
            int valor = inicio.valor;
            inicio = inicio.proximo;
            if (inicio == null) fim = null;
            return valor;
        }

        public int primeiro() {
            if (vazia()) return -1;
            return inicio.valor;
        }

        public void imprimir() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return;
            }
            No atual = inicio;
            while (atual != null) {
                System.out.print(atual.valor + " ");
                atual = atual.proximo;
            }
            System.out.println();
        }
    }

    private class MergeLista {
        public FilaLista merge(FilaLista A, FilaLista B) {
            FilaLista C = new FilaLista();

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
        MergeListaMain outer = new MergeListaMain();
        FilaLista A = outer.new FilaLista();
        FilaLista B = outer.new FilaLista();
        FilaLista C = null;
        MergeLista mergeUtil = outer.new MergeLista();
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
                C = mergeUtil.merge(A, B);
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
