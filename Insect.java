package assignment1;

public abstract class Insect {

	private Tile position;
	private int healthPoints;

	public Insect(Tile position, int hp) {

		String errMsg = "Invalid input to creating an insect";

		if (!position.addInsect(this))
			throw new IllegalArgumentException(errMsg);

		this.healthPoints = hp;
	}

	public final Tile getPosition() {

		return position;
	}

	public final int getHealth() {

		return healthPoints;
	}

	public void setPosition(Tile new_position) {

		this.position = new_position;
	}


	public void takeDamage(int damage) {

		healthPoints = healthPoints - damage;

		if(healthPoints <= 0) {
			position.removeInsect(this);
		}
	}

	public abstract boolean takeAction();
	

	public boolean equals(Object obj) {

		if(obj.getClass() == this.getClass() && ((Insect) obj).healthPoints == this.healthPoints 
				&& ((Insect) obj).position == this.position) {
			return true;

		}
		return false;
	}

	public void regenerateHealth(double regenPercentage) {

		int regenHealth =(int) (healthPoints * regenPercentage);
		int newHealth = healthPoints  + regenHealth;
		healthPoints = newHealth;


	}


}
