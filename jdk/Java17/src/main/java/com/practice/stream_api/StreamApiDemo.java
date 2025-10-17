package com.practice.stream_api;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static java.util.stream.Collectors.*;



/** * Example of Stream API Teeing collector
 * Teeing collector is used to perform two different reduction operations on the same stream
 * and then combine the results.
 * In this example, we calculate the average salary of workers by counting the number of workers
 * and summing their salaries, then dividing the total salary by the count.
 */
public class StreamApiDemo {


  public static void main(String[] args) {
    List<WorkerSalary> workerSalaries = List.of(
        new WorkerSalary("Mark", BigDecimal.valueOf(100, 0)),
        new WorkerSalary("Bob", BigDecimal.valueOf(200, 0)));

    tearing(workerSalaries);
    toListApi(workerSalaries);
  }

  /**
   * Demonstrates the use of the toList() method in the Stream API to collect stream elements into a List.
   * This method is a convenient way to gather all elements from a stream into a List without needing to specify
   * a specific collection type or supplier.
   * The List returned is an unmodifiable List, meaning that attempts to modify it (e.g., adding or removing elements)
   * will result in an UnsupportedOperationException.
   * @param workerSalaries List of WorkerSalary records containing worker names and their salaries.
   */
  private static void toListApi(List<WorkerSalary> workerSalaries) {
    List<String> workers = workerSalaries
        .stream()
        .map(WorkerSalary::worker)
        .toList();
    System.out.println("Workers: " + workers);
  }

  private static void tearing(List<WorkerSalary> workerSalaries) {
    BigDecimal average = workerSalaries
        .stream()
        .collect(
            teeing(
                counting(),
                reducing(BigDecimal.ZERO, WorkerSalary::salary, BigDecimal::add),
                (count, sum) -> {
                  System.out.println("Count: " + count);
                  System.out.println("sum: " + sum);
                  return sum.divide(BigDecimal.valueOf(count), RoundingMode.HALF_EVEN);
                }
            ));
    System.out.println("Average salary is " + average);
  }

  record WorkerSalary(String worker, BigDecimal salary) {
  }
}
