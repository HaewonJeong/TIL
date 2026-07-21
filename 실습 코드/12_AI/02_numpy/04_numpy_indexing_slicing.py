import numpy as np

def n_index_1d():
    print("== 1차원 인덱싱 ==")
    scores = np.array([90, 80, 75, 100, 85])
    print("scores[0]   :", scores[0])
    print("scores[-1]   :", scores[-1])
    print("scores[2]   :", scores[2])
    print("scores[4]   :", scores[4])
    print("scores[-2]   :", scores[-2])

def n_index_2d():
    print("== 2차원 인덱싱[행, 열] ==")
    scores = np.array([
        [90, 80, 50],
        [85, 95, 75],
        [100, 90, 80]
    ])

    print("scores[0,0] > 첫 학생 첫 점수: ", scores[0, 0])
    print("scores[1,2] > 두번째 학생 세번째 점수: ", scores[1, 2])
    print("scores[-1,-1] > 마지막/마지막: ", scores[-1, -1])

def n_slice_1d():
    print("== 1차원 슬라이싱 ==")
    numbers = np.arange(10)   # [0, 1, .... , 9]
    print("원본         :", numbers)
    print("앞에서 5개   :", numbers[:5])
    print("뒤에서 3개   :", numbers[-3:])
    print("2칸씩        :", numbers[::2])
    print("역순         :", numbers[::-1])
    # start부터 end미만까지 step만큼 가져온다.

def n_slice_2d():
    print("== 2차원 슬라이싱 ==")
    students = np.array([
        [90, 80, 50],
        [85, 95, 75],
        [100, 90, 80]
    ])
    # 콜론(:)은 해당 방향의 전체를 의미
    print("첫번째 행[0,:]   :", students[0, :])
    print("첫번째 열[:,0]   :", students[:, 0])
    print("앞의 두 행 [:2, :] :\n", students[:2, :])
    print("마지막 두 열[:,1:] :\n", students[:, 1:])

def n_fancy():
    print("== Fancy Indexing ==")
    numbers = np.arange(10)
    # 원하는 위치 번호들을 리스트로 묶어서 한 번에 가져온다.
    print("numbers[[1, 3, 5]]  : ", numbers[[1, 3, 5]])

    students = np.array([
        [90, 80, 50],
        [85, 95, 75],
        [100, 90, 80]
    ])
    print("students[[0, 2]]  :\n", students[[0, 2]])


def n_boolean(): # 조건에 맞는것만
    print("== Boolean Indexing ==")
    scores = np.array([90, 74, 68, 60, 95])
    print("80점 이상 : ", scores[scores >= 80])

    numbers = np.arange(10)
    print("짝수만   :", numbers[numbers % 2 == 0])

def n_flatten():
    print("== flatten() ==")
    matrix = np.array([[1,2,3], [4,5,6]])
    print("flattenl: ", matrix.flatten())
    r = matrix.flatten()
    r[0] = 100

    print(matrix) # 가능하면 원본 메모리를 유지

def n_ravel():
    print("== ravel() ==")
    matrix = np.array([[1,2,3], [4,5,6]])
    print("ravel: ", matrix.ravel())
    r = matrix.ravel()
    r[0] = 100

    print(matrix) # 가능하면 원본 메모리를 유지

def n_transpose():
    print("== transpose() ==")

    matrix = np.array([
        [1, 2, 3],
        [4, 5, 6]
    ])

    print("원본")
    print(matrix)

    print("transpose():")
    print(matrix.transpose())

    print("T (축약)")
    print(matrix.T)

if __name__ == "__main__":
    n_index_1d()
    n_index_2d()
    n_slice_1d()
    n_slice_2d()
    n_fancy()
    n_boolean()