package generator.models;

/**
 * Created by Dawid on 2016-10-30.
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by Dawid on 2016-10-23.
 */
public class Pesel {
    private StringBuilder pesel = new StringBuilder("");

    public Pesel(LocalDate dayOfBirth, boolean isMan) {
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyMMdd");
        String dayOfBirthString= dayOfBirth.format(dateTimeFormatter);
        pesel.append(dayOfBirthString);
        Random random= new Random();
        for(int i=0; i<3;i++){
            pesel.append(random.nextInt(10));
        }
        int genderNumber=random.nextInt(10)/2*2;
        if(isMan)
            genderNumber++;
        pesel.append(genderNumber);
        String controlString="1379137913";
        int controlNumber=0;
        for (int i=0; i<10;i++)
            controlNumber=Character.getNumericValue(pesel.toString().charAt(i))*Character.getNumericValue(controlString.charAt(i));
        pesel.append(controlNumber%10);
    }

    public String toString() {
        return pesel.toString();
    }

    public StringBuilder getPesel() {
        return pesel;
    }

    public void setPesel(StringBuilder pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Pesel pesel1 = (Pesel) o;
        return this.toString().equals(pesel1.toString());

    }

    @Override
    public int hashCode() {
        return pesel.hashCode();
    }
}

