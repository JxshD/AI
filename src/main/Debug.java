package main;

import java.util.Arrays;

import layers.Layer;
import network.NeuralNetwork;
import neurons.Neuron;

public class Debug {
	public static void main(String[] args) {

		// NEURON COPYING IS FLAWLESS
		/*
		 * Neuron neuron1 = new Neuron(3);
		 * 
		 * System.out.println("Bias of neuron 1: " + neuron1.bias);
		 * System.out.println("Output Weights of neuron 1: " +
		 * Arrays.toString(neuron1.outputWeights));
		 * 
		 * System.out.println(" "); System.out.println("Neuron 1 Cloned.");
		 * System.out.println(" ");
		 * 
		 * Neuron neuron2 = neuron1.cloneSelf();
		 * 
		 * System.out.println("Bias of neuron 2: " + neuron2.bias);
		 * System.out.println("Output Weights of neuron 2: " +
		 * Arrays.toString(neuron2.outputWeights));
		 * 
		 * System.out.println(" "); System.out.
		 * println("Neuron 2 changes bias to 3 and Output Weights to {2, 4, 5}.");
		 * System.out.println(" ");
		 * 
		 * neuron2.bias = 3; neuron2.outputWeights[0] = 2; neuron2.outputWeights[1] = 4;
		 * neuron2.outputWeights[2] = 5;
		 * 
		 * System.out.println("Bias of neuron 1: " + neuron1.bias);
		 * System.out.println("Output Weights of neuron 1: " +
		 * Arrays.toString(neuron1.outputWeights));
		 * System.out.println("Bias of neuron 2: " + neuron2.bias);
		 * System.out.println("Output Weights of neuron 2: " +
		 * Arrays.toString(neuron2.outputWeights));
		 * 
		 * System.out.println(" "); System.out.
		 * println("Neuron 1 changes bias to 8 and Output Weights to {9, 15, 14}.");
		 * System.out.println(" ");
		 * 
		 * neuron1.bias = 8; neuron1.outputWeights[0] = 9; neuron1.outputWeights[1] =
		 * 15; neuron1.outputWeights[2] = 14;
		 * 
		 * System.out.println("Bias of neuron 1: " + neuron1.bias);
		 * System.out.println("Output Weights of neuron 1: " +
		 * Arrays.toString(neuron1.outputWeights));
		 * System.out.println("Bias of neuron 2: " + neuron2.bias);
		 * System.out.println("Output Weights of neuron 2: " +
		 * Arrays.toString(neuron2.outputWeights));
		 */

		// Bias is not affected. The weights in the neurons themselves, however, are.
		/*
		 * NeuralNetwork network1 = new NeuralNetwork(3, 4, 3);
		 * 
		 * System.out.println("Network 1 Data (Pre NN 2 Mutation): ");
		 * System.out.println("Layers: " + network1.layers.length);
		 * System.out.println(" ");
		 * 
		 * for (int i = 0; i < network1.layers.length; i++) {
		 * 
		 * // "Layer 1" System.out.println("Layer " + (i + 1));
		 * 
		 * // "Output Weights" System.out.println("Output Weights"); for (double[] array
		 * : network1.layers[i].outputWeights) {
		 * System.out.println(Arrays.toString(array)); }
		 * 
		 * // "Neuron: " System.out.println(" "); for (Neuron neuron :
		 * network1.layers[i].neurons) { System.out.println("Neuron: ");
		 * System.out.println("Bias: " + neuron.bias);
		 * System.out.println("Output Weights: " +
		 * Arrays.toString(neuron.outputWeights)); System.out.println(" ");
		 * 
		 * } }
		 * 
		 * System.out.println(" "); System.out.println(" ");
		 * System.out.println("Network 2 is copied from Network 1 and mutated.");
		 * System.out.println(" "); System.out.println(" ");
		 * 
		 * NeuralNetwork network2 = network1.cloneSelf();
		 * network2.layers[1].outputWeights[2][2] = 5;
		 * network2.layers[0].neurons[1].bias = 3;
		 * 
		 * System.out.println("Network 1 Data (Post NN 2 Mutation): ");
		 * System.out.println("Layers: " + network1.layers.length);
		 * System.out.println(" ");
		 * 
		 * for (int i = 0; i < network1.layers.length; i++) {
		 * 
		 * // "Layer 1" System.out.println("Layer " + (i + 1));
		 * 
		 * // "Output Weights" System.out.println("Output Weights"); for (double[] array
		 * : network1.layers[i].outputWeights) {
		 * System.out.println(Arrays.toString(array)); }
		 * 
		 * // "Neuron: " System.out.println(" "); for (Neuron neuron :
		 * network1.layers[i].neurons) { System.out.println("Neuron: ");
		 * System.out.println("Bias: " + neuron.bias);
		 * System.out.println("Output Weights: " +
		 * Arrays.toString(neuron.outputWeights)); System.out.println(" ");
		 * 
		 * } }
		 */

		// Copy is unaffected by changes in the original array. Neither is testArray.
		/*
		 * 
		 * double[] testArray = {1, 2, 3, 4, 5};
		 * 
		 * double[] testCopy = testArray.clone();
		 * 
		 * System.out.
		 * println("testArray and testCopy exist with testCopy as testArray.clone()");
		 * System.out.println("TestArray: " + Arrays.toString(testArray));
		 * System.out.println("TestCopy: " + Arrays.toString(testCopy));
		 * System.out.println("TestCopy is changed to {5, 2, 3, 4, 5}"); testCopy[0] =
		 * 5; System.out.println("TestArray: " + Arrays.toString(testArray));
		 * System.out.println("TestCopy: " + Arrays.toString(testCopy));
		 */

		// Testing Layer
		// LAYER WORKS FLAWLESSLY
		// ISSUE IN NEURAL NETWORK CODE
		/*
		 * Layer layer1 = new Layer(3, 4);
		 * 
		 * System.out.println("Layer1 Stats: "); System.out.println("Output Weights");
		 * for (double[] array : layer1.outputWeights) {
		 * System.out.println(Arrays.toString(array)); }
		 * 
		 * // "Neuron: " System.out.println(" "); for (Neuron neuron : layer1.neurons) {
		 * System.out.println("Neuron: "); System.out.println("Bias: " + neuron.bias);
		 * System.out.println("Output Weights: " +
		 * Arrays.toString(neuron.outputWeights)); System.out.println(" ");
		 * 
		 * }
		 * 
		 * System.out.println("Layer 1 copied into layer 2"); Layer layer2 =
		 * layer1.cloneSelf(); System.out.println("Layer2 Stats: ");
		 * System.out.println("Output Weights"); for (double[] array :
		 * layer2.outputWeights) { System.out.println(Arrays.toString(array)); }
		 * 
		 * // "Neuron: " System.out.println(" "); for (Neuron neuron : layer2.neurons) {
		 * System.out.println("Neuron: "); System.out.println("Bias: " + neuron.bias);
		 * System.out.println("Output Weights: " +
		 * Arrays.toString(neuron.outputWeights)); System.out.println(" ");
		 * 
		 * }
		 * 
		 * System.out.println("Layer1 mutated"); layer1.neurons[2].outputWeights[1] = 5;
		 * layer1.neurons[1].bias = 3;
		 * 
		 * System.out.println("Layer1 Stats: "); System.out.println("Output Weights");
		 * for (double[] array : layer1.outputWeights) {
		 * System.out.println(Arrays.toString(array)); }
		 * 
		 * // "Neuron: " System.out.println(" "); for (Neuron neuron : layer1.neurons) {
		 * System.out.println("Neuron: "); System.out.println("Bias: " + neuron.bias);
		 * System.out.println("Output Weights: " +
		 * Arrays.toString(neuron.outputWeights)); System.out.println(" ");
		 * 
		 * } System.out.println("Layer2 Stats: "); System.out.println("Output Weights");
		 * for (double[] array : layer2.outputWeights) {
		 * System.out.println(Arrays.toString(array)); }
		 * 
		 * // "Neuron: " System.out.println(" "); for (Neuron neuron : layer2.neurons) {
		 * System.out.println("Neuron: "); System.out.println("Bias: " + neuron.bias);
		 * System.out.println("Output Weights: " +
		 * Arrays.toString(neuron.outputWeights)); System.out.println(" ");
		 * 
		 * }
		 */

		// LAYER TESTING - I GOT IT YOOOO

		Layer layer1 = new Layer(3, 4);

		Layer layer2 = layer1.cloneSelf();

		System.out.println("Layer1 Stats. Layer 2 is cloned but not mutated.");
		System.out.println("Output Weights");
		for (double[] array : layer1.outputWeights) {
			System.out.println(Arrays.toString(array));
		}
		for (Neuron neuron : layer1.neurons) {
			System.out.println("Neuron");
			System.out.println("Bias: " + neuron.bias);
			System.out.println("Output Weights: " + Arrays.toString(neuron.outputWeights));
			System.out.println(" ");
		}

		System.out.println(" ");
		System.out.println("LAYER 2 MUTATED");
		System.out.println(" ");

		layer2.outputWeights[2][2] = 5;
		layer2.neurons[1].bias = 3;

		System.out.println("Layer1 Stats. Layer 2 is mutated.");
		System.out.println("Output Weights");
		for (double[] array : layer1.outputWeights) {
			System.out.println(Arrays.toString(array));
		}
		for (Neuron neuron : layer1.neurons) {
			System.out.println("Neuron");
			System.out.println("Bias: " + neuron.bias);
			System.out.println("Output Weights: " + Arrays.toString(neuron.outputWeights));
			System.out.println(" ");
		}

		// SPACER
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");

		// NEURAL NETWORK TESTING
		NeuralNetwork network1 = new NeuralNetwork(3, 4, 3);

		System.out.println("Network 1 Data (Pre NN 2 Mutation): ");
		System.out.println("Layers: " + network1.layers.length);
		System.out.println(" ");

		for (int i = 0; i < network1.layers.length; i++) {

			System.out.println("Layer " + (i + 1));
			System.out.println("Output Weights");
			for (double[] array : network1.layers[i].outputWeights) {
				System.out.println(Arrays.toString(array));
			}

			for (Neuron neuron : network1.layers[i].neurons) {
				System.out.println("Neuron: ");
				System.out.println("Bias: " + neuron.bias);
				System.out.println("Output Weights: " + Arrays.toString(neuron.outputWeights));
				System.out.println(" ");
			}

		}

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Network 2 is copied from Network 1 and mutated.");
		System.out.println(" ");
		System.out.println(" ");

		NeuralNetwork network2 = network1.cloneSelf();
		network2.layers[1].outputWeights[2][2] = 5;
		network2.layers[0].neurons[1].bias = 3;

		System.out.println("Network 1 Data (Post NN 2 Mutation): ");
		System.out.println("Layers: " + network1.layers.length);
		System.out.println(" ");

		for (int i = 0; i < network1.layers.length; i++) {

			System.out.println("Layer " + (i + 1));
			System.out.println("Output Weights");
			for (double[] array : network1.layers[i].outputWeights) {
				System.out.println(Arrays.toString(array));
			}

			for (Neuron neuron : network1.layers[i].neurons) {
				System.out.println("Neuron: ");
				System.out.println("Bias: " + neuron.bias);
				System.out.println("Output Weights: " + Arrays.toString(neuron.outputWeights));
				System.out.println(" ");
			}

		}
	}
}
