package br.com.dio;

import br.com.dio.model.Board;
import br.com.dio.service.BoardService;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner =
            new Scanner(System.in);

    public static void main(String[] args) {

        BoardService service = new BoardService();

        Board board = service.createBoard();

        int option = -1;

        while (option != 7) {

            System.out.println();
            System.out.println("===== SUDOKU =====");
            System.out.println("1 - Iniciar jogo");
            System.out.println("2 - Colocar número");
            System.out.println("3 - Remover número");
            System.out.println("4 - Visualizar jogo");
            System.out.println("5 - Verificar status");
            System.out.println("6 - Reiniciar jogo");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();

            switch (option) {

                case 1 ->
                    service.printBoard(board);

                case 2 ->
                    insertNumber(board);

                case 3 ->
                    removeNumber(board);

                case 4 ->
                    service.printBoard(board);

                case 5 ->
                    checkStatus(board);

                case 6 -> {
                    board.reset();

                    System.out.println(
                        "Jogo reiniciado."
                    );
                }

                case 7 ->
                    System.out.println(
                        "Jogo encerrado."
                    );

                default ->
                    System.out.println(
                        "Opção inválida."
                    );
            }
        }

        scanner.close();
    }

    private static void insertNumber(Board board) {

        System.out.print("Linha (0-8): ");
        int row = scanner.nextInt();

        System.out.print("Coluna (0-8): ");
        int col = scanner.nextInt();

        System.out.print("Número (1-9): ");
        int value = scanner.nextInt();

        if (!validPosition(row, col)
            || value < 1
            || value > 9) {

            System.out.println(
                "Valores inválidos."
            );

            return;
        }

        board.changeValue(
                row,
                col,
                value
        );
    }

    private static void removeNumber(Board board) {

        System.out.print("Linha (0-8): ");
        int row = scanner.nextInt();

        System.out.print("Coluna (0-8): ");
        int col = scanner.nextInt();

        if (!validPosition(row, col)) {

            System.out.println(
                "Posição inválida."
            );

            return;
        }

        board.clearValue(
                row,
                col
        );
    }

    private static void checkStatus(Board board) {

        System.out.println(
            "Status: "
            + board.getStatus().getLabel()
        );

        if (board.hasErrors()) {

            System.out.println(
                "O jogo contém erros."
            );

        } else {

            System.out.println(
                "O jogo não contém erros."
            );
        }

        if (board.gameIsFinished()) {

            System.out.println(
                "Parabéns! Sudoku concluído!"
            );
        }
    }

    private static boolean validPosition(
            int row,
            int col
    ) {

        return row >= 0
                && row < 9
                && col >= 0
                && col < 9;
    }
}