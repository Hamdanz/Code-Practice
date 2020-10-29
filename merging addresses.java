import java.util.*;

class Main {
    public static int row;
       public static void printMatrix(int[][] array, int row, int column)   // Class used for printing the Answer/Merged addresses
       {
        System.out.print("The merged addresses are ");
        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < column; j++) 
            {
                System.out.print(array[i][j] + " ");
            }
          System.out.println();
        }
        }
	public static int[][] merge_zipcodes(int[][] input_zipcodes) 
    {
    if(input_zipcodes.length <= 1)
        return input_zipcodes;      // Edge case where length of input_zipcodes is less than 1.
    
    Arrays.sort(input_zipcodes,(index1,index2)->Integer.compare(index1[0],index2[0])); //Sorting the input_zipcodes
    List<int[]> result = new ArrayList<>();   //To hold the answer
        
    result.add(input_zipcodes[0]);       //Adding the first interval into result List
        
        for(int i=1; i<input_zipcodes.length; i++)
        {
            int[] popped = result.get(result.size()-1);  //popping the most recent inserted zip code from the result List.
            if(input_zipcodes[i][0] <= popped[1])        //Comparing second index of popped zipcode with first index of subsequent zipcode interval
            {
                int merged_zipcode[] = {popped[0],Math.max(popped[1], input_zipcodes[i][1] )};
                result.set(result.size()-1, merged_zipcode);    //Setting the changes solution.
            }else{
                result.add(input_zipcodes[i]);
            }
        }
        return result.toArray(new int[result.size()][]);   //Converting a ArrayList to multidimensional Array and returning it
    }
	
	public static void main(String args[])
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the number of zipcode ranges ");
		row = sc.nextInt();
		int column = 2; 
		int[][] matrix = new int[row][column];
        
        for(int i=0;i< row ; i++)
        {
		System.out.println("Please Enter the zip code range separated by space, Example:- 95100 95300 ");
            for(int j=0; j< column; j++) 
            {
                int val = sc.nextInt();
                matrix[i][j] = val;
            }
        }
        int[][] final_answer = merge_zipcodes(matrix);
        printMatrix(final_answer,row,2);
		}
}





