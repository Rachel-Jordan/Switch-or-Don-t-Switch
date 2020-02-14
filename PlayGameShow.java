
public class PlayGameShow {
// Rachel Jordan
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameShow gs = new GameShow();
		//for (int i = 0; i <= 1000; i++)
		//{
			gs.play();
			gs.playswitch();
		//}
		
		System.out.println("Total stay wins" + gs.getwins() + " Total switch wins"+ gs.getswitchwin());
	}

}
