package main;

import data.RegexReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try(RegexReader buffer =
                    new RegexReader(new FileReader(
                            "D:\\DAM\\2º\\Programación de servicios y procesos\\Unit 1\\dates.txt"),
                            "\\d{,2}/\\d{1,2}/(\\d{4}|\\d{2})"))
        {
            String line;
            while((line = buffer.readLine()) != null)
            {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e1) {

        }
    }
}
