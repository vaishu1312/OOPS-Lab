package ConvertionPackage;
public class CurrencyConverter {
	public double rupeeToDollar(double m)
	{
		double d;
		d=m/68.60;
		return d;
	}

	public double dollarToRupee(double m)
	{
		double r;
		r=m*68.60;
		return r;
	}
	public double rupeeToEuro(double m)
	{
		double e;
		e=m/80.34;
		return e;
	}
	public double euroToRupee(double m)
	{
		double r;
		r=m*80.34;
		return r;
	}
	public double rupeeToYen(double m)
	{
		double y;
		y=m/0.61;
		return y;
	}
	public double yenToRupee(double m)
	{
		double r;
		r=m*0.61;
		return r;
	}
}
