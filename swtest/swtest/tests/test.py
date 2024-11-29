import unittest
from src.compare import *


class TestCompare(unittest.TestCase):
    def test_parameter1(self):
        self.assertEqual(get_smaller(10, 11), 10)

    def test_parameter2(self):
        self.assertEqual(get_smaller(11, 10), 10)

    def test_same_value(self):
        with self.assertRaises(ValueError):
            get_smaller(4, 4)
