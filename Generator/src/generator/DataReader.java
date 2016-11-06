package generator;

import generator.models.entities.Profile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Dawid on 2016-10-31.
 */
public class DataReader {

    public DataReader(){
    }

    public static ArrayList<Profile> readProfiles(){
        ArrayList<Profile> listOfProfiles=new ArrayList<>(15);
        String csvFile = "rozszerzenia.csv";
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] extensions = line.split(cvsSplitBy);
                Optional<Profile> profileOptional=listOfProfiles.stream().filter(profile -> profile.getName().equals(extensions[0])).findAny();
                if(!profileOptional.isPresent())
                    listOfProfiles.add(new Profile(extensions[0]));
                listOfProfiles.stream().filter(profile ->
                        profile.getName().equals(extensions[0])).findFirst().ifPresent(profile ->
                            profile.addAdvancedSubject(extensions[1], Stream.of(Arrays.copyOfRange(extensions,2,5)).mapToInt(Integer::parseInt).toArray()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfProfiles;
    }

    public static List<String[]> readDataFiles(){
        List listOfArrays=new ArrayList<String[]>(6);
        String[] csvFiles = {"zenskie.csv", "meskie.csv", "nazwiska.csv", "miasta.csv", "ulice.csv"};
        String line = "";
        String cvsSplitBy = ",";
        for(int i=0; i<5;i++){
            try (BufferedReader br = new BufferedReader(new FileReader(csvFiles[i]))) {
                while ((line = br.readLine()) != null) {
                    listOfArrays.add(line.split(cvsSplitBy));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listOfArrays;
    }
}
