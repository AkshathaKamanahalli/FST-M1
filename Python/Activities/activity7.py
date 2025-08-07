"""
#Given list of numbers
numlist = [1,2,3,4,5]

#calculate sum of numbers in the list
sum=0
	
for num in numlist:
	
  sum += num
	
#print the sum
	
print(sum)
print("The sume of nums in the list is:", sum)
"""


numbers = input("Enter a sequence of comma separated values: ").split(',')
sum = 0

for number in numbers:
  sum += int(number)

print(sum)