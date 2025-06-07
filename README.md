# Set Accumulators and their Applications to Blockchain Systems

This repository contains the presentation and source code for the examples shown during the tutorial "Set Accumulators and their Applications to Blockchain Systems", presented by Matteo Loporchio at IEEE ICBC 2025 - 7th International Conference on Blockchain and Cryptocurrency.

# Tutorial abstract

The development of novel blockchain protocols has renewed the interest in cryptographic techniques designed to ensure security, enhance user privacy, and maintain data integrity. Among such techniques, set accumulators stand out for their ability to compress large sets of elements into single and fixed-size values while enabling a number of authenticated operations on such sets. This tutorial aims to explore the primary applications of set accumulators in blockchain systems, highlighting their ability to improve scalability, efficiency, and privacy. The tutorial begins with a theoretical overview of set accumulators, followed by the presentation of four relevant applications to blockchain systems: query authentication, stateless transaction validation, anonymity enhancement, and identity management. For each use case, we present the main issues that can be tackled using accumulators and review several state-of-the-art proposals. We then provide a comprehensive discussion of the literature, highlighting common themes and open problems currently faced in each area. Finally, the tutorial concludes with a technical hands-on session demonstrating how set accumulators can be implemented in blockchain systems storing spatial information to efficiently retrieve and verify the integrity of on-chain data.

# Presentation

The PDF version of the tutorial presentation is available in the `presentation` folder.

# Source code

The source code for the examples is organized in two folders:

- `bilinear`: contains an example showing how to instantiate a bilinear accumulator scheme using the Cryptimeleon Java library.

- `spatial`: contains code for the implementation of a Merkle R-tree, an authenticated data structure that can be used to store and query spatial data efficiently.

# Requirements

To run the code, Java 11 or higher is required. The code has been tested with Oracle JDK 24.0.1.


