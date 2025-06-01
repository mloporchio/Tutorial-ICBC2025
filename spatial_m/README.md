# Spatial Query Authentication Example

This folder contains an example implementation, written in Java, of a spatial query authentication system using the Merkle R-tree data structure.

# Overview

This example demonstrates how to use a Merkle R-tree to authenticate spatial queries. The Merkle R-tree is a data structure that allows for efficient spatial indexing and verification of spatial queries.

# Requirements
- Java Development Kit (JDK) 11 or higher

# How to compile and run

## With Makefile
1. Ensure you have `make` installed on your system.
2. Open a terminal and navigate to the directory containing this README file.
3. Run the following command to compile:
   ```bash
   make
   ```
4. After compilation, run the example with:
    ```bash
    javac -cp "bin" Test data/crash_data.csv
    ```
5. To clean up the compiled files, run:
    ```bash
    make clean
    ```

## Without Makefile
1. Ensure you have JDK 11 or higher installed.
2. Open a terminal and navigate to the directory containing this README file.
3. Compile the Java files:
   ```bash
   javac -d bin *.java
   ```
4. After compilation, run the example with:
   ```bash
   java -cp "bin" Test data/crash_data.csv
   ```
5. To clean up the compiled files, you can manually delete the `bin` directory or use:
   ```bash
   rm -rf bin
   ```

# Dataset
The example uses a sample dataset located in the `data` directory. The `crash_data.csv` file contains spatial information that can be inserted in a Merkle R-tree and queried using the same data structure.

Points included in the dataset were collected from the _South Australia car crash dataset_ available at https://data.sa.gov.au/data/dataset/road-crash-data.