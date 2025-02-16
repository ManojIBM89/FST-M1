def fibonacci(num):
    if num<=1:
        return num
    else:
        return(fibonacci(num-1)+fibonacci(num-2))
#Entering the numbers
inputnum = int(input("Enter the numbers:"))
#Giving error if user enters less than 1 digit
if (inputnum<=0):
    print("Please enter positive number")
else:
    print("---Here is the Fibonacci series---")
    for i in range(inputnum):
        print(fibonacci(i))

    
    
    
    
