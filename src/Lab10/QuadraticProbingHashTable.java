package Lab10;

//QuadraticProbingHashTable abstract class
//
// CONSTRUCTION: with an approximate initial size or a default.
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// Hashable find( x )     --> Return item that matches x
// void makeEmpty( )      --> Remove all items
// int hash( String str, int tableSize )
//                        --> Static method to hash strings

/**
 * Probing table implementation of hash tables.
 * Note that all "matching" is based on the equals method.
 * @author Mark Allen Weiss
 */
public class QuadraticProbingHashTable
{
    /**
     * Construct the hash table.
     */
    public QuadraticProbingHashTable( )
    {
    	//a standard declaration with no argument, where the array is given default size
        this( DEFAULT_TABLE_SIZE );
    }

    /**
     * Construct the hash table.
     * @param size the approximate initial size.
     */
    public QuadraticProbingHashTable( int size )
    {
    	//The declaration with the argument of the initial size
        allocateArray( size ); //it allocates an amount of memory
        makeEmpty( ); //and creates an empty data structure
    }

    /**
     * Insert into the hash table. If the item is
     * already present, do nothing.
     * @param x the item to insert.
     */
    public void insert( Hashable x )
    {
            // Insert x as active
        int currentPos = findPos( x ); //hash the input number and find where it should go
 
        if( isActive( currentPos ) ) { //checks to see if number is already in that spot
            return;
        }

        array[ currentPos ] = new HashEntry( x, true ); //fills the value into the position

            // Rehash; see Section 5.5
        if( ++currentSize > array.length / 2 ) {//if the size of the array approaches the hash table size
            rehash( ); //then just rehash the numbers!
        }
    }
    

    /**
     * Expand the hash table.
     */
    private void rehash( )
    {
        HashEntry [ ] oldArray = array; //create a copy of the old array

            // Create a new double-sized, empty table
        allocateArray( nextPrime( 2 * oldArray.length ) ); //doubles the size to the next prime
        currentSize = 0;
        
        int i = 0;
        while(i < oldArray.length) { //evaluates each index of the array
        	if( oldArray[ i ] != null && oldArray[ i ].isActive ) { //if it existed in the old array...
                insert( oldArray[ i ].element ); //insert it into the new array!!
            }
        	i++;
        }
            // Copy table over
//        for( int i = 0; i < oldArray.length; i++ ) {
//            if( oldArray[ i ] != null && oldArray[ i ].isActive ) {
//                insert( oldArray[ i ].element );
//            }
//        }
        return;
    }

    /**
     * Method that performs quadratic probing resolution.
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    private int findPos( Hashable x ) //called in the insert to find the position for the entry
    {
/* 1*/      int collisionNum = 0; //creating a variable for collisions
/* 2*/      int currentPos = x.hash( array.length ); //hashing the entry according to the array size
			
			//break if the position being evaluated isn't null			
			//break if the element at the position equals the insert variable
/* 3*/      while( array[ currentPos ] != null && 
                !array[ currentPos ].element.equals( x ) ) 
        	{
/* 4*/          currentPos += 2 * ++collisionNum - 1;  // Compute ith probe
				//evaluates if the currentPos is greater than the array length
/* 5*/          if( currentPos >= array.length ) {      // Implement the mod
/* 6*/              currentPos -= array.length;
				}
        	}
			count = count + collisionNum + 1; //count the amount of collisions
/* 7*/      return currentPos; //return the positions for the node to be inserted at
    }
    

    /**
     * Remove from the hash table.
     * @param x the item to remove.
     */
    public void remove( Hashable x )
    {
        int currentPos = findPos( x ); //find the position of x
        if( isActive( currentPos ) ) {  //if the node is filled
            array[ currentPos ].isActive = false; //then remove it
        }
    }

    /**
     * Find an item in the hash table.
     * @param x the item to search for.
     * @return the matching item.
     */
    public Hashable find( Hashable x )
    {
        int currentPos = findPos( x ); //find the position of x
        if(isActive( currentPos )) {//if the position is active
        	return array[currentPos].element; //then return the value
        }
        else {
        	return null;
        }
//    return isActive( currentPos ) ? array[ currentPos ].element : null;
    }

    /**
     * Return true if currentPos exists and is active.
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active.
     */
    private boolean isActive( int currentPos )
    {
    	//checks to see if the node at the position is active
        return array[ currentPos ] != null && array[ currentPos ].isActive;
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0; //sets the currentSize variable to 0
        for( int i = 0; i < array.length; i++ ) { //examines each item in the array
            array[ i ] = null; //and sets each node to null
        }
    }

    /**
     * A hash routine for String objects.
     * @param key the String to hash.
     * @param tableSize the size of the hash table.
     * @return the hash value.
     */
    public static int hash( String key, int tableSize )
    {
        int hashVal = 0;

        for( int i = 0; i < key.length( ); i++ ) { //for each character in the string
            hashVal = 37 * hashVal + key.charAt( i ); //turns the string into a number
        }
        hashVal %= tableSize; //modulus tableSize is the hash function
        
        //makes sure the hash value isn't negative
        if( hashVal < 0 ) {
            hashVal += tableSize;
        }
        return hashVal;
    }

    private static final int DEFAULT_TABLE_SIZE = 11;

        /** The array of elements. */
    private HashEntry [ ] array;   // The array of elements
    private int currentSize;
    public int count;// The number of occupied cells

    /**
     * Internal method to allocate array.
     * @param arraySize the size of the array.
     */
    private void allocateArray( int arraySize )
    {
        array = new HashEntry[ arraySize ];
    }

    /**
     * Internal method to find a prime number at least as large as n.
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime( int n )
    {
    	//checks to see if N is divisible by 2
        if( n % 2 == 0 ) {
            n++;
        }
        
        //while n isn't a prime number, add two and check again
        while(!isPrime( n )) {
        	n += 2;
        }

//        for( ; !isPrime( n ); n += 2 )
//            ;

        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime( int n )
    {
    	//checks to see if b is 2 or 3
        if( n == 2 || n == 3 ) {
            return true;
        }

        //checks to see if n is 1, or if it is divisible by 2
        if( n == 1 || n % 2 == 0 ) {
            return false;
        }
        int i = 3;
        
        //checks to see if i*i is less than or equal to n
        while(i * i <= n) {
        	//if n is divisible by i then the number is not a prime
        	if( n % i == 0 ) {
        		return false;
        	}
        	i += 2;
        }

//        for( int i = 3; i * i <= n; i += 2 )
//            if( n % i == 0 )
//                return false;

        return true;
    }
    public HashEntry[] getTable() {
    	HashEntry[] copy = array;
    	return copy;
    }
    public int size() {
    	return currentSize;
    }


    // Simple main
    public static void main( String [ ] args )
    {
        QuadraticProbingHashTable H = new QuadraticProbingHashTable(21);

        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );


        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            H.insert( new MyInteger( i ) );
        for( int i = 1; i < NUMS; i+= 2 )
            H.remove( new MyInteger( i ) );

        for( int i = 2; i < NUMS; i+=2 )
            if( ((MyInteger)(H.find( new MyInteger( i ) ))).intValue( ) != i )
                System.out.println( "Find fails " + i );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( H.find( new MyInteger( i ) ) != null )
                System.out.println( "OOPS!!! " +  i  );
        }
          
//        for(int i = 0; i < copy.length-1; i++) {
//        	if(copy[i] != null) {
//        		System.out.println(copy[i].element);
//        	}
//        }
    }

}