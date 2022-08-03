def isPetyaLanguage():
    words = input().split(' ')

    result = []
    for i in range(0, 6):
        result.append(int(0))

    total = int(1)
    for word in words:
        judeg = word[-3:]
        if judeg == 'ios':
            result[0] += 1
        elif judeg == 'etr':
            result[1] += 1
            ios = result[0]
        elif judeg == 'tis':
            result[2] += 1
        elif judeg == 'ala':
            result[3] += 1
        elif judeg == 'tra':
            result[4] += 1
        elif judeg == 'tes':
            result[5] += 1
        else:
            total = 0
            break
        if  result[1] > 0 and ios != result[0]:
            total = 0
            break

    if total == 1 and (((result[1] == 1 or result[0] + result[1] + result[2] == 1) and result[3] + result[4] + result[5] == 0) or ((result[4] == 1 or result[3] + result[4] + result[5] == 1) and result[0] + result[1] + result[2] == 0)):
        print('YES')
    else:
        print('NO')

    return



if __name__ == '__main__':
    isPetyaLanguage()