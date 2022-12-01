from itertools import groupby

# Part 1
with open('input.txt') as f:
    it = groupby(f, lambda line: line == '\n')
    groups = [sum(map(int, group)) for key, group in it if not key]
    print(max(groups))

    # Part 2
    print(sum(sorted(groups)[-3:]))