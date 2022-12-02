with open("input.txt") as f:
    lines = f.readlines()

    shape_points = {
            'X': 1,
            'Y': 2,
            'Z': 3
            }

    outcome = {
            'AX': 3, 'AY': 6, 'AZ': 0,
            'BX': 0, 'BY': 3, 'BZ': 6,
            'CX': 6, 'CY': 0, 'CZ': 3
            }

    # part 2
    outcome_2 = {
            'AX': 'Z', 'AY': 'X', 'AZ': 'Y',
            'BX': 'X', 'BY': 'Y', 'BZ': 'Z',
            'CX': 'Y', 'CY': 'Z', 'CZ': 'X'
            }

    outcome_points = {
            'X': 0,
            'Y': 3,
            'Z': 6,
            }

    score, score_2 = 0, 0
    for line in lines:
        elf, me = line.split(" ")

        score += shape_points[me[0]] + outcome[elf + me[0]]

        # part 2
        outcome_shape = outcome_2[elf + me[0]]
        score_2 += shape_points[outcome_shape] + outcome_points[me[0]]
    print(f"Score P1: {score}. Score P2: {score_2}")
