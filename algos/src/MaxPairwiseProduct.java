import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static Long getMaxPairwiseProduct(Long[] numbers) {
        Long max_product = 0L;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                        numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }
    static Long getMaxPairwiseProduct2(Long[] numbers) {
        Long max_product = 0L;
        int n = numbers.length;
        int max_index1 = -1;
        int max_index2 = -1;
        for (int first = 0; first < n; ++first) {
            if((max_index1==-1) ||(numbers[first] > numbers[max_index1])) {
                max_index1 = first;
            }
        }
        for (int second = 0; second < n; ++second) {
            if((second!=max_index1) && (max_index2==-1 ||((numbers[second] > numbers[max_index2] )))) {
                max_index2 = second;
            }
        }
        max_product= numbers[max_index1] * numbers[max_index2];
        return max_product;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        Long[] numbers = new Long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }

        System.out.println(getMaxPairwiseProduct2(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        Long nextLong() {
            return Long.parseLong(next());
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
