package Controllers;

import Objects.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.bind.JAXB;

public class SequentialFile {

    public static void main(String[] args) {
        Path path = Paths.get("employees.xml");

        try (BufferedReader in = Files.newBufferedReader(path)) {
            Employees employees;
            employees = JAXB.unmarshal(in, Employees.class);

            try (BufferedWriter output = Files.newBufferedWriter(path)) {
                Scanner input = new Scanner(System.in);

                System.out.printf("%s%n%s%n? ", "Enter employee ID number, first name and last name.",
                        "Enter end-of-file indicator to end input.");

                while (input.hasNext()) {
                    // loop until end-of-file indicator
                    try {
                        // create new record
                        Employee record = new Employee(input.next(), input.next(), input.next(),
                                input.next(), input.nextLine());

                        // add to EmployeeList
                        employees.getEmployees().add(record);

                    } catch (NoSuchElementException elementException) {
                        System.err.println("Invalid input. Please try again.");
                        input.nextLine(); // discard input so user can try again
                    }
                    System.out.print("? ");
                }

                // write AccountList's XML to output
                JAXB.marshal(employees, output);
            } catch (IOException ioException) {
                System.err.println("Error opening file. Terminating.");
            }
        } catch (IOException e) {
            System.err.println("Error opening file. Terminating.");
        }
    }
}