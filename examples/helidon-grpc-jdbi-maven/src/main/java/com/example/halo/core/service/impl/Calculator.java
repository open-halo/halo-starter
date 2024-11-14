package com.example.halo.core.service.impl;

import com.example.halo.core.service.ICalculator;
import jakarta.inject.Singleton;

import java.util.Arrays;

@Singleton
public class Calculator implements ICalculator {
    @Override
    public int sum(int arr[]) {
        return Arrays.stream(arr).sum();
    }
}
