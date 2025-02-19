import time

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait

def add_qualifications(driver, wait):
    wait.until(expected_conditions.element_to_be_clickable((By.ID, "menu_pim_viewMyDetails")))
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    wait.until(expected_conditions.element_to_be_clickable((By.LINK_TEXT, "Qualifications")))
    driver.find_element(By.LINK_TEXT, "Qualifications").click()
    wait.until(expected_conditions.visibility_of_element_located((By.XPATH, "//h1[text() = 'Work Experience']")))
    driver.find_element(By.ID, "addWorkExperience").click()
    driver.find_element(By.ID, "experience_employer").send_keys("def company")
    driver.find_element(By.ID, "experience_jobtitle").send_keys("Testing")
    from_date = driver.find_element(By.ID, "experience_from_date")
    from_date.clear()
    from_date.send_keys("2021-08-04")
    to_date = driver.find_element(By.ID, "experience_to_date")
    to_date.clear()
    to_date.send_keys("2021-08-04")
    driver.find_element(By.ID, "experience_comments").send_keys("Testing Comments")
    driver.find_element(By.ID, "btnWorkExpSave").click()

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
    action = ActionChains(driver)
    add_qualifications(driver, wait)

    driver.close()
