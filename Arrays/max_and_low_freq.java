import java.util.Arrays;

public class max_and_low_freq{
    public static int[] getFrequencies(int[] v) {
        // Find the minimum and maximum values in the array
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int num : v) {
            if (num < minVal) minVal = num;
            if (num > maxVal) maxVal = num;
        }

        // Create a frequency array for the range
        int range = maxVal - minVal + 1;
        int[] freq = new int[range];

        // Count the frequencies
        for (int num : v) {
            freq[num - minVal]++;
        }

        // Return the frequency array (mapped back to input array order)
        int[] result = new int[v.length];
        for (int i = 0; i < v.length; i++) {
            result[i] = freq[v[i] - minVal];
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        int[] data = {3, 1, 4, 4, 5, 2, 6, 2, 4, 1, 3, 6, 6, 6, 7};
        int[] frequencies = getFrequencies(data);

        System.out.println("Input Array: " + Arrays.toString(data));
        System.out.println("Frequencies: " + Arrays.toString(frequencies));
    }
}
