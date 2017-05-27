package BitManipulation;

public class FlipBit {
	
public static int SEQUENCE_LENGTH = 32;
	
	/* Given set of three sequences ordered as {0s, then 1s, then 0s}, 
	 * find max sequence that can be formed. */
	public static int getMaxSequence(int[] sequences) { /* 1s, then 0s, then [old] ones */
		if (sequences[1] == 1) { // a single 0 -> merge sequences
			return sequences[0] + sequences[2] + 1; 
		} else if (sequences[1] == 0) { // no 0s -> take one side
			return Math.max(sequences[0], sequences[2]); 
		} else {  // many 0s -> take side, add 1 (flip a bit)
			return Math.max(sequences[0], sequences[2]) + 1;
		}
	}
	
	public static void shift(int[] sequences) {
		sequences[2] = sequences[1];
		sequences[1] = sequences[0];
		sequences[0] = 0;
	}
	
	public static int longestSequence(int n) {
		int searchingFor = 0;
		int[] sequences = {0, 0, 0}; // Counts of last 3 sequences
		int maxSequence = 1;
		
		for (int i = 0; i < SEQUENCE_LENGTH; i++) {
			if ((n & 1) != searchingFor) {
				if (searchingFor == 1) { // End of 1s + 0s + 1s sequence
					maxSequence = Math.max(maxSequence, getMaxSequence(sequences));
				}
				
				searchingFor = n & 1; // Flip 1 to 0 or 0 to 1
				shift(sequences); // Shift sequences
			}
			sequences[0]++;
			n >>>= 1;
		}
		
		/* Check final set of sequences */
		if (searchingFor == 0) {
			shift(sequences);		
		}
		int finalSequence = getMaxSequence(sequences);
		maxSequence = Math.max(finalSequence, maxSequence);		
		
		return maxSequence;
	}	
	
	//simpler solution
		public static int flipBit(int a) {
			/* If all 1s, this is already the longest sequence. */
			if (~a == 0) return Integer.BYTES * 8;
			
			int currentLength = 0;
			int previousLength = 0;
			int maxLength = 1; // We can always have a sequence of at least one 1
			while (a != 0) {
				if ((a & 1) == 1) {
					currentLength++;
				} else if ((a & 1) == 0) {
					/* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
					previousLength = (a & 2) == 0 ? 0 : currentLength;
					currentLength = 0;
				}
				maxLength = Math.max(previousLength + currentLength + 1, maxLength);
				a >>>= 1;
			}
			return maxLength;
		}
		
		public static void main(String[] args) {
/*			int[][] cases = {{-22, 4}, {Integer.MAX_VALUE, 32}, {-10, 31}, {0, 1}, 
					{1, 2}, {15, 5}, {1775, 8}};
			for (int[] c : cases) {
				int x = flipBit(c[0]);
				boolean r = (c[1] == x);
				System.out.println(c[0] + ": " + x + ", " + c[1] + " " + r);
			}*/
			
			int x = flipBit(-22);
			boolean r = (4 == x);
			System.out.println(-22 + ": " + x + ", " + 4 + " " + r);
			
			System.out.println("\n" + "-22 : " + longestSequence(-22));

		}

	}

