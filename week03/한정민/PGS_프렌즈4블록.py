def solution(m, n, board):
    answer = 0
    board = [list(row) for row in board]
    
    while True:
        # 지워야 할 블록의 좌표 저장
        erased = set()
        
        for i in range(m-1):
            for j in range(n-1):
                if board[i][j] != ' ' and board[i][j] == board[i+1][j] == board[i][j+1] == board[i+1][j+1]:
                    erased.update([(i, j), (i+1, j), (i, j+1), (i+1, j+1)])
                    
        if not erased:
            break
        
        for x, y in erased:
            # 지운 블록은 공백으로 처리
            board[x][y] = ' '
        answer += len(erased)
        
        for j in range(n):
            remaining = [board[i][j] for i in range(m) if board[i][j] != ' ']
            for i in range(m - len(remaining)):
                board[i][j] = ' '
            for i in range(len(remaining)):
                board[m - len(remaining) + i][j] = remaining[i]
                
    return answer