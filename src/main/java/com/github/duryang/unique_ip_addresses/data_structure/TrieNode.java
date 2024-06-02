package com.github.duryang.unique_ip_addresses.data_structure;

public class TrieNode {

    TrieNode[] children;

    public TrieNode(int size) {
        children = new TrieNode[size];
    }
}
