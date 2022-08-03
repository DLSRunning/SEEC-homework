x = int(0)
y = int(0)

def move(judge):
    global x
    global y

    if judge == 'U':
        y -= 1

    if judge == 'D':
        y += 1

    if judge == 'R':
        x += 1

    if judge == 'L':
        x -= 1

def logo_play():
    global x
    global y
    x = 0
    y = 0
    is_draw = int(1)

    result = {}
    for i in range(0, 100):
        result[i] = ' '

    tmp = str(0)

    is_succeed = int(1)
    while True:
        origin = input()
        order = origin.split()

        if order[0] == "end":
            if x > 9 or y > 9 or x < 0 or y < 0:
                is_succeed = 0
            if is_succeed == 1:
                for i in range(0, 100):
                    print(result[i], end="")
                    if (i + 1) % 10 == 0:
                        print()
            else:
                print("Error!")
            return
        elif order[0] == 'move':
            if len(order) > 3:
                tmp = str(order[3])
            for i in range(0, int(order[2])):
                move(order[1])
                if is_draw:
                    result[x + 10 * y] = tmp
        elif order[0] == 'pen_up':
            is_draw = 0
        elif order[0] == 'pen_down':
            is_draw = 1
        elif order[0] == 'cross':
            if len(order) > 2:
                tmp = str(order[2])
            if is_draw:
                result[x + y * 10] = tmp
                for i in range(1, int(order[1]) + 1):
                    result[x - i + y * 10] = tmp
                    result[x + i + y * 10] = tmp
                    result[x + (y - i) * 10] = tmp
                    result[x + (y + i) * 10] = tmp
            if x - int(order[1]) < 0 or x + int(order[1]) > 9 or y - int(order[1]) < 0 or y + int(order[1]) > 9:
                is_succeed = 0
        elif order[0] == 'rect':
            if len(order) > 3:
                tmp = order[3]
            if is_draw:
                for i in range(0, int(order[1])):
                    result[x + i + y * 10] = tmp
                    result[x + i + (y + int(order[2]) - 1) * 10] = tmp
                for j in range(0, int(order[2])):
                    result[x + (y + j) * 10] = tmp
                    result[x + int(order[1]) - 1 + (y + j) * 10] = tmp
                if x + int(order[1]) - 1 > 9 or y + int(order[2]) - 1 > 9:
                    is_succeed = 0
        elif order[0] == 'rect_f':
            if len(order) > 3:
                tmp = order[3]
            if is_draw:
                for i in range(0, int(order[1])):
                    for j in range(0, int(order[2])):
                        result[x + i + (y + j) * 10] = tmp
            if x + int(order[1]) - 1 > 9 or y + int(order[2]) - 1 > 9:
                is_succeed = 0

if __name__ == '__main__':
    logo_play()