import time

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait


def directory_page_title(driver,wait):

    directory = wait.until(expected_conditions.visibility_of_element_located((By.XPATH, "//*[text()= 'Directory']")))
    wait.until(expected_conditions.element_to_be_clickable((By.XPATH, "//*[text()= 'Directory']")))
    assert directory.is_displayed()
    directory.click()
    time.sleep(5)
    print(driver.find_element(By.TAG_NAME, "h1").text)

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
    directory_page_title(driver, wait)
    driver.close()