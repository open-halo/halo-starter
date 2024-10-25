package org.example.halo.dynamic;

import org.example.halo.core.gateway.IAlgorithm;

public class Algorithm implements IAlgorithm {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
