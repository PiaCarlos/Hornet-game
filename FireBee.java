package assignment1;

public class FireBee extends HoneyBee {

	private int max_attack_range;
	public static int BASE_HEALTH;
	public static int BASE_COST;


	public FireBee(Tile position, int attack_range) {
		super(position, BASE_HEALTH, BASE_COST);
		this.max_attack_range = attack_range;

	}

	public boolean takeAction() {

		Tile currentPosition = this.getPosition();
		Tile nextPosition = currentPosition.towardTheNest();
		int max_range = max_attack_range;
		int counter = 0;

		if(currentPosition.isOnThePath()) {

			while (counter < max_range && nextPosition != null) {

				if ( !nextPosition.isOnFire() && nextPosition.getNumOfHornets() > 0 
						&& !nextPosition.isNest()) {
					nextPosition.setOnFire();
					return true; 
				} 
				counter = counter + 1;
				nextPosition = nextPosition.towardTheNest();
			}

		}

		return false; 
	}
}
