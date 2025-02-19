from selenium import webdriver

with webdriver.Chrome() as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    title = driver.title
    assert title == "OrangeHRM"
    print(title)
    driver.close()