def rod(length, price, cost):
    value = list()
    value.append(0)
    m = -1
    for i in range(1,length):
        m = price[i]
        for j in range(1,i-1):
            m = max(m,price[i]+value[i-j]-cost)
        value[i] = max
    return value[length]