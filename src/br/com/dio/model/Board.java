package br.com.dio.model;

public class Board {

    private final Space[][] spaces;

    public Board(Space[][] spaces) {
        this.spaces = spaces;
    }

    public Space[][] getSpaces() {
        return spaces;
    }

    public void changeValue(int row, int col, int value) {

        if (spaces[row][col].isFixed()) {
            System.out.println("Esta posição possui um valor fixo.");
            return;
        }

        spaces[row][col].setActual(value);
    }

    public void clearValue(int row, int col) {

        if (spaces[row][col].isFixed()) {
            System.out.println("Esta posição possui um valor fixo.");
            return;
        }

        spaces[row][col].clearSpace();
    }

    public void reset() {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (!spaces[row][col].isFixed()) {
                    spaces[row][col].clearSpace();
                }
            }
        }
    }

    public boolean hasErrors() {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                Space space = spaces[row][col];

                if (space.getActual() != null &&
                    space.getActual() != space.getExpected()) {

                    return true;
                }
            }
        }

        return false;
    }

    public boolean gameIsFinished() {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                Space space = spaces[row][col];

                if (space.getActual() == null ||
                    space.getActual() != space.getExpected()) {

                    return false;
                }
            }
        }

        return true;
    }

    public GameStatusEnum getStatus() {

        boolean hasFilledSpace = false;

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (!spaces[row][col].isFixed()
                    && spaces[row][col].getActual() != null) {

                    hasFilledSpace = true;
                }
            }
        }

        if (!hasFilledSpace) {
            return GameStatusEnum.NON_STARTED;
        }

        if (gameIsFinished()) {
            return GameStatusEnum.COMPLETE;
        }

        return GameStatusEnum.INCOMPLETE;
    }
}