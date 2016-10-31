package generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dawid on 2016-10-30.
*/
public class PersonalDataGenerator {
    private String[] womansNames;

    private String[] mansNames;

    private String[] surnames;
    private String[] cities;

    private String[] streets;
    private Random random;

    public PersonalDataGenerator(){
        /*

        String[] csvFiles = {"zenskie.csv", "meskie.csv", "nazwiska.csv", "miasta.csv", "ulice.csv"};
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        for(int i=0; i<5;i++){
            try {
                br = new BufferedReader(new FileReader(csvFiles[i]));
                while ((line = br.readLine()) != null) {
                    listOfArrays.add(line.split(cvsSplitBy));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }*/
        List listOfArrays=DataReader.readDataFiles();
        womansNames=(String[])listOfArrays.get(0);
        mansNames=(String[])listOfArrays.get(1);
        surnames=(String[])listOfArrays.get(2);
        cities=(String[])listOfArrays.get(3);
        streets=(String[])listOfArrays.get(4);
        random=new Random();
    }

    public String getName(boolean isManName){
        if(isManName)
            return mansNames[random.nextInt(mansNames.length)];
        else
            return womansNames[random.nextInt(womansNames.length)];
    }
    public String getSurname(boolean isManSurname){
        String surname= surnames[random.nextInt(surnames.length)];
        if(surname.substring(surname.length()-1).equals("i")){
            if(!isManSurname){
                surname=surname.substring(0,surname.length()-1)+"a";
            }
        }
        return surname;
    }
    public String getCity(){
        int chancesOfCity=random.nextInt(100);
        if(chancesOfCity<80)
            return cities[0];//Gdansk
        else{
            return cities[random.nextInt(cities.length-1)+1];
        }
    }
    public String getStreet(){
        return streets[random.nextInt(streets.length)];
    }
    public String getHouseNumber(){
        if(random.nextBoolean())
            return String.valueOf(random.nextInt(200));
        else
            return String.valueOf(random.nextInt(200)) + "m. "+ String.valueOf(random.nextInt(100)) ;
    }

}