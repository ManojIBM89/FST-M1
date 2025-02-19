from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    title = driver.title
    assert title == "OrangeHRM"
    img = driver.find_element(By.XPATH, "//div[@id = 'divLogo']/img").get_dom_attribute("src")
    print(img)
    driver.close()