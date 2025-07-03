import java.util.Scanner;

public class TicTacToe {
    static char[][] tabuleiro = new char[3][3];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        boolean jogarNovamente;

        do {
            iniciarJogo();
            char jogadorAtual = 'X';
            boolean jogoFinalizado = false;

            while (!jogoFinalizado) {
                imprimirJogo();
                System.out.println("Vez do jogador "+jogadorAtual);
                

               int linha = -1;
               int coluna = -1;
               
                while (true) {
                    System.out.print("Informe a linha (1, 2 ou 3): ");
                linha = scanner.nextInt();
                if (linha >= 1 && linha <= 3) {
                    linha--;
                    break;
                    } else {
                        System.out.println("Linha inválida! Digite um número de 1 a 3.");
        }
    }
                        
                while (true) {
                    System.out.print("Informe a coluna (1, 2 ou 3): ");
                    coluna = scanner.nextInt();
                    if (coluna >= 1 && coluna <= 3) {
                    coluna--;
                    break;
                    } else {
                        System.out.println("Coluna inválida! Digite um número de 1 a 3.");
        }
    }
                                    
                if (tabuleiro[linha][coluna] == ' ') {
                    tabuleiro[linha][coluna] = jogadorAtual;
                } else {
                    System.out.println("Posição já ocupada, tente novamente.");
                    continue;
    }
                                            
                if (verificarVencedor(jogadorAtual)) {
                    imprimirJogo();
                    System.out.println("Jogador "+jogadorAtual+" venceu!");
                    jogoFinalizado = true;
                } else if (verificarEmpate()) {
                    imprimirJogo();
                    System.out.println("Empate!");
                    jogoFinalizado = true;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            }

            System.out.print("Deseja jogar novamente? (sim/não): ");
            jogarNovamente = scanner.next().equalsIgnoreCase("Sim");

        } while (jogarNovamente);

        System.out.println("Jogo encerrado.");
        scanner.close();
        
    }

    public static void iniciarJogo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    
    public static void imprimirJogo() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");

            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean verificarVencedor(char jogador) {

        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }

        if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
            (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
            return true;

        }
        return false;
    }
    
    public static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}