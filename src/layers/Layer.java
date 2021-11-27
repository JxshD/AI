package layers;

import neurons.Neuron;

public class Layer {

	public Neuron[] neurons;

	// The output weights (e.g. [neuron1[1, 4], neuron2[3, 3], neuron3[5, 9]])
	public double[][] outputWeights;

	// For cloning
	public int cloneNeurons;
	public int cloneNextNeurons;

	// Initialization in declaration.
	public Layer(int neurons, int nextNeurons) {

		// For cloning
		this.cloneNeurons = neurons;
		this.cloneNextNeurons = nextNeurons;

		// Creates neurons.
		this.neurons = new Neuron[neurons];
		for (int i = 0; i < neurons; i++) {
			this.neurons[i] = new Neuron(nextNeurons);
		}

		// Creates double[][] output weights from the neurons
		this.outputWeights = new double[neurons][nextNeurons];
		for (int i = 0; i < neurons; i++) {
			this.outputWeights[i] = this.neurons[i].outputWeights;
		}

	}

	// Runs as hidden or output layer.
	public double[] run(double[] inputValues, double[][] inputWeights) {

		// Creates variable to store outputs.
		double[] outputs = new double[this.neurons.length];

		for (int i = 0; i < this.neurons.length; i++) {
			outputs[i] = this.neurons[i].run(inputValues, reverseArray(inputWeights)[i]);
		}

		return outputs;
	}

	// Runs as input layer.
	public double[] run(double[] inputValues) {

		// Returns input values as output values.
		return inputValues;
	}

	// Reverses an array for neurons.
	public double[][] reverseArray(double[][] array) {

		// Creates variable to store output.
		double[][] reversedArray = new double[array[0].length][array.length];

		// Reverses the array.
		for (int i = 0; i < array[0].length; i++) {
			for (int n = 0; n < array.length; n++) {
				reversedArray[i][n] = array[n][i];
			}
		}

		// Returns reversed array.
		return reversedArray;
	}

	public Layer cloneSelf() {

		// Creates cloned layer.
		Layer clonedLayer = new Layer(this.cloneNeurons, this.cloneNextNeurons);

		// Clones values
		for(int i = 0; i < clonedLayer.outputWeights.length; i ++) {
			clonedLayer.outputWeights[i] = this.outputWeights[i].clone();
		}

		// Clones neurons
		for (int i = 0; i < clonedLayer.neurons.length; i++) {
			clonedLayer.neurons[i] = this.neurons[i].cloneSelf();
		}

		// Returns cloned layer.
		return clonedLayer;
	}
}
