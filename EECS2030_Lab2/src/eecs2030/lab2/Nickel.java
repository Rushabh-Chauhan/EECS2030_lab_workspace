package eecs2030.lab2;

public class Nickel implements Comparable<Nickel> {

	private int year;

	/**
	 * The monetary value of a nickel in cents.
	 */
	public final int CENTS = 5;
	
	public Nickel(int year)
	{
		if (year < 1858)
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			this.year = year;
		}
	}
	
	public int issueYear()
	{
		return this.year;
	}
	
	

	@Override
	public int compareTo(Nickel other) {
		// TODO Auto-generated method stub
		return this.year - other.year;
	}
	
	
	@Override
	public boolean equals(Object obj)
	{

		if (this == obj)
		{
			return true;
		}
		
		if (obj == null || obj.getClass()!= this.getClass())
		{
			return false;
		}
		Nickel other = (Nickel)obj;
		
		return (other.CENTS == this.CENTS);

		
	}
	
	
	@Override
	public int hashCode()
	{
		return this.year;
	}
	
	
	
	

}
