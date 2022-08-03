import unittest
import sys
from src import logo


class Test(unittest.TestCase):

    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass

    def test1(self):
        input_str = ["2\n",
                     "R 3 X\n",
                     "D 5 Y\n"]
        output_str = [" XXX      \n",
                      "   Y      \n",
                      "   Y      \n",
                      "   Y      \n",
                      "   Y      \n",
                      "   Y      \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        for i in range(len(output_str)):
            result = str(self.stream_out.readline())
            self.assertEqual(result, output_str[i])

    def test2(self):
        input_str = ["3\n",
                     "D 2 1\n",
                     "R 4\n",
                     "U 1 2\n"]
        output_str = ["          \n",
                      "1   2     \n",
                      "11111     \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        for i in range(len(output_str)):
            result = str(self.stream_out.readline())
            self.assertEqual(result, output_str[i])

    def test3(self):
        input_str = ["3\n",
                     "R 1 N\n",
                     "U 3 E\n",
                     "D 7 G\n"]
        output_str = ["Error!\n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        for i in range(len(output_str)):
            result = str(self.stream_out.readline())
            self.assertEqual(result, output_str[i])

    def test4(self):
        input_str = ["5\n",
                     "D 4 A\n",
                     "R 9 B\n",
                     "U 4 C\n",
                     "L 5 D\n",
                     "D 9 E\n"]
        output_str = ["    DDDDDC\n",
                      "A   E    C\n",
                      "A   E    C\n",
                      "A   E    C\n",
                      "ABBBEBBBBB\n",
                      "    E     \n",
                      "    E     \n",
                      "    E     \n",
                      "    E     \n",
                      "    E     \n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        for i in range(len(output_str)):
            result = str(self.stream_out.readline())
            self.assertEqual(result, output_str[i])

    def test5(self):
        input_str = ["11\n",
                    "R 9 A\n",
                    "D 9\n",
                    "L 9 R\n",
                    "U 7\n",
                    "R 7 C\n",
                    "D 5\n",
                    "L 5 A\n",
                    "U 3\n",
                    "R 3 E\n",
                    "D 1\n",
                    "L 1 A\n"]
        output_str = [" AAAAAAAAA\n",
                      "         A\n",
                      "RCCCCCCC A\n",
                      "R      C A\n",
                      "R AEEE C A\n",
                      "R A AE C A\n",
                      "R A    C A\n",
                      "R AAAAAC A\n",
                      "R        A\n",
                      "RRRRRRRRRA\n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        for i in range(len(output_str)):
            result = str(self.stream_out.readline())
            self.assertEqual(result, output_str[i])

    def test6(self):
        input_str = ["2\n",
                    "R 5 X\n",
                    "L 6 Y\n"]
        output_str = ["Error!\n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        for i in range(len(output_str)):
            result = str(self.stream_out.readline())
            self.assertEqual(result, output_str[i])

    def test7(self):
        input_str = ["4\n",
                    "R 5 X\n",
                    "D 6 Y\n",
                    "U 4 Z\n",
                    "D 2 W\n"]
        output_str = [" XXXXX    \n",
                      "     Y    \n",
                      "     Z    \n",
                      "     W    \n",
                      "     W    \n",
                      "     Z    \n",
                      "     Y    \n",
                      "          \n",
                      "          \n",
                      "          \n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        for i in range(len(output_str)):
            result = str(self.stream_out.readline())
            self.assertEqual(result, output_str[i])
    def tearDown(self):
        sys.stdout = self.out_stream
        sys.stdin = self.in_stream
        pass


class MyStream:

    def __init__(self):
        self.buff = []

    def write(self, output_stream):
        self.buff.append(output_stream)

    def readline(self):
        result = ''
        while len(self.buff) > 0:
            cur = self.buff[0]
            del self.buff[0]
            result = result + cur
            if result.endswith('\n'):
                return result
        return result
