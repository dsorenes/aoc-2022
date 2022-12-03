with open('input.txt') as f:
    pri1 = 0
    pri2 = 0
    l2 = []
    for line in f:
        l2.append(line)
        for char in line[:len(line)//2]:
            if char in line[len(line)//2:]:
                pri1 += ord(char)
                pri1 -= 96 if ord(char) > 96 else (64 - 26)
                break

        if len(l2) == 3:
            for char in l2[0]:
                if char in l2[1] and char in l2[2]:
                    pri2 += ord(char)
                    pri2 -= 96 if ord(char) > 96 else (64 - 26)
                    break
            l2 = []

    print(f"Part 1: {pri1}")
    print(f"Part 2: {pri2}")