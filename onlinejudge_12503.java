import java.util.*;

public class onlinejudge_12503 {

	public static void main(String[] args) {
		// Collecting input data.
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		
		// Running through all test cases to collect input instructions for each case.
		for (int i = 0; i < numCases; i++) {
			// Instantiating variables for number of instructions, the instructions themselves, and the x-position.
			int numInstr = input.nextInt();
			String[] instr = new String[numInstr];
			int pos = 0;
			
			// Wasting an input line to avoid an empty record.
			input.nextLine();
			
			// Iterating through all instructions for a given test case to record the instruction and move accordingly.
			for (int j = 0; j < numInstr; j++) {
				instr[j] = input.nextLine();
				pos = move(instr, j, pos);
			}
			
			// Printing final position.
			System.out.println(pos);
			
		}
		
	input.close();
	}
	
	// Method to carry out the change in position for each instruction.
	public static int move(String[] instr, int instrIn, int pos) {
		// Moving left if left.
		if (instr[instrIn].equals("LEFT")){return pos - 1;}
		
		// Moving right if right.
		else if (instr[instrIn].equals("RIGHT")){return pos + 1;}
		
		// If the instruction is long enough, checking for the "SAME AS" to indicate a reference to a previous instruction.
		else if (instr[instrIn].length() > 5){
			if (instr[instrIn].substring(0, 7).equals("SAME AS")){
				// Recursively calling method move to run through all connected references until a left or right instruction is found and returned.
				return move(instr, Integer.parseInt(instr[instrIn].substring(8, instr[instrIn].length())) - 1, pos);
			}
		}
		// Failsafe so compiler does not complain about returning an integer.
		return -999;
	}
}
