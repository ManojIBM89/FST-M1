fruit_shop={
    "apple": 10,
    "mango": 15,
    "banana": 5,
    "orange": 8,
}
search_item=input("What friut you need:")
if(search_item in fruit_shop):
    print("Item Available")
    print(search_item + " costs " + str(fruit_shop[search_item]) + " rupees")
else:
    print("Item Not availeble")
