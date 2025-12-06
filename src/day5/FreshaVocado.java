package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class FreshaVocado
{
    static private List<String[]> ranges = new ArrayList<>();
    static private long freshCount = 0;

    static public void addRange(String s)
    {
        String[] temp = s.split("-");
        ranges.add(temp);
    }

    static public void isFresh(String str)
    {
        long id = Long.parseLong(str);
        for(String[] s : ranges)
        {
            long lowerBound = Long.parseLong(s[0]);
            long upperBound = Long.parseLong(s[1]);
            if(id >= lowerBound && id <= upperBound)
            {
                freshCount++;
                return;
            }
        }
    }

    static public long getFreshProductNumber(String filename) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        int mode = 1;
        //List<String[]> ranges = new ArrayList<>();

        while((line = br.readLine()) != null)
        {
            if(line.isBlank())
            {
                mode = 2;
                pruneRanges();
            }

            if(mode == 1)
            {
                addRange(line);
            }
            else if(!line.isBlank())
            {
                FreshaVocado.isFresh(line);
            }
        }
        return freshCount;
    }


    public static boolean union(String[] a, String[] b)
    {
        String[] overlapped;
        long aLow = Long.parseLong(a[0]);
        long aUpp = Long.parseLong(a[1]);
        long bLow = Long.parseLong(b[0]);
        long bUpp = Long.parseLong(b[1]);


        if(bLow <= aLow && aUpp <= bUpp) //b contains a
        {
            ranges.remove(a);
            return true;
        }
        else if(aLow <= bLow && bUpp <= aUpp) //a contains b
        {
            ranges.remove(b);
            return true;
        }
        else if(aLow <= bUpp && aLow >= bLow) //overlapping, b is overall lower than a
        {
            overlapped = new String[]{b[0], a[1]};
            ranges.add(overlapped);
            ranges.remove(a);
            ranges.remove(b);
            return true;
        }
        else if(aUpp >= bLow && aUpp <= bUpp) //overlapping, a is overall lower than b
        {
            overlapped = new String[]{a[0], b[1]};
            ranges.add(overlapped);
            ranges.remove(a);
            ranges.remove(b);
            return true;
        }

        return false;
    }

    public static void pruneRanges()
    {
        //List<String[]> temp = new ArrayList<>(ranges);
        //String[] s = new String[2];

        boolean didSomething = true;
        while(didSomething)
        {
            didSomething = false;
            for (int i = 0; i < ranges.size(); i++)
            {
                for (int j = i+1; j < ranges.size(); j++)
                {
                    if(union(ranges.get(i), ranges.get(j)))
                    {
                        didSomething = true;
                        break;
                    }
                }
                if(didSomething)
                    break;
            }
            //delta = delta - ranges.size();
        }

        for(String[] t : ranges)
        {
            System.out.println(t[0] + "-" + t[1]);
        }
    }

    static public long freshIDs(String filename)throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        List<Long> idlist = new ArrayList<>();
        while(!line.isBlank())
        {
            addRange(line);
            line = br.readLine();
        }

        pruneRanges();

        for(String[] s : ranges)
        {
            long lower = Long.parseLong(s[0]);
            long upper = Long.parseLong(s[1]);

            freshCount += upper - lower + 1;

        }

        return freshCount;
    }


    static public long getFreshCount()
    {
        return freshCount;
    }

}
