import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CRUDAlunos {

    private static boolean validarFormatoData(String dataStr) {
        String formatoData = "\\d{2}/\\d{2}/\\d{4}"; // Formato DD/MM/AAAA
        return dataStr.matches(formatoData);
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        PriorityQueue<Aluno> filaDePrioridade = new PriorityQueue<>((a1, a2) -> a1.getNome().compareTo(a2.getNome()));

        while (true) {
            System.out.println("\n\nMenu:");
            System.out.println("1. Registrar aluno");
            System.out.println("2. Exibir alunos registrados");
            System.out.println("3. Atualizar Aluno");
            System.out.println("4. Excluir aluno");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = entrada.nextInt();
            entrada.nextLine();

            
            if (escolha == 1) {
                Aluno novoAluno = new Aluno();
            
                while (true) {
                    System.out.print("\nDigite o nome do aluno: ");
                    String Nome = entrada.nextLine();
                    if (Nome.isEmpty()) {
                        System.out.println("\nNome não pode ser vazio. Tente novamente.\n");
                        continue;
                    }
                    novoAluno.setNome(Nome);
            
                    while (true) {
                        System.out.print("\nDigite a data de nascimento do aluno (DD/MM/AAAA): ");
                        String dataNascimentoStr = entrada.nextLine();
                        if (!validarFormatoData(dataNascimentoStr)) {
                            System.out.println("\nFormato de data inválido. Use o formato DD/MM/AAAA. Tente novamente.\n");
                            continue;
                        }
                        String[] partesData = dataNascimentoStr.split("/");
                        int dia = Integer.parseInt(partesData[0]);
                        int mes = Integer.parseInt(partesData[1]);
                        int ano = Integer.parseInt(partesData[2]);
                        data dataNascimento = new data(dia, mes, ano);
                        novoAluno.setNascimento(dataNascimento);
                        break; // Saia do loop interno quando a data for válida.
                    }
            
                    System.out.print("\nDigite o endereço do aluno: ");
                    novoAluno.setEndereco(entrada.nextLine());
            
                    alunos.add(novoAluno); 
                    filaDePrioridade.add(novoAluno); 
                    System.out.println("\nAluno registrado com sucesso!\n");
                    break; // Sai do loop externo quando todas as informações estiverem preenchidas corretamente.
                }
            } else if (escolha == 2) {

                System.out.println("\nAlunos registrados (ordenados por nome):");
                for (Aluno aluno : filaDePrioridade) {
                    System.out.println("\nNome: " + aluno.getNome()
                            + ", | Endereço: " + aluno.getEndereco() +
                            "| Data de Nascimento: " + aluno.getNascimento().getDia() + "/" +
                            aluno.getNascimento().getMes() + "/" + aluno.getNascimento().getAno());
                    System.out.println("----------------------------------------------------------------------------------+");
                }
            } else if (escolha == 3) {
               
                
                System.out.println("\nDigite o nome do aluno que deseja atualizar: ");
                String nomeParaAtualizar = entrada.nextLine();
                boolean alunoAtualizado = false;
               
                for (Aluno aluno : alunos) {
                    if (aluno.getNome().equalsIgnoreCase(nomeParaAtualizar)) {
                        System.out.print("\nDigite o novo nome do aluno: ");
                        String novoNome = entrada.nextLine();
                        if (novoNome.isEmpty()) {
                            System.out.println("\nNome não pode ser vazio. Tente novamente.\n");
                            continue; 
                        }
                        aluno.setNome(novoNome);
                        
                        System.out.print("\nDigite a nova data de nascimento do aluno (DD/MM/AAAA): ");
                        String novaDataNascimentoStr = entrada.nextLine();
                        
                        if (!validarFormatoData(novaDataNascimentoStr)) {
                            System.out.println("\nFormato de data inválido. Use o formato DD/MM/AAAA. Tente novamente.\n");
                            continue; 
                        }

                        String[] partesData = novaDataNascimentoStr.split("/");
                        int novoDia = Integer.parseInt(partesData[0]);
                        int novoMes = Integer.parseInt(partesData[1]);
                        int novoAno = Integer.parseInt(partesData[2]);

                        // Cria uma nova instância de Data com os valores atualizados
                        data novaDataNascimento = new data(novoDia, novoMes, novoAno);

                        // Configura a nova data de nascimento para o aluno
                        aluno.setNascimento(novaDataNascimento);
                        
                       
            
                        System.out.print("\nDigite o novo endereço do aluno: ");
                        aluno.setEndereco(entrada.nextLine());
            
                        alunoAtualizado = true;
                        System.out.println("\nAluno atualizado com sucesso!\n");
                        break; 
                    
                    }
                
                 }
                
                if (!alunoAtualizado) {
                    System.out.println("\nAluno não encontrado. Verifique o nome e tente novamente.\n");
            }
            

            } else if (escolha == 4) {
                System.out.println("\nDigite o nome do aluno que deseja excluir: ");
                String nomeParaExcluir = entrada.nextLine();
                boolean alunoExcluido = false;

                for (Aluno aluno : alunos) {
                     if (aluno.getNome().equalsIgnoreCase(nomeParaExcluir)) {
                        alunos.remove(aluno);
                        alunoExcluido = true;
                        System.out.println("\nAluno excluído com sucesso!\n");
                        break; 
                    }
                }

                if (!alunoExcluido) {
                    System.out.println("\nAluno não encontrado. Verifique o nome e tente novamente.\n");
                }

            } else if (escolha == 5) {
                System.out.println("Programa Encerrado!");
                entrada.close();
                System.exit(0);

            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
