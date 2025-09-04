package assignment1;

public class SwarmOfHornets {

	private Hornet[] hornets; 
	private int size;
	public static double QUEEN_BOOST;

	public SwarmOfHornets() {

		this.hornets = new Hornet[0];
		this.size = 0;

	}

	public int sizeOfSwarm() {

		return size;
	}

	public Hornet[] getHornets() {
		int counter = 0;
		int new_size = 0;
		int i = 0;
		int j = 0;
		while(i<size)
		{
			if(hornets[i] != null) new_size++;
			i++;
		}
		Hornet[] all_hornets = new Hornet[new_size];
		while(counter < size) {
			if(hornets[counter] != null) {
				all_hornets[j] = hornets[counter];
				j++;
			}
			counter++;

		}


		return all_hornets;
	}



	public Hornet getFirstHornet() {

		if(size > 0) {

			return hornets[0];
		}

		else {
			return null;
		}
	}


	public void addHornet(Hornet new_hornet) {

		int capacity = hornets.length;


		if(size >= capacity) {

			Hornet[] new_hornets = new Hornet[capacity + 1];
			int counter = 0;

			while (counter < size) {
				new_hornets[counter] = hornets[counter];
				counter = counter + 1;
			}
			hornets = new_hornets;
		}

		hornets[size] = new_hornet;
		size = size + 1;


		if (new_hornet.isTheQueen()) {

			int j = 0;

			while(j < size - 1) {
				hornets[j].regenerateHealth(QUEEN_BOOST);
				j++;
			}
		}
	}


	public boolean removeHornet(Hornet hornet_to_remove) {

		int counter = 0;
		int position = -1;
		int j = 0;
		boolean removes = false;

		while(counter < size) {
			if (hornets[counter] == hornet_to_remove) {
				position = counter;
				removes = true;
				break;
			}
			counter++;
		}

		if(position >= 0) {
			Hornet[] new_hornets = new Hornet[size-1];
			for (int i = 0; i < size; i++) {
				if(i != position) {
					new_hornets[j] = hornets[i];
					j++;
				}
			}
			hornets = new_hornets;
			size = size - 1;
		}

		return removes;

	} 	

}









