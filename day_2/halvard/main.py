
shapes = {
    'A': 'Rock',
    'B': 'Paper',
    'C': 'Scissors',
    'X': 'Rock',
    'Y': 'Paper',
    'Z': 'Scissors'
}

points = {
    'Rock': 1,
    'Paper': 2,
    'Scissors': 3,
    'Loses': 0,
    'Draw': 3,
    'Wins': 6
}

outcome = {
    'Rock': {
        'Rock': 'Draw',
        'Scissors': 'Loses',
        'Paper': 'Wins'
    },
    'Paper': {
        'Rock': 'Loses',
        'Scissors': 'Wins',
        'Paper': 'Draw'
    },
    'Scissors': {
        'Rock': 'Wins',
        'Scissors': 'Draw',
        'Paper': 'Loses'
    }
}

#Part 2
outcome_shape = {
    shapes['X']: 'Loses',
    shapes['Y']: 'Draw',
    shapes['Z']: 'Wins'
}

outcome_2 = {
    key: {val: key2 for (key2, val) in value.items()} for (key, value) in outcome.items()
}

# Part 1
with open('input.txt') as f:
    games = [[shapes[shape] for shape in line.strip().split(' ')] for line in f]

    def get_outcome(game):
        elf, you = game[0], game[1]
        game_outcome = outcome[elf][you]
        return points[you] + points[game_outcome]

    print(sum(map(get_outcome, games)))

    # Part 2
    def get_outcome_2(game):
        elf, you = game[0], game[1]
        game_outcome = outcome_shape[you]
        elf_played = outcome_2[elf]
        you_played = elf_played[game_outcome]
        return points[you_played] + points[game_outcome]

    print(sum(map(get_outcome_2, games)))
