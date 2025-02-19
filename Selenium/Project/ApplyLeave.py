import time

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support.select import Select

def apply_leave(driver, wait):
    driver.find_element(By.LINK_TEXT, "Apply Leave").click()
    assert driver.find_element(By.TAG_NAME, "h1").text == "Apply Leave"
    dropdown = driver.find_element(By.TAG_NAME, "select")
    select = Select(dropdown)
    select.select_by_visible_text("DayOff")
    from_date = driver.find_element(By.ID, "applyleave_txtFromDate")
    from_date.clear()
    from_date.send_keys("2025-02-02")
    to_date = driver.find_element(By.ID, "applyleave_txtToDate")
    to_date.clear()
    to_date.send_keys("2025-02-08")
    driver.find_element(By.ID, "applyleave_txtComment").send_keys("Testing Comments")
    driver.find_element(By.ID, "applyBtn").click()

def validate_values(driver):
    driver.find_element(By.LINK_TEXT, "My Leave").click()
    status = driver.find_element(By.XPATH, "//table/tbody/tr/td[6]").text
    if status.startswith("Pending"):
        print("Your leave status is still pending for Approval")

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
    apply_leave(driver, wait)
    validate_values(driver)

    driver.close()
