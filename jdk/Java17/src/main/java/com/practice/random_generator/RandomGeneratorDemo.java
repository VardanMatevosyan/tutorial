package com.practice.random_generator;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;


/** * Demonstrates the usage of RandomGenerator and RandomGeneratorFactory introduced in Java 17.
 * This example creates a random number generator using the "L64X128MixRandom" algorithm,
 * generates a random integer between 1 and 50, and prints a stream of 5 positive random integers.
 *
 * There are several algorithms available, such as:
 * - L32X64MixRandom
 * - L64X128MixRandom
 * - L128X256MixRandom
 * These algorithms offer different trade-offs between speed and quality of randomness.
 * You can choose the one that best fits your application's needs.
 * For example, L64X128MixRandom is a good balance for many applications.
 * The 64 and 128 in the name refer to the internal state size of the generator, which affects its period and quality.
 * A larger state size generally means a longer period and better randomness quality, but it may also be slower.
 */
public class RandomGeneratorDemo {
  public static void main(String[] args) {
    RandomGeneratorFactory<RandomGenerator> factory = RandomGeneratorFactory.of("L64X128MixRandom");
    RandomGenerator randomGenerator = factory.create();

    // Generate a random integer between 1 and 50
    int randomValue = randomGenerator.nextInt(1, 50);
    System.out.println("Random Value: " + randomValue);

    // IntStream of random numbers
    randomGenerator
        .ints()
        .filter(i -> i > 0)
        .limit(5)
        .forEach(System.out::println);

  }
}
