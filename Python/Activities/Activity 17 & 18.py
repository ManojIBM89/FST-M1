#Activity 17
import pandas as pd
data = {
    "Usernames":["admin","Charles","Deku"],
    "Passwords":["password","Charl13","AllMight"]
}

table=pd.DataFrame(data)
print(table)
table.to_csv("sample.csv",index=False)
#Activity 18
#Entire Data
read_data=pd.read_csv("sample.csv")
print("Entire Data")
print(read_data)
#Print values in username columns
print("Print values in the User name columns")
print(read_data["Usernames"])
#print user name and password of 2nd row
print("print user name and password of 2nd row")
print(read_data["Usernames"][1],read_data["Passwords"][1])
#Sort the Usernames column data in ascending order and print data
print("Sort the Usernames column data in ascending order and print data")
print(read_data.sort_values("Usernames"))
#Sort the Passwords column in descending order and print data
print("Sort the Passwords column in descending order and print data")
print(read_data.sort_values("Passwords",ascending=False))