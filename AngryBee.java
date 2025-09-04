package assignment1;

public class AngryBee extends HoneyBee {

	private int attack_damage;
	public static int BASE_HEALTH;
	public static int BASE_COST;
	
	public AngryBee(Tile position, int damage) {
		
		super(position, BASE_HEALTH, BASE_HEALTH);
		this.attack_damage = damage;
		
	}
	
	public boolean takeAction() {
		
		Tile currentPosition = this.getPosition();
		Tile nextPosition = currentPosition.towardTheNest();
		
				
		if(currentPosition.isOnThePath()) {
			Hornet hornet = currentPosition.getHornet();
			if(hornet != null && !hornet.getPosition().isNest()) {
				 hornet.takeDamage(attack_damage);
				 return true;
			}
			Hornet nextHornet = nextPosition.getHornet();
			if(nextHornet != null && !nextHornet.getPosition().isNest()) {
				nextHornet.takeDamage(attack_damage);
				return true;
			}
		}
		
		return false;
	}
	
}
