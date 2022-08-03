import unittest
import sys
from src import maximum_difference


class Testwordcount(unittest.TestCase):
    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass

    def test_maximum_one(self):
        self.stream_in.write('7 1 5 4')
        maximum_difference.cal_max_difference()
        expect = '4'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)


    def test_maximum_two(self):
        self.stream_in.write('9 4 3 2')
        maximum_difference.cal_max_difference()
        expect = '-1'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)


    def test_maximum_three(self):
        self.stream_in.write('6 234 53 1 23 5635 742 5300 43875 385 542')
        maximum_difference.cal_max_difference()
        expect = '43874'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)


    def test_maximum_four(self):
        self.stream_in.write('888 777 666 555 444 333')
        maximum_difference.cal_max_difference()
        expect = '-1'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)


    def test_maximum_five(self):
        self.stream_in.write('1 2 4 5 6 7 10')
        maximum_difference.cal_max_difference()
        expect = '9'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)


    def test_maximum_six(self):
        self.stream_in.write('52349 485917 34595 213485 345890 123412 23841 543289')
        maximum_difference.cal_max_difference()
        expect = '519448'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)


    def tearDown(self):
        sys.stdout = self.out_stream
        sys.stdin = self.in_stream
        pass

class MyStream:

    def __init__(self):
        self.buff = []
        self.write_count = 0

    def write(self, output_stream):
        self.buff.append(output_stream)

    def readline(self):
        if len(self.buff) > 0:
            cur = self.buff[0]
            del self.buff[0]
            return cur

if __name__ == '__main__':
    unittest.main
