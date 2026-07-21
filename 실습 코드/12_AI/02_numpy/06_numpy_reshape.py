import numpy as np

def n_reshape():
    print("== reshape ==")

    numbers = np.arange(12)
    print("원본 :", numbers)

    print("3행 4열:\n", numbers.reshape(3, 4))
    print("2행 6열:\n", numbers.reshape(2, 6))
    print()

def n_auto():
    print("== reshape(-1) 자동 계산 ==")

    numbers = np.arange(12)

    print("reshape(3, -1):\n", numbers.reshape(3, -1))
    print("reshape(-1, 2):\n", numbers.reshape(-1, 2))

def n_flatten():
    print("== flatten ==")
    # 다차원 -> 1차원(새 배열 생성)
    matrix = np.array([[1,2,3], [4,5,6]] )
    print("flatten:", matrix.flatten())
    print(matrix) # 원본유지

if __name__ == "__main__":
    n_reshape()
    n_auto(0)