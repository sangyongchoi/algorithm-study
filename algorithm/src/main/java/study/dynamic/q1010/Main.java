package study.dynamic.q1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int size = Integer.parseInt(br.readLine());

        for (int k = 0; k < size; k++) {
            final String s = br.readLine();
            final String[] split = s.split(" ");
            final BigInteger a = new BigInteger(split[0]);
            final BigInteger b = new BigInteger(split[1]);

            BigInteger result = factorial(b).divide(factorial(a).multiply(factorial(b.subtract(a))));
            System.out.println(result);
        }
    }

    public static BigInteger factorial(BigInteger a){
        if (a.intValue() == 1 || a.intValue() == 0) {
            return new BigInteger("1");
        }

        return a.multiply(factorial(a.subtract(new BigInteger("1"))));
    }
}
