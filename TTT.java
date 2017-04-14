import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TTT
{

	JFrame jf1;
	JButton b[] = new JButton[9];
	JButton reset = new JButton("Reset");
	int a[] = new int[9];

	public static void main(String args[])
	{

		TTT ob1 = new TTT();
		ob1.firstFrame();
	}

// Initialisation of Frame
public void firstFrame()
	{
		jf1 = new JFrame();
		jf1.setSize(600,800);
		jf1.setLayout(null);
		jf1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	// Tic Tac Toe Heading
		JLabel lb1 = new JLabel("Tic Tac Toe");
		lb1.setBounds(150,10,400,50);
		lb1.setFont(new Font("AR DARLING",Font.PLAIN,40));
		jf1.add(lb1);

	// About Game Currrent Status
		JLabel lb2 = new JLabel("Your Turn !");
		lb2.setBounds(150,420,400,50);
		lb2.setFont(new Font("AR DARLING",Font.PLAIN,40));
		jf1.add(lb2);

	// Reset Button
		reset.setBounds(150,600,200,100);
		reset.setFont(new Font("ARIAL",Font.PLAIN,50));
		reset.addActionListener(new ActionListener(){	  
				public void actionPerformed(ActionEvent e){ 
					for(int i=0 ; i<9 ; i++)
					{
						a[i] = 0;
						b[i].setText("");
					}
					lb2.setText("Your Turn");
        		}
        	});
		jf1.add(reset);

		//Button 1
			b[0] = new JButton();
			b[0].setBounds(100,100,100,100);
			b[0].setFont(new Font("AR DARLING",Font.PLAIN,50));
			b[0].addActionListener(new ActionListener(){	  
				public void actionPerformed(ActionEvent e){ 
            		if(b[0].getText() != "X" && b[0].getText() != "O")
            		{
            			b[0].setText("X");
            			a[0] = -1;
            			int move[] = a;
            			move = compAI(move);
            			a = move;
            			if(checkWin(move) == 1 || checkWin(move) == -1 || checkDraw(move) == 1)
            			{
            				String result;
            				if(checkWin(move) == 1)
            					result = "You Lost !";
            				else if(checkWin(move) == -1)
            					result = "You Won !";
            				else
            					result = "Game Draw !";
            				lb2.setText(result);
            			}
            		}
        		}
        	});
			jf1.add(b[0]);

		//Button 2
			b[1] = new JButton();
			b[1].setBounds(100*2,100,100,100);
			b[1].setFont(new Font("AR DARLING",Font.PLAIN,50));
			b[1].addActionListener(new ActionListener(){	  
				public void actionPerformed(ActionEvent e){  
            		if(b[1].getText() != "X" && b[1].getText() != "O")
            		{
            			b[1].setText("X");
            			a[1] = -1;
            			int move[] = a;
            			move = compAI(move);
            			a = move;
            			if(checkWin(move) == 1 || checkWin(move) == -1 || checkDraw(move) == 1)
            			{
            				String result;
            				if(checkWin(move) == 1)
            					result = "You Lost !";
            				else if(checkWin(move) == -1)
            					result = "You Won !";
            				else
            					result = "Game Draw !";
            				lb2.setText(result);
            			}
            		}
        		}
        	});
			jf1.add(b[1]);

	//Button 3
			b[2] = new JButton();
			b[2].setBounds(100*3,100,100,100);
			b[2].setFont(new Font("AR DARLING",Font.PLAIN,50));
			b[2].addActionListener(new ActionListener(){	  
				public void actionPerformed(ActionEvent e){  
            		if(b[2].getText() != "X" && b[2].getText() != "O")
            		{
            			b[2].setText("X");
            			a[2] = -1;
            			int move[] = a;
            			move = compAI(move);
            			a = move;
            			if(checkWin(move) == 1 || checkWin(move) == -1 || checkDraw(move) == 1)
            			{
            				String result;
            				if(checkWin(move) == 1)
            					result = "You Lost !";
            				else if(checkWin(move) == -1)
            					result = "You Won !";
            				else
            					result = "Game Draw !";
            				lb2.setText(result);
            			}
            		}
        		}
        	});
			jf1.add(b[2]);

	//Button 4
			b[3] = new JButton();
			b[3].setBounds(100,100*2,100,100);
			b[3].setFont(new Font("AR DARLING",Font.PLAIN,50));
			b[3].addActionListener(new ActionListener(){	  
				public void actionPerformed(ActionEvent e){  
            		if(b[3].getText() != "X" && b[3].getText() != "O")
            		{
            			b[3].setText("X");
            			a[3] = -1;
            			int move[] = a;
            			move = compAI(move);
            			a = move;
            			if(checkWin(move) == 1 || checkWin(move) == -1 || checkDraw(move) == 1)
            			{
            				String result;
            				if(checkWin(move) == 1)
            					result = "You Lost !";
            				else if(checkWin(move) == -1)
            					result = "You Won !";
            				else
            					result = "Game Draw !";
            				lb2.setText(result);
            			}
            		}
        		}
        	});
			jf1.add(b[3]);
		
	//Button 5
			b[4] = new JButton();
			b[4].setBounds(100*2,100*2,100,100);
			b[4].setFont(new Font("AR DARLING",Font.PLAIN,50));
			b[4].addActionListener(new ActionListener(){	  
				public void actionPerformed(ActionEvent e){  
            		if(b[4].getText() != "X" && b[4].getText() != "O")
            		{
            			b[4].setText("X");
            			a[4] = -1;
            			int move[] = a;
            			move = compAI(move);
            			a = move;
            			if(checkWin(move) == 1 || checkWin(move) == -1 || checkDraw(move) == 1)
            			{
            				String result;
            				if(checkWin(move) == 1)
            					result = "You Lost !";
            				else if(checkWin(move) == -1)
            					result = "You Won !";
            				else
            					result = "Game Draw !";
            				lb2.setText(result);
            			}
            		}
        		}
        	});
			jf1.add(b[4]);

	//Button 6
			b[5] = new JButton();
			b[5].setBounds(100*3,100*2,100,100);
			b[5].setFont(new Font("AR DARLING",Font.PLAIN,50));
			b[5].addActionListener(new ActionListener(){	  
				public void actionPerformed(ActionEvent e){  
            		if(b[5].getText() != "X" && b[5].getText() != "O")
            		{
            			b[5].setText("X");
            			a[5] = -1;
            			int move[] = a;
            			move = compAI(move);
            			a = move;
            			if(checkWin(move) == 1 || checkWin(move) == -1 || checkDraw(move) == 1)
            			{
            				String result;
            				if(checkWin(move) == 1)
            					result = "You Lost !";
            				else if(checkWin(move) == -1)
            					result = "You Won !";
            				else
            					result = "Game Draw !";
            				lb2.setText(result);
            			}
            		}
        		}
        	});
			jf1.add(b[5]);

	//Button 7
			b[6] = new JButton();
			b[6].setBounds(100,100*3,100,100);
			b[6].setFont(new Font("AR DARLING",Font.PLAIN,50));
			b[6].addActionListener(new ActionListener(){	  
				public void actionPerformed(ActionEvent e){  
            		if(b[6].getText() != "X" && b[6].getText() != "O")
            		{
            			b[6].setText("X");
            			a[6] = -1;
            			int move[] = a;
            			move = compAI(move);
            			a = move;
            			if(checkWin(move) == 1 || checkWin(move) == -1 || checkDraw(move) == 1)
            			{
            				String result;
            				if(checkWin(move) == 1)
            					result = "You Lost !";
            				else if(checkWin(move) == -1)
            					result = "You Won !";
            				else
            					result = "Game Draw !";
            				lb2.setText(result);
            			}
            		}
        		}
        	});
			jf1.add(b[6]);
		
	//Button 8
			b[7] = new JButton();
			b[7].setBounds(100*2,100*3,100,100);
			b[7].setFont(new Font("AR DARLING",Font.PLAIN,50));
			b[7].addActionListener(new ActionListener(){	  
				public void actionPerformed(ActionEvent e){  
            		if(b[7].getText() != "X" && b[7].getText() != "O")
            		{
            			b[7].setText("X");
            			a[7] = -1;
            			int move[] = a;
            			move = compAI(move);
            			a = move;
            			if(checkWin(move) == 1 || checkWin(move) == -1 || checkDraw(move) == 1)
            			{
            				String result;
            				if(checkWin(move) == 1)
            					result = "You Lost !";
            				else if(checkWin(move) == -1)
            					result = "You Won !";
            				else
            					result = "Game Draw !";
            				lb2.setText(result);
            			}
            		}
        		}
        	});
			jf1.add(b[7]);

	//Button 9
			b[8] = new JButton();
			b[8].setBounds(100*3,100*3,100,100);
			b[8].setFont(new Font("AR DARLING",Font.PLAIN,50));
			b[8].addActionListener(new ActionListener(){	  
				public void actionPerformed(ActionEvent e){  
            		if(b[8].getText() != "X" && b[8].getText() != "O")
            		{
            			b[8].setText("X");
            			a[8] = -1;
            			int move[] = a;
            			move = compAI(move);
            			a = move;
            			if(checkWin(move) == 1 || checkWin(move) == -1 || checkDraw(move) == 1)
            			{
            				String result;
            				if(checkWin(move) == 1)
            					result = "You Lost !";
            				else if(checkWin(move) == -1)
            					result = "You Won !";
            				else
            					result = "Game Draw !";
            				lb2.setText(result);
            			}
            		}
        		}
        	});
			jf1.add(b[8]);

			jf1.setVisible(true);
	}

// Computer Turn - Returns Whole Array with value inserted
	public int [] compAI(int x[])
	{
		int move = -1;
		int max = -2;
		for(int i=0 ; i<9 ; i++)
		{
			if(x[i] == 0)
			{
				x[i] = 1;
				int score = -algoAI(a,-1);
				x[i] = 0;
				if(score > max)
				{
					max = score;
					move = i;
				}
			}
		}
		if(move != -1)
		{
			x[move] = 1;
			b[move].setText("O");
		}
		return x;
	}

// Recursive AI Algorithm
	public int algoAI(int x[],int turn)
	{
		int move = -1;
		int max = -2;
		if(checkWin(x) != 0)
		{
			return checkWin(x)*turn;
		}
		for(int i=0 ; i<9 ; i++)
		{
			if(x[i] == 0)
			{
				x[i] = turn;
				int score = -algoAI(a,-1*turn);
				if(score > max)
				{
					max = score;
					move = i;
				}
				x[i] = 0;
			}
		}
		if(move == -1)
			return 0;
		return max;
	}

// Draw Condition - Returns 1 when draw
	public int checkDraw(int x[])
	{
		for(int i=0 ; i<9 ; i++)
		{
			if(x[i]==0)
				return 0;
		}
		return 1;
	}

// Winning Condition - Rerturns Respective Player Code				
	public int checkWin(int x[])
	{
		for(int i=0 ; i<9 ; i+=3)
		{
			if(x[i]==a[i+1] && x[i]==a[i+2])
			{
				return x[i];
			}
		}
		for(int i=0 ; i<3 ; i++)
		{
			if(x[i]==a[i+3] && x[i]==a[i+6])
			{
				return x[i];
			}
		}
		if(x[0]==x[4] && x[0]==x[8])
		{
			return x[0];
		}
		if(x[2]==x[4] && x[2]==x[6])
		{
			return x[2];
		}
		return 0;
	}
}
