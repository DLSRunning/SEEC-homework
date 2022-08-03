import unittest
import sys
from src import buy_lolipop


class TestCalc(unittest.TestCase):
    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass

    def test_buy_lolipop_one(self):
        self.stream_in.write('20 6')
        expect = '3'
        buy_lolipop.cal_amount_of_lolipop()
        result = self.stream_out.buff[0]
        self.assertEqual(expect, result)

    def test_buy_lolipop_two(self):
        self.stream_in.write('0 0')
        expect = '0'
        buy_lolipop.cal_amount_of_lolipop()
        result = self.stream_out.buff[0]
        self.assertEqual(expect, result)

    def test_buy_lolipop_three(self):
        self.stream_in.write('193 9')
        expect = '28'
        buy_lolipop.cal_amount_of_lolipop()
        result = self.stream_out.buff[0]
        self.assertEqual(expect, result)

    def test_buy_lolipop_four(self):
        self.stream_in.write('6 6')
        expect = '0'
        buy_lolipop.cal_amount_of_lolipop()
        result = self.stream_out.buff[0]
        self.assertEqual(expect, result)

    def test_buy_lolipop_five(self):
        self.stream_in.write('66 23')
        expect = '10'
        buy_lolipop.cal_amount_of_lolipop()
        result = self.stream_out.buff[0]
        self.assertEqual(expect, result)

    def test_buy_lolipop_six(self):
        self.stream_in.write('0 9')
        expect = '0'
        buy_lolipop.cal_amount_of_lolipop()
        result = self.stream_out.buff[0]
        self.assertEqual(expect, result)

    def test_buy_lolipop_seven(self):
        self.stream_in.write('99999 1')
        expect = '14925'
        buy_lolipop.cal_amount_of_lolipop()
        result = self.stream_out.buff[0]
        self.assertEqual(expect, result)

    def test_buy_lolipop_eight(self):
        self.stream_in.write('2147483648 0')
        expect = '320519947'
        buy_lolipop.cal_amount_of_lolipop()
        result = self.stream_out.buff[0]
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
        if len(self.buff) > 10000:
            sys.exit("Too many outputs, error! There may be an endless loop in your code!")

    def readline(self):
        if len(self.buff) > 0:
            cur = self.buff[0]
            del self.buff[0]
            return cur
        return ''
