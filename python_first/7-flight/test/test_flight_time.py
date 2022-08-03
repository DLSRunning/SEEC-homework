import unittest
import sys
from src import flight_time


class TestCalc(unittest.TestCase):

    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass

    def test_one(self):
        self.stream_in.write('17:48:19 21:57:24')
        self.stream_in.write('11:05:18 15:14:23')
        flight_time.flight_calculation()
        expect = '04:09:05\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_two(self):
        self.stream_in.write('17:21:07 00:31:46 (+1)')
        self.stream_in.write('23:02:41 16:13:20 (+1)')
        flight_time.flight_calculation()
        expect = '12:10:39\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_three(self):
        self.stream_in.write('21:42:10 09:05:55 (+2)')
        self.stream_in.write('10:15:07 09:06:34')
        flight_time.flight_calculation()
        expect = '17:07:36\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_four(self):
        self.stream_in.write('23:07:00 14:56:20 (+1)')
        self.stream_in.write('09:22:18 04:03:50')
        flight_time.flight_calculation()
        expect = '05:15:26\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_five(self):
        self.stream_in.write('03:55:54 02:40:58 (+1)')
        self.stream_in.write('15:15:01 08:26:27 (+1)')
        flight_time.flight_calculation()
        expect = '19:58:15\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_six(self):
        self.stream_in.write('04:05:54 21:54:43 (+1)')
        self.stream_in.write('20:23:02 15:59:19')
        flight_time.flight_calculation()
        expect = '18:42:33\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_seven(self):
        self.stream_in.write('17:49:49 13:46:37 (+1)')
        self.stream_in.write('16:44:45 03:08:53')
        flight_time.flight_calculation()
        expect = '03:10:28\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_eight(self):
        self.stream_in.write('04:40:47 15:25:08 (+1)')
        self.stream_in.write('19:49:55 00:43:34 (+1)')
        flight_time.flight_calculation()
        expect = '19:49:00\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_nine(self):
        self.stream_in.write('03:27:46 05:07:32 (+1)')
        self.stream_in.write('01:52:21 19:06:21')
        flight_time.flight_calculation()
        expect = '21:26:53\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_ten(self):
        self.stream_in.write('22:01:06 01:16:06 (+2)')
        self.stream_in.write('21:12:23 07:21:47')
        flight_time.flight_calculation()
        expect = '06:42:12\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_eleven(self):
        self.stream_in.write('02:50:58 06:53:44 (+1)')
        self.stream_in.write('19:42:43 05:20:19')
        flight_time.flight_calculation()
        expect = '06:50:11\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_twelve(self):
        self.stream_in.write('14:28:27 21:52:54 (+1)')
        self.stream_in.write('20:12:58 16:04:13')
        flight_time.flight_calculation()
        expect = '13:37:51\n'
        result = ''
        for i in range(0, len(self.stream_out.buff)):
            result = result + self.stream_out.buff[i]
        self.assertEqual(expect, result)

    def test_thirteen(self):
        self.stream_in.write('10:19:19 20:41:24')
        self.stream_in.write('22:19:04 16:41:09 (+1)')
        flight_time.flight_calculation()
        expect = '14:22:05\n'
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
        if len(self.buff) > 1000:
            sys.exit("Too many outputs, error! There may be an endless loop in your code!")

    def readline(self):
        if len(self.buff) > 0:
            cur = self.buff[0]
            del self.buff[0]
            return cur
