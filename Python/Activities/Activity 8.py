num_list=list(input("Enter input number:").split(","))
if(num_list[-1]==num_list[0]):
    print("First and last numbers are same")
else:
    print("First and last numbers are different")