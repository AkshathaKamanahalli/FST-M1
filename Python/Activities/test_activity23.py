import pytest

@pytest.mark.activity
def test_sum(num_list):
	
 # Initialize sum
	
    sum = 0
	
 # Calculate the sum of numbers in the list
	
    for n in num_list:
	
        sum += n
# Assertion

    assert sum == 55