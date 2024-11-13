#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.service.impl;

import ${package}.core.service.ICalculator;
import jakarta.inject.Singleton;

import java.util.Arrays;

@Singleton
public class Calculator implements ICalculator {
    @Override
    public int sum(int arr[]) {
        return Arrays.stream(arr).sum();
    }
}
