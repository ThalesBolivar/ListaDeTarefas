
import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefas {
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        do {
            System.out.println("== Aplicativo de Lista de Tarefas ==");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Listar tarefas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite a tarefa a ser adicionada:");
                    String tarefa = scanner.nextLine();
                    adicionarTarefa(tarefas, tarefa);
                    break;
                case 2:
                    System.out.println("Digite o índice da tarefa a ser removida: ");
                    int indice = scanner.nextInt();
                    removerTarefa(tarefas, indice);
                    break;
                case 3:
                    listarTarefas(tarefas);
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void adicionarTarefa(ArrayList<String> tarefas, String tarefa) {
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso.");
    }

    private static void removerTarefa(ArrayList<String> tarefas, int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("Índice inválido. A tarefa não foi removida.");
        }
    }

    private static void listarTarefas(ArrayList<String> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
        } else {
            System.out.println("Lista de Tarefas:");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println(i + ". " + tarefas.get(i));
            }
        }
    }
}
