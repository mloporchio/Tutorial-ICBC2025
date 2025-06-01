# Bilinear Accumulator Example

This module contains an example showing how to instantiate a bilinear accumulator scheme using the [Cryptimeleon](https://cryptimeleon.org/) Java library.
The example demonstrates how to create a bilinear accumulator, add elements to it, and verify membership of elements.

This code is intended to be a starting point for understanding how to use bilinear accumulators in Java applications.

## Requirements
To run the code, Java 11 or higher is required. The code has been tested with Oracle JDK 24.0.1.

## Usage
To run the example, follow these steps:
1. Compile the Java file:
   ```bash
   javac -cp ".:lib/*" BilinearAccumulatorExample.java
   ```
2. Run the `BilinearAccumulatorExample` class:
   ```bash
   java -cp ".:lib/*" BilinearAccumulatorExample
   ```
3. The output will show the accumulator value after insertion and the membership witness for an element in the set.