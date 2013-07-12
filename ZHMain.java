import com.spreada.utils.chinese.ZHConverter;
import java.util.Scanner;

public class ZHMain
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		while (in.hasNext())
		{
			String line = in.nextLine();
			ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
			System.out.println(converter.convert(line));
		}
	}
}