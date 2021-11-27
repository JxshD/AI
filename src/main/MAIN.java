package main;

import java.util.Arrays;

import ai.AI;
import layers.Layer;
import neurons.Neuron;

public class MAIN {
	public static void main(String[] args) {

		AI bot = new AI(3, 4, 3);

		bot.makeDataSet(new double[] { 1, 0, 0 }, new double[] { 0, 1, 0 });
		bot.makeDataSet(new double[] { 0, 1, 0 }, new double[] { 0, 0, 1 });
		bot.makeDataSet(new double[] { 0, 0, 1 }, new double[] { 1, 0, 0 });

		bot.train(100, 100, 0.25, 0.1);


		for (Layer layer : bot.bestNetwork.layers) {
			System.out.println("Layer");
			System.out.println("Output Weights");

			for (double[] array : layer.outputWeights) {
				System.out.println(Arrays.toString(array));
			}

			for (Neuron neuron : layer.neurons) {
				System.out.println(" ");
				System.out.println("Neuron");
				System.out.println("Bias " + neuron.bias);
			}
			System.out.println(" ");
		}
	}
}
