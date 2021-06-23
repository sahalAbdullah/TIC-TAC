package newtictactoe;

import java.util.ArrayList;

public class Board {

    public static final int NO_Player = 0;
    public static final int Player_X = 1;
    public static final int Player_0 = 2;
    int v;
    Point computerMove;

    private int[][] board;

    public Board() {
        this.board = new int[3][3];

    }

    public boolean isGameOver() {
        return hasPlayerWon(Player_X) || hasPlayerWon(Player_0) || getAvailableCells().isEmpty();
    }

    public boolean hasPlayerWon(int player) {
        // For Diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == player)
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == player)) {
            return true;
        }

        // For Rows and Columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == player)
                    || (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] == player)) {
                return true;
            }
        }

        // if No one Wins
        return false;
    }

    public ArrayList<Point> getAvailableCells() {

        ArrayList<Point> avaliableCells = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == NO_Player) {
                    avaliableCells.add(new Point(i, j));
                }
            }
        }
        return avaliableCells;
    }
    public boolean placeMovePlayer(int position, int player) {

        Point point = isValidMovePlayer(position);

        if (point != null) {
            if (board[point.x][point.y] != NO_Player) {

                return false;
            } else {
                board[point.x][point.y] = player;
                return true;
            }
        } else {
            return false;
        }
    }
    public boolean placeMove(Point point, int player) {

        if (board[point.x][point.y] != NO_Player) {
            return false;
        } else {
            board[point.x][point.y] = player;
            return true;
        }
    }

    Point isValidMovePlayer(int position) {
        switch (position) {
            case 0:
                if (board[0][0] == NO_Player) {
                    return new Point(0, 0);
                } else {
                    return null;
                }

            case 1:
                if (board[0][1] == NO_Player) {
                    return new Point(0, 1);
                } else {
                    return null;
                }
            case 2:
                if (board[0][2] == NO_Player) {
                    return new Point(0, 2);
                } else {
                    return null;
                }
            case 3:
                if (board[1][0] == NO_Player) {
                    return new Point(1, 0);
                } else {
                    return null;
                }
            case 4:
                if (board[1][1] == NO_Player) {
                    return new Point(1, 1);
                } else {
                    return null;
                }
            case 5:
                if (board[1][2] == NO_Player) {
                    return new Point(1, 2);
                } else {
                    return null;
                }
            case 6:
                if (board[2][0] == NO_Player) {
                    return new Point(2, 0);
                } else {
                    return null;
                }
            case 7:
                if (board[2][1] == NO_Player) {
                    return new Point(2, 1);
                } else {
                    return null;
                }
            case 8:
                if (board[2][2] == NO_Player) {
                    return new Point(2, 2);
                } else {
                    return null;
                }
            default:
                return null;
        }
    }

    public void displayBoard() {
        System.out.println("");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char value = '?';

                if (board[i][j] == Player_X) {
                    value = 'X';
                } else if (board[i][j] == Player_0) {
                    value = '0';
                }
                System.out.print(value);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public int minimax(int depth, int turn) {

        if (hasPlayerWon(Player_X)) {
            return 1;
        }
        if (hasPlayerWon(Player_0)) {
            return -1;
        }

        ArrayList<Point> avaliableCells = getAvailableCells();

        if (avaliableCells.isEmpty()) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < avaliableCells.size(); i++) {

            Point point = avaliableCells.get(i);

            if (turn == Player_X) {

                placeMove(point, Player_X);
                int currentScore = minimax(depth + 1, Player_0);
                max = Math.max(currentScore, max);

                if (depth == 0) {
                    System.out.println("Computer score for position" + point + "=" + currentScore);
                }
                if (currentScore >= 0) {
                    if (depth == 0) {
                        computerMove = point;
                    }
                }
                if (currentScore == 1) {
                    board[point.x][point.y] = NO_Player;
                    break;
                }
                if (i == avaliableCells.size() - 1 && max < 0) {
                    if (depth == 0) {
                        computerMove = point;
                    }
                }

            } else if (turn == Player_0) {
                placeMove(point, Player_0);
                int currentScore = minimax(depth + 1, Player_X);
                min = Math.min(currentScore, min);

                if (min == -1) {
                    board[point.x][point.y] = NO_Player;
                    break;
                }
            }
            board[point.x][point.y] = NO_Player;
        }
        return turn == Player_X ? max : min;
    }

    int isValidAIMove(Point move) {
        if (move.x == 0 && move.y == 0) {
            return 0;
        } else if (move.x == 0 && move.y == 1) {
            return 1;
        } else if (move.x == 0 && move.y == 2) {
            return 2;
        } else if (move.x == 1 && move.y == 0) {
            return 3;
        } else if (move.x == 1 && move.y == 1) {
            return 4;
        } else if (move.x == 1 && move.y == 2) {
            return 5;
        } else if (move.x == 2 && move.y == 0) {
            return 6;
        } else if (move.x == 2 && move.y == 1) {
            return 7;
        } else if (move.x == 2 && move.y == 2) {
            return 8;
        }
        return -1;
    }

    int AlphaBeta() {
        v = max(Integer.MAX_VALUE, Integer.MIN_VALUE);
        return v;
    }

    int max(int alpha, int beta) {
        if (isGameOver()) {
            return v;
        }
        v = alpha;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == NO_Player) {
                    board[i][j] = 1;
                    v = min(alpha, beta);
                    board[i][j] = NO_Player;
                    computerMove = new Point(i, j);
                    if (v >= beta) {
                        return v;
                    }
                }
            }
        }
        alpha = Math.max(alpha, v);
        return v;
    }

    int min(int alpha, int beta) {
        if (isGameOver()) {
            return v;
        }
        v = beta;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == NO_Player) {
                    board[i][j] = 2;
                    v = max(alpha, beta);
                    computerMove = new Point(i, j);
                    board[i][j] = 0;
                    if (v <= alpha) {
                        return v;
                    }
                }
            }
        }
        beta = Math.min(beta, v);
        return beta;
    }
}
