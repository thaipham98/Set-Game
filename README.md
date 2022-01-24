# Set-Game

This is a Set-Game solver programmed with Java. 

The program’s output should consist of:
1. A single line containing the number of possible SETs of three cards in the input.
2. A single line containing the maximum number of disjoint SETs in the input.
3. The cards forming a largest collection of disjoint SETs, each card on its own line and each SET preceded by a blank line.

## Usage

1. Clone this Github repo or download the zip file.
2. Open terminal of choice and cd into the Set-Game directory.
3. Cd into source folder:

```bash
cd src
```

## Compile program

First, we need to compile all .java files at `src/com/game`

```bash
javac com/game/*.java
```

## Test

Run the below command to test against 2 provided sample test cases

```bash
java com.game.Test
```

## Run with customized test case

1. Create a test case as .txt file and put it into the `Set-Game/src` directory.
2. Make sure you are still at src directory (parent directory).
3. Run the program agaisnt the test case with below command: 

For Windows Command Prompt:

```bash
type [test folder name] | java com.game.Main
```

For Macs Terminal: 

```bash
cat [test folder name] | java com.game.Main
```

For example, I use Windows so I run with `input.txt`:

```bash
type input.txt | java com.game.Main
```

With Macs:

```bash
cat input.txt | java com.game.Main
```


