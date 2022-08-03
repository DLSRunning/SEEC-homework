
import csv

def getcommand(file):
    n = int(input())
    for i in range(0, n):
        order = input()
        order = order.split(' ')
        if order[0] == 'INSERT':
            with open(file, 'a') as file_project:
                file_project.write('\n' + order[1])
                file_project.close()
        if order[0] == 'SHOWALL':
            with open(file, 'r') as file_project:
                lines = file_project.readlines()
                for j in range(0, len(lines)):
                    lines[j] = (lines[j].rstrip()).split(',')
                lines.sort(key=lambda x: int(x[2]))
                len1 = len(max(lines, key=lambda x: len(x[0]))[0])
                len2 = len(max(lines, key=lambda x: len(x[1]))[1])
                avg = sum(int(lines[j][2]) for j in range(0, len(lines))) / len(lines)

                name = 'Name'
                title = 'Title'
                while len(name) < len1 + 1:
                    name += ' '
                while len(title) < len2 + 1:
                    title += ' '
                for j in range(0, len(lines)):
                    while len(lines[j][0]) < len1 + 1:
                        lines[j][0] += ' '
                    while len(lines[j][1]) < len2 + 1:
                        lines[j][1] += ' '
                print(name + title + 'Salary')
                for j in range(0, len(lines)):
                    print(lines[j][0] + lines[j][1] + str('{:.2f}'.format(int(lines[j][2]))))
                print('AVG:' + str('{:.2f}'.format(avg)))
    return


if __name__ == '__main__':
    getcommand('C:/Users/DLSRunning/Desktop/SEEC_homework/fifth/23-readcsv/test/resource-1.csv')