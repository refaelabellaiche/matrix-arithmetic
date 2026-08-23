# Matrix Arithmetic Library (Java)

An integer matrix implementation built for an Object-Oriented Programming
course assignment (Grade: 100/100), focused on interface design, a custom
exception hierarchy, and defensive programming.

## What it does

`Matrix` implements two interfaces:
- **`Arithmetic`** — `add`, `sub`, `mul`, `div`. Addition and subtraction are
  implemented for same-size matrices; multiplication and division are
  intentionally unsupported for this representation and throw dedicated
  exceptions instead of failing silently.
- **`InputOutput`** — `read` (reads matrix values from the user, re-prompting
  on invalid input instead of crashing) and `write` (prints the matrix).

It also overrides `equals()` for content-based comparison, and implements
`clone()` for deep copies (so the copy doesn't share its underlying array
with the original).

## Custom exception hierarchy

All matrix-specific errors extend a common `MatrixException` (unchecked),
so callers can catch broadly or specifically:

```
MatrixException
├── InvalidMatrixSizeException     (non-positive dimensions in the constructor)
├── IncompatibleDimensionsException (add/sub on mismatched sizes)
├── IllegalComparisonException      (equals() against a non-Matrix, or mismatched sizes)
├── MultOperationNotSupported       (mul() is not defined for this representation)
└── DivOperationNotSupported        (div() is not defined for this representation)
```

## Project structure

```
matrix-arithmetic/
└── src/
    ├── Arithmetic.java                     # interface: add, sub, mul, div
    ├── InputOutput.java                     # interface: read, write
    ├── Matrix.java                           # main implementation
    ├── MatrixException.java                  # base exception
    ├── InvalidMatrixSizeException.java
    ├── IncompatibleDimensionsException.java
    ├── IllegalComparisonException.java
    ├── MultOperationNotSupported.java
    ├── DivOperationNotSupported.java
    └── Program.java                          # demo / manual test driver
```

## Running it

```bash
cd src
javac *.java
java Program
```

`Program` creates two 3x3 matrices, reads their values from standard input,
then demonstrates addition, subtraction, equality comparison, cloning, and
bounds-checked value access — printing the result (or the caught exception
message) for each.
