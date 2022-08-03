def cal_max_difference():
    nums = input()
    n = int(0)

    for i in range(0, len(nums)):
        if nums[i] == " ":
            n += 1

    result = int(0)
    number = []

    for i in range(0, n + 1):
        number.append(int(nums.split(" ")[i]))

    for i in range(0, n + 1):
        for j in range(i, n + 1):
            tmp = number[j] - number[i]
            if tmp > result:
                result = tmp

    if result != 0:
        print(result, end="")
    else:
        print(-1, end="")

    return

if __name__ == '__main__':
    cal_max_difference()