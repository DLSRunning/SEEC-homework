
def process(result):
	final = str()
	for i in range(0, len(result)):
		if len(result[i]) > 1:
			final = final + result[i].title() + ','
	if len(final) > 2:
		final = final[:len(final) - 1]

	return final


if __name__ == '__main__':
	names = input()
	names = names.replace('[', '')
	names = names.replace(']', '')
	names = names.replace('\'', '')
	result = names.split(', ')

	print(process(result), end='')