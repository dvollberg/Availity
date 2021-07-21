package com.vollberg.availity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class EnrolleeCsvParser {

    public static void main(String[] args) throws IOException {

        Map<String, Map<String, Enrollee>> insuranceCompanies = new HashMap<>();
        //assume args0 contains the filename of the .csv
        String filename = args[0];

        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(row -> {
                String[] cols = row.split(",");
                Enrollee enrollee = new Enrollee(cols[0], cols[1], cols[2], Integer.parseInt(cols[3]), cols[4]);
                Map<String, Enrollee> company = insuranceCompanies.get(enrollee.getInsuranceCompany());
                if ( company == null ) {
                    company = new HashMap<>();
                    insuranceCompanies.put(enrollee.getInsuranceCompany(), company);
                }
                Enrollee existing = company.get(enrollee.getUserId());
                if ( existing != null && enrollee.getVersion() < existing.getVersion() ) {
                    return;
                }
                company.put(enrollee.getUserId(), enrollee);
            });
        }
    
        List<Map<String, Enrollee>> values = new ArrayList<>(insuranceCompanies.values());
        values.forEach(company -> {
            List<Enrollee> enrolleeList = new ArrayList<>(company.values());
            Collections.sort(enrolleeList);
            String insuranceCompany = enrolleeList.get(0).getInsuranceCompany();
            Path file = Paths.get(insuranceCompany + ".csv");
            List<String> lines = new ArrayList<>();
            enrolleeList.forEach(enrollee -> lines.add(enrollee.toString()));
            try{ 
                Files.write(file, lines, StandardOpenOption.CREATE_NEW);
            } catch (Exception ioe) {
                // handle errors
            }
        });
    }
}