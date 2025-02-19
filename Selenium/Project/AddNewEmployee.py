import time

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait


def select_employee_list(driver, action):
    action.move_to_element(driver.find_element(By.XPATH, "//b[text() = 'PIM']")).perform()
    driver.find_element(By.XPATH, "//*[text() ='Employee List']").click()
    driver.find_element(By.ID, "btnAdd").click()
    assert driver.find_element(By.TAG_NAME, "h1").text == "Add Employee"
    print(driver.find_element(By.TAG_NAME, "h1").text )

def add_employee(driver):
    driver.find_element(By.ID, "firstName").send_keys("Anitha")
    driver.find_element(By.ID, "lastName").send_keys("Balan")
    id = driver.find_element(By.ID, "employeeId").get_dom_attribute("value")
    print(id)
    driver.find_element(By.ID, "chkLogin").click()
    driver.find_element(By.ID, "user_name").send_keys("AnithaBalan")
    driver.find_element(By.ID, "user_password").send_keys("Welcome1!")
    driver.find_element(By.ID, "re_password").send_keys("Welcome1!")
    driver.find_element(By.ID, "btnSave").click()
    # driver.timeouts.implicit_wait(5)
    time.sleep(5)
    id_after_save = driver.find_element(By.ID, "personal_txtEmployeeId").get_dom_attribute("value")
    print(id_after_save)
    assert id_after_save == id

def search_employee_real(driver, action):
    action.move_to_element(driver.find_element(By.XPATH, "//b[text() = 'PIM']")).perform()
    driver.find_element(By.XPATH, "//*[text() ='Employee List']").click()
    search_field = (driver.find_element(By.ID, "empsearch_employee_name_empName"))
    search_field.click()
    search_field.clear()
    search_field.send_keys("Anitha " + "Balan")
    driver.find_element(By.ID, "empsearch_id").click()
    driver.find_element(By.ID, "searchBtn").click()
    time.sleep(5)
    first_name = driver.find_element(By.XPATH, "//table/tbody/tr/td[3]/a").text
    last_name = driver.find_element(By.XPATH, "//table/tbody/tr/td[4]/a").text
    print(first_name)
    print(last_name)
    assert first_name == "Anitha"
    assert last_name == "Balan"

def delete_employee(driver):
    search_field = driver.find_element(By.ID, "empsearch_employee_name_empName")
    search_field.clear()
    search_field.send_keys("anitha")
    driver.find_element(By.ID, "empsearch_id").click()
    driver.find_element(By.ID, "searchBtn").click()
    driver.find_element(By.ID, "ohrmList_chkSelectAll").click()
    driver.find_element(By.ID, "btnDelete").click()
    ok_button = driver.find_element(By.ID, "dialogDeleteBtn")
    driver.execute_script("arguments[0].click();", ok_button)
    time.sleep(5)

def search_employee_junk(driver):
    search_field = (driver.find_element(By.ID, "empsearch_employee_name_empName"))
    search_field.click()
    search_field.clear()
    search_field.send_keys("Madhannukumarrruuu")
    driver.find_element(By.ID, "empsearch_id").click()
    driver.find_element(By.ID, "searchBtn").click()
    time.sleep(5)
    no_result = driver.find_element(By.XPATH, "//table/tbody/tr/td").text
    print(no_result)
    assert no_result == "No Records Found"


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
    select_employee_list(driver,  action)
    add_employee(driver)
    search_employee_real(driver, action)
    delete_employee(driver)
    search_employee_junk(driver)


    driver.close()