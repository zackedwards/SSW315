package Lab10;

// The basic entry stored in ProbingHashTable

class HashEntry
{
    Hashable element;   // the element
    boolean  isActive;  // false is deleted
    String str_value;

    public HashEntry( Hashable e )
    {
        this( e, true );
    }

    public HashEntry( Hashable e, boolean i )
    {
        element   = e;
        isActive  = i;
    }
    public HashEntry( String e, boolean i) {
    	str_value= e;
    	isActive  = i;
    }
}