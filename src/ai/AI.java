package ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import network.NeuralNetwork;
import layers.Layer;
import neurons.Neuron;

public class AI {

	// Mode the AI uses. 1 = ReLU, 2 = Step, 3 = Greatest Value
	public int mode = 3;

	// Networks and their stats for training.
	public NeuralNetwork[] networks;
	public NeuralNetwork bestNetwork;

	// Data sets for training.
	public List<double[][]> DataSets = new ArrayList<>(0);

	public int[] layers;

	public AI(int... layers) {

		// Sets this.layers to layers.
		this.layers = layers;

		// Creates the best network and sets it to the base values.
		this.bestNetwork = new NeuralNetwork(layers);

		// Prints Data.
		System.out.println("AI created successfully.");
		System.out.println("Layers per network: " + Arrays.toString(layers));
		System.out.println("Default weight value: " + this.bestNetwork.layers[0].outputWeights[0][0]);
		System.out.println("Default bias value: " + this.bestNetwork.layers[0].neurons[0].bias);
	}

	// Trains neural network with built in data set.
	public void train(int population, int generations, double mutationProbability, double maxMutation) {

		// Creates the population of neural networks
		this.networks = new NeuralNetwork[population];

		for (int i = 0; i < population; i++) {
			this.networks[i] = this.bestNetwork.cloneSelf();
		}

		// Runs the training algorithm however many times.
		for (int i = 0; i < generations; i++) {
			System.out.println("Generation " + (i + 1));

			// Mutates all networks except for the best one.
			for (NeuralNetwork network : this.networks) {
				mutate(network, mutationProbability, maxMutation);
			}

			// Runs the best network.
			double bestTotalLoss = 0;

			// For each data set
			for (int n = 0; n < this.DataSets.size(); n++) {

				// outputs = best network runs the inputs
				double[] outputs = this.bestNetwork.run(this.DataSets.get(n)[0]);

				// loss = array difference of the outputs and expected outputs
				double loss = arrayDifference(this.DataSets.get(n)[1], outputs);

				// Adds this to the external variable for loss
				bestTotalLoss += loss;

			}

			this.bestNetwork.loss = bestTotalLoss / this.DataSets.size();

			System.out.println("Best Layer: " + this.bestNetwork.loss);

			// Runs the networks
			for (NeuralNetwork network : this.networks) {

				double totalLoss = 0;

				// Runs each data set for a network
				for (int n = 0; n < this.DataSets.size(); n++) {

					// Stores output of the input data set ran.
					double[] outputs = network.run(this.DataSets.get(n)[0]);

					// Stores average output difference as neural network loss.
					double loss = arrayDifference(this.DataSets.get(n)[1], outputs);

					// Adds this to the external variable for loss
					totalLoss += loss;

				}

				network.loss = totalLoss / this.DataSets.size();
			}

			// DEBUG
			System.out.println(" ");
			System.out.println("For all layers except best layer: ");
			for (NeuralNetwork network : this.networks) {
				System.out.println(network.loss);
			}

			// Finds best network and stores that as the new best network.
			NeuralNetwork tempBest = this.networks[0];

			for (int j = 1; j < this.networks.length; j++) {

				if (this.networks[j].loss < tempBest.loss) {
					tempBest = this.networks[j].cloneSelf();
				}
			}

			if (tempBest.loss < this.bestNetwork.loss) {
				this.bestNetwork = tempBest.cloneSelf();
			}
			
			System.out.println("New Best Layer Loss: " + this.bestNetwork.loss);
			
			// Resets population
			for (int x = 0; x < population; x++) {
				this.networks[x] = this.bestNetwork.cloneSelf();
			}
		}
	}

	public double[] run(double[] inputValues) {

		// Returns the ran best neural network.
		return alterArray(this.mode, this.bestNetwork.run(inputValues));
	}

	public void mutate(NeuralNetwork network, double mutationProbability, double maxMutation) {

		// Creates random to use for mutation.
		Random random = new Random();

		// Goes through the entire neural network and mutates it's weights and biases..
		for (Layer layer : network.layers) {

			// For each bias
			for (Neuron neuron : layer.neurons) {

				// If it mutates based off the odds
				if (random.nextDouble() < mutationProbability) {

					// Mutates bias.
					neuron.bias += random.nextDouble() * (2 * maxMutation) - maxMutation;
				}
			}

			// For each weight
			for (int i = 0; i < layer.outputWeights.length; i++) {

				for (int n = 0; n < layer.outputWeights[i].length; n++) {

					// If it mutates based off the odds
					if (random.nextDouble() < mutationProbability) {

						// Mutate it
						layer.outputWeights[i][n] += random.nextDouble() * (2 * maxMutation) - maxMutation;
					}
				}
			}
		}
	}

	public double[] alterArray(int mode, double[] array) {

		// Stores output in a variable.
		double[] output = new double[array.length];

		// Debug mode 0
		if (mode == 0) {

		}

		// Mode 1: ReLU
		else if (mode == 1) {

			// Runs a secondary ReLU on the output to ensure negatives arent permitted.
			for (int i = 0; i < array.length; i++) {
				output[i] = ReLU(array[i]);
			}
		}

		// Mode 2: Step
		else if (mode == 2) {

			// Runs a step function on the output to change it to 0s and 1s.
			for (int i = 0; i < array.length; i++) {
				output[i] = ReLU(array[i]);
			}
		}

		// Mode 3: Greatest value
		else if (mode == 3) {

			// Finds the greatest place value.
			int gpv = GPV(array);

			// Sets all values of output to 0.
			for (int i = 0; i < output.length; i++) {
				output[i] = 0;
			}

			// Sets output of the greatest place value to 1.
			output[gpv] = 1;
		}

		// Returns output.
		return output;
	}

	// Creates a method to do the ReLU activation function.
	private double ReLU(double input) {

		// Runs ReLu function and returns it.
		return Math.max(input, 0);
	}

	public double Step(double value) {
		if (value <= 0) {
			return 0;
		} else {
			return 1;
		}
	}

	public int GPV(double[] values) {

		// Calculates max value.
		double max = values[0];
		int placeValue = 0;

		for (int i = 0; i < values.length; i++) {
			if (values[i] > max) {
				max = values[i];
				placeValue = i;
			}
		}

		// Returns the Greatest Place Value
		return placeValue;
	}

	public void makeDataSet(double[] inputValues, double[] outputValues) {

		// Adds a data set to the list of data sets in this class.
		this.DataSets.add(DataSets.size(), new double[][] { inputValues, outputValues });

	}

	public double arrayDifference(double[] array1, double[] array2) {

		// Creates output to store the averages
		double output = 0;

		// Goes through each array value and adds the difference to output
		for (int i = 0; i < array1.length; i++) {
			output += Math.abs(array1[i] - array2[i]);
		}

		// Divides output.
		output /= array1.length;

		// Returns output.
		return output;
	}

	public void runBest() {
		// Runs the best network.
		double bestTotalLoss = 0;

		// For each data set
		for (int n = 0; n < this.DataSets.size(); n++) {

			// outputs = best network runs the inputs
			double[] outputs = this.bestNetwork.run(this.DataSets.get(n)[0]);

			// loss = array difference of the outputs and expected outputs
			double loss = arrayDifference(this.DataSets.get(n)[1], outputs);

			// Adds this to the external variable for loss
			bestTotalLoss += loss;

		}

		this.bestNetwork.loss = bestTotalLoss / this.DataSets.size();
	}
}
