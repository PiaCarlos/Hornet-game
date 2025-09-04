package assignment1;

public class SniperBee extends HoneyBee {

	private int attack_damage;
	private int piercing_power;
	public static int BASE_HEALTH;
	public static int BASE_COST;
	private boolean isAiming = false;

	public SniperBee(Tile position, int attack_damage, int piercing_power) {

		super(position,BASE_HEALTH,BASE_COST);
		this.attack_damage = attack_damage;
		this.piercing_power = piercing_power;
	}

	public boolean takeAction() {
		Tile currentPosition = this.getPosition();
		Tile nextPosition = currentPosition.towardTheNest();
		int n = piercing_power;
		int counter = 0;

		if(currentPosition.isOnThePath()) {
			if (!isAiming) {
				isAiming = true;
				return false; 
			} 
			isAiming = false;
			
			while (nextPosition != null) {

				if (nextPosition.getNumOfHornets() > 0 && !nextPosition.isNest()) {
					Hornet[] hornets = nextPosition.getHornets();

					if (hornets.length < n) {
						n = hornets.length;
					}

					while(counter < n) {
						hornets[counter].takeDamage(attack_damage);
						counter++;
					}

					return true;
				}
				nextPosition = nextPosition.towardTheNest();
			}
		}
		return false;
	}
}
