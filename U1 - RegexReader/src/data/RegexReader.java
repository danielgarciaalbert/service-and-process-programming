package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class RegexReader extends BufferedReader {

    public RegexReader (Reader reader, String expression) {
        super(reader);
    }

    @Override
    public String readLine() throws IOException
    {
        String line = super.readLine();
        return line != null?line.toUpperCase():null;
    }

}
