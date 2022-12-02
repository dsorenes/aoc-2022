def read_input(filename):
    with open(filename) as f:
        lines = f.readlines()

        return lines

if __name__ == '__main__':
    lines = read_input("input.txt")
    current_calories = 0
    calories = []
    for line in lines:
        if line != '\n':
            current_calories += int(line)
        else:
            calories.append(current_calories)
            current_calories = 0
    calories.sort()
    # part 1
    print(calories[-1])
    # part 2
    print(calories[-1] + calories[-2] + calories[-3])
