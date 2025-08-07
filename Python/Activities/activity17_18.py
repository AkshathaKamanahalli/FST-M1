import pandas as pd

# writing data to csv file (Activity 17)

# create a dataset
data= {

    "Usernames" :["admin","charles","Deku"],
    "Passwords" :["password","charl13","Almight"]

}

#Convert the data into dataframe
df=pd.DataFrame(data)

#Write the DataFrame to a csv file
df.to_csv("./sample.csv",index=False)


#Reading data from csv file (Activity 18)
input_data=pd.read_csv("./sample.csv")
#print the Entire DataFrame
#input_data["Permissions"]=["Read","Write","Execute"]

#to insert data in csv
#ilock
#To add new row by concatinating dataframes:
new_row = pd.DataFrame({
    "Usernames": ["new_user"],
    "Passwords": ["new_password"]
})
input_data = pd.concat([input_data, new_row]).reset_index(drop=True)
print(input_data)

# Print the values only in the Usernames column
print("==============Usernames Columns=============")
print(input_data["Usernames"])


#  Print the username and password of the second row
print("==============Second Row Data=============")
print(input_data["Usernames"][1],input_data["Passwords"][1])

#  Sort the Usernames column data in ascending order and print data
print("==============Sorted Usernames Column =============")
print(input_data.sort_values(by="Usernames"))


#  Sort the Passwords column in descending order and print data

print("==============Sorted Password Column =============")
print(input_data.sort_values(by="Passwords" , ascending=False))