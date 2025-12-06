package day4;

import java.util.List;

public class RollCounter
{
    private static long rollsCount;

    public static long accessibleCounter(List<String> wall)
    {
        for(int row = 0; row < wall.size(); row++)
        {
            String temp = wall.get(row);
            int adjacentRolls = 0;
            for (int col = 0; col < temp.length(); col++)
            {
                if(temp.charAt(col) == '@')
                {

                    if((row > 0 && col > 0) && (wall.get(row-1).charAt(col-1) == '@'))
                        adjacentRolls++;
                    if((row > 0) && wall.get(row-1).charAt(col) == '@')
                        adjacentRolls++;
                    if((row > 0 && col < temp.length()-1) && wall.get(row-1).charAt(col+1) == '@')
                        adjacentRolls++;
                    if((col > 0) && wall.get(row).charAt(col-1) == '@')
                        adjacentRolls++;
                    if((col < temp.length()-1) && wall.get(row).charAt(col+1) == '@')
                        adjacentRolls++;
                    if((row < wall.size()-1 && col > 0) && wall.get(row+1).charAt(col-1) == '@')
                        adjacentRolls++;
                    if((row < wall.size()-1) && wall.get(row+1).charAt(col) == '@')
                        adjacentRolls++;
                    if((row < wall.size()-1 && col < temp.length()-1) && wall.get(row+1).charAt(col+1) == '@')
                        adjacentRolls++;

                    if(adjacentRolls < 4)
                        rollsCount++;

                    adjacentRolls = 0;

                }
            }
        }
        return rollsCount;
    }

    public static void rollRemover(List<char[]> wall)
    {

        for(int row = 0; row < wall.size(); row++)
        {
            char[] temp = wall.get(row);
            int adjacentRolls = 0;
            for (int col = 0; col < temp.length; col++)
            {
                if(temp[col] == '@')
                {

                    if((row > 0 && col > 0) && (wall.get(row-1)[col-1] == '@'))
                        adjacentRolls++;
                    if((row > 0) && wall.get(row-1)[col] == '@')
                        adjacentRolls++;
                    if((row > 0 && col < temp.length-1) && wall.get(row-1)[col+1] == '@')
                        adjacentRolls++;
                    if((col > 0) && wall.get(row)[col-1] == '@')
                        adjacentRolls++;
                    if((col < temp.length-1) && wall.get(row)[col+1] == '@')
                        adjacentRolls++;
                    if((row < wall.size()-1 && col > 0) && wall.get(row+1)[col-1] == '@')
                        adjacentRolls++;
                    if((row < wall.size()-1) && wall.get(row+1)[col] == '@')
                        adjacentRolls++;
                    if((row < wall.size()-1 && col < temp.length-1) && wall.get(row+1)[col+1] == '@')
                        adjacentRolls++;

                    if(adjacentRolls < 4)
                    {
                        rollsCount++;
                        //set current to . in original array
                        wall.get(row)[col] = '.';
                    }

                    adjacentRolls = 0;

                }
            }
        }
    }

    public static long getRollsCount()
    {
        return rollsCount;
    }
}
