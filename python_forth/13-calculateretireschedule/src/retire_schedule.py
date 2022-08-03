import datetime

def calculate():
	age = input('What is your current age?')

	retire = input('At what age would you like to retire?')

	year = datetime.datetime.now().year

	if int(retire) - int(age) > 0:
		print('You have '+str(int(retire) - int(age))+' years left until you can retire.')
	else:
		print('You have 0 years left until you can retire.')
	print('It\'s ' + str(year) + ', so you can retire in ' + str(year + int(retire) - int(age)) + '.')

	return

if __name__ == '__main__':
	calculate()
