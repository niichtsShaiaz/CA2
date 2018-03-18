/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generator;

import Entities.CityInfo;
import Facade.Facademan;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ezl
 */
public class Generator
{
    Random rnd = new Random();
    
    public static void main(String[] args)
    {
        Generator g = new Generator();
        //System.out.println(g.generateAddressTable(10));
        //System.out.println(g.generatePersonTable(10));
        //System.out.println(g.generatePhoneTable(10));
        //System.out.println(g.generateHobbyTable(10));
        //System.out.println(g.generatePersonHobby(10));
        System.out.println(g.generateDummyDatabaseData(1000));
    }

    public String generateDummyDatabaseData(int qty)
    {
        String sql = "";
        sql += generateAddressTable(qty);
        sql += generatePersonTable(qty);
        sql += generatePhoneTable(qty);
        sql += generateHobbyTable(qty);
        sql += generatePersonHobby(qty);
        return sql;
    }

    private String generateAddressTable(int qty)
    {
        String[] streetNames = {"Ballerup-Centret", "Banetoften", "Brydehusvej", "Trepkasgade", "Baldersgade", "Staldgade", "Husumvej"};
        String[] aInfo ={"lorem ipsum", "dolor sit amet", "consectetur adipiscing elit", "sed do eiusmod tempor", "sit voluptatem accusantium"};
        int[] zips ={2100, 2200, 2300, 4900, 2000, 110};
        String sql = "";
        for (int i = 0; i < qty; i++)
        {
            int n = rnd.nextInt(streetNames.length);
            int n2 = rnd.nextInt(zips.length);
            int n3 = rnd.nextInt(aInfo.length);
            sql += "INSERT INTO ADDRESS SET ID = "+(i+1)+", ADDITIONALINFO = \"" + aInfo[n3] + "\", STREET = \"" + streetNames[n] + "\", CITYINFO_ZIP = " + zips[n2] + ";\n";
        }

        return sql;
    }

    private String generatePersonTable(int qty)
    {
        String[] fNames ={"Jann", "Garland", "Leslee", "Jesusa", "Antone"};
        String[] lNames ={"Gillie", "Rossell", "Rosenzweig", "Durrell", "Niels"};
        String sql = "";
        for (int i = 0; i < qty; i++)
        {
            int n = rnd.nextInt(fNames.length);
            int n2 = rnd.nextInt(fNames.length);
            int n3 = rnd.nextInt(fNames.length);
            int n4 = rnd.nextInt(fNames.length);
            sql += "INSERT INTO PERSON SET ID = "+(i+1)+",  EMAIL = \"" + fNames[n] + "@" + lNames[n2] + ".com\", FNAME = \"" + fNames[n3] + "\", LNAME = \"" + lNames[n4] + "\", ADDRESS_ID = \"" + (rnd.nextInt(qty) + 1) + "\";\n";
        }
        return sql;
    }

    private String generatePhoneTable(int qty)
    {
        String sql = "";
        int[] number ={12345678, 987654321, 80808080, 32323232, 112};
        String[] desc ={"lorem ipsum", "dolor sit amet", "consectetur adipiscing elit", "sed do eiusmod tempor", "sit voluptatem accusantium"};
        for (int i = 0; i < qty; i++)
        {
            int n = rnd.nextInt(number.length);
            int n2 = rnd.nextInt(number.length);
            sql += "INSERT INTO PHONE SET ID = "+(i+1)+", DESCRIPTION = \"" + desc[n] + "\", NUMBER = \"" + number[n2] + "\", PERSON_ID = \"" + (rnd.nextInt(qty) + 1) + "\";\n";
        }
        return sql;
    }

    private String generateHobbyTable(int qty)
    {
        String sql = "";

        String[] desc ={"lorem ipsum", "dolor sit amet", "consectetur adipiscing elit", "sed do eiusmod tempor", "sit voluptatem accusantium"};
        String[] name ={"Fodbold", "Skydning", "Træne", "Synge", "Syning"};

        for (int i = 0; i < qty; i++)
        {
            int n = rnd.nextInt(desc.length);
            int n2 = rnd.nextInt(desc.length);
            sql += "INSERT INTO HOBBY SET ID = "+(i+1)+", DESCRIPTION = \"" + desc[n] + "\", NAME = \"" + name[n2] + "\";\n";
        }
        return sql;
    }

    private String generatePersonHobby(int qty)
    {
        String sql = "";
        for (int i = 0; i < qty; i++)
        {
            int n = rnd.nextInt(qty) + 1;
            sql += "INSERT INTO PERSON_HOBBY SET Person_ID = \"" + (i+1) + "\", hobbys_ID = \"" + n + "\";\n";
        }
        return sql;
    }
}
