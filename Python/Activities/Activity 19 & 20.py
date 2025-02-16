# Import pandas
import pandas
from pandas import ExcelWriter

# Create a dictionary that will be used to create the DataFrame
data = {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

# Create the DataFrame that will be written to the excel file
dataframe = pandas.DataFrame(data)

# Print the dataframe
print(dataframe)

# Write the dataframe to a Excel file
writer = ExcelWriter('newexcel.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)

# Commit data to the Excel file
writer.close()
#Activity 20
#Printing the data in the excel sheet
print("Reading Excel and printing")
readexcel=pandas.read_excel("newexcel.xlsx")
print(readexcel)
#Printing number of rows and columns in the excel
rc=readexcel.shape
print("Printing number of rows and columns in the excel")
print(rc)
#Print the data in the emails column only
print("Print the data in the emails column only")
print(readexcel["Email"])
#Sort the data based on FirstName in ascending order and print the data
print("Sort the data based on FirstName in ascending order and print the data")
print(readexcel.sort_values("FirstName"))

