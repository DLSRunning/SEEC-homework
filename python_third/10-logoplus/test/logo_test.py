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
        input_str = ["move R 3 X\n",
                     "move D 5 Y\n",
                     "end\n"]
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
        output="".join(output_str)
        result=str(self.stream_out.readall())
        self.assertEqual(result,output)


    def test2(self):
        input_str = ["rect 3 5 a \n",
                     "end\n"]
        output_str = ["aaa       \n",
                      "a a       \n",
                      "a a       \n",
                      "a a       \n",
                      "aaa       \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        output = "".join(output_str)
        result = str(self.stream_out.readall())
        self.assertEqual(result, output)

    def test3(self):
        input_str = ["rect_f 4 6 b\n",
                     "end\n"]
        output_str = ["bbbb      \n",
                      "bbbb      \n",
                      "bbbb      \n",
                      "bbbb      \n",
                      "bbbb      \n",
                      "bbbb      \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        output = "".join(output_str)
        result = str(self.stream_out.readall())
        self.assertEqual(result, output)

    def test4(self):
        input_str = ["pen_up\n",
                     "move D 3\n",
                     "move R 3\n",
                     "pen_down\n",
                     "cross 3 c\n",
                     " end\n"]
        output_str = ["   c      \n",
                      "   c      \n",
                      "   c      \n",
                      "ccccccc   \n",
                      "   c      \n",
                      "   c      \n",
                      "   c      \n",
                      "          \n",
                      "          \n",
                      "          \n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        output = "".join(output_str)
        result = str(self.stream_out.readall())
        self.assertEqual(result, output)

    def test5(self):
        input_str = ["pen_up\n",
                     "move D 3\n",
                     "move R 3\n",
                     "pen_down\n",
                     "cross  4 c\n",
                     "end\n"]
        output_str = ["Error!\n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        output = "".join(output_str)
        result = str(self.stream_out.readall())
        self.assertEqual(result, output)

    def test6(self):
        input_str = ["rect 2 2 a\n",
                     "pen_up\n",
                     "move D 2\n",
                     "move R 2\n",
                     "pen_down\n",
                     "rect 2 2 b\n",
                     "pen_up\n",
                     "move D 2\n",
                     "move R 2\n",
                     "pen_down\n",
                     "rect 2 2 c\n",
                     "pen_up\n",
                     "move D 2\n",
                     "move R 2\n",
                     "pen_down\n",
                     "rect 2 2 d\n",
                     "end\n"]
        output_str = ["aa        \n",
                      "aa        \n",
                      "  bb      \n",
                      "  bb      \n",
                      "    cc    \n",
                      "    cc    \n",
                      "      dd  \n",
                      "      dd  \n",
                      "          \n",
                      "          \n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        output = "".join(output_str)
        result = str(self.stream_out.readall())
        self.assertEqual(result, output)

    def test7(self):
        input_str = ["rect 5 1 a\n",
                     "rect 1 4 b\n",
                     "end\n"]
        output_str = ["baaaa     \n",
                      "b         \n",
                      "b         \n",
                      "b         \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n",
                      "          \n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        output = "".join(output_str)
        result = str(self.stream_out.readall())
        self.assertEqual(result, output)

    def test8(self):
        input_str = ["pen_up\n",
                     "move R 8\n",
                     "move D 8\n",
                     "pen_down\n",
                     "rect 3 3 x\n",
                     "end\n"]
        output_str = ["Error!\n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        output = "".join(output_str)
        result = str(self.stream_out.readall())
        self.assertEqual(result, output)

    def test9(self):
        input_str = ["rect 10 10 p\n",
                     "pen_up\n",
                     "move R 6\n",
                     "move D 3\n",
                     "pen_down\n",
                     "cross 3\n",
                     "move L 6\n",
                     "rect 7 7\n",
                     "end\n"]
        output_str = ["pppppppppp\n",
                      "p     p  p\n",
                      "p     p  p\n",
                      "pppppppppp\n",
                      "p     p  p\n",
                      "p     p  p\n",
                      "p     p  p\n",
                      "p     p  p\n",
                      "p     p  p\n",
                      "pppppppppp\n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        output = "".join(output_str)
        result = str(self.stream_out.readall())
        self.assertEqual(result, output)

    def test10(self):
        input_str = ["rect_f 10 10 a\n",
                     "rect_f 9 9 b\n",
                     "rect_f 8 8 c\n",
                     "rect_f 7 7 d\n",
                     "rect_f 6 6 e\n",
                     "rect_f 5 5 f\n",
                     "rect_f 4 4 g\n",
                     "rect_f 3 3 h\n",
                     "rect_f 2 2 i\n",
                     "rect_f 1 1 j\n",
                     "end\n"]
        output_str = ["jihgfedcba\n",
                      "iihgfedcba\n",
                      "hhhgfedcba\n",
                      "ggggfedcba\n",
                      "fffffedcba\n",
                      "eeeeeedcba\n",
                      "dddddddcba\n",
                      "ccccccccba\n",
                      "bbbbbbbbba\n",
                      "aaaaaaaaaa\n"]
        for i in range(len(input_str)):
            self.stream_in.write(input_str[i])
        logo.logo_play()
        output = "".join(output_str)
        result = str(self.stream_out.readall())
        self.assertEqual(result, output)

    def tearDown(self):
        sys.stdout = self.out_stream
        sys.stdin = self.in_stream
        pass


class MyStream:

    def __init__(self):
        self.buff = []

    def write(self, output_stream):
        self.buff.append(output_stream)

    def readall(self):
        result = ''
        while len(self.buff)>0:
            cur=self.buff[0]
            del self.buff[0]
            result=result+cur
        return result

    def readline(self):
        result = ''
        while len(self.buff) > 0:
            cur = self.buff[0]
            del self.buff[0]
            result = result + cur
            if result.endswith('\n'):
                return result
        return result
