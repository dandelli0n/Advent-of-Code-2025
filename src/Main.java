import day1.*;
import day2.*;
import day3.*;
import day4.*;
import day5.FreshaVocado;

void main() throws IOException
{
    int DAY = 5;
    int MODE = 2;

    //BufferedReader dayselector = new BufferedReader(new InputStreamReader(System.in));
    //DAY = Integer.parseInt(dayselector.readLine());
    //MODE = Integer.parseInt(dayselector.readLine());

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
    if(DAY == 4)
    {
        BufferedReader br = new BufferedReader(new FileReader("input4.txt"));
        List<char[]> rack = new ArrayList<>();
        String temp;
        char[] chars;
        while((temp = br.readLine()) != null)
        {
            chars = temp.toCharArray();
            rack.add(chars);
        }
        long delta = 1;
        while(delta != 0)
        {
            delta = RollCounter.getRollsCount();
            RollCounter.rollRemover(rack);
            delta = RollCounter.getRollsCount() - delta;
        }

        puzzleSolution = RollCounter.getRollsCount();

    }
    if(DAY == 5)
    {
        if(MODE == 1)
            puzzleSolution = FreshaVocado.getFreshProductNumber("example5.txt");
        else if(MODE == 2)
            puzzleSolution = FreshaVocado.freshIDs("input5.txt");
    }

    System.out.println(puzzleSolution);

    long end = System.currentTimeMillis();
    long delta = end - start;

    System.out.println("Elapsed time: " + delta + " ms");


}