import java.util.*;

public class TicTacToeSingle
{

	int n = 1;			// For First Time Reference Display

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		TicTacToeSingle ob1 = new TicTacToeSingle();
		int ain[] = {1,2,3,4,5,6,7,8,9};
		int a[] = new int[9];
		System.out.println("Welcome Comrade !");
		ob1.display(ain);
		System.out.println("Choose the number According to reference");
		ob1.display(a);
		System.out.println("Player-1 , Your Symbol is 'P' <><><><><> My Symbol is 'X'");
		while(true)
		{
			a = ob1.player(a);
			ob1.display(a);
			a = ob1.compAI(a);
			if(ob1.checkWin(a) == -1 || ob1.checkWin(a) == 1 || ob1.checkDraw(a) ==1 )
			{
				if(ob1.checkWin(a) == 1)
					System.out.println("Sorry Comrade ! You Lost");
				else if(ob1.checkWin(a) == -1)
					System.out.println("Congracts Comrade ! You Win");
				else
					System.out.println("Game Draw");
				return ;
			}
			ob1.display(a);
		}	
	}

// player Turn - Returns whole array with inserted Symbols
	public int [] player(int a[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Comrade ! It's your turn");
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
		a[ch-1]=-1;
		return a;
	}

// Computer Turn - Returns Whole Array with value inserted
	public int [] compAI(int a[])
	{
		int move = -1;
		int max = -2;
		for(int i=0 ; i<9 ; i++)
		{
			if(a[i] == 0)
			{
				a[i] = 1;
				int score = -algoAI(a,-1);
				a[i] = 0;
				if(score > max)
				{
					max = score;
					move = i;
				}
			}
		}
		if(move != -1)
			a[move] = 1;
		return a;
	}

// Recursive AI Algorithm
	public int algoAI(int a[],int turn)
	{
		int move = -1;
		int max = -2;
		if(checkWin(a) != 0)
		{
			return checkWin(a)*turn;
		}
		for(int i=0 ; i<9 ; i++)
		{
			if(a[i] == 0)
			{
				a[i] = turn;
				int score = -algoAI(a,-1*turn);
				if(score > max)
				{
					max = score;
					move = i;
				}
				a[i] = 0;
			}
		}
		if(move == -1)
			return 0;
		return max;
	}

// Display Game at the instant
	public void display(int a[])
	{
		System.out.println();
		if(n == 1)
		{
			for(int i=0 ; i<9 ; i++)
			{
				System.out.print(" "+a[i]);
				if((i+1)%3 == 0)
					System.out.println();
			}
			System.out.println();
			n = 0;
		}
		else
		{
			for(int i=0 ; i<9 ; i++)
			{
				char pr;
				if(a[i]==1)
					pr = 'X';
				else if(a[i] == -1)
					pr = 'P';	
				else
					pr = Character.forDigit(a[i], 10);
				System.out.print(" "+pr);
				if((i+1)%3 == 0)
					System.out.println();
			}
			System.out.println();
		}
	}


// Draw Condition - Returns 1 when draw
	public int checkDraw(int a[])
	{
		for(int i=0 ; i<9 ; i++)
		{
			if(a[i]==0)
				return 0;
		}
		return 1;
	}

// Winning Condition - Rerturns Respective Player Code				
	public int checkWin(int a[])
	{
		for(int i=0 ; i<9 ; i+=3)
		{
			if(a[i]==a[i+1] && a[i]==a[i+2])
			{
				return a[i];
			}
		}
		for(int i=0 ; i<3 ; i++)
		{
			if(a[i]==a[i+3] && a[i]==a[i+6])
			{
				return a[i];
			}
		}
		if(a[0]==a[4] && a[0]==a[8])
		{
			return a[0];
		}
		if(a[2]==a[4] && a[2]==a[6])
		{
			return a[2];
		}
		return 0;
	}
}
