package com.github.duryang.unique_ip_addresses.approach;

import org.openjdk.jmh.annotations.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.github.duryang.unique_ip_addresses.Constants.FILE_PATH;

/**
 * Reads line by line and uses a HashSet<String> <br/>
 * The output will be incorrect if the number of unique addresses
 * is greater than {@link Integer#MAX_VALUE}
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Naive {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    public int countUnique() throws IOException {

        Set<String> unique = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                unique.add(line);
            }
        }

        return unique.size();
    }
}
