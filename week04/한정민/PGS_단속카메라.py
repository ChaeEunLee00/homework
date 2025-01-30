def solution(routes):
    answer = 0
    routes.sort(key = lambda x : x[1])
    camera = []

    while routes:
        camera.append(routes[0][1])
        temp = routes[0][1]
        routes.pop(0)
        
        i = 0
        while i < len(routes):
            if routes[i][0] <= temp <= routes[i][1]:
                routes.pop(i)
            else:
                i += 1
                
    answer = len(camera)
    return answer