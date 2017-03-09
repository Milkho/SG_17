/*«найд≥ть ≥мена (name) вс≥х прац≥вник≥в (employees), зарплата (salary) €ких б≥льша за кер≥вника (boss).*/

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
	
	
/*«найд≥ть прац≥вник≥в, котр≥ мають найб≥льшу зарплатню в своЇму п≥дрозд≥л≥ (department).*/

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
	
	
/*«найд≥ть назви вс≥х п≥дрозд≥ли, котр≥ мають менш н≥ж 3-х прац≥вник≥в*/

SELECT
	Departments.Name
FROM 
	Departments
INNER JOIN Employees ON Departments.DepartmentID = Employees.DepartmentID
GROUP BY Departments.Name
HAVING COUNT(Employees.EmployeeID) < 3


/*«найд≥ть прац≥вник≥в, котр≥ не мають кер≥вник≥в в своЇму п≥дрозд≥л≥*/

SELECT
	Employees.Name, 
	Departments.Name
FROM
	Employees
INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
WHERE
	Employees.BossID IS NULL
	

/*«найд≥ть котру загальну суму зарплатн≥ отримуЇ кожен п≥дрозд≥л*/

SELECT
	Departments.DepartmentID,
	SUM(Employees.Salary)
FROM
	Employees
INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID
GROUP BY Departments.DepartmentID
























