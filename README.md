# Maze Solver

A Java-based desktop application that visualizes maze solving using the Depth-First Search (DFS) algorithm.

## Overview

This project demonstrates how graph traversal algorithms can be used to solve maze problems. The application provides a graphical interface where users can visualize the path-finding process from the start point to the destination.

## Features

* Interactive Java Swing user interface
* Maze traversal using Depth-First Search (DFS)
* Real-time path visualization
* Efficient backtracking mechanism
* Simple and modular code structure

## Tech Stack

* Java
* Java Swing
* Depth-First Search (DFS)

## Project Structure

```text
MazeUI.java    - User interface and maze visualization
dfs.java       - DFS algorithm implementation
```

## How It Works

1. The maze is represented as a grid.
2. The DFS algorithm starts from the source cell.
3. It explores each possible path recursively.
4. If a dead end is reached, the algorithm backtracks.
5. The process continues until the destination is found.

## Getting Started

### Prerequisites

* Java JDK 8 or above
* Any Java IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Run the Project

```bash
javac MazeUI.java dfs.java
java MazeUI
```

## Future Improvements

* Add Breadth-First Search (BFS) support
* Allow custom maze generation
* Add speed controls for visualization
* Compare different path-finding algorithms
* Export solved maze results

## Author

Anuj Kushwaha

* LinkedIn: https://linkedin.com/in/your-linkedin-profile
* GitHub: https://github.com/anujkus45
