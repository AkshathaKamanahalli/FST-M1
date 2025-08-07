import pandas as pd
from pandas import ExcelWriter


# writing data to Excel file (Activity 19)
#create the Dataset
data= {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Emails':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}
#.xlsx->workbook->sheets->rows
#Convert the datset into a Dataframe
df=pd.DataFrame(data)
#create an Excel writer object
writer=ExcelWriter("./sample.xlsx")
#Write the DtaFrame to an Excel File
df.to_excel(writer,sheet_name='Sheet1',index=False)
#Close the writer
writer.close()

#Reading from Excel File (Activity 20)
input_data=pd.read_excel("./sample.xlsx",sheet_name='Sheet1')

#Print the number of rows and columns
	
print("==============DataFrame Shape====================")
#print("Number of rows and columns:", DataFrame.shape)
print("Rows: ",input_data.shape[0],"Columns: ",input_data.shape[1])

#Print the data in the emails column only
	
print("=============Emails Column=================")
print(input_data["Emails"])

#Sort the data based on FirstName in ascending order and print the data

print("============Sorted By FirstName========================")
print(input_data.sort_values(by="FirstName"))
