def get_smaller(val1, val2):
    if val1 < val2:
        return val1

    if val1 > val2:
        return val2

    raise ValueError("Values are equal")
