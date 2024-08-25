package medium;

import java.util.*;

// accepted: 45.09% time and 23.21% memory

public class q592 {
    // idea: find the LCM of denominators and add/subtract the numerators
    // to simplify the fraction, find the GCD of the numerator and denominator

    public String fractionAddition(String expression) {
        // split fractions by "+" and "-" while including the delimiters
        String[] fractions = expression.split("(?=[+-])");

        // convert first fraction's sign
        if (!fractions[0].startsWith("-"))
            fractions[0] = "+" + fractions[0];

        int[] numerators = new int[fractions.length];
        int[] denominators = new int[fractions.length];
        boolean[] positive = new boolean[fractions.length];

        for (int i = 0; i < fractions.length; i++) {
            String[] split = fractions[i].split("/");
            positive[i] = fractions[i].startsWith("+");
            numerators[i] = Integer.parseInt(split[0].substring(1));
            denominators[i] = Integer.parseInt(split[1]);
        }

        int numerator = positive[0] ? numerators[0] : -numerators[0];
        int denominator = denominators[0];

        for (int i = 1; i < fractions.length; i++) {
            int LCM = LCM(denominator, denominators[i]);

            numerator *= (LCM / denominator);
            numerators[i] *= (LCM / denominators[i]);

            denominator = LCM;
            denominators[i] = LCM;

            // System.out.println("test: "+numerator + "/" + denominator);

            if (positive[i])
                numerator += numerators[i];
            else
                numerator -= numerators[i];
        }

        int GCD = GCD(Math.abs(numerator), denominator);
        return (numerator / GCD) + "/" + (denominator / GCD);
    }

    public int GCD(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }

        return a;
    }

    public int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }

    public static void main(String[] args) {
        q592 instance = new q592();
        System.out.println(instance.fractionAddition("-1/2+1/2"));
        System.out.println(instance.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(instance.fractionAddition("1/3-1/2"));
    }
}
