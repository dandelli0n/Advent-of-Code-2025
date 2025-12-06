package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dial
{
    protected static int dialState = 50;
    protected static int pwd = 0;

    //counts how many times the dial head landed on 0
    public static void turnDial(String[] turn)
    {
        if(turn[0].equals("L"))
        {
            dialState = dialState - Integer.parseInt(turn[1]);
            if(dialState < 0)
            {
                dialState = dialState % 100;

                if(dialState != 0)
                    dialState += 100;

            }
        }
        else if(turn[0].equals("R"))
        {
            dialState = dialState + Integer.parseInt(turn[1]);

            if(dialState > 99)
            {
                dialState = dialState % 100;
            }
        }
        else
        {
            System.out.println("bad input for the dial's left/right indicator");
        }
       
        if(dialState == 0)
            pwd++;
    }

    //counts how many times the dial head passed 0 while turning
    public static void clickDial(String[] turn)
    {
        int turnNum = Integer.parseInt(turn[1]);

        for(int i = 0; i < turnNum; i++)
        {
            if(turn[0].equals("L"))
            {
                dialState--;
            }
            else
                dialState++;

            if(dialState == -1)
                dialState = 99;
            if(dialState == 100)
                dialState = 0;

            if(dialState == 0)
                pwd++;
        }
    }

    //solves the puzzle in the set mode
    public static int getZeros(String s, int mode) throws IOException
    {
        resetDial();
        BufferedReader br = new BufferedReader(new FileReader(s));
        String line;
        String[] cmd = new String[2];

        while ((line = br.readLine()) != null)
        {
            cmd[0] = line.substring(0, 1);
            cmd[1] = line.substring(1);
            if(mode == 1)
                turnDial(cmd);
            else if(mode == 2)
                clickDial(cmd);
        }
        return pwd;
    }

    public static void resetDial()
    {
        dialState = 50;
    }
    public int getPassword()
    {
         return pwd;
    }

    public int getDialState()
    {
        return dialState;
    }

}
