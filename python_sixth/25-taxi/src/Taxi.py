
def solve():
    n = input()
    number = input()
    number = number.split(' ')
    number.sort()
    people = []
    for i in range(0, 4):
        people.append(int(0))
    for i in number:
        people[int(i) - 1] += 1

    cars = people[3] + int(people[1] / 2)
    people[1] = people[1] % 2
    if people[2] + people[1] >= people[0]:
        cars += people[2] + people[1]
    else:
        cars += people[2] + people[1] + int((people[0] - people[2] - people[1]) / 4)
        if (people[0] - people[2] - people[1]) % 4 != 0:
            cars += 1

    print(cars)

    return

if __name__ == '__main__':
	solve()
