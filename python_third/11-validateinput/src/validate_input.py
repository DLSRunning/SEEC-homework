
def validate():
    first_name = input('Enter the first name:')
    last_name = input('Enter the last name:')
    code = input('Enter the ZIP code:')
    id = input('Enter an employee ID:')

    if len(first_name) == 0:
        print("The first name must be filled in.")
    elif len(first_name) == 1:
        print('\"' + first_name + '\"' + ' is not a valid first name. It is too short.')

    if len(last_name) == 0:
        print("The last name must be filled in.")
    elif len(last_name) == 1:
        print('\"' + last_name + '\"' + ' is not a valid last name. It is too short.')

    if not code.isdigit():
        print('The ZIP code must be numeric.')

    if not (id[0:1].isalpha() and id[2] == '-' and id[3:6].isdigit()):
        print(id + ' is not a valid ID.')

    return

if __name__ == '__main__':
    validate()