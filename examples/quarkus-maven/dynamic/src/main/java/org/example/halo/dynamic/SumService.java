package org.example.halo.dynamic;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.halo.core.gateway.IAlgorithm;
import org.example.halo.core.service.ISumService;

@Named
public class SumService implements ISumService {

    @Inject
    IAlgorithm algorithm;

    @Override
    public int sum(int[] intArray) {
        int result = 0;
        for (int i=0; i<intArray.length; ++i) {
            result = algorithm.add(result, intArray[i]);
        }
        return result;
    }
}
