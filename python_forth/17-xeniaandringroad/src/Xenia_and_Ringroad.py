
def solve():
    n, m = map(int, input().split())
    task = input()

    task = task.split(' ')

    position = int(1)
    steps = int(0)

    for i in range(0, m):
        while position != int(task[i]):
            position += 1
            if position > n:
                position = 1
            steps += 1

    print(steps)
    return

if __name__ == '__main__':
    solve()