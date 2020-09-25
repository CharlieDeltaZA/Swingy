package com.cdiogo.swingy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.cdiogo.swingy.models.PlayerFactory;
import com.cdiogo.swingy.models.heroes.Player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File {

    private static String line = "";
    
    public List<Player> loadFromFile() {
        // TODO: Handle no file/empty file appropriately across all places where
        // <heroes> is used
        String filename = System.getProperty("user.dir") + "/saves.txt";
        List<Player> heroes = new ArrayList<>();
        String line;
        int lineNum = 1;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            // String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",");
                try {
                    Player hero = PlayerFactory.existingPlayer(splitLine[0], splitLine[1],
                            Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]),
                            Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]),
                            Integer.parseInt(splitLine[6]), splitLine[7], splitLine[8], splitLine[9]);

                    Set<ConstraintViolation<Player>> constraintViolations = validator.validate(hero);

                    for (ConstraintViolation<Player> violation : constraintViolations)
                        System.out.println(String.format("Validation Failed: %s - Hero on line: %d", violation.getMessage(), lineNum));
            
                    if (constraintViolations.size() > 0)
                        hero = null;
                        
                    if (hero != null) {
                        heroes.add(hero);
                    }

                } catch (NumberFormatException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                lineNum++;
            }
            reader.close();
            // System.out.println(heroes);
            return (heroes);
        } catch (FileNotFoundException e) {
            // TODO remove the stackTrace
            System.out.println(String.format("File '%s' not found, continuing", filename));
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (null);
    }

    public void addLine(String hero) {
        line += hero;
    }

    public void saveFile() {
        try {
            FileWriter writer = new FileWriter("saves.txt");
            writer.write(line);
            writer.close();
            line = "";
        } catch (IOException e) {
            System.out.println("Error creating file 'saves.txt', quitting...");
            e.printStackTrace();
            System.exit(1);
        }
        
    }

}
