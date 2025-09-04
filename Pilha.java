import java.util.Scanner;

public class Pilha {
    private class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No topo;

    public Pilha() {
        topo = null;
    }

    public void inserir(int valor) {
        No novo = new No(valor);
        novo.proximo = topo;
        topo = novo;
    }

    public int remover() {
        if (topo == null) {
            System.out.println("A pilha está vazia!");
            return -1;
        }
        int valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    public void imprimir() {
        if (topo == null) {
            System.out.println("A pilha está vazia!");
            return;
        }
        No atual = topo;
        System.out.print("Elementos da pilha: ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha pilha = new Pilha();
        int numero = 0;
        int opc = 1;
        
        while (opc != 0) {
            System.out.println("");
            System.out.println("Inserir numero (1)");
            System.out.println("Remover numero(2)");
            System.out.println("Imprimir pilha(3)");
            System.out.println("Encerrar(0)");
            System.out.println("Digite uma opcao: ");
            opc = sc.nextInt();

            if (opc == 1) {
                System.out.print("Digite um número: ");

                numero = sc.nextInt();
                pilha.inserir(numero);
            } if (opc == 2){
                System.out.println("Removendo ultimo numero: " + pilha.remover());
                
            } if (opc == 3) {
                pilha.imprimir(); 
            }

        } 
        sc.close();
    }
}


    
}


