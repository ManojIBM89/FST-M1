def calculatesum(num):
    if num:
        return num+calculatesum(num-1)
    else:
        return 0
    #calculatesum function calling here
res=calculatesum(10)
#print sum
print("The total sum is: ",res)