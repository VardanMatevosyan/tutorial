package com.practice.collections.map.best_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntUnaryOperator;

import static java.util.Objects.nonNull;

public class MapPractice {
    public static void main(String[] args) {
        Map<String, IntUnaryOperator> functions = getFunctionsMap();

        IntUnaryOperator squareBadFn = getBadFunctionByNameOrReturnTheSameValueBack(functions, "square");
        IntUnaryOperator squareGoodFn = getGoodFunctionByNameOrReturnTheSameValueBack(functions, "square");

        int badSquareFnResult = squareBadFn.applyAsInt(4);
        int goodSquareFnResult = squareGoodFn.applyAsInt(4);
        System.out.println("badSquareFnResult should be 16 : " + badSquareFnResult);
        System.out.println("goodSquareFnResult should be 16 : " + goodSquareFnResult);
        System.out.println();

        IntUnaryOperator sumBadFn = getBadFunctionByNameOrReturnTheSameValueBack(functions, "sum");
        IntUnaryOperator sumGoodFn = getGoodFunctionByNameOrReturnTheSameValueBack(functions, "sum");

        int badSumFnResult = sumBadFn.applyAsInt(10);
        int goodSumFnResult = sumGoodFn.applyAsInt(10);
        System.out.println("badSumFnResult should be 20 : " + badSumFnResult);
        System.out.println("goodSumFnResult should be 20 : " + goodSumFnResult);
        System.out.println();

        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

    }

    private static IntUnaryOperator getBadFunctionByNameOrReturnTheSameValueBack(Map<String, IntUnaryOperator> fnMap,
                                                                                 String name) {
        IntUnaryOperator fn = fnMap.get(name);
        if (nonNull(fn)) {
            return fn;
        }
        return IntUnaryOperator.identity();
    }

    private static IntUnaryOperator getGoodFunctionByNameOrReturnTheSameValueBack(Map<String, IntUnaryOperator> fnMap,
                                                                                  String name) {
        return fnMap.getOrDefault(name, IntUnaryOperator.identity());
    }

    private static Map<String, IntUnaryOperator> getFunctionsMap() {
        Map<String, IntUnaryOperator> functions = new HashMap<>();
        functions.put("square", x -> x * x);
        functions.put("sum", x -> x + x);
        functions.put("increment", x -> x + 1);
        return functions;
    }
}
