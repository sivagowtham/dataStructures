package testPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestClass {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> input = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array");
		int n = Integer.parseInt(br.readLine());
		for(int i =0; i<n;i++)
		{
			input.add(Integer.parseInt(br.readLine()));
		}
		int highestNumber = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;
		if(input.get(0) > input.get(1) )
		{
			highestNumber = input.get(0);
			secondHighest = input.get(1);
		}
		else
		{
			highestNumber = input.get(1);
			secondHighest = input.get(0);
		}
		for (int i =0; i<input.size();i++)
		{
			if(input.get(i)>highestNumber)
			{
				secondHighest = highestNumber;
				highestNumber = input.get(i);
			}
			else if(input.get(i)>secondHighest && highestNumber!= input.get(i))
			{
				secondHighest = input.get(i);
			}
		}
		System.out.println(secondHighest+"    "+highestNumber);
	}
}
