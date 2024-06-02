package com.github.duryang.unique_ip_addresses.data_structure;

public class IPv4Address {

    private final byte[] octets;

    public IPv4Address(String address) {

        String[] parts = address.split("\\.");

        octets = new byte[4];

        for (int i = 0; i < 4; i++) {
            octets[i] = (byte)(Integer.parseInt(parts[i]) - 128);
        }
    }

    public int getOctet(int i) {
        return octets[i] + 128;
    }
}
