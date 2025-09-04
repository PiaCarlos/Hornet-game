package assignment1;

public class Hornet extends Insect{

	private int attack_damage;
	public static int BASE_FIRE_DMG;
	private boolean isQueen = false;
	private static int howManyQueens = 0;


	public Hornet(Tile position, int hp, int damage) {

		super(position, hp);
		this.attack_damage = damage;
	}

	public boolean takeAction() {

		Tile position = this.getPosition();
		HoneyBee bee = position.getBee();
		int counter = 0;
		int max = (this.isTheQueen()) ? 2 : 1;
		
		 while(counter < max) {
			 counter++;

			if(position.isOnFire()){
				this.takeDamage(BASE_FIRE_DMG);
			}	

			if (position.isHive() && bee == null) {
				return false;
			}

			if(bee != null) {
				bee.takeDamage(attack_damage);

			} else {
				position.removeInsect(this);
				position = position.towardTheHive();
				position.addInsect(this);

			}
		}
		return true;
	}

	public boolean equals(Object obj) {

		if (!super.equals(obj)) {
			return false;
		}

		if (obj instanceof Hornet) {
			return this.attack_damage == ((Hornet) obj).attack_damage;
		}

		return false;
	}

	public boolean isTheQueen() {
		return isQueen;
	}

	public void promote() {
		if(howManyQueens == 0) {
			this.isQueen = true;
		}
	}




}


