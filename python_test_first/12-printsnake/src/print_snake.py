
def print_snake():
    order = input()
    line = order.split(' ')
    r = int(line[0])
    c = int(line[1])

    for i in range(0, r):
        if i % 4 == 1:
            for j in range(0, c - 1):
                print('.', end='')
            print("#")
        elif i % 4 == 3:
            print("#", end='')
            for j in range(0, c - 1):
                print('.', end='')
            print()
        else:
            for j in range(0, c):
                print('#', end='')
            if i != r - 1:
                print()
    return


if __name__ == '__main__':
    print_snake()
