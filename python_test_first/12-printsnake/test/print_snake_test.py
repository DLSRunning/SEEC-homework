import unittest
import sys
from src import print_snake


class TestPrintSnake(unittest.TestCase):
    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass

    def test_judge1(self):
        self.stream_in.write('3 3')
        print_snake.print_snake()
        result = ''.join(self.stream_out.buff)
        self.assertEqual(result, "###\n..#\n###")

    def test_judge2(self):
        self.stream_in.write('5 4')
        print_snake.print_snake()
        result = ''.join(self.stream_out.buff)
        self.assertEqual(result, "####\n...#\n####\n#...\n####")

    def test_judge3(self):
        self.stream_in.write('3 4')
        print_snake.print_snake()
        result = ''.join(self.stream_out.buff)
        self.assertEqual(result, "####\n...#\n####")

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
