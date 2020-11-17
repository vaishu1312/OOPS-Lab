package ConvertionPackage;

public class DistanceConverter {
	public double metreToKilo(double m)
	{
		double k=m/1000;
		return k;
	}
	public double mileToKilo(double m)
	{
		double k=m*1.6;
		return k;
	}
	public double kiloToMetre(double k)
	{
		double m=k*1000;
		return m;
	}
	public double kiloToMile(double k)
	{
		double m=k/1.6;
		return m;
	}
}
