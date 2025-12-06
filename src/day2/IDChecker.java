package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IDChecker
{
    private static long sum = 0;

    public static String[] rangeParser(String s)
    {
        String[] pattern = new String[2];
        pattern[0] = s.substring(0, s.length()/2);
        pattern[1] = s.substring(s.length()/2);

        return pattern;
    }

    //checks if the number sequence is made of two repeating number sequences, if yes, adds it to the sum
    public static void patternChecker(long n)
    {
        String input = Long.toString(n);
        if(input.length() % 2 != 0)
            return;

        String[] pattern = rangeParser(input);

        if(pattern[0].equals(pattern[1]))
            sum += n;
    }

    public static void repeatChecker(long n)
    {
        sum -= 1;
    }

    public static long getPatternSum(String str, int mode) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(str));
        String readLine = br.readLine();
        String[] ids = readLine.split(",");
        for(String s : ids)
        {
            String[] range = s.split("-");
            long from = Long.parseLong(range[0]);
            long to = Long.parseLong(range[1]);

            for(long i = from; i <= to; i++)
            {
                if(mode == 1)
                    patternChecker(i);
                else if(mode == 2)
                {
                    repeatChecker(i);
                }
            }
        }

        return sum;
    }
}
