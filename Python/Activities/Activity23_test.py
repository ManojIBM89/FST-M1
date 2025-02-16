import pytest
	
@pytest.fixture
def num_list():
    fixtureList=[1,2,3,4,5,6,7,8,9,10]
    return fixtureList

def test_first10numadd(fixtureList):
    sum=0
    for num in fixtureList:
        sum += num
    assert sum ==55
    
    