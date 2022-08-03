file_path = './tasks.txt'


def to_do():
    fp = open(file_path, 'a')

    while 1:
        with open(file_path) as file_project:
            file = file_project.readlines()

        order = input().split('"')
        i = int(0)
        while i < len(order):
            if order[i] == '' or order[i] == ' ':
                del order[i]
                i -= 1
            i += 1

        if order[0] == 'todo -a ':
            with open(file_path, 'a') as file_project:
                for i in range(1, len(order)):
                    file_project.write('todo:' + order[i] + '\n')
        elif order[0] == 'todo -d ':
            for i in range(1, len(order)):
                for j in range(0, len(file)):
                    if (file[j][:4] == 'todo' and file[j][5:] == order[i] + '\n') or (
                            file[j][:9] == 'completed' and file[j][10:] == order[i] + '\n'):
                        del file[j]
                        break
            with open(file_path, 'w') as file_project:
                for i in range(0, len(file)):
                    file_project.write(file[i])
        elif order[0] == 'todo -c ':
            for i in range(1, len(order)):
                for j in range(0, len(file)):
                    if file[j][:4] == 'todo' and file[j][5:] == order[i] + '\n':
                        file[j] = 'completed:' + order[i] + '\n'
                        break
            with open(file_path, 'w') as file_project:
                for i in range(0, len(file)):
                    file_project.write(file[i])
        elif order[0][6] == 'f':
            if order[0][8:] == 'todo':
                for i in range(0, len(file)):
                    if file[i][:4] == 'todo':
                        print(file[i].rstrip())
            else:
                for i in range(0, len(file)):
                    if file[i][:9] == 'completed':
                        print(file[i].rstrip())
        elif order[0] == 'todo -all':
            for i in range(0, len(file)):
                print(file[i].rstrip())
        elif order[0] == 'todo -quit':
            break

    return


if __name__ == '__main__':
    to_do()
