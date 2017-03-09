/*������� ����� (name) ��� ���������� (employees), �������� (salary) ���� ����� �� �������� (boss).*/

SELECT
	Employees.Name
FROM
	Employees,
	(SELECT
		Employees.EmployeeID,
		Employees.Salary
	FROM
		Employees
	) AS SalaryInfo

WHERE Employees.BossID = SalaryInfo.EmployeeID
	AND Employees.Salary > SalaryInfo.Salary
	
	
/*������� ����������, ���� ����� �������� ��������� � ����� ������� (department).*/

SELECT
	Employees.*
FROM
	Employees
INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
WHERE 
	Employees.Salary = (SELECT
							MAX (Employees.Salary) 
						FROM 
							Employees
						WHERE
							Employees.DepartmentID = Departments.DepartmentID)
ORDER BY 
	Employees.DepartmentID
	
	
/*������� ����� ��� ��������, ���� ����� ���� �� 3-� ����������*/

SELECT
	Departments.Name
FROM 
	Departments
INNER JOIN Employees ON Departments.DepartmentID = Employees.DepartmentID
GROUP BY Departments.Name
HAVING COUNT(Employees.EmployeeID) < 3


/*������� ����������, ���� �� ����� �������� � ����� �������*/

SELECT
	Employees.Name, 
	Departments.Name
FROM
	Employees
INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
WHERE
	Employees.BossID IS NULL
	

/*������� ����� �������� ���� �������� ������ ����� �������*/

SELECT
	Departments.DepartmentID,
	SUM(Employees.Salary)
FROM
	Employees
INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
GROUP BY Departments.DepartmentID
























