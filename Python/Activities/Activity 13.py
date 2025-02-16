def calculator_sum(numbers):
    sum = 0
    for number in numbers:
        sum+=number
    return sum
#Define the list of numbers
numList=[10,20,40,90]
#calculate the numbers in the list
result= calculator_sum (numList)
print("The total sum is: "+str(result))