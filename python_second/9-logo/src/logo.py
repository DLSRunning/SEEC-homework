
def logo_play():
    number = int(input())
    order = []

    for i in range(0, number):
        order.append(input())

    x = int(0)
    y = int(0)

    issucceed = int(1)

    result = {}
    for i in range(0, 100):
        result[i] = ' '

    for i in range(0, number):
        for j in range(0, int(order[i][2])):
            if order[i][0] == 'U':
                y -= 1

            if order[i][0] == 'D':
                y += 1

            if order[i][0] == 'R':
                x += 1

            if order[i][0] == 'L':
                x -= 1
            if len(order[i]) > 3:
                result[x + 10 * y] = str(order[i][4])
                tmp = str(order[i][4])
            else:
                result[x + 10 * y] = tmp
        if x > 9 or y > 9 or x < 0 or y < 0:
            issucceed = 0

    if issucceed == 1:
        for i in range(0, 100):
            print(result[i], end="")
            if (i + 1) % 10 == 0:
                print()
    else:
        print("Error!")

    return

if __name__ == '__main__':
    logo_play()