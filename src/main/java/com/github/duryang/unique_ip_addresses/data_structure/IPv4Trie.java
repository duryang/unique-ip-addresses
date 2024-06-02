package com.github.duryang.unique_ip_addresses.data_structure;

import lombok.Getter;

public class IPv4Trie {

    private static final TrieNode LEAF = new TrieNode(0);

    private final TrieNode root;

    @Getter
    private long size;

    public IPv4Trie() {
        root = new TrieNode(256);
    }

    public void add(IPv4Address iPv4Address) {
        addOctet(iPv4Address, 0, root);
    }

    private void addOctet(IPv4Address iPv4Address, int level, TrieNode node) {

        int octet = iPv4Address.getOctet(level);

        if (level == 3) {
            if (node.children[octet] != LEAF) {
                node.children[octet] = LEAF;
                size++;
            }

            return;
        }

        if (node.children[octet] == null) {
            node.children[octet] = new TrieNode(256);
        }

        addOctet(iPv4Address, level + 1, node.children[octet]);
    }
}
