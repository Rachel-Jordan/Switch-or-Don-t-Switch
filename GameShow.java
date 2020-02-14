import java.util.Random;
public class GameShow {
	/**
	 * Rachel Jordan 
	 * 
	 * the highest prize is 1
	 *  the curtain values are the prizes
	 *  the player values are which curtain they choose
	 *  
	 * 
	 * 
	 * 
	 */
	private Random rand;
	private int curtain1;
	private int curtain2;
	private int curtain3;
	private int player1;
	private int player2;
	private int curplayer;
	private int nextplayer;
	private int swich; 
	private int wins;
	private int switchwin;
	public GameShow()
	{
		rand = new Random();
		curtain1 = 0;
		curtain2 = 0;
		curtain3 = 0;
		player1 = 0;
		player2 = 0;
		curplayer = 0;
		nextplayer = 0;
		swich = 0;
		wins = 0;
		switchwin = 0;
	}
	/**
	 * Always staying 
	 */	
	public void play()
	{
		prizes();
		pickcurtain();
		pickplayer();
		int x = whatcurtain(curplayer);
		whatprize(x);
		x= whatcurtain(nextplayer);
		whatprize(x);
		win();
		restgame();
		
	}
	/**
	 * Always switching 
	 */
	public void playswitch()
	{
		prizes();
		pickcurtain();
		pickplayer();
		int x = whatcurtain(curplayer);
		whatprize(x);
		x= whatcurtain(swich);
		whatprize(x);
		switchwin();
		restgame();
		
	}
	/**
	 * Random Prizes behind curtains
	 */
	public void prizes()
	{
		
		curtain1 = rand.nextInt(3) + 1;
		while (curtain2 == curtain1 || curtain2 == 0) 
		{
			curtain2 = rand.nextInt(3) + 1;
		}
		while (curtain3 == curtain1 || curtain3 == 0 || curtain3 == curtain2) 
		{
			curtain3 = rand.nextInt(3) + 1;
		}
		System.out.println("Behind the secnes curtain1 is " + curtain1 + " curtain2 is "+ curtain2 + " curtain3 is "+ curtain3);
	}
	/**
	 * Players picking curtains 
	 */
	public void pickcurtain()
	{
		player1 = rand.nextInt(3) + 1;
		while (player2 == player1 || player2 == 0)
		{
			player2 = rand.nextInt(3) + 1;
		}
		while (swich == player1 || swich == 0 || swich == player2) 
		{
			swich = rand.nextInt(3) + 1;
		}
		
		
		System.out.println("player1 picks "+ player1+" player2 picks "+ player2);
		
		
		
	}
	/**
	 * The value of the curtain picked
	 * @param x
	 * @return
	 */
	public int whatcurtain(int x)
	{
		if (x == 1)
		{
			return curtain1;
		}
		else if (x == 2)
		{
			return curtain2;
		}
		else 
		{
			return curtain3;
		}
	}
	/**
	 * Choosing the first curtain 
	 */
	public void pickplayer()
	{
		if (whatcurtain(player1) < whatcurtain(player2))
		{
			curplayer = player2;
			nextplayer = player1;
			System.out.println("picks player2");
		}
		else 
		{
			curplayer = player1;
			nextplayer = player2;
			System.out.println("picks player1");
		}
		
	}
	/**
	 * Opening curtains
	 * @param x
	 */
	public void whatprize(int x)
	{
		System.out.println("Opening prize" + x);
	}
	/**
	 * switching
	 */
	public void switchprize()
	{
		nextplayer = swich;
	}
	/**
	 * did you win?
	 */
	public void win()
	{
		int x = whatcurtain(nextplayer);
		int i = whatcurtain(swich);
		if (i > x)
		{
			wins++;
		}
		System.out.println("Total  stay wins: " + wins);
	}
	/**
	 * Did you switch and win?
	 */
	public void switchwin()
	{
		int x = whatcurtain(nextplayer);
		int i = whatcurtain(swich);
		if (i < x)
		{
			switchwin++;
		}
		System.out.println("Total switch wins: " + switchwin);
	}
	/**
	 * resting the game
	 */
	public void restgame()
	{
		curtain1 = 0;
		curtain2 = 0;
		curtain3 = 0;
		player1 = 0;
		player2 = 0;
		curplayer = 0;
		nextplayer = 0;
		swich = 0;
	}
	
	
	public int getwins()
	{
		return wins;
	}
	
	public int getswitchwin()
	{
		return switchwin;
	}
}
