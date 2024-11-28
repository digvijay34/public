import java.util.Random;

public record EmployeeBean(String id,String name,Department department,long salary)
{
static Random random=new Random();
public static EmployeeBean getRandom(String id)
{
	Department department=Department.getRandom(random);
	return new EmployeeBean(id,FirstName.getRandom(random)+" "+LastName.getRandom(random),department,1000*random.nextLong(department.getMinSal(),department.getMaxSal()));
}
}