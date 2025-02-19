import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait


def edit_info(web_driver, web_wait):
    web_wait.until(expected_conditions.element_to_be_clickable((By.ID, "menu_pim_viewMyDetails")))
    web_driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    web_driver.find_element(By.ID, "btnSave").click()
    web_wait.until(expected_conditions.element_to_be_clickable((By.ID, "personal_txtEmpFirstName")))
    first_name = driver.find_element(By.ID, "personal_txtEmpFirstName")
    first_name.clear()
    first_name.send_keys("Anu")
    last_name = driver.find_element(By.ID, "personal_txtEmpLastName")
    last_name.clear()
    last_name.send_keys("Balan")
    driver.find_element(By.ID, "personal_optGender_1").click()
    driver.find_element(By.ID, "personal_optGender_2").click()
    dob = driver.find_element(By.ID, "personal_DOB")
    dob.clear()
    dob.send_keys("1994-04-08")
    dropdown = driver.find_element(By.ID, "personal_cmbNation")
    select = Select(dropdown)
    select.select_by_value("38")
    driver.find_element(By.ID, "btnSave").click()
    time.sleep(5)


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
    edit_info(driver, wait)

    driver.close()
