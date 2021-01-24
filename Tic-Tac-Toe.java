import java.util.Scanner;
public class Assignment1
{
    public static void main(String[] args) {
      Scanner Obj=new Scanner(System.in);
      Introduction_to_game();
      
      System.out.println("The current status is");
      
        String [][] board= {{"\t+-----------------------+"},{"\n\t|","","\t|","","\t|","","\t|"},{"\n\t+-----------------------+"},{"\n\t|","","\t|","","\t|","","\t|"},{"\n\t+-----------------------+"},{"\n\t|","","\t|","","\t|","","\t|"},{"\n\t+-----------------------+"}};
        print(board);

        System.out.print("\n");
        int turn=1;
        
            for(turn=1;turn<6;turn++){
              System.out.println("turn: "+turn);
             
              System.out.println("Player1 make your move");
              System.out.print("Enter the row: ");
              int row=Obj.nextInt();
              

               if(row<1||row>3){
                  System.out.println("Invalid input");
                  turn-=1;
                  continue;
              }

              System.out.print("Enter the column: ");
              int col=Obj.nextInt();
             

              if(col<1||col>3){
                System.out.println("Invalid input");
                turn-=1;
                continue;
              }
              int[] row_column=Modifying_indexes(row,col);
              row=row_column[0];
              col=row_column[1];

              if(board[row][col]!=""){

                System.out.println("The box is already filled");
                System.out.println("Enter again");
                turn-=1;
                continue;
                }
     

              int player=1;
              fill_board(row,col,player,board);
              //System.out.println("input_validity_check" +input_validity_check);

              print(board);
              

              if(turn>2){
                String output=win_check(board,player);
                if(output!=""){
                System.out.println(output);
                break;
                }
                else if(output==""&&turn==5){
                    System.out.println("Match Tied");
                    break;
                }

              }
              
             
              System.out.print("\n");
              
              


              System.out.println("Player2 make your move");
              int check1=1;
              int row2=0;
              int col2=0;
              while(check1==1){
                System.out.println("TURN: "+turn);
                  check1+=1;
              System.out.print("Enter the row: ");
              row2=Obj.nextInt();


              
               if(row2<1||row2>3){
                   check1=1;
                  System.out.println("Invalid input");
      
                  continue;
              }

             

              System.out.print("Enter the column: ");
              col2=Obj.nextInt();
             

              if(col2<1||col2>3){
                  check1=1;
                System.out.println("Invalid input");
                continue;
              }
              int[] row_column2=Modifying_indexes(row2,col2);
              row2=row_column2[0];
              col2=row_column2[1];


              if(board[row2][col2]!=""){
                check1=1;

                System.out.println("The box is already filled");
                System.out.println("Enter again");
                continue;
                }
              }
              player=2;
              fill_board(row2,col2,player,board);
              print(board);
              
             if(turn>2){
                String output1=win_check(board,player);
                if(output1!=""){
                System.out.println(output1);
                break;
                }
                else if(output1==""&&turn==5){
                    System.out.println("Match Tied");
                    break;
                }
              }


            }
          }

    public static int[] Modifying_indexes(int row, int column){
      int array[]=new int[2];
      if(row==2){
        row+=1;
      }
      else if(row==3){
        row+=2;
      }
      if(column==2){
        column+=1;
      }
      else if(column==3){
        column+=2;
      }
      array[0]=row;
      array[1]=column;
      return array;

    }      
    public static void Introduction_to_game(){
        System.out.println("\t\t=============================");
        System.out.println("\t\t  WELCOME TO TIC TAC TOE! ");
        System.out.println("\t\t    Designer: Hassan Shakoor"); 
        System.out.println("\t\t    Class: COMP 295");
        System.out.println("\t\t    Date: 12/09/2020 ");
        System.out.println("\t\t  1-- Person vs. Person");
        System.out.println("\t\t============================");
    }
      public static void print(String [][]board){

        for(int i=0;i<board.length;i++){
          for(int j=0;j<board[i].length;j++){
            
            System.out.print(board[i][j]);
           
              
            }
        }
        System.out.print("\n");
      }
    public static void fill_board(int row,int col,int player,String[][]board){
     
      if(player==1){
        board[row][col]=("X");
      }

      else if(player==2){
        board[row][col]=("O");             

      }
      System.out.print("\n");
      System.out.println("Good!, the current status is");
      }
    public static String win_check(String[][]board, int player){
        
      
        String out="";
      if(player==1){
          //IST ROW X X X
        if(board[1][1]=="X" && board[1][3]=="X" && board[1][5]=="X"){
        out="PLayer 1 is winner";
          // 2ND ROW
        }
        else if(board[3][1]=="X"&& board[3][3]=="X" && board[3][5]=="X"){
            out="PLayer 1 is winner";
        }
        // 3RD ROW
        else if(board[5][1]=="X"&& board[5][3]=="X" && board[5][5]=="X"){
             out="PLayer 1 is winner";
        }
        // IST COLUMN 
        else if(board[1][1]=="X"&& board[3][1]=="X" && board[5][1]=="X"){
            out="Player 1 is winner";
        }
        //2nd COLUMN
        else if(board[1][3]=="X"&& board[3][3]=="X" && board[5][3]=="X"){

            out="Player 1 is winner";
        }
        //3RD COLUMN
        else if(board[1][5]=="X"&& board[3][5]=="X" && board[5][5]=="X"){

            out="Player 1 is winner";
        }
      }

      else if(player==2){
        if(board[1][1]=="O" && board[1][3]=="O" && board[1][5]=="O"){
        out="PLayer 2 is winner";
          // 2ND ROW
        }
        else if(board[3][1]=="O"&& board[3][3]=="O" && board[3][5]=="O"){
            out="PLayer 2 is winner";
        }
        // 3RD ROW
        else if(board[5][1]=="O"&& board[5][3]=="O" && board[5][5]=="O"){
             out="PLayer 2 is winner";
        }
        // IST COLUMN 
        else if(board[1][1]=="O"&& board[3][1]=="O" && board[5][1]=="O"){
            out="Player 2 is winner";
        }
        //2nd COLUMN
        else if(board[1][3]=="O"&& board[3][3]=="O" && board[5][3]=="O"){

            out="Player 2 is winner";
        }
        //3RD COLUMN
        else if(board[1][5]=="O"&& board[3][5]=="O" && board[5][5]=="O"){

            out="Player 2 is winner";
        }
      }
      return out;
    }
}
