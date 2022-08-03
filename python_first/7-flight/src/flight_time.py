def flight_calculation():

    go = input()

    back = input()

    time1_hour = -(int(go[0]) * 10 + int(go[1]) - int(go[9])*10 - int(go[10]))

    time2_hour = -(int(back[0]) * 10 + int(back[1]) - int(back[9]) * 10 - int(back[10]))

    time1_minute = -(int(go[3]) * 10 + int(go[4]) - int(go[12]) * 10 - int(go[13]))

    time2_minute = -(int(back[3]) * 10 + int(back[4]) - int(back[12]) * 10 - int(back[13]))

    time1_second = -(int(go[6]) * 10 + int(go[7]) - int(go[15]) * 10 - int(go[16]))

    time2_second = -(int(back[6]) * 10 + int(back[7]) - int(back[15]) * 10 - int(back[16]))

    if len(go) > 18:
        time1_hour += 24 * int(go[20])

    if len(back) > 18:
        time2_hour += 24 * int(back[20])

    if time1_second < 0:
        time1_minute -= 1
        time1_second += 60

    if time1_minute < 0:
        time1_hour -= 1
        time1_minute += 60

    if time2_second < 0:
        time2_minute -= 1
        time2_second += 60

    if time2_minute < 0:
        time2_hour -= 1
        time2_minute += 60


    time_hour = int((time1_hour + time2_hour) / 2)
    time_minute = int((time1_minute + time2_minute) / 2)
    time_second = int((time1_second + time2_second) / 2)

    if (time1_hour + time2_hour) % 2 > 0:
        time_minute += 30

    if (time1_minute + time2_minute) % 2 > 0:
        time_second += 30

    if time_second >= 60:
        time_minute += 1
        time_second -= 60

    if time_minute >= 60:
        time_minute -= 60
        time_hour += 1

    if time_hour < 10:
        result1 = str(0)
    else:
        result1 = str(time_hour // 10)
    result2 = str(time_hour % 10)

    if time_minute < 10:
        result3 = str(0)
    else:
        result3 = str(time_minute // 10)
    result4 = str(time_minute % 10)

    if time_second < 10:
        result5 = str(0)
    else:
        result5 = str(time_second // 10)
    result6 = str(time_second % 10)

    print(result1 + result2 + ':' + result3 + result4 + ':' + result5 + result6)

    return

if __name__ == '__main__':
    flight_calculation()