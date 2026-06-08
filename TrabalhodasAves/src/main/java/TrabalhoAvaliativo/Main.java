package TrabalhoAvaliativo;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        try{

            // terreno inicial aleatorio
            Terrenos[] allterrenos = Terrenos.values();
            int indeceInicial = random.nextInt(allterrenos.length);
            Terrenos terrenoDaArena = allterrenos[indeceInicial];

            Aves jogador = null;
            Aves inimigo = null;
            int turnoAtual = 1;


            System.out.println("======================================");
            System.out.println("       SELEÇÃO DE PERSONAGEM          ");
            System.out.println("======================================");


            try {
                // seleção jogador 1
                System.out.println("Jogador 1, escolha sua Ave: ");
                System.out.println("[1] - Ganso");
                System.out.println("[2] - Marreco");
                System.out.println("[3] - Cisne");
                System.out.print("Faça sua escolha: ");
                int classeJ1 = scanner.nextInt();

                if (classeJ1 == 1) {
                    jogador = new Ganso();
                    jogador.nome = "Ganso do player[1]";
                } else if (classeJ1 == 2) {
                    jogador = new Marreco();
                    jogador.nome = "Marreco do player [1]";
                } else if (classeJ1 == 3) {
                    jogador = new Cisne();
                    jogador.nome = "Cisne do player [1]";
                } else {
                    jogador = new Ganso();
                    jogador.nome = "Ganso do player[1]";
                }

                // Jogador 2
                System.out.println("Jogador 2, escolha sua Ave: ");
                System.out.println("[1] - Ganso");
                System.out.println("[2] - Marreco");
                System.out.println("[3] -Cisne");
                System.out.print("Faça sua escolha: ");
                int classeJ2 = scanner.nextInt();

                if (classeJ2 == 1) {
                    inimigo = new Ganso();
                    inimigo.nome = "Ganso do player[2]";

                } else if (classeJ2 == 2) {
                    inimigo = new Marreco();
                    inimigo.nome = "Marreco do player[2]";

                } else if (classeJ2 == 3) {
                    inimigo = new Cisne();
                    inimigo.nome = "Cisne do player[2]";

                } else {
                    inimigo = new Ganso();
                    inimigo.nome = "Ganso do player 2";
                }

            } catch (InputMismatchException e) {
                System.err.println("ERRO fatal: vc não digitol nenhum numero");
                System.err.println("Encerrando jogo");
                scanner.close();
                return;
            } catch (Exception er){
                System.err.println("Erro generico: algo deu errado");
                scanner.close();
                return;
            }

            System.out.println("\n=====================================");
            System.out.println("BATALHA INICIA EM UM TERRENO: " + terrenoDaArena);
            System.out.println("=====================================");

            while (jogador.vida > 0 && inimigo.vida > 0) {

                if (turnoAtual > 1 && turnoAtual % 2 == 1) {
                    System.out.println("\nO Local do combate foi alterado de forma Brusca! ");
                    Terrenos[] todosTerrenos = Terrenos.values();
                    int indiceSorteado = random.nextInt(todosTerrenos.length);
                    terrenoDaArena = todosTerrenos[indiceSorteado];
                    System.out.println(" Novo terreno da Batalha: " + terrenoDaArena + "\n");
                }

                System.out.println("=============================");
                System.out.println("Vida do: " + jogador.nome + ":" + jogador.vida + " HP");
                System.out.println("vida do: " + inimigo.nome + ":" + inimigo.vida + " HP");
                System.out.println("=============================");


                //  criar variavel para apontar quem vai primeiro;

                Aves primeiro;
                Aves segundo;

                if (jogador.velocidade >= inimigo.velocidade) {
                    primeiro = jogador;
                    segundo = inimigo;
                } else {
                    System.out.println(inimigo.nome + " é mais rápido que você e toma a iniciativa!\n");
                    primeiro = inimigo;
                    segundo = jogador;
                }


                try {
                    // 1º ATAQUE (Quem tiver mais velocidade)
                    System.out.println("--- Turno de " + primeiro.nome + " ---");
                    System.out.println("[1]: " + primeiro.getNomeAtaqueNormal());
                    System.out.println("[2]: " + primeiro.getNomeAtaquePesado());
                    System.out.println("[3]: " + primeiro.getNomeUltimate());
                    System.out.print("Digite o numero da sua ação: ");

                    String entradax = scanner.next();
                    System.out.println();

                    if (entradax.equalsIgnoreCase("pato")){
                        throw new PatosupremoException("Easter egg: ");
                    }

                    int escolhax = Integer.parseInt(entradax);


                    switch (escolhax) {
                        case 1:
                            ((Ataques) primeiro).ataqueNormal(segundo, terrenoDaArena);
                            break;
                        case 2:
                            ((Ataques) primeiro).ataquePesado(segundo, terrenoDaArena);
                            break;
                        case 3:
                            ((Ataques) primeiro).ultimate(segundo, terrenoDaArena);
                            break;
                        default:
                            System.out.println("Dormiu no ponto e perdeu a vez de atacar");
                            
                    }

                    // Se o segundo morrer, o loop acaba aqui
                    if (segundo.vida <= 0) {
                        System.out.println("O " + segundo.nome + " foi derrotado! " + primeiro.nome + " venceu!!!");
                        break;
                    }


                    // 2º ATAQUE (O que sobrou revida)
                    System.out.println("--- Turno de " + segundo.nome + " ---");
                    System.out.println("[1]: " + segundo.getNomeAtaqueNormal());
                    System.out.println("[2]: " + segundo.getNomeAtaquePesado());
                    System.out.println("[3]: " + segundo.getNomeUltimate());
                    System.out.print("Digite o numero da sua ação: ");

                    String entraday = scanner.next();
                    System.out.println();

                    if (entraday.equalsIgnoreCase("pato")) {
                        throw new PatosupremoException("Easter egg");
                    }

                    int escolhay = Integer.parseInt(entraday);


                    switch (escolhay) {
                        case 1:
                            ((Ataques) segundo).ataqueNormal(primeiro, terrenoDaArena);
                            break;
                        case 2:
                            ((Ataques) segundo).ataquePesado(primeiro, terrenoDaArena);
                            break;
                        case 3:
                            ((Ataques) segundo).ultimate(primeiro, terrenoDaArena);
                            break;
                        default:
                            System.out.println("Dormiu no ponto e perdeu a vez de atacar");
                    }

                    // Se o primeiro morrer, o loop acaba aqui
                    if (primeiro.vida <= 0) {
                        System.out.println("O " + primeiro.nome + " foi derrotado! " + segundo.nome + " venceu!!!");
                        break;
                    }

                }catch(PatosupremoException a)
                {
                    System.out.println("Easter egg");
                    System.err.println("Encerrando programa");
                    return;

                }catch (InputMismatchException | NumberFormatException e){
                    System.err.println("Erro: não foi digitado nenhum numero");
                    System.err.println("Encerrando luta");
                    return;

                }
                catch (Exception ero) {
                    System.err.println("Erro generico: aconteceu algo");
                    return;
                }

                System.out.println("\n========= Fim do Turno " + turnoAtual + " ============\n");
                turnoAtual++;
            }

            System.out.println("\n===== FIM DA BATALHA =======");

        }finally {
            System.err.println("Systema: Scanner fechado com sucesso");
            scanner.close();

        }
    }
}