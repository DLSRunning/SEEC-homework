def special_typing():
    n = int(input())
    for i in range(0, n):
        s = list(input())
        t = list(input())
        judge = int(0)
        position_0 = []
        for k in range(0, len(s)):
            if s[k] == t[0] and k + len(t) <= len(s):
                position_0.append(int(k))
        for m in range(0, len(position_0)):
            position = position_0[m] + 1
            for j in range(1, len(t)):
                while position < len(s) and t[j] != s[position]:
                    position += 2
                position += 1
            if (len(s) - position) % 2 == 0 and position <= len(s):
                judge = 1
                break
        if judge == 1:
            print('YES')
        else:
            print('NO')

    return

if __name__ == '__main__':
    special_typing()