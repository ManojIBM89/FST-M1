from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    title = driver.title
    print(title)

    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    assert driver.find_element(By.XPATH, "//*[@id = 'welcome']").is_displayed();
    print(driver.find_element(By.TAG_NAME, "h1").text)

    driver.close()