
def to_do():
    file_path = './resource.txt'

    with open(file_path, 'r') as file_project:
        file = file_project.readlines()
        data = []
        for row in file:
            row = row.strip('\n')
            tmp_list = row.split(' ')
            for number in tmp_list:
                data.append(int(number))

        avg = sum(data) / len(data)
        result = int(0)
        for number in data:
            result = (number - avg)**4 + result

        print(result / 120)


if __name__ == '__main__':
    to_do()

