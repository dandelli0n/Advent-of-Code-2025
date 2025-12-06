package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math.*;

import static java.lang.Math.pow;

public class JoltageCalculator
{
    private static long sum = 0;

    public static int chartoi(char c)
    {
        int n;
        n = c - '0';
        return n;
    }

    //selects the two largest batteries (the largest 2 digit number without changing the numbers' order)
    public static void twoBatteries(String s)
    {
        int max1 = 0;
        int startindex = 0;
        for (int i = 0; i < s.length() - 1; i++)
        {
            int curr = chartoi(s.charAt(i));
            if (max1 < curr)
            {
                max1 = curr;
                startindex = i;
            }
        }

        int max2 = 0;
        for (int i = startindex + 1; i < s.length(); i++)
        {
            int curr = chartoi(s.charAt(i));
            if (max2 < curr)
            {
                max2 = curr;
            }
        }

        sum += (max1* 10L) + max2;
    }

    //finds the 12 largest batteries (the largest 12 digit number without changing the numbers' orders)
    public static void twelveBatteries(String s)
    {
        int max = 0;
        int i = 0;
        int maxindex = 0;
        int exp = 11;
        int lim = s.length() - exp;
        while(exp >= 0)
        {
            for(i = maxindex; i < lim; i++)
            {
                int curr = chartoi(s.charAt(i));
                if(curr > max)
                {
                    max = curr;
                    maxindex = i;
                }
            }

            maxindex++;

            sum = (long) (sum + (max*pow(10, exp)));

            exp--;
            lim++;
            max = 0;
        }
    }

    public static long getJoltage(String s, int mode) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(s));
        String line;

        while((line = br.readLine()) != null)
        {
            if(mode == 1)
                JoltageCalculator.twoBatteries(line);
            else if(mode == 2)
                twelveBatteries(line);
        }

        return sum;
    }

    public static long getSum()
    {
        return sum;
    }
}
