
def binarySearch(arr, T, l, r, key): 
    while (r - l > 1): 
        m = l + (r - l)//2
        if (arr[T[m]] >= key): 
            r = m 
        else: 
            l = m 
    return r 
def LongestIncreasingSubsequence(arr): 
    t =[0 for i in range(len(arr) + 1)]   
    prev =[-1 for i in range(len(arr) + 1)]    
    ans = 1 
    for i in range(1, len(arr)): 
      
        if (arr[i] < arr[t[0]]):  
            t[0] = i 
          
        elif (arr[i] > arr[t[ans-1]]): 
            prev[i] = t[ans-1] 
            t[ans] = i 
            ans += 1
          
        else: 
            pos = binarySearch(arr, t, -1, 
                                   ans-1, arr[i]) 
   
            prev[i] = t[pos-1] 
            t[pos] = i 
    i = t[ans-1] 
    while(i >= 0): 
        i = prev[i] 
    return ans