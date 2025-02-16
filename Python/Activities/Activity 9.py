#Creating two lists
list1=[1,2,3,4,5]
list2=[6,7,8,9,10]
list3=[]
#adding the odd number in list 1
for i in range (0,5):
    if list1[i]%2!=0:
        list3.append(list1[i])
for j in range (0,5):
    if list2[j]%2==0:
        list3.append(list2[j])
print(list3)