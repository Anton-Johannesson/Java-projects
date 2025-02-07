package Src.AppRun;


import java.util.Random;

public class MatrixBoard{
    private int size;
    private CardImage[][] board;
    private boolean[][] revealed;
    //private Bank bank;
    //private int accountNumber;

    public MatrixBoard(int size, String backFileName, String[] frontFileName) {
        this.size = size;
        this.board = new CardImage[size][size];
        this.revealed = new boolean[size][size];
        CreateImage(backFileName, frontFileName);
        //Bank bank = new Bank();
    }

    private void CreateImage(String backFileName, String[] frontFileName){
        Random rand = new Random();

        for(int i = 0; i < (size * size) / 2; i++){
            CardImage card = new CardImage(frontFileName[i], backFileName);

            int r = rand.nextInt(size);
            int c = rand.nextInt(size);
            while(board[r][c] != null){
                r = rand.nextInt(size);
                c = rand.nextInt(size);
            }
            board[r][c] = card;

            while(board[r][c] != null){
                r = rand.nextInt(size);
                c = rand.nextInt(size);
            }
            board[r][c] = card;
        }
    }

    public int getSize(){
        return size;
    }

    public CardImage getCardImage(int r, int c){
        return board[r][c];
    }

    public void turnCard(int r, int c){
        revealed[r][c] = !revealed[r][c];
    }

    public boolean isRevealed(int r, int c){
        return revealed[r][c];
    }

    public boolean same(int r1, int c1, int r2, int c2){
        return board[r1][c1] == board[r2][c2];
    }

    public boolean hasWon(){
        //int accountNumber = scan.nextInt();
        for(int r = 0; r < size; r++){
            for(int c = 0; c < size; c++){
                if(!revealed[r][c]){
                    return false;
                }
            }
        }
        return true;//lägg till att pengar ska läggas in på kontot

    }


    
    
}
