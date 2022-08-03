def cal_amount_of_lolipop():
    a,b = map(int, input().split())

    total = a * 10 + b

    price = 67

    number = total // price

    print(number)

    return

if __name__ == '__main__':
    cal_amount_of_lolipop()

