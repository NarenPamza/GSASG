import java.util.Arrays;

// GS Question Working one PErfect
public class CopyOfTruckOwner {

	public static void main(String[] args) {

		int mat[][] = {
				{ 38, 130, 500 }, 
				{ 21, 280, 1800 }, 
				{ 13, 120, 1500 },
				//{ 7, 110, 2000 },

		};

		int[] findTruckCargo = findTruckCargo(300, mat);
		System.out.println(Arrays.toString(findTruckCargo));

	}

	/*
	 * Complete the findTruckCargo function below.
	 */
	private static int[] findTruckCargo(int maxCargoWeight, int[][] cargoList) {

		if (cargoList == null) {
			return new int[0];
		}

		if (maxCargoWeight <= 0) {
			return new int[0];
		}

		int[] weight = new int[cargoList.length];
		int[] amount = new int[cargoList.length];

		for (int i = 0; i < cargoList.length; i++) {
			for (int j = 0; j < cargoList[i].length; j++) {

				if (j == 1) {
					weight[i] = cargoList[i][j];
				}

				if (j == 2) {
					amount[i] = cargoList[i][j];
				}

			}
		}

		int[] weightIndex = findWeightCombination(weight, maxCargoWeight,
				amount);
		
		weightIndex[0] = cargoList[weightIndex[0]][0];
		weightIndex[1] = cargoList[weightIndex[1]][0];
		

		return weightIndex;

	}

	private static int[] findMaxProfit(int[] amount) {
		int[] amountIndex = new int[2];

		int maxAmount = 0;
		int prevProfit = 0;

		for (int j = 0; j < amount.length; j++) {
			for (int j2 = j + 1; j2 < amount.length; j2++) {
				prevProfit = maxAmount;

				if (amount[j] != -1 && amount[j2] != -1) {

					maxAmount = amount[j] + amount[j2];
					if (maxAmount > prevProfit) {
						amountIndex[0] = j;
						amountIndex[1] = j2;
					}
				}
			}
		}
		return amountIndex;
	}

	private static int[] findWeightCombination(int[] weight,
			int maxCargoWeight, int[] amount) {

		int[] result = new int[3];

		int weightPrev = 0;

		while (weightPrev <= maxCargoWeight) {

			int[] findMaxProfit = findMaxProfit(amount);

			for (int j : findMaxProfit) {

				if (j != -1) {
					weightPrev += weight[j];
				}

			}

			if (weightPrev > maxCargoWeight) {
				
				weightPrev = 0;

				if (weight[findMaxProfit[0]] > weight[findMaxProfit[1]]) {
					amount[findMaxProfit[0]] = -1;
				} else {
					amount[findMaxProfit[1]] = -1;
				}

			} else {

				result[0] = findMaxProfit[0];
				result[1] = findMaxProfit[1];
				result[2] = amount[findMaxProfit[0]] + amount[findMaxProfit[1]];
				break;
			}
		}

		return result;
	}
}
