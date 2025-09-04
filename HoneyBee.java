package assignment1;

public abstract class HoneyBee extends Insect {

	private int cost;
	public static double HIVE_DMG_REDUCTION;

	public HoneyBee(Tile position, int hp, int cost) {

		super(position, hp);
		this.cost = cost; 
	}

	public int getCost() {
		return cost;
	}

	public void takeDamage(int damage) {

		Tile position = this.getPosition();

		if(position.isHive()) {
			double damage_reduction = damage * HIVE_DMG_REDUCTION;
			int reduced_damage = (int) (damage - damage_reduction);
			super.takeDamage(reduced_damage);
		} else {
			super.takeDamage(damage);
		}
	}
}
