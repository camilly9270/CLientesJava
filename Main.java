package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Cliente> listCliente = new ArrayList<>();

    public static void main(String[] args) {
        int contador = 0;
        LoopUm:
        while(true){
            contador++;
            System.out.println("\nSe você deseja sair, digite 1");
            System.out.println("Se você deseja criar uma entidade cliente, digite 2");
            System.out.println("Se você deseja deletar uma entidade cliente, digite 3");
            System.out.println("Se VocÊ deseja buscar um cliente, digite 4");
            System.out.println("Se você deseja ver a lista completa, digite 5");
            System.out.println("Se você deseja alterar a idade do cliente, digite 6");
            Scanner scanner = new Scanner(System.in);
            int opcaoEscolhida = scanner.nextInt();

            if (opcaoEscolhida == 1){
                System.out.println("Você entrou " +  contador + " vezes no loopUm");
                System.out.println("Você esta saindo do loop...");
                break LoopUm;
            }

            if (opcaoEscolhida == 2){
                Cliente cliente = new Cliente();
                System.out.println("Digite o nome do cliente: ");
                Scanner atributoDoCliente = new Scanner(System.in);
                cliente.nome = atributoDoCliente.nextLine();
                System.out.println("Digite a idade do cliente: ");
                cliente.idade = atributoDoCliente.nextInt();
//                cliente.atualizandoAposentadoria();

                if(cliente.idade >=65){
                    cliente.aposentadoria = 2000;
                }

                System.out.println("Cliente de nome: " + cliente.nome);
                System.out.println("Cliente com idade: " + cliente.idade);
                listCliente.add(cliente);
            }

            if (opcaoEscolhida == 3){
                for(int i = 0; i < listCliente.size(); i++){
                    System.out.println("Digite nome do cliente que você deseja deletar: ");
                    Scanner clienteDelete = new Scanner(System.in);
                    String nomeDigitado = clienteDelete.nextLine();
                    if (nomeDigitado.equals(listCliente.get(i).nome)){
                        listCliente.remove(i);
                    }
                }
            }

            if (opcaoEscolhida == 4){
                for(int i = 0; i < listCliente.size(); i++) {
                    System.out.println("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    for (Cliente c : listCliente){
                        if (c.nome.equals(nomeCliente)){
                            System.out.println("Nome do cliente: " + c.nome);
                            System.out.println("Idade do cliente: " + c.idade);
                            System.out.println("Aposentadoria do cliente: " +c.aposentadoria);
                        }
                    }
                }
            }

            if (opcaoEscolhida == 5){
                if (listCliente.size()>0){
                    for (Cliente c : listCliente){
                        System.out.println("Lista completa: ");
                        System.out.println(c.nome);
                        System.out.println(c.idade);
                        System.out.println(c.aposentadoria);
                    }
                }
            }
            if (opcaoEscolhida==6){
                for(int i = 0; i < listCliente.size(); i++) {
                    System.out.println("Digite o nome da pessoa que vc deseja alterar a idade: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String nomeDigitado = scanner1.nextLine();
                    if (nomeDigitado.equals(listCliente.get(i).idade)) {
                        System.out.println("Digite a nova idade: ");
                        Scanner idadeAlterada = new Scanner(System.in);
                        int a = idadeAlterada.nextInt();
                        listCliente.get(i).idade = a;
                    }
                }
            }
        }
    }
}