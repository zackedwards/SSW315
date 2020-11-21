package Lab10;
//Java implementation of the Quadratic Probing 

class GFG { 

	// Function to print an array 
	static void printArray(int arr[]) 
	{ 

		// Iterating and printing the array 
		for (int i = 0; i < arr.length; i++) { 
			System.out.print("(" + i + ", " + arr[i] + " " + ") "); 
		} 
	} 

	// Function to implement the 
	// quadratic probing 
	static void hashing(int table[], int tsize, 
						int arr[], int N) 
	{ 

		// Iterating through the array 
		for (int i = 0; i < N; i++) { 

			// Computing the hash value 
			int hv = arr[i] % tsize; 

			// Insert in the table if there 
			// is no collision 
			if (table[hv] == -1) 
				table[hv] = arr[i]; 
			else { 

				// If there is a collision 
				// iterating through all 
				// possible quadratic values 
				for (int j = 0; j < tsize; j++) { 

					// Computing the new hash value 
					int t = (hv + j * j) % tsize; 
					if (table[t] == -1) { 

						// Break the loop after 
						// inserting the value 
						// in the table 
						table[t] = arr[i]; 
						break; 
					} 
				} 
			} 
		} 

		printArray(table); 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		int arr[] = { 7, 22, 44, 43, 27, 89, 30, 64, 85 }; 
		int N = 9; 

		// Size of the hash table 
		int L = 21; 
		int hash_table[] = new int[L]; 

		// Initializing the hash table 
		for (int i = 0; i < L; i++) { 
			hash_table[i] = -1; 
		} 

		// Quadratic probing 
		hashing(hash_table, L, arr, N); 
	} 
} 
