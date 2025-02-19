import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait


def emergency_contact(driver, wait):
    wait.until(expected_conditions.element_to_be_clickable((By.ID, "menu_pim_viewMyDetails")))
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.LINK_TEXT, "Emergency Contacts").click()
    mobile_numbers = driver.find_elements(By.XPATH, "//table/tbody/tr")
    for mobile_number in mobile_numbers:
        number = mobile_number.find_element(By.XPATH, "./td[5]").text
        print(number)

with webdriver.Chrome() as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    title = driver.title
    print(title)

    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    assert driver.find_element(By.XPATH, "//*[@id = 'welcome']").is_displayed();
    print(driver.find_element(By.TAG_NAME, "h1").text)
    wait = WebDriverWait(driver, 5)
    emergency_contact(driver,wait)

    driver.close()
