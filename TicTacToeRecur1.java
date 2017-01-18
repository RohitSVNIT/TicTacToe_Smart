import java.util.*;

public class TicTacToeRecur1
{
	int turnShift = 1;
	int turn = 0;
//	int move = 0;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		TicTacToeRecur1 ob1 = new TicTacToeRecur1();

		int ain[] = {1,2,3,4,5,6,7,8,9};
		int a[] = new int[9];
		System.out.println("Welcome Comrade !");
		ob1.display(ain);
		System.out.println("Choose the number According to reference");
		ob1.display(a);
		while(true)
		{
			System.out.println("\t1.Single Player Game\n\t2.Two Player Game\n\t3.Exit Game");
			int n = sc.nextInt();
			String mode = "sp";
			switch(n)
			{
// Single Player Mode
				case 1:
					mode = "sp";
					System.out.println("Player-1 , Your Symbol is '1' <><><><><> My Symbol is '2'");
					break;
// Multi-Player Mode
				case 2:
					mode = "mp";
					System.out.println("Player-1 Symbol '1' <><><><><> Player-2 Symbol '2'");
					break;
// Exit Game
				case 3:
					System.out.println("--! THANK YOU FOR PLAYING !--");
					return;
// Invalid Input
				default:
					System.out.println("Invalid Selection ! Try again");
					continue;
			}
			while(true)
			{
				a = ob1.player(a);
				ob1.display(a);
				if(ob1.gameStatus(a) == ob1.turnShift || ob1.gameStatus(a) == 3)
				{
					if(ob1.gameStatus(a) == ob1.turnShift)
						System.out.println("Player - "+ob1.turnShift+" Won");
					else
						System.out.println("Game Draw");
					return ;
				}
				if(mode == "sp")
				{
					a = ob1.compAI(a);
					ob1.display(a);
					ob1.turnShift = 2;
				}
				if(ob1.gameStatus(a) == ob1.turnShift || ob1.gameStatus(a) == 3)
				{
					if(ob1.gameStatus(a) == ob1.turnShift)
						System.out.println("Player - "+ob1.turnShift+" Won");
					else
						System.out.println("Game Draw");
					return ;
				}

// Change Turn of Player
				{
					if(ob1.turnShift == 1)
						ob1.turnShift = 2;
					else
						ob1.turnShift = 1;
				}
			}
		}
	}

	public int [] player(int a[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Player - "+turnShift+" ! It's your turn");
		int ch = sc.nextInt();
		if(ch<1 || ch>9)
		{
			System.out.println(" Sorry Comrade ! Invalid Input\n Please Try Again");
			return player(a);
		}
		else if(a[ch-1]!=0)
		{
			System.out.println(" Sorry Comrade ! Already Occupied\n Please Try Again");

			return player(a);
		} 
		a[ch-1]=turnShift;
		return a;
	}

	public int playerRetry(int a[],int b[])
	{
		for(int i=0 ; i<9 ; i++)
		{
			if(a[i] != b[i])
				return 1;
		}
		return 0;
	}

	public int [] compAI(int a[])
	{
		int move = 0;
		int max = 0;
		int score = 0;
		for(int i=0 ; i<9 ; i++)
		{
			if(a[i] == 0)
			{
				a[i] = 2; 
				turn = 1;
				score = algoAI(a);
				a[i] = 0;
				if(score > max)
				{
					max = score;
					move = i;
				}
			}
		}
		a[move] = 2;
		return a;
	}
	public void turnAI()
	{
		if(turn==1)
			turn = 2;
		else
			turn = 1;
		return ;
	}
	
	public int algoAI(int a[])
	{
		Scanner sc = new Scanner(System.in);
		int score = 0;
		int max = 0;
		int move = 0;
		if(gameStatus(a) == 2 || gameStatus(a) == 3 || gameStatus(a) == 1)
		{
			if(gameStatus(a) == 2)
				return 2;
			if(gameStatus(a) == 3)
				return 1;
			if(gameStatus(a) == 1)
				return 0;
		}
		for(int i=0 ; i<9 ; i++)
		{
			if(a[i] == 0)
			{
				a[i] = turn;
				turnAI();
//				display(a);
//				System.out.println("i = "+i+" , turn = "+turn);
//				int z = sc.nextInt();
				score = algoAI(a);
				a[i] = 0;
/*				if(score > max)
				{
					max = score;
					move = i;
				}
*/
//				display(a);
//				System.out.println("i = "+i+" , turn = "+turn);
//				z = sc.nextInt();
			}
		}
		return score;
	}

// Display Game at the instant
	public void display(int a[])
	{
		System.out.println();
		for(int i=0 ; i<9 ; i++)
		{
			System.out.print(" "+a[i]);
			if((i+1)%3 == 0)
				System.out.println();
		}
		System.out.println();
	}

// Draw Condition
	public int checkGrid(int a[])
	{
		for(int i=0 ; i<9 ; i++)
		{
			if(a[i]==0)
				return 0;
		}
		return 1;
	}

// Present Game Status
	public int gameStatus(int a[])
	{
		if(checkWin(a) == 1 || checkWin(a) == 2)
		{
			return checkWin(a);
		}
		if(checkGrid(a) == 1)
		{
			return 3;
		}
		return 0;
	}

// Winning Condition
	public int checkWin(int a[])
	{
		for(int i=0 ; i<9 ; i+=3)
		{
			if(a[i]==a[i+1] && a[i]==a[i+2] && a[i]!=0)
			{
				return a[i];
			}
		}
		for(int i=0 ; i<3 ; i++)
		{
			if(a[i]==a[i+3] && a[i]==a[i+6] && a[i]!=0)
			{
				return a[i];
			}
		}
		if(a[0]==a[4] && a[0]==a[8] && a[0]!=0)
		{
			return a[0];
		}
		if(a[2]==a[4] && a[2]==a[6] && a[2]!=0)
		{
			return a[2];
		}
		return 0;
	}
}
