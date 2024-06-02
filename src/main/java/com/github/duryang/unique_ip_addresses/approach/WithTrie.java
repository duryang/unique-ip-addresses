package com.github.duryang.unique_ip_addresses.approach;

import com.github.duryang.unique_ip_addresses.data_structure.IPv4Address;
import com.github.duryang.unique_ip_addresses.data_structure.IPv4Trie;
import org.openjdk.jmh.annotations.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.github.duryang.unique_ip_addresses.Constants.FILE_PATH;

/**
 * Reads line by line and uses an {@link IPv4Trie}
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class WithTrie {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    public long countUnique() throws IOException {

        var trie = new IPv4Trie();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                trie.add(new IPv4Address(line));
            }
        }

        return trie.getSize();
    }
}
