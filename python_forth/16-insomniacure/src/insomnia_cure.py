
def solve():
    k = int(input())
    l = int(input())
    m = int(input())
    n = int(input())
    d = int(input())

    survival = []

    for i in range(0, d):
        survival.append('1')

    for i in range(k, d + 1, k):
        survival[i - 1] = '0'
    for i in range(l, d + 1, l):
        survival[i - 1] = '0'
    for i in range(m, d + 1, m):
        survival[i - 1] = '0'
    for i in range(n, d + 1, n):
        survival[i - 1] = '0'

    number = int(0)
    for i in range(0, d):
        if survival[i] == '0':
            number += 1
    print(number)
    return

if __name__ == '__main__':
    solve()