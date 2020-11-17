
package ConvertionPackage;

public class TimeConverter {
public double hourToMin(double h)
{
	double min=h*60;
	return min;
}
public double hourToSec(double h)
{
	double sec=h*60*60;
	return sec;
}
public double minToHour(double m)
{
	double h=m/60;
	return h;
}
public double secToHour(double s)
{
	double h=s/3600;
	return h;
}
}
