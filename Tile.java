package assignment1;

public class Tile {

	private int food;
	private boolean hive_built;
	private boolean nest_built;
	private boolean isOnPath;
	private Tile nextNestToHive;
	private Tile nextHiveToNest;
	private HoneyBee bee;
	private SwarmOfHornets swarm;
	private boolean tileOnFire = false;

	public Tile() {

		this.food = 0;
		this.hive_built = false;
		this.nest_built = false;
		this.isOnPath = false;
		this.nextNestToHive = null;
		this.nextHiveToNest = null;
		this.bee = null;
		this.swarm = new SwarmOfHornets();
	}

	public Tile(int food,boolean hive_built,boolean nest_built,boolean isOnPath,
			Tile nextNestToHive, Tile nextHiveToNest, HoneyBee bee, SwarmOfHornets swarm){

		this.food = food;
		this.hive_built = hive_built;
		this.nest_built = nest_built;
		this.isOnPath = isOnPath;
		this.nextNestToHive = nextNestToHive;
		this.nextHiveToNest = nextHiveToNest;
		this.bee = bee;
		if(swarm == null) {
			this.swarm = new SwarmOfHornets();
		} else {
			this.swarm = swarm;}
	}

	public boolean isHive() {
		return hive_built;
	}

	public boolean isNest() {
		return nest_built;
	}

	public void buildHive() {
		this.hive_built = true;	
	}

	public void buildNest() {
		this.nest_built = true;	
	}

	public boolean isOnThePath() {
		return isOnPath;
	}

	public Tile towardTheHive() {
		if(isOnPath && !hive_built) {
			return nextNestToHive;
		}
		return null;
	}

	public Tile towardTheNest() {
		if(isOnPath && !nest_built) {
			return nextHiveToNest;
		}
		return null;
	}

	public void createPath(Tile nx_NestToHive, Tile nx_HiveToNest) {
		String errMsg = "Invalid input for making a path";

		if(( !this.hive_built && nx_NestToHive == null) ||
				(!this.nest_built && nx_HiveToNest == null)) {
			throw new IllegalArgumentException(errMsg);
		}

		if(nx_NestToHive == null && nx_HiveToNest == null) {
			throw new IllegalArgumentException(errMsg);
		}

		this.isOnPath = true;
		this.nextHiveToNest = nx_HiveToNest;
		this.nextNestToHive = nx_NestToHive;

	}
	public int collectFood() {

		int collecting_food = food;
		food = 0;
		return collecting_food;
	}

	public void storeFood(int food_received){
		food = food + food_received;
	}

	public int getNumOfHornets() {

		return swarm.sizeOfSwarm();
	}

	public HoneyBee	getBee() {
		return bee;
	}

	public Hornet getHornet(){
		return swarm.getFirstHornet();
	}

	public Hornet[] getHornets() {
		return swarm.getHornets();
	}

	/**
	 * @param newInsect
	 * @return
	 */
	public boolean addInsect(Insect newInsect) {

		if( newInsect instanceof HoneyBee && bee == null && !nest_built) {
			newInsect.setPosition(this);
			bee = (HoneyBee) newInsect;
			return true;
		}
		else if(newInsect instanceof Hornet && isOnPath) {
			newInsect.setPosition(this);
			swarm.addHornet((Hornet) newInsect);
			return true;
		}
		return false;
	}

	public boolean removeInsect(Insect insect) {

		if( insect instanceof HoneyBee && bee == (HoneyBee) insect) {
			insect.setPosition(null);
			bee = null;
			return true;
		}
		else if(insect instanceof Hornet) {
			insect.setPosition(null);
			return swarm.removeHornet((Hornet) insect);
		}
		return false;

	}

	public void setOnFire() {
		tileOnFire = true;
	}

	public boolean isOnFire() {
		return tileOnFire;
	}



}
