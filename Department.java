
import java.util.Random;

public enum Department{
HR(20,140),
TEST(30,160),
DEVELOPMENT(60,190),
QA(50,170),
CLOUD(70,160),
FINANCE(70,120);
private static Random random= new Random();
private long minSal;
private long maxSal;

Department(long minSal,long maxSal)
{
	this.minSal=minSal;
	this.maxSal=maxSal;
}
public long getMinSal()
{
	return this.minSal;
}
public long getMaxSal()
{
	return this.maxSal;
}
public static Department getRandom()
{
	Department [] depatmentList= Department.class.getEnumConstants();
	
	return depatmentList[random.nextInt(depatmentList.length)];
}
public static Department getRandom(Random random)
{
	Department [] depatmentList= Department.class.getEnumConstants();
	
	return depatmentList[random.nextInt(depatmentList.length)];
}
}