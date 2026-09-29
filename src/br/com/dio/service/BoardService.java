package br.com.dio.service;

import br.com.dio.model.Board;
import br.com.dio.model.Space;

public class BoardService {

    private static final int[][] SOLUTION = {

        {5,3,4,6,7,8,9,1,2},
        {6,7,2,1,9,5,3,4,8},
        {1,9,8,3,4,2,5,6,7},

        {8,5,9,7,6,1,4,2,3},
        {4,2,6,8,5,3,7,9,1},
        {7,1,3,9,2,4,8,5,6},

        {9,6,1,5,3,7,2,8,4},
        {2,8,7,4,1,9,6,3,5},
        {3,4,5,2,8,6,1,7,9}
    };

    private static final boolean[][] FIXED = {

        {true,true,false,false,true,false,false,false,false},
        {true,false,false,true,true,true,false,false,false},
        {false,true,true,false,false,false,false,true,false},

        {true,false,false,false,true,false,false,false,true},
        {true,false,false,true,false,true,false,false,true},
        {true,false,false,false,true,false,false,false,true},

        {false,true,false,false,false,false,true,true,false},
        {false,false,false,true,true,true,false,false,true},
        {false,false,false,false,true,false,false,true,true}
    };

    public Board createBoard() {

        Space[][] spaces = new Space[9][9];

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                spaces[row][col] =
                        new Space(
                                SOLUTION[row][col],
                                FIXED[row][col]
                        );
            }
        }

        return new Board(spaces);
    }

    public void printBoard(Board board) {

        Space[][] spaces = board.getSpaces();

        System.out.println();
        System.out.println("    0 1 2   3 4 5   6 7 8");
        System.out.println("  +-------+-------+-------+");

        for (int row = 0; row < 9; row++) {

            System.out.print(row + " | ");

            for (int col = 0; col < 9; col++) {

                Integer value = spaces[row][col].getActual();

                System.out.print(
                    (value == null ? " " : value) + " "
                );

                if ((col + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }

            System.out.println();

            if ((row + 1) % 3 == 0) {
                System.out.println(
                    "  +-------+-------+-------+"
                );
            }
        }
    }
}