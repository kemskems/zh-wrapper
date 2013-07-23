import com.spreada.utils.chinese.ZHConverter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * Main wrapper class for ZHConverter library.
 * 
 * @author Kemal Maulana <kemskems12@gmail.com>
 */
public class ZHMain
{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            String message = "Error: missing argument(s)\n\n"
                           + "Usage: java ZHMain CODE\n"
                           + "Converts between simplified and traditional Chinese characters. Reads from "
                           + "STDIN and writes to STDOUT.\n\n"
                           + "Parameters:\n"
                           + "\tCODE\tTarget type of characters conversion. Use 'zh-CN' for simplified "
                           + "Chinese or 'zh-TW' for traditional Chinese.";
            System.err.println(message);
            System.exit(1);
        }

        int type = ZHConverter.SIMPLIFIED;
        if (args[0].equals("zh-TW"))
        {
            type = ZHConverter.TRADITIONAL;
        }
        else if (!args[0].equals("zh-CN"))
        {
            String message = "Unknown code '" + args[0] + "'. Use 'zh-CN' for simplified "
                           + "Chinese or 'zh-TW' for traditional Chinese.";
            System.err.println(message);
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        ZHConverter converter = ZHConverter.getInstance(type);
        String str;
        int lineNumber = 1;
        try
        {
            while ((str = in.readLine()) != null)
            {
                System.err.println("LINE " + (lineNumber++));
                System.err.println("READS: " + str);
                String convertedStr = converter.convert(str);
                System.err.println("CONVERTED TO: " + convertedStr + "\n");
                out.write(convertedStr);
                out.newLine();
            }
            out.close();
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
