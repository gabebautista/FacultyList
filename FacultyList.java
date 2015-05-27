import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FacultyList 
{
	public static void main(String[] args)
	{
		String listOfNames = "Copy of Snapshot for AY16 Catalog 20150518.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String currString = "";
		String finalString = "";
		
		try 
		{
			br = new BufferedReader(new FileReader(listOfNames));
			while ((line = br.readLine()) != null)
			{
				String[] facultyMember = line.split(cvsSplitBy);
				/*
				for(int i = 0; i < facultyMember.length; i++)
				{
					System.out.print(facultyMember[i] + " ");
				}
				*/
				currString = facultyMember[0] + ", " + facultyMember[1] + ", " + facultyMember[2] + "of " + facultyMember[3] + ", " + facultyMember[4] + ", " + facultyMember[5] + "\n";
				finalString = finalString + currString;
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter(new FileWriter("FacultyList1.txt"));
			writer.write(finalString);
		}
		catch (IOException e)
		{}
		finally
		{
			try
			{
				if(writer != null)
					writer.close();
			}
			catch(IOException e)
			{}
		}
	}
}
