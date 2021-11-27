package network;

import layers.Layer;

public class NeuralNetwork {

	// The network's layers.
	public Layer[] layers;

	// For cloning
	public int[] cloneLayers;

	// For training
	public double loss;

	public NeuralNetwork(int... layers) {

		// For cloning
		this.cloneLayers = layers;

		// Initializes this.layers
		this.layers = new Layer[layers.length];

		// Creates corresponding layers.
		for (int i = 0; i < layers.length - 1; i++) {
			this.layers[i] = new Layer(layers[i], layers[i + 1]);
		}

		this.layers[layers.length - 1] = new Layer(layers[layers.length - 1], 0);
	}

	public double[] run(double[] inputValues) {

		// Stores output in a variable
		double[] output = new double[this.layers[this.layers.length - 1].neurons.length];

		// First layer runs input values and stores as the previous values.
		double[] previousValues = this.layers[0].run(inputValues);

		// Runs the rest of the layers.
		for (int i = 1; i < this.layers.length; i++) {

			// Runs the program with the previous values.
			output = this.layers[i].run(previousValues, this.layers[i - 1].outputWeights);

			previousValues = output;
		}

		return output;
	}

	public NeuralNetwork cloneSelf() {

		// Creates cloned network
		NeuralNetwork clonedNet = new NeuralNetwork(this.cloneLayers);

		// Clones loss.
		clonedNet.loss = this.loss;

		// Clones each layer.
		for (int i = 0; i < clonedNet.layers.length; i++) {
			clonedNet.layers[i] = this.layers[i].cloneSelf();
		}

		// Returns finished cloned network.
		return clonedNet;
	}
}
