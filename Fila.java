import java.util.Scanner;

public class Fila {
    private class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No inicio; 
    private No fim;     

    public Fila() {
        inicio = null;
        fim = null;
    }

    
    public void inserir(int valor) {
        No novo = new No(valor);
        if (fim == null) { 
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    
    public int remover() {
        if (inicio == null) {
            System.out.println("A fila está vazia!");
            return -1;
        }
        int valor = inicio.valor;
        inicio = inicio.proximo;


        if (inicio == null) {
            fim = null;
        }

        return valor;
    }

    public void imprimir() {
        if (inicio == null) {
            System.out.println("A fila está vazia!");
            return;
        }
        No atual = inicio;
        System.out.print("Elementos da fila: ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Fila fila = new Fila();
            int numero = 0;
            int opc = 1;

            while (opc != 0) {
                System.out.println("");
                System.out.println("Inserir numero (1)");
                System.out.println("Remover numero (2)");
                System.out.println("Imprimir fila (3)");
                System.out.println("Encerrar (0)");
                System.out.print("Digite uma opcao: ");
                opc = sc.nextInt();

                if (opc == 1) {
                    System.out.print("Digite um número: ");
                    numero = sc.nextInt();
                    fila.inserir(numero);
                }
                if (opc == 2) {
                    System.out.println("Removendo numero: " + fila.remover());
                }
                if (opc == 3) {
                    fila.imprimir();
                }
            }

            sc.close();
        }
    }
}
