package neurons;

public class Neuron {
	
	// This neuron's bias.
	public double bias;
	
	// This neuron's output weights.
	public double[] outputWeights;
	
	// Saves for cloning
	public int cloneNextNeurons;
	
	// Initialization in declaration.
	public Neuron(int nextNeurons) {
		
		// For cloning
		this.cloneNextNeurons = nextNeurons;

		// Creates output weights and defaults them to 1.
		this.outputWeights = new double[nextNeurons];
		for (int i = 0; i < nextNeurons; i++) {
			this.outputWeights[i] = 1;
		}

		// Defaults bias to 0.
		this.bias = 0;

	}
	
	// Runs as a hidden or output neuron.
	public double run(double[] inputValues, double[] inputWeights) {

		// Returns the calculated output.
		return ReLU(dotProduct(inputValues, inputWeights)) + this.bias;
	}
	
	// Runs as an input neuron
	public double run(double inputValue) {

		// Returns the input as the output.
		return inputValue;
	}

	private double dotProduct(double[] inputs, double[] weights) {

		// Creates variable to store the output.
		double output = 0;

		// Runs a dot product and stores the values to output.
		for (int i = 0; i < inputs.length; i++) {
			output += inputs[i] * weights[i];
		}

		// Returns output.
		return output;
	}

	// Creates a method to do the ReLU activation function.
	private double ReLU(double input) {

		// Runs ReLu function and returns it.
		return Math.max(input, 0);
	}
	
	public Neuron cloneSelf() {
		
		// Clones neuron
		Neuron clonedNeuron = new Neuron(this.cloneNextNeurons);
		
		// Clones values.
		clonedNeuron.bias = this.bias;
		clonedNeuron.outputWeights = this.outputWeights.clone();
		
		// Returns cloned neuron.
		return clonedNeuron;
		
	}
}
