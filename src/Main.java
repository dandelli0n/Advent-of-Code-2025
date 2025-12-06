import day1.*;
import day2.*;
import day3.*;

void main() throws IOException
{
    int DAY;
    int MODE;

    BufferedReader dayselector = new BufferedReader(new InputStreamReader(System.in));
    DAY = Integer.parseInt(dayselector.readLine());
    MODE = Integer.parseInt(dayselector.readLine());

    long start = System.currentTimeMillis();

    long puzzleSolution = 0;

    if(DAY == 1)
    {
        puzzleSolution = (long)(Dial.getZeros("input1.txt", MODE));
    }
    if(DAY == 2) //only finished task1 yet
    {
        puzzleSolution = IDChecker.getPatternSum("input2.txt", 1);
    }
    if(DAY == 3)
    {
        puzzleSolution = JoltageCalculator.getJoltage("input3.txt", 2);
    }

    System.out.println(puzzleSolution);

    long end = System.currentTimeMillis();
    long delta = end - start;

    System.out.println(delta);


}