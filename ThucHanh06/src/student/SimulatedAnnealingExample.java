package student;

	import java.util.Random;

	public class SimulatedAnnealingExample {

	    // Hàm mục tiêu của bài toán
	    public static double objectiveFunction(double x) {
	        return Math.pow(x, 2) - 4 * x + 4;
	    }

	    // Thuật toán gia mô nung
	    public static double simulatedAnnealing(double startingTemperature, double coolingRate, int iterations) {
	        Random random = new Random();
	        double currentSolution = random.nextDouble() * 20 - 10; // Giải pháp khởi tạo ngẫu nhiên trong khoảng [-10, 10]
	        double bestSolution = currentSolution;
	        double temperature = startingTemperature;

	        for (int i = 0; i < iterations; i++) {
	            // Tạo một giải pháp lân cận
	            double neighborSolution = currentSolution + (random.nextDouble() * 2 - 1); // Bước ngẫu nhiên trong khoảng [-1, 1]

	            // Tính giá trị hàm mục tiêu
	            double currentValue = objectiveFunction(currentSolution);
	            double neighborValue = objectiveFunction(neighborSolution);
	            double bestValue = objectiveFunction(bestSolution);

	            // Chấp nhận hoặc từ chối giải pháp lân cận
	            if (neighborValue < currentValue || Math.exp((currentValue - neighborValue) / temperature) > random.nextDouble()) {
	                currentSolution = neighborSolution;
	            }

	            // Cập nhật giải pháp tốt nhất
	            if (neighborValue < bestValue) {
	                bestSolution = neighborSolution;
	            }

	            // Làm mát nhiệt độ
	            temperature *= coolingRate;
	        }

	        return bestSolution;
	    }

	    public static void main(String[] args) {
	        // Tham số
	        double startingTemperature = 1000;
	        double coolingRate = 0.95;
	        int iterations = 1000;

	        // Chạy thuật toán gia mô nung
	        double bestSolution = simulatedAnnealing(startingTemperature, coolingRate, iterations);

	        // In kết quả
	        System.out.println("Giải pháp tốt nhất: " + bestSolution);
	        System.out.println("Giá trị hàm mục tiêu: " + objectiveFunction(bestSolution));
	    }
	}

