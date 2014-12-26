import numpy as np

def readbinary(f, dims, dt):
    data = np.fromfile(f, dt)
    return np.reshape(data, dims)

# example
if __name__ == "__main__":
    example = readbinary("../rs-clj/data/nireland.dat", (472, 682, 128), np.int16)
